data = tuple(map(float, input().split()))
# new_data = {}
# for i in range(len(data)):
#     if data[i] not in new_data.keys():
#         new_data[data[i]] = 1
#     else:
#         new_data[data[i]] += 1
#
# for key, value in new_data.items():
#     if key <0:
#         print(" "*5 + str(key)+ " "*6 + f"{value} times")
#     else:
#         print(" "*6 + str(key) + " "*6 + f"{value} times")
checked_nums = []
for el in data:
    if el not in checked_nums:
        print(f"{el:6}{data.count(el):6} times")
        checked_nums.append(el)
