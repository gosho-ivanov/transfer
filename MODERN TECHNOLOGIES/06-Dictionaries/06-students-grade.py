average_grades = {}

data = input()
counter = 1
while data != "":
    f_name, l_name, grades = data.split()
    name = f_name + " " + l_name
    grades = grades.split(",")
    grades = list(map(int, grades))
    average_grades[counter] = {"name": name, "BEL": grades}
    data = input()
    counter += 1

for id, student in average_grades.items():
    avg_grade = sum(student["BEL"])/len(student["BEL"])
    print(f"{id}. {student["name"]} {avg_grade:.2f}")