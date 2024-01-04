import math

def get_sqr_root(a: list):
    b = []
    for el in a:
        b.append(math.sqrt(el))
    return b

data = list(map(int, input().split()))
new = get_sqr_root(data)
for i in range (len(new)):
    print(f'Square of {data[i]} = {new[i]:.2f}')
