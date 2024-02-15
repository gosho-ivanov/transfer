matrix = []
for i in range(4):
    a = []
    for j in range(5):
        a.append(0)
    matrix.append(a)

for row in matrix:
    for col in row:
        print(col, end = " ")
    print()