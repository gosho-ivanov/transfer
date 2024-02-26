matrix = []
N = int(input())
for _ in range(N):
    matrix.append(list(map(int, input().split())))

main_diagonal = sum([matrix[i][i] for i in range(N)])
secondary_diagonal = sum([matrix[j][N-1-j] for j in range(N-1, -1, -1)])
print(f"{main_diagonal}\n{secondary_diagonal}")