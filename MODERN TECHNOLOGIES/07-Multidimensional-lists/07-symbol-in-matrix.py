matrix = []
N = int(input())
matrix = [list(input()) for _ in range(N)]

searching_for = input()
found = False
for row in range(N):
    for col in range(N):
        if matrix[row][col] == searching_for:
            print(f"({row}, {col})")
            found = True

if  not found:
    print(f"{searching_for} does not occur in the  matrix")