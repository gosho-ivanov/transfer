courses = {}

course = input()
while "->" in course:
    data = course.split(" -> ")
    if data[0] not in courses.keys():
        courses[data[0]] = 0
    courses[data[0]] += int(data[1])
    course = input()

if course in courses.keys():
    print(f"{course} - {courses[course]}")