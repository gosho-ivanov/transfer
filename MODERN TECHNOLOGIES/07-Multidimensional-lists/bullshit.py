a = []
stat = 1
for row in range(3):
    b = []
    for col in range(3):
        b.append(stat)
        stat+=1
    a.append(b)

for x in a:
    for b in x:
        print(b, end=" ")
    print()

# [print(*row) for row in a]
