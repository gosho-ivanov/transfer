class Person:
    def __init__(self, first_name: str, last_name: str, age: int, nationality: str):
        self.first_name = first_name
        self.last_name = last_name
        self.age = age
        self.nationality = nationality

    def __str__(self):
        return f"{self.first_name} {self.last_name}, Age: {self.age}, Nationality: {self.nationality}"

    def greet(self):
        return f"Hello, my name is {self.first_name} {self.last_name}, I am {self.age} years old and I am {self.nationality}."

class Student(Person):
    def __init__(self, first_name: str, last_name: str, age: int, nationality: str, university: str, study_year: int):
        super().__init__(first_name, last_name, age, nationality)
        self.university = university
        self.study_year = study_year

    def __str__(self):
        return f"{super().__str__()}, University: {self.university}, Study Year: {self.study_year}"
    
# За този клас не знаех дали опитът трябва да е като списък със работни места или се има в предвид години опит, затова го направих като списък с работни места.
class Lecturer(Person):
    def __init__(self, first_name: str, last_name: str, age: int, nationality: str, university: str, experience: list[str]):
        super().__init__(first_name, last_name, age, nationality)
        self.university = university
        self.experience = experience

    def __str__(self):
        exp_str = ', '.join(self.experience)
        return f"{super().__str__()}, University: {self.university}, Experience: {exp_str}"
    

def main():
    person = Person("Alice", "Johnson", 30, "Canadian")
    student = Student("John", "Doe", 20, "American", "MIT", 2)
    lecturer = Lecturer("Jane", "Smith", 45, "British", "Oxford", ["10 years at University A", "5 years at University B"])

    print(person)
    print(person.greet())
    print(student)
    print(student.greet())
    print(lecturer)
    print(lecturer.greet())


if __name__ == "__main__":
    main()