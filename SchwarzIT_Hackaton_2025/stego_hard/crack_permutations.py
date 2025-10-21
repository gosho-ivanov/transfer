#!/usr/bin/env python3
"""
Load parts.pkl (created by extract_faAA.py) and try permutations to find the hidden flag.
Usage: python crack_permutations.py
Optional: set NUM_WORKERS > 1 for multiprocessing speedup.
"""
import pickle, hashlib, zlib, itertools
from pathlib import Path

# Change to >1 to use multiprocessing (speedup on multi-core)
NUM_WORKERS = 1

def load_parts(pickle_path="parts.pkl"):
    with open(pickle_path, "rb") as f:
        data = pickle.load(f)
    plte = data["plte"]
    parts = data["parts"]
    # Convert to tuple list: (part_idx, iv, ciphertext)
    tup_parts = [(p["part_idx"], p["iv"], p["ciphertext"]) for p in parts]
    # Sort by part_idx for a canonical baseline (not necessary)
    tup_parts.sort(key=lambda x: x[0])
    return plte, tup_parts

def decrypt_piece(plte, iv, ciphertext):
    key = hashlib.sha256(plte + iv).digest()  # 32 bytes
    decrypted = bytes([c ^ key[i % len(key)] for i, c in enumerate(ciphertext)])
    return decrypted

def attempt_permutation(plte, perm):
    # perm is an iterable of (part_idx, iv, ciphertext)
    joined = b"".join(decrypt_piece(plte, iv, ct) for _, iv, ct in perm)
    try:
        dec = zlib.decompress(joined)
    except Exception:
        return None
    return dec

def brute_force(plte, parts):
    # parts: list of (part_idx, iv, ciphertext)
    n = len(parts)
    print(f"Trying {math_factorial(n)} permutations ({n} parts)...")
    for i, perm in enumerate(itertools.permutations(parts), start=1):
        dec = attempt_permutation(plte, perm)
        if dec is not None and b"ctf{" in dec:
            print(f"Found after {i} tries!")
            try:
                print(dec.decode())
            except Exception:
                print(dec)
            return True
        # optional progress print
        if i % 500 == 0:
            print(f"  tried {i} permutations...")
    print("No valid permutation found.")
    return False

def math_factorial(n):
    import math
    return math.factorial(n)

def main():
    plte, parts = load_parts()
    print("Loaded parts; part indices:", [p[0] for p in parts])
    n = len(parts)
    if n > 9:
        print("Warning: factorial blowup. Consider smarter ordering heuristics.")
    # Try brute force (single-process)
    success = brute_force(plte, parts)
    if not success and NUM_WORKERS > 1:
        # Multiprocessing attempt (split permutations across workers)
        print("Attempting multiprocessing (this may use lots of CPU/RAM).")
        from multiprocessing import Pool, cpu_count
        import itertools as _it
        pool = Pool(NUM_WORKERS)
        chunk_size = 1000  # tune as desired
        def gen_perms():
            for perm in _it.permutations(parts):
                yield perm
        # Map in chunks
        for result in pool.imap_unordered(lambda perm: attempt_permutation(plte, perm), gen_perms(), chunksize=chunk_size):
            if result is not None and b"ctf{" in result:
                print("Found!")
                print(result.decode(errors="ignore"))
                pool.terminate()
                return
        pool.close()
    print("Done.")

if __name__ == "__main__":
    main()
