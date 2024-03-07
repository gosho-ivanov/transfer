N = int(input())
matrix = [input().split() for _ in range(N)]
for x in range(N):
    if "B" in matrix[x]:
        bunny_pos = [x, matrix[x].index("B")]
        break

max_eggs = 0
best_path = []
best_direction = ""

directions = {
    "up": (-1, 0),
    "down": (1, 0),
    "left": (0, -1),
    "right": (0, 1)
}

for direction, positions in directions.items():
    x, y = [
        bunny_pos[0] + positions[0], 
        bunny_pos[1] + positions[1]
    ]
    path = []
    collected_eggs = 0
    while 0 <= x < N and 0 <= y < N:
        if matrix[x][y] == "X":
            break
        collected_eggs +=int(matrix[x][y])
        path.append([x, y])

        x += positions[0]
        y += positions[1]

        if max_eggs < collected_eggs:
            max_eggs = collected_eggs
            best_direction = direction
            best_path = path

print(best_direction)
print(*best_path, sep="\n")
print(max_eggs)