from itertools import permutations

M = int(input("Input backpack capacity in kilograms: "))
N = int(input("Input  number of subjects in the interval from 2 to 5: "))
G = []
for i in range(N):
    G.append(int(input(f"Input weight of subject {i+1} which cannot be less than 2 kilograms: ")))
STAT = [0] * N
PERMUTATIONS = permutations(G)
for Perm in PERMUTATIONS:
    print(Perm)
    m = M
    for i in range(N):
        STAT[i] = 0
        while m >= Perm[i]:
            STAT[i] += 1
            m -= Perm[i] 
    if m == 0:
        print("There are items to accurately represent the weight of the backpack.")
        for i in range(N):
            print(f"{STAT[i]} of subject {i+1}")
    else:
        print("No items to accurately represent backpack weight")
