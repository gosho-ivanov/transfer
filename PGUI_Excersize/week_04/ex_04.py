import math

while True:
    num = int(input("Enter a number: "))
    if num > 0:
        break
    print("Please enter a positive number")

if num == 1:
    print("Numebr is 1")
else:
    flag = True
    for i in range(2, int(math.sqrt(num))+1):
        if (num % i) == 0:
            flag = False
            break
    if flag:
        print(f"{num} is a prime number")
    else:
        print(f"{num} is not a prime number")