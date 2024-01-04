data = list(map(float, input().split()))
x = lambda x: abs(x)
for i in range(len(data)):
    data[i] = x(data[i])

print(data)