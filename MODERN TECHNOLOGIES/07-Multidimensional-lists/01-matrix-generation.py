matrix = []
for _ in range(4):
    a = []
    for _ in range(5):
        a.append(0)
    matrix.append(a)

[print(*row) for row in matrix]