beginning_side = False
other_side = True
wolf = beginning_side
goat = beginning_side
cabbage = beginning_side
count = 0

while True:
    count += 1
    print(count)
    if goat and cabbage and wolf and goat == other_side:
        print(f'All done')
        break
    if cabbage == goat and cabbage != other_side:
        print('Warning!')
        goat = other_side
        count += 1  # We return empty-handed
        print(count)
        continue
    if wolf == goat and wolf!= other_side:
        print('Warning!')
        wolf = other_side
        continue

    if goat == cabbage and cabbage == other_side:
        print('Warning!')
        goat = beginning_side
        continue
    if cabbage == wolf and cabbage != other_side:
        cabbage = other_side
        continue
    if cabbage and wolf and goat != other_side:
        goat = other_side
        continue
