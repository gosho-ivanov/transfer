import re

with open("/Users/thanatos/Documents/school/transfer/SchwarzIT_Hackaton_2025/osint_3/I See You - SIT CTF", "r") as f:
    data = f.read()

# Find sequences of 4 or more consecutive printable characters
matches = re.findall(r'[ -~]{4,}', data)
print("All printable sequences (length >= 4):")
for m in matches:
    print(m)
    