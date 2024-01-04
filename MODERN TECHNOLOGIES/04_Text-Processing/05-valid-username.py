import re

pattern = r"[a-zA-Z1-9\.\_]+"
data = list(input().split(", "))
valid_users = []

for i in range(len(data)):
    name = data[i]
    matches = re.findall(pattern,name)
    if name == matches[0] and 5<=len(name)<=15:
        valid_users.append(name)

print("\n".join(valid_users))