from collections import deque

customers = deque()

command = input()

while command != "End":
    if command == "Info":
        while customers:
            print(customers.popleft())
    elif "#" in input():
        customers.append(command)
    command = input()

print(f"{customers.size()} customers remaining")