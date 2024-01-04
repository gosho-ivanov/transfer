n = int(input())
data = []
for i in range(n):
    data.append(input())
data = set(data)

print(*data, sep = "\n")