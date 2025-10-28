text = input("Enter a string: ").lower() # не знам дали трябва да се взима предвид case-а на буквите или не, затова съм го направил без значение на case-а
chars = dict()

for char in text:
    if char in chars:
        chars[char] += 1
    else:
        chars[char] = 1

for key, value in chars.items():
    print(f"'{key}': {value}")