def bin2dec(number: str):
    return int(number, 2)

def bin2oct(number: str):
    return oct(int(number, 2))[2:]

def bin2hex(number: str):
    return hex(int(number, 2))[2:]

def oct2dec(number: str):
    return int(number, 8)

def oct2bin(number: str):
    return bin(int(number,8))[2:]

def oct2hex(number: str):
    return hex(int(number, 8))[2:]

def dec2bin(number: int):
    return bin(number)[2:]

def dec2oct(number: int):
    return oct(number)[2:]

def dec2hex(number: int):
    return hex(number)[2:]

def hex2bin(number: str):
    return bin(int(number, 16))[2:]
