try:
    num = input("Enter a number: ")
    num = float(num)
    print(f"Converted number: {num}")
except ValueError:
    print("Error: Cannot convert object of <str> to <float> due to the appearence of text")