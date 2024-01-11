dictionary = {}

word = input()
while word!="":
    meanings = input().split("/")
    if word not in dictionary.keys():
        dictionary[word] = meanings
    else:
        dictionary[word].append(meanings)
    word = input()

for key, values in dictionary.items():
    print(f"{key} - {(", ").join(values)}")