wolf = False
goat = False
cabbage = False
other_side = True
count = 0

while True:
    count += 1
    print(count)
    if goat and cabbage and goat == other_side:
        print(f'All done')
        break
    if wolf == goat and wolf != other_side:
        print('Warning!')
        goat = True
        count += 1  # We return empty-handed
        print(count)
        continue
    if wolf == goat and wolf == other_side:
        print('Warning!')
        goat = False
        continue

    if goat == cabbage and cabbage != other_side:
        print('Warning!')
        cabbage = True
        continue
    if cabbage == wolf and cabbage != other_side:
        wolf = True
        continue
    if cabbage and wolf and goat != other_side:
        goat = True
        continue
