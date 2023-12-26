def swap_case(s):
    res = ""
    for char in s:
        if char.islower():
            res += char.upper()
        else:
            res += char.lower()
    return res

if __name__ == '__main__':
    s = input()
    result = swap_case(s)
    print(result)