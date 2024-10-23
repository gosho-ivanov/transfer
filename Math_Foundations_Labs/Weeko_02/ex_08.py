a = int(input("Enter value for a: "))
b = int(input("Enter value for b: "))
c = int(input("Enter value for c: "))
y = int(input("Enter value for x: "))

if a < c and c < b:
    if a <= y and y <= b and y != c:
        print(True)
    else:
        print(False)
else:
    print(False)