t = tuple([int(x) for x in input().split()])
for i in range(1, len(t)-1):
    print(t[i]*t[0], end=", ")
print(t[len(t)-1]*t[0])


# map is faster than a for loop!!!!!!!
