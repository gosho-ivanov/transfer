text = input("Enter the message you want to encrypt: ")

text = text.replace("and", "&").replace("or", "|")

vowels_dict = {"a": "0", 
               "e": "1", 
               "i": "2", 
               "o": "3", 
               "u": "4"}
intervals = "#$%"
encrypted_text = ""
counter = 0

for char in text:
    if char in vowels_dict:
        encrypted_text += vowels_dict[char]
    elif char.isalpha():
        encrypted_text += chr(ord(char) -2 )
    elif char.isdigit():
        encrypted_text += "\\" + str(int(char) + 1)
    elif char.isspace():
        encrypted_text+= intervals[counter]
        counter = (counter + 1) % 3
    else:
        encrypted_text += char

reversed_text = encrypted_text[::-1]

print(reversed_text)