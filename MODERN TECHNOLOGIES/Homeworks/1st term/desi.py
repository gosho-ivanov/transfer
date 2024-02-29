message = input()
message = message.replace("and" , "&")
message = message.replace("or" , "|")

encrypted = ""
text = "aeiou"
spaces_replace = "#$%"
spaces_counter = 0

for letter in message:
    if letter in text:
        encrypted = encrypted + str(text.index(letter))

    elif letter.isalpha():
        encrypted = encrypted + chr(ord(letter) - 2)
    
    elif letter.isdigit():
        encrypted = encrypted + "\\" + str(int(letter) + 1)
    
    elif letter.isspace():
        encrypted = encrypted + spaces_replace[spaces_counter]
        spaces_counter = (spaces_counter + 1) % 3

    else:
        encrypted = encrypted + letter

encrypted = encrypted[::-1]
print(encrypted)