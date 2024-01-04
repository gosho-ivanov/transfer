data = input()
rev = ""
while data != "Stop":
    for i in range(len(data)):
        if data[-1-i] == " ":
            continue
        rev += data[-1-i]
    print(f"{data} -> {rev}")
    rev = ""
    data = input()
