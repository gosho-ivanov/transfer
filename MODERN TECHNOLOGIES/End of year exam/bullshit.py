from collections import deque

wool_collecting = deque(map(float, input().split()))
sum_wool = 0
minimum = int(input())
not_good = []

for el in wool_collecting:
    if el > minimum:
        sum_wool += el
    else:
        not_good.append(el)

print(f"Sheep's wool: {sum_wool:.2f}")
print(*not_good, sep=", ")