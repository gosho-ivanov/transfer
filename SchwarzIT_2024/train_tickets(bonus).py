def checkSales(age_passenger, time, price_ticket):
    hours = int(time[:2])
    minutes = int(time[3:])
    if (0 <= hours <= 6 and 0<= minutes < 60) or (19 <= hours <= 23 and 0<= minutes < 60):
        price_ticket -= price_ticket * 0.05

    age_passenger = int(age_passenger)
    if age_passenger <= 7:
        price_ticket = 0
    elif 7 < age_passenger < 13:
        price_ticket -= price_ticket * 0.2
    elif 12 < age_passenger < 19 or 64 <= age_passenger:
        price_ticket -= price_ticket * 0.1

    return price_ticket






destination_count = int(input("Destinations: "))
destinations = {}


for i in range(destination_count):
    destination, price = input().split()
    destinations[i] = [destination, float(price[:-3]), 0]

print(f"\n{destinations[0][0]}:")
data = input()
i = 0
counter_destination = 0
while i in destinations.keys():
    if "NEXT DESTINATION" in data:
        if counter_destination >= 4:
            destinations[i][2] -= destinations[i][2] * 0.05
        counter_destination = 0
        i += 1
        if i not in destinations.keys(): break

        print(f"\n{destinations[i][0]}")
        data = input()
        continue

    age, time = data.split("y ")
    price = checkSales(age, time, destinations[i][1])
    destinations[i][2] += price
    counter_destination += 1
    data = input()

print("No more destinations left!")
for i in range(len(destinations)):
    print(f"{destinations[i][0]}: {destinations[i][2]:.2f}bgn")