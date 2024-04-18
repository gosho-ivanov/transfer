try:
    numbers_list = [int(x) for x in input().split(", ")]
    result = 1
    for i in range(len(numbers_list)):
        number = numbers_list[i]
        if number <= 5:
            result *= number
        elif 5 < number <= 10:
            result /= number
    print(result)
except SyntaxError:
    print("Your code doesn't work dumbass! Look at how many SyntaxErrors you have.")
except IndentationError:
    print("Bro doesn't know how to use TAB.")
except NameError:
    print("The variable 'total' does not exist")
except ValueError:
    print("You can't use string for range() -> only int")
except IndexError:
    print("Bro is so dumb he doesn't know how indexes work.")
