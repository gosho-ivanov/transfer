class Mammal:
    _kingdom = 'animals'

    def __init__(self, name: str, type: str, sound: str):
        self.name = name
        self.type = type
        self.soound = sound

    def make_sound(self):
        return f"{self.name} makes {self.soound}"
    
    def get_kingdom(self):
        return self._kingdom
    
    def info(self):
        return f"{self.name} is of type {self.type}"
    
mammal = Mammal("Dog", 'Domestic', 'Bark')
print(mammal.make_sound())
print(mammal.get_kingdom())
print(mammal.info())