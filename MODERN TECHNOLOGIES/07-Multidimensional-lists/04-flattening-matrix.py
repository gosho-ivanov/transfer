matrix = []
rows = int(input())
for _ in range(rows):
    matrix.append(list(map(int, input().split(', '))))

data = []
for row in matrix:
    for el in row:
        data.append(el)

print(data)