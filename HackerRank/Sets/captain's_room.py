k = int(input())
rooms_list = list(map(int, input().split()))
sets_per_group = []

number_groups = len(rooms_list)//k
low = 0
high = k
for _ in range(number_groups+1):
    set_group = set(rooms_list[low:high])
    low = high
    high += k
    sets_per_group.append(set_group)

captian_room = sets_per_group[0]
for i in range(1, len(sets_per_group)):
    temp = captian_room
    captian_room = captian_room.difference(sets_per_group[i])
    if captian_room == set():
        captian_room = sets_per_group[i].difference(temp)


print(sum(captian_room))