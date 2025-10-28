x = int(input("Enter the amount of numbers to input: "))

while x <= 0:
    x = int(input("Invalid input. Please enter a positive integer: "))

numbers = [int(input("Enter a number: ")) for _ in range(x)]
counter = 0

while True:
    if counter >= len(numbers):
        break
    if counter + 1 >= len(numbers):
        print("The list started with", x, "numbers, so no more pairs can be formed.")
        break
    
    sum_nums = numbers[counter] + numbers[counter + 1]
    numbers.insert(counter + 2, sum_nums)
    counter += 3

print("The new list is:", numbers)