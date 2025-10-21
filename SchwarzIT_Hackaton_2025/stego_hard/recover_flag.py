#!/usr/bin/env python3
"""
recover_flag.py
Load parts.pkl (from extract_faAA.py) and try permutations to find the hidden flag.
Usage: python recover_flag.py
"""
import pickle
import itertools
import hashlib
import zlib
import time
from pathlib import Path

PARTS_PKL = "parts.pkl"

def load_parts(pkl_path=PARTS_PKL):
    with open(pkl_path, "rb") as f:
        data = pickle.load(f)
    plte = data["plte"]
    parts = data["parts"]
    # Normalize to list of tuples (part_idx, iv, ciphertext, raw)
    tup = [(p["part_idx"], p["iv"], p["ciphertext"], p["raw"]) for p in parts]
    return plte, tup

def decrypt_piece(plte, iv, ciphertext):
    key = hashlib.sha256(plte + iv).digest()  # 32 bytes
    return bytes([c ^ key[i % len(key)] for i, c in enumerate(ciphertext)])

# quick zlib header check: common wrappers are 0x78 0x9C / 0x78 0x01 / 0x78 0xDA
def looks_like_zlib(data):
    if len(data) < 2:
        return False
    return data[0] == 0x78 and data[1] in (0x01, 0x9C, 0xDA)

def try_permutations(plte, parts):
    total = 0
    start = time.time()
    for perm in itertools.permutations(parts):
        total += 1
        # decrypt & join
        decrypted_pieces = []
        for (_, iv, ciphertext, _) in perm:
            decrypted_pieces.append(decrypt_piece(plte, iv, ciphertext))
        joined = b"".join(decrypted_pieces)

        # quick sanity check: look for zlib header before trying decompress
        if not looks_like_zlib(joined):
            # still possible to be compressed differently; skip only for speed
            if total % 500 == 0:
                elapsed = time.time() - start
                print(f"[{total}] tried, elapsed {elapsed:.1f}s — header mismatch, continuing...")
            continue

        try:
            dec = zlib.decompress(joined)
        except Exception as e:
            if total % 500 == 0:
                elapsed = time.time() - start
                print(f"[{total}] tried, elapsed {elapsed:.1f}s — zlib failed: {e}")
            continue

        # success check
        if b"ctf{" in dec:
            print("="*60)
            print(f"Found after {total} tries (elapsed {time.time()-start:.1f}s)!")
            try:
                print(dec.decode(errors="replace"))
            except Exception:
                print(repr(dec))
            print("="*60)
            return True

        # occasional progress print
        if total % 500 == 0:
            elapsed = time.time() - start
            print(f"[{total}] tried, elapsed {elapsed:.1f}s — no flag yet")

    print(f"Done. Tried {total} permutations in {time.time()-start:.1f}s; flag not found.")
    return False

def main():
    p = Path(PARTS_PKL)
    if not p.exists():
        print(f"Error: {PARTS_PKL} not found in current directory.")
        return
    plte, parts = load_parts()
    print(f"Loaded {len(parts)} parts. Part indices (as read): {[p[0] for p in parts]}")
    print("Starting permutation brute-force (this will try 7! = 5040 permutations)...")
    try_permutations(plte, parts)

if __name__ == "__main__":
    main()
