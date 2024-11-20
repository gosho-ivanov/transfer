a = bin(int(input()))[2:]
b = bin(int(input()))[2:]
operation = input()

def bitwise_op(x: str, y: str, op: str):
    if op.upper() == 'AND':
        return x & y
    elif op.upper() == 'OR':
        return x | y
    elif op.upper() == "XOR":
        return x ^ y
    elif op.upper() == "NOT":
        return ~x
    elif op.upper() == "LEFT SHIFT":
        z = int(input())
        return x << z
    elif op.upper() == "RIGHT SHIFT":
        z = int(input())
        return x >> z
    else:
        pass

print(bitwise_op(a, b, operation))