num_of_students = int(input("Number of students: "))
students = {}

for i in range(1, num_of_students+1):
    students[i] = input()

for id, name in students.items():
    print(f"{id}: {name}")