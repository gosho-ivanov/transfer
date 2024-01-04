s1 = {1, 2, 3, 4, 5}
s2 = {"a", "b", "c", "d"}
mix = {1, "gay", False, 4.20}

my_set = {"Python", "Java", "PHP", "HTML", "CSS"}
# print(my_set)

# SETS HAVE NO INDEXES AND WHEN PRINTED THEY COME OUT RANDOMLY

# for el in my_set:
#     print(el, end="; ")
# print()

# my_set.add("Ruby")
# print(*my_set, sep=" * ")

# my_set.update(["Assembly"]) # ADD ELEMENTS IN lIST!!!!!
# print(*my_set, sep=" ")

# my_set.remove("CSS") # GIVES ERROR IF THE GIVEN ELEMENT IS NOT IN THE SET
# print(*my_set, sep=" ")

# my_set.discard("HTML") # GIVES NO ERROR IF THE GIVEN ELEMENT IS NOT IN THE SET
# print(*my_set, sep=" ")

new_set = {"Python", "Assembly", "MySQL", "Ruby"}

data = new_set.union(my_set) # .union() ADDS ONLY THE UNIQUE ELEMENTS
print(*data, sep="; ")

data = new_set.intersection(my_set) # .intersect() ADDS ONLY THE NON_UNIQUE ELEMENTS
print(*data, sep=" ")