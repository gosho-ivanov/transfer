from itertools import permutations

backpack = int(input("Enter the weight that the backpack has: "))
n = int(input("Enter the number of possible items (between 2 and 5): "))
items_weight = []
statistics = []

for i in range(n):
    items_weight.append(int(input("Enter the weight of the current item (between 2 and 9 kgs): ")))

permutations_items = permutations(items_weight)

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
    statistics.append(data)

filled_backpack = []

for variant in statistics:
    total = 0
    for key in variant.keys():
        total += key*variant[key]
        if total == backpack:
            filled_backpack.append(variant)

for variant in filled_backpack:
    print(f"\nThe following variant fills the backpack succesfully:")
    for key in variant:
        print(f"{key} kg item: {variant[key]} times")