import re

date_regex = r'(0\d|1\d|2\d|3[0-1])-(0[1-9]|1[0-2])-(\d{4})'
date_input = input("Enter string: ")
matches = re.findall(date_regex, date_input)
for match in matches:
    print(match)