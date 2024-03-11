n = int(input())
data = set(map(int, input().split()))
N= int(input())
for _ in range(N):

    info = input()
    if info == "pop":
        data.pop()
    else:
        command,  value = info.split(" ")
        value = int(value)
        if command == "remove":
            data.remove(value)
        elif command == "discard":
            data.discard(value)
        
print(sum(data))