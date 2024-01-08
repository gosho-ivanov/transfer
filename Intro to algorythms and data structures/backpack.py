from itertools import permutations

backpack = int(input("Enter the weight that the backpack has: "))
n = int(input("Enter the number of possible items (between 2 and 5): "))
items_weight = []
statistics = []

for i in range(n):
    items_weight.append(int(input("Enter the weight of the current item (between 2 and 9 kgs): ")))

permutations_items = list(permutations(items_weight))

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
perms_locations = []
for variant in statistics:
    total = 0
    for key in variant.keys():
        total += key*variant[key]
        if total == backpack:
            if variant not in filled_backpack:
                filled_backpack.append(variant)
                perms_locations.append(statistics.index(variant))
            else:
                filled_backpack.append(variant)
                perms_locations.append(statistics.index(variant)+1)

index = 0
for variant in filled_backpack:
    print(f"\nThe following variant fills the backpack succesfully:\n"
          f"Permutation: {permutations_items[perms_locations[index]]}")
    for key in filled_backpack[index].keys():
        print(f"{key} kg item: {variant[key]} times")
    index+=1

print(f"\n{len(permutations_items)} permutations were created and only {len(filled_backpack)} filled the backpack succesfully.")