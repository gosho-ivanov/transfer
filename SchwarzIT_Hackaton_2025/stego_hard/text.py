import re

iv_plte_hex = "d163abb184dc094e5c22c3d571ca2d5c56300717f8e78631c1f71937627773d4aa5141ac257f642c"
iv_data = bytes.fromhex(iv_plte_hex)

# XOR key
key = bytes.fromhex('9b93e04a')

# XOR-decode entire data
decoded_full = bytes([b ^ key[i % len(key)] for i, b in enumerate(iv_data)])

# Convert all bytes to characters, non-printable as '.'
decoded_all_chars = ''.join([chr(b) if 32 <= b <= 126 else '.' for b in decoded_full])
print("Full XOR-decoded with dots for non-printable:")
print(decoded_all_chars)
print("\n---")

# Find sequences of 4 or more consecutive printable characters
matches = re.findall(b'[ -~]{4,}', decoded_full)
print("All printable sequences (length >= 4):")
for m in matches:
    print(m.decode('utf-8'))
