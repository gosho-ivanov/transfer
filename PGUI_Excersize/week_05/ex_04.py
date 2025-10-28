x = int(input("Enter a positive integer: "))
while x < 0:
    x = int(input("Invalid input. Please enter a positive integer: "))

numbers = [i for i in range(1, x + 1)]
dict_numbers = {}
for i in range(len(numbers)):
    dict_numbers[numbers[i]] = numbers[-(i+1)]

print("The resulting dictionary is:", dict_numbers)