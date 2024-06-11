pickaxe_materials= {
    "Cobblestone":3,
    "Stick":2
}
sticks_amount = 0
cobblestone_amount = 0



com = input()
while com!= "END":
    if com == "Wood":
        sticks_amount += 4
    elif com == "Cobblestone":
        cobblestone_amount += 1
    elif com == "Sticks":
        sticks_amount += 1
    com = input()

pickaxe_per_stick = sticks_amount // pickaxe_materials["Stick"]
pickaxe_per_cobblestone = cobblestone_amount // pickaxe_materials["Cobblestone"]

if pickaxe_per_stick <= pickaxe_per_cobblestone:
    print(f"Amount of stone pickaxes: {pickaxe_per_stick}")
else:
    print(f"Amount of stone pickaxes: {pickaxe_per_cobblestone}")