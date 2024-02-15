row = int(input())

matrix = []
for _ in range(row):
    a=[]
    els = input().split(", ")
    for el in els:
        if int(el) %2 == 0:
            a.append(el)
    matrix.append(a)

print(matrix)