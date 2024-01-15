original_message = input()
original_message = original_message.replace("and", "&").replace("or", "|")

new_message = ""
vowels = ["a", "e", "i", "o", "u"]
intervals = ["#", "$", "%"]
interval = 0

for char in original_message:
    if char in vowels:
        new_message += str(vowels.index(char))
    elif char.isalpha():
        new_message += chr(ord(char)-2)
    elif char.isnumeric():
        new_message += f"\\{int(char)+1}"
    elif char == " ":
        new_message += intervals[interval]
        interval+=1
        if interval>2:
            interval=0
    else:
        new_message += char 

new_message = new_message[::-1]
print(new_message)       