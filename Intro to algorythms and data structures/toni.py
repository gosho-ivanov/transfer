from itertools import permutations

M = int(input("Enter the capicity of the backpack: "))
N = int(input("Enter the number of objects (2 - 5): "))
G = []

for i in range(N):
    G.append(int(input("Enter the weight of the object (2kg - 9kg): ")))

perm = permutations(G)

for i in list(perm):
    rem = M
    c_conter = 0
    t_counter = 0
    for item in i:
        if rem/item >= 0:
            c_counter = int(rem/item)
        rem %= item
        t_counter += c_counter
    
    print(i)
    if rem != 0:
        print("Not possible.")
    else:
        print(t_counter)
