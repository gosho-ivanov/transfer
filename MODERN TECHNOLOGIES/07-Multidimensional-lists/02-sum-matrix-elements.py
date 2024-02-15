row, col = input().split(", ")
row, col = int(row), int(col)

sum_elements = 0
matrix = []
for i in range(row):
    a = []
    row_input = input().split(", ")
    for j in range(col):
        a.append(int(row_input[j]))
        sum_elements+=int(row_input[j])
    matrix.append(a)

print(f"{sum_elements}\n{matrix}")
