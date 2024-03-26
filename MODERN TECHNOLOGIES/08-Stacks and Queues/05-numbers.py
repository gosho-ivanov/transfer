stack1 = set(map(int, input().split()))
stack2 = set(map(int, input().split()))

functions = {
    "Add First": lambda x: [stack1.add(el) for el in x],
    "Add Second": lambda x: [stack2.add(el) for el in x],
    "Remove Second": lambda x: [stack2.discard(el) for el in x],
    "Remove First": lambda x: [stack1.discard(el) for el in x],
    "Check Subset": lambda x: print(stack1.issubset(stack2) or stack2.issubset(stack1)),
}

for _ in range(int(input())):
    f_com, sec_com, *data = input().split()
    com = f"{f_com} {sec_com}"
    functions[com]([int(x) for x in data])

print(*stack1, sep=", ")
print(*stack2, sep=", ")