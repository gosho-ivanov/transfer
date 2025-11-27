import math
try:
    x: int = int(input("Enter an integer: "))
    if x < 0:
        raise ValueError()
    result: float = math.sqrt(x)
    print(f"The square root of {x} is {result}")
except ValueError:
    print("Invalid number!")
except Exception as e:
    print(e)
finally:
    print("Bye-bye!")