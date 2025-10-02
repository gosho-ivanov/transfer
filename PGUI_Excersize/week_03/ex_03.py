while True:
    age = int(input("Enter your age: "))
    if age < 0:
        print("Invalid age, try again.")
    else: break

print("You can vote") if age >= 18 else print("You cannot vote yet")

