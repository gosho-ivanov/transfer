days = {
        "Monday": 0,
        "Tuesday": 0,
        "Wednesday": 0,
        "Thursday": 0,
        "Friday": 0,
        }

for i in range(1, 6):
    good_pcbs = list(map(int, input().split("-")))
    total_pcbs = len(good_pcbs)*10
    good_pcbs = sum(good_pcbs)

    percentage_good_pcbs = (good_pcbs / total_pcbs) * 100
    if i == 1: 
        days["Monday"] += percentage_good_pcbs
    elif i == 2:
        days["Tuesday"] += percentage_good_pcbs
    elif i == 3:
        days["Wednesday"] += percentage_good_pcbs
    elif i == 4:
        days["Thursday"] += percentage_good_pcbs
    elif i == 5:
        days["Friday"] += percentage_good_pcbs

for day, percentage in days.items():
    print(f"{day} : {percentage:.1f}%")