from math import ceil

dict = {}
data = input()
while data != "":
    data = data.split()
    water_calc = data[0]
    calc_water = list(map(int, data[1:len(data)]))
    dict[water_calc] = calc_water
    data = input()

for key, values in dict.items():
    avg_water = sum(values)/6
    total = sum(values) * 1.843
    print(f"{key} - {ceil(avg_water)} - {total:.2f} BGN")