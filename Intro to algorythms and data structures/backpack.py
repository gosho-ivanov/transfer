from itertools import permutations

backpack = int(input("Enter the weight that the backpack has: "))
n = int(input("Enter the number of possible items (between 2 and 5): "))
items_weight = []
statistics = []

for i in range(n):
    items_weight.append(int(input("Enter the weight of the current item (between 2 and 9 kgs): ")))

permutations_items = list(permutations(items_weight))
valid_permutations = 0

for perm in permutations_items:
    m = backpack
    index = 0
    data = {}
    while index < len(perm) and m > 0:
        fitting_items = m//perm[index]
        if fitting_items > 0:
            data[perm[index]] = fitting_items
            m -= fitting_items*perm[index]
        index+=1
    if m == 0:
        valid_permutations+=1
        print(f"\nThe following variant fills the backpack succesfully:\n"
              f"Permutation: {perm}")
        for key in data.keys():
            print(f"{key} kg item: {data[key]} times")

print(f"\n{len(permutations_items)} permutations were created and only {valid_permutations} filled the backpack succesfully.")