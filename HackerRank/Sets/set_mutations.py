a = int(input())
set1 = set(map(int, input().split()))
n = int(input())

for _ in range(n):
    command, set2_length = input().split()
    set2 = set(map(int, input().split(" ")))
    if command == "update":
        set1.update(set2)
    elif command == "intersection_update":
        set1.intersection_update(set2)
    elif command == 'symmetric_difference_update':
        set1.symmetric_difference_update(set2)
    elif command == "difference_update":
        set1.difference_update(set2)

print(sum(set1))