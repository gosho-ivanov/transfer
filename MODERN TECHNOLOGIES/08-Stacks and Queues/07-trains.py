from collections import deque

N = int(input())
train = deque(input().split())
puller_spot = True

for _ in range(N):
    command = input().split()
    if puller_spot:
        if "Load " in command:
            train.append(data[1])
        elif command[0] == "Unload":
            train.pop()
        elif command[0] == "Change":
            puller_spot = not puller_spot
    else:
        if "Load " in command:
            com, data = command.split()
            train.appendleft(data)
        elif command[0] == "Unload":
            train.popleft()
        elif command[0] == "Change":
            puller_spot = not puller_spot
    
train = tuple(map(int, train))
print(*train, sep=", ")
print(sum(train))