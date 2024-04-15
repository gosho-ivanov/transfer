employees = {}
data = input()
while data != "":
    data = list(data.split())
    id = data.pop(0)
    employees[id] = data
    data = input()

for id, data in employees.items():
    starting_year = int(data[2])
    salary = float(data[1])
    internship = 2024 - starting_year
    
    print(f"{id}: {data[0]} - {internship}, {salary:.2f} USD")