import re

pattern = r"\w++\.+\w+"
text = input()
data = re.findall(pattern, text)

p2 = r"[^.]+"
info = re.findall(p2,data[0])
print(f"File name: {info[0]}\nFile extension: {info[1]}")