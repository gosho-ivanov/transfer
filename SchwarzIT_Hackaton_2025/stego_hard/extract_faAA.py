#!/usr/bin/env python3
"""
Extract PLTE and faAA chunks from a PNG and save to parts.pkl
Usage: python extract_faAA.py /path/to/Challenge\ from\ SIT\ CTF.png
"""
import sys, struct, pickle
from pathlib import Path

def read_chunks(f):
    while True:
        hdr = f.read(8)
        if len(hdr) < 8:
            break
        length, ctype = struct.unpack(">I4s", hdr)
        data = f.read(length)
        crc = f.read(4)
        yield ctype, data

def main(png_path):
    png_path = Path(png_path)
    with open(png_path, "rb") as f:
        sig = f.read(8)
        if sig != b"\x89PNG\r\n\x1a\n":
            raise SystemExit("Not a PNG")
        plte = None
        fa_chunks = []
        for ctype, data in read_chunks(f):
            if ctype == b"PLTE":
                plte = data
            elif ctype == b"faAA":
                # store raw chunk payload (we'll parse fields later)
                fa_chunks.append(data)

    if plte is None:
        raise SystemExit("PLTE chunk not found (expected indexed-color PNG)")

    # Parse faAA chunk structure as inferred:
    # [0] version, [1] part_idx, [2] total, [3:19] iv (16 bytes), [19:23] crc32, [23:] ciphertext
    parts = []
    for raw in fa_chunks:
        if len(raw) < 24:
            raise SystemExit("unexpected small faAA chunk")
        version = raw[0]
        part_idx = raw[1]
        total = raw[2]
        iv = raw[3:3+16]
        crc32 = struct.unpack(">I", raw[19:23])[0]
        ciphertext = raw[23:]
        parts.append({
            "version": version,
            "part_idx": part_idx,
            "total": total,
            "iv": iv,
            "crc32": crc32,
            "ciphertext": ciphertext,
            "raw": raw
        })

    # Save a pickle with plte and parts for later use
    out = {"plte": plte, "parts": parts}
    with open("parts.pkl", "wb") as o:
        pickle.dump(out, o)

    print(f"Saved parts.pkl with {len(parts)} faAA chunks and PLTE ({len(plte)} bytes).")
    print("Summary of parts (part_idx, ciphertext_len):")
    for p in parts:
        print(f"  idx={p['part_idx']}, len={len(p['ciphertext'])}, crc32=0x{p['crc32']:08x}")

if __name__ == "__main__":
    if len(sys.argv) != 2:
        print("Usage: python extract_faAA.py /path/to/image.png")
        raise SystemExit(1)
    main(sys.argv[1])
