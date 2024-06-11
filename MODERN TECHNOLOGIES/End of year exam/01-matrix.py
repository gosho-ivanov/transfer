matrix = []
rows, cols = [int(x) for x in input().split(", ")]

for _ in range(rows):
    data = [int(x) for x in input().split(", ")]
    matrix.append(data)

for i in range(rows):
    for k in range(cols):
        if matrix[i][k] == 0 :
            matrix[i][k] = -100
        elif matrix[i][k] % 2 == 0:
            matrix[i][k] += 1
        elif matrix[i][k] % 2 == 1:
            matrix[i][k] += 2

for data in matrix:
    print(*data, sep = ", ")