try:
    even_numbers = [2, 4, 6, 8, 10, 12, 14, 16, 18, 20]
    index = int(input("Enter index: "))
    denom = int(input("Denominator: "))
    res = even_numbers[index] / denom
    print(res)
except ZeroDivisionError:
    print("Denominator cannot be 0")

except IndexError:
    print("Index out of range")

except ValueError:
    print("Cannot convert input to int due to not being with base 10")

