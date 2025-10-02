while True:
    letter = input("Enter a letter: ").lower()
    if len(letter) != 1:
        print("Invalid input, try again.")
    else: break

vowels = "aeiou"
print("The letter is a vowel") if letter in vowels else print("The letter is a consonant")