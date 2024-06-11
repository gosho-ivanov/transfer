matrix = []
rows, cols = list(map(int, input().split(", ")))

for i in range(rows):
    r = list(map(int, input().split(", ")))
    matrix.append(r)

for j in range(rows):
    for k in range(cols):
        if matrix[j][k] == 0:
            matrix[j][k] = 100
        elif matrix[j][k] % 2 == 0:
            matrix[j][k] += 2
        elif matrix[j][k] %2 != 0:
            matrix[j][k] += 1

for row in matrix:
    print(*row, sep=", ")