def get_squared(a: list):
    return a[0]**a[1]

data = list(map(int, input().split(", ")))
print(f'{data[0]} to the power of {data[1]} is {get_squared(data)}')
