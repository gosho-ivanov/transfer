positive_nums = []
negative_nums = []
even_nums = []
odd_nums = []
number_of_nums = int(input("number:"))

for _ in range(number_of_nums):
    num = int(input("numbers:"))
    if num < 0:
        negative_nums.append(num)
    else:
        positive_nums.append(num)
    if num % 2 == 0:
        even_nums.append(num)
    else:
        odd_nums.append(num)

command = input("comand:")
if command == "even":
    print(f"Numbers {command}: {sorted(even_nums)}")
elif command == 'odd':
    print(f"Numbers {command}: {sorted(odd_nums)}")
elif command == "positive":
    print(f"Numbers {command}: {sorted(positive_nums)}")
elif command == "negative":
    print(f"Numbers {command}: {sorted(negative_nums)}")
