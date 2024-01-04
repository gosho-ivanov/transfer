present_products = set(input().split(", "))
recipe = input()
needed_products = set()
product = input()
count = 0
while product != "":
    needed_products.add(product)
    count+=1
    product = input()

to_buy = needed_products.intersection(present_products)
needed_count = 0
for el in to_buy:
    needed_count+=1
unnecessary = present_products.difference(needed_products)

print(
    f"There are {count} products for {recipe}: {', '.join(present_products.intersection(needed_products))}\n"
    f"You need to buy {needed_count} products: {', '.join(to_buy)}\n"
    f"Unnecessary products: {', '.join(unnecessary)}"
)