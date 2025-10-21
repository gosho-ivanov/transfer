symbols = list("M33FW2cWbxDM9Vk8kdxRj8Qju5dkFNM0m=csNd0FBzxxN12RMdfDczM=Xj9QwRzzNcG1fsDc")

# The numbers in the order you listed them:
order = [
    37, 6, 68, 11, 42, 26, 57, 18, 49, 3, 34, 65, 15, 46, 16, 47, 2, 33, 64, 1, 32, 63, 27, 58,
    12, 43, 13, 44, 14, 45, 17, 48, 40, 71, 9, 24, 55, 29, 60, 35, 4, 66, 20, 51, 31, 62, 36, 5,
    67, 21, 52, 30, 61, 10, 41, 72, 25, 56, 39, 70, 8, 23, 54, 28, 59, 19, 50, 38, 69, 7, 22, 53
]

# Reorder symbols so that flag1.txt corresponds to the first, flag2.txt to the second, etc.
reordered = [''] * len(order)
for i, flag_num in enumerate(order):
    reordered[flag_num - 1] = symbols[i]

print("".join(reordered))
