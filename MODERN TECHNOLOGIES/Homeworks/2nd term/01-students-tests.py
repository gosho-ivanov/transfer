from math import ceil

class_grades = {}
student_id = 1
points = input()
while points != "":
    points = list(map(int, points.split(", ")))
    class_grades[student_id] = points
    student_id += 1
    points = input()

for student, points in class_grades.items():
    avg_score = sum(points) / len(points)
    grade = 2 + (avg_score/100 * 4)
    print(f"{student}: {ceil(avg_score)} -> {grade:.2f}")