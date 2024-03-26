from collections import deque

stack = deque()
N = int(input())
for _ in range(N):
    com = input()
    if com[0] == "1":
        com, value = com.split()
        stack.appendleft(int(value))
    elif com == "2":
        if stack:
            stack.pop()
    elif com == "3":
        print(max(stack))
    elif com == "4":
        print(min(stack))

print(*stack, sep=", ")