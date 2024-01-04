nums = input().split()
set1 = []
for i in range(int(nums[0])):
    set1.append(int(input()))
set1 = set(set1)
set2 = []
for j in range(int(nums[1])):
    set2.append(int(input()))
set2 = set(set2)

data = set1.intersection(set2)
print(*data, sep="\n")