n = int(input())
data = []
for i in range(n):
    elements = input().split()
    for el in elements:
        data.append(el)
data = set(data)

print(*data, sep="\n")