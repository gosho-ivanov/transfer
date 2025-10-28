def summarize_numbers(num1: int | float, num2: int | float) -> int | float:
    return num1 + num2

def multiply_numbers(num1: int | float, num2: int | float) -> int | float:
    return num1 * num2

def divide_numbers(num1: int | float, num2: int | float) -> float:
    if num2 == 0:
        raise ValueError("Cannot divide by zero.")
    return num1 / num2

def subtract_numbers(num1: int | float, num2: int | float) -> int | float:
    return num1 - num2

def math_operations(num1: int, num2: int, operation: str) -> float | int:
    if len(operation) != 1 or operation not in "+-*/":
        raise ValueError("Invalid operation. Please use one of the following: +, -, *, /")
    if operation == "+":
        return summarize_numbers(num1, num2)
    elif operation == "-":
        return subtract_numbers(num1, num2)
    elif operation == "*":
        return multiply_numbers(num1, num2)
    elif operation == "/":
        return divide_numbers(num1, num2)
    