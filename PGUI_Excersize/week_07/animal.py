class Animal:
    def __init__(self, species: str, name: str, age: int, gender: str, habitat: str):
        self.__species = species
        self.__name = name
        self.__age = age
        self.__gender = gender
        self.__habitat = habitat 

    def info(self) -> str:
        return f"This is a {self.__age}-year-old {self.__gender} {self.__species} named {self.__name} who lives in the {self.__habitat}."
    
    def get_species(self) -> str:
        return self.__species
    
    def get_name(self) -> str:
        return self.__name
    
    def get_age(self) -> int:
        return self.__age
    
    def get_gender(self) -> str:
        return self.__gender
    
    def get_habitat(self) -> str:
        return self.__habitat
    
    def set_species(self, species: str) -> None:
        self.__species = species
    
    def set_name(self, name: str) -> None:
        self.__name = name
    
    def set_age(self, age: int) -> None:
        self.__age = age
    
    def set_gender(self, gender: str) -> None:
        self.__gender = gender
    
    def set_habitat(self, habitat: str) -> None:
        self.__habitat = habitat

    @classmethod
    def get_animals_with_same_habitat(cls, animals: list, habitat: str) -> list:
        return [animal for animal in animals if animal.get_habitat() == habitat]

    @classmethod
    def get_average_age(cls, animals: list) -> float:
        if not animals:
            return 0.0
        total_age = sum(animal.get_age() for animal in animals)
        return total_age / len(animals)

def main():
    animal1 = Animal("Lion", "Leo", 5, "Male", "Savannah")
    animal2 = Animal("Elephant", "Ella", 10, "Female", "Savannah")
    animal3 = Animal("Penguin", "Penny", 3, "Female", "Antarctica")
    animals = [animal1, animal2, animal3]
    for animal in animals:
        print(animal.info())
    savannah_animals = Animal.get_animals_with_same_habitat(animals, "Savannah")
    print(f"Animals in Savannah: {[animal.get_name() for animal in savannah_animals]}")
    average_age = Animal.get_average_age(animals)
    print(f"Average age of animals: {average_age}")


if __name__ == "__main__":
    main()    