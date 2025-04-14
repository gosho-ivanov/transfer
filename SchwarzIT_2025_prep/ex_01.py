string = input()
capital_letters = 0
small_letters = 0
numbers = 0
special_characters = 0
for char in string:
    if char.isupper():
        capital_letters += 1
    elif char.islower():
        small_letters += 1
    elif char.isdigit():
        numbers += 1
    else:
        special_characters += 1

print(f"Capital letters: {capital_letters}")
print(f"Small letters: {small_letters}")
print(f"Numbers: {numbers}")
print(f"Special characters: {special_characters}")