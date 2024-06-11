matrix = []
row, col = list(map(int, input().split(", ")))

for _ in range(row):
    data = list(map(int, input().split(", ")))
    matrix.append(data)

for i in range(row):
    for k in range(col):
        if matrix[i][k] == 0 :
            matrix[i][k] = 100
        elif matrix[i][k] % 2 == 0:
            matrix[i][k] += 2
        elif matrix[i][k] % 2 == 1:
            matrix[i][k] += 1
        else:pass


print()
for data in matrix:
    print(*data, sep = ", ")