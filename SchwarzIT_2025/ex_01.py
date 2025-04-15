word = input("Enter the word you would like to check: ").lower()
letters = {}
check = True

if word:
    for letter in word:
        if letter not in letters:
            letters[letter] = 0
        letters[letter] += 1
        if letters[letter] > 1:
            check = False
            break

print(check)