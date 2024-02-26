rows, cols = list(map(int, input().split(", ")))
matrix = []
for _ in range(rows):
    matrix.append(list(map(int, input().split())))

sums = []
for i in range(cols):
    curr_sum = 0
    for j in range(rows):
        curr_sum +=  matrix[j][i]
    sums.append(curr_sum)

for sum in sums:
    print(sum)