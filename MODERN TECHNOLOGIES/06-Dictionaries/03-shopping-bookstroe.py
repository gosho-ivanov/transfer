shopping_cart = {}
command = input()
while command != "print":
    data = command.split("-")
    if data[0] not in  shopping_cart.keys():
        shopping_cart[data[0]] = 0
    shopping_cart[data[0]] += int(data[1])
    command = input()

print("Products from the booktsotre:")
for key, value in shopping_cart.items():
    print(f"{key}: {value}")

print(f"Total products: {len(shopping_cart.keys())}\n"
      f"Total quantity: {sum(shopping_cart.values())}")