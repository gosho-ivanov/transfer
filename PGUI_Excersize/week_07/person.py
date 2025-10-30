class Person:
    def __init__(self, first_name, last_name, age, nationality):
        self.first_name = first_name
        self.last_name = last_name
        self.age = age
        self.nationality = nationality


    def greet(self):
        return f"Hello, my name is {self.first_name} {self.last_name}, I am {self.age} years old and I am {self.nationality}."
    
def main():
    person1 = Person("John", "Doe", 30, "American")
    person2 = Person("Jane", "Smith", 25, "British")
    
    print(person1.greet())
    print(person2.greet())

if __name__ == "__main__":
    main()