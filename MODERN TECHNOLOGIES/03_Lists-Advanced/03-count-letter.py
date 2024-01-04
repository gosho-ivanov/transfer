data = [letter for letter in input()]
letter = input()
repeated = [x for x in data if x==letter]
print(f"There are {len(repeated)} letters {letter} in the text")