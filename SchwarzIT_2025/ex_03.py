matrix = []
n = int(input("Enter the number of rows in the matrix: "))
while n <= 0:
    n = int(input("Invalid input. Please enter a positive integer: "))

for _ in range(n):
    data = list(map(int, input("Enter the elements of each row separated by ', ': ").split(", ")))
    matrix.append(data)


num_to_search = int(input("Enter the number you would like to look up: "))
row_index = 0
col_index = 0
found = False

for row in matrix:
    if num_to_search in row:
        col_index = row.index(num_to_search)
        found = True
        break
    row_index += 1


if found:
    print(f"({row_index}, {col_index})")
else:
    print("Not found!")