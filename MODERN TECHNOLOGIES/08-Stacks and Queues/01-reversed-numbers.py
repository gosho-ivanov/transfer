from collections import deque

stack = deque(input())

while stack:
    el = stack.pop()
    print(el, end="")