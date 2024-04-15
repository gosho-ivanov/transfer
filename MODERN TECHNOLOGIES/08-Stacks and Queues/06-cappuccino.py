from collections import deque

coffee_amount = deque(map(int, input().split(", ")))
milk_amount = deque(map(int, input().split(", ")))
coffees_made = 0

while coffees_made < 5 and coffee_amount and milk_amount:
    cur_coffee = coffee_amount.popleft()
    cur_milk = milk_amount.pop()
    if cur_coffee == cur_milk:
        coffees_made += 1
    else:
        if cur_coffee < cur_milk:
            coffee_amount.appendleft(cur_coffee + 10)
        milk_amount.appendleft(cur_milk)


print(coffees_made)
if coffees_made == 5:
    print("Great! You made all the cappuccinos needed!")
else: 
    print("Not enought cappuccions.")
if coffee_amount:
    print(f"Coffee left: {sum(coffee_amount)}ml.")
if milk_amount:
    print(f"Milk left: {sum(milk_amount)}ml.")