original_message = input()
original_message = original_message.replace("and", "&").replace("or", "|")

new_message = ""
vowels = {"a":"0", "e":"1", "i":"2", "o":"3", "u":"4"}
intervals = ["#", "$", "%"]
interval = 0

for char in original_message:
    if char in vowels.keys():
        new_message += vowels[char]
    elif char.isalpha():
        new_message += chr(ord(char)-2)
    elif char.isdigit():
        new_message += f"\\{int(char)+1}"
    elif char.isspace():
        new_message += intervals[interval]
        interval += 1
        interval %= 3
    else:
        new_message += char 

new_message = new_message[::-1]
print(new_message)