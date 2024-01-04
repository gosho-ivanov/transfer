data = list(input().split("\n"))
print(data)
for item in data:
    file = item.split(".")
    if file[1] == "gif" or file[1] == "jpg" or file[1] == "png":
        print(file[0])

#DEBUG THIS NEXT TIME