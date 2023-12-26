days = int(input())
total_blueberries = []

for i in range(1,days+1):
    collected = list(map(float, input().split(", ")))
    pickers = len(collected)
    total_for_day = sum([x for x in collected if x >= 1])
    total_blueberries.append(total_for_day)
    print(f"Day {i}: {pickers} blueberry pickers -> total: {total_for_day:.2f} kg")

print(f"Total blueberries: {sum(total_blueberries):.2f} kg\n"
      f"The most blueberries were collected during day {total_blueberries.index(max(total_blueberries))+1}")
