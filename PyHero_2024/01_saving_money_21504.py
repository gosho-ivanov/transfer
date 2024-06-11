data = list(map(int, input().split(", ")))
purses = int(input())
purses_money = {}

while data:
    for i in range(1, purses+1):
        if i not in purses_money.keys():
            purses_money[i] = 0
        if data:
            purses_money[i] += data[0]
            del data[0]
        else:
            break

for purse, money in purses_money.items():
    print(f"Purse {purse} - {money:.2f}lv")
