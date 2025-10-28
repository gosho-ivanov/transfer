# Не знам дали в тази задача трябва елементите на кортежа да са от тип int или str, затова съм ги оставил като str
num = str(int(input("Enter a number: ")))
tuple_num = tuple(num)
print("The number you entered is:", tuple_num)
rev_num = tuple(reversed(num))
print("Reversed:", rev_num)