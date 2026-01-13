import re

phone_num_regex = r'0(8|9)\d{8}'
phone_number = input("Enter your phone number: ")
if re.search(phone_num_regex, phone_number):
    print("Valid phone number")
else:
    print("Invalid phone number")