from collections import deque

unsorted_sheep = list(map(float, input().split()))
preggos = deque(map(float, input().split()))
categorised = []

for el in unsorted_sheep:
    if el >= 20:
        preggos.appendleft(el)
    else:
        categorised.append(el)

print(f"Pregnant sheep: {len(preggos)}")
print(*preggos, sep=", ")
print(*unsorted_sheep, sep=", ")