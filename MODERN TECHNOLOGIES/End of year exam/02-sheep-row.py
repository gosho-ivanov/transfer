from collections import deque

to_be_cut = deque(map(float, input().split()))
min_kgs = float(input())

under_min = deque()
total_collected = 0

for i in range(len(to_be_cut)-1, -1, -1):
    sheep = to_be_cut[i]
    if sheep <= min_kgs:
        under_min.appendleft(sheep)
    else:
        total_collected += sheep

print(f"Sheep's wool: {total_collected:.2f}")
print(*under_min, sep=", ")