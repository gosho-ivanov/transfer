average_grades = {}

data = input()
while data != "":
    f_name, l_name, grades = data.split()
    name = f_name + " " + l_name
    grades = grades.split(",")
    grades = list(map(int, grades))
    average_grades[name] = grades
    data = input()

counter = 1
for name, grades in average_grades.items():
    avg_grade = sum(grades)/len(grades)
    print(f"{counter}. {name} {avg_grade:.2f}")