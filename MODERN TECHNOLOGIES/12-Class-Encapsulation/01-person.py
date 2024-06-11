class Person:
    def __init__(self, name: str, age: int):
        self.__name = name
        self.__age = age

    def get_name(self):
        return self.__name

    def get_age(self):
        return self.__age

p1 = Person('Georgi', 16)
print(p1.get_name())
print(p1.get_age())