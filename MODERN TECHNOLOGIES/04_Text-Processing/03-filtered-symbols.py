data = input()
nums = ""
letters = ""
others = ""
for i in range(len(data)):
    if 47<=ord(data[i])<=57:
        nums+=data[i]
    elif 65<=ord(data[i])<=90 or 97<=ord(data[i])<=122:
        letters += data[i]
    else:
        others += data[i]
print(f"{nums}\n"
      f"{letters}\n"
      f"{others}\n")