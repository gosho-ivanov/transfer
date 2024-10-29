#DECIMAL OPERATIONS
def find_max_num(data: list):
    data = [int(x) for x in data]
    return max(data)

def len_dec(num: int):
    return len(str(num))

def numd2dec(data: list):
    as_str = ""
    for num in data:
        as_str += num
    return int(as_str)

def check4num(number: int, check: int):
    number = str(number)
    if number[0] == check:
        return True
    else:
        number = number[:-1]
        if number == "":
            return False
        else:
            return check4num(number, check)
        

def even_uneven(num: int):
    even = 0
    uneven = 0
    