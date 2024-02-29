row, col = list(map(int, input().split(", ")))
matrix = [list(map(int, input().split(", "))) for _ in range(row)]

max_sum_els = {}
max_sum = 0
for i in range(row-1):
    for j in range(0, col-1):
        curr_sum = matrix[i][j] + matrix[i+1][j] + matrix[i+1][j+1] + matrix[i][j+1]
        if curr_sum > max_sum:
            max_sum = curr_sum
            max_sum_els["row"] = i
            max_sum_els["col"] = j

rows = max_sum_els["row"]
cols = max_sum_els["col"]
print(f"{matrix[rows][cols]} {matrix[rows][cols+1]}\n"
      f"{matrix[rows+1][cols]} {matrix[rows+1][cols+1]}\n"
      f"{max_sum}")