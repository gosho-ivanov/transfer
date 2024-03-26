from collections import deque

iso_data = input().split("-")
stack = deque([x for x in iso_data])

while len(stack)!=1:
    x = stack.pop()
    print(f"{x}", end=".")
print(stack.pop())