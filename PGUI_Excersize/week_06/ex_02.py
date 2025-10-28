def check_palindrome(num: int) -> bool:
    str_num = str(num)
    return 1 if str_num == str_num[::-1] else 0