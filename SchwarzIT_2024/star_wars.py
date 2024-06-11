from abc import ABC, abstractclassmethod

class Battleship(ABC):
    def __init__(self, name: str, alliance: str, shield_capacity: int, blaster_dmg: int, speed: int, light_speed: bool):
        self.name = name
        self.alliance = alliance
        self.shield_capacity = shield_capacity
        self. blaster_dmg = blaster_dmg
        self.speed = speed
        self.light_speed = light_speed

    def travel(self, destination: str):
        pass
    
    @abstractclassmethod
    def fight(self, enemy: object):
        pass

class XWing(Battleship):
    def __init__(self, name: str, alliance : str, shield_capacity: int, blaster_dmg: int, speed: int, light_speed: bool, maneuverability: int):
        super().__init__(name,alliance, shield_capacity, blaster_dmg, speed, light_speed)
        self.maneuverability = maneuverability

    def evade(self, enemy):
        if isinstance(enemy, XWing) == True:
            if self.maneuverability > enemy.maneuverability:
               return True
            else:
                return False
        else:
            pass

    
    def travel(self, destination):
        if self.light_speed == False:
            print(f"XWing {self.name} is en route to {destination}")
        else:
            print(f"XWing {self.name} eneters lightspeed hyperspace en route to {destination}")
    
    def fight(self, enemy: object):
        if self.alliance == enemy.alliance:
            return None
        else:
            if isinstance(enemy, StarDestroyer):
                return None
            if self.blaster_dmg > enemy.shield_capacity:
                print("Victory!")
            elif enemy.shield_capacity > self.blaster_dmg:
                if enemy.blaster_dmg > self.shield_capacity:
                    print("Defeat!")
            else:
                if self.evade(enemy) == True:
                    print("Battle Evaded!")
                else:
                    print("Defeat!")



class StarDestroyer(Battleship):
    def __init__(self,name: str, alliance: str, shield_capacity: int, blaster_dmg: int, speed: int, light_speed: bool, crew_amount: int, guns_amount: int):
        self.crew_capacity = crew_amount
        self.guns_amount = guns_amount
        self.total_power = guns_amount * blaster_dmg
        super().__init__(name, alliance, shield_capacity, blaster_dmg, speed, light_speed)

    def deploy_troops(self, location: str):
        if self.light_speed == True:
            print(f"Star Destroyer {self.name} enters lightspeed hyperspace en router to {location}")
        else:
            print(f"Star Destroyer {self.name} deployes troops to {location}")
    
    def fight(self, enemy):
        if enemy.alliance == self.alliance:
            return None
        else:
            if isinstance(enemy, XWing):
                return None
            if self.total_power > enemy.shield_capacity:
                print("Victory!")
            elif enemy.shield_capacity > self.total_power:
                if enemy.total_power > self.shield_capacity:
                    print("Defeat!")
            else:
                print("Both ships damaged!")
    

class SpaceshipFactory:
    def create_XWing(*args):
        name,alliance, shield_capacity, blaster_dmg, speed, light_speed, maneuverability = args[1:]
        return XWing(name, alliance, shield_capacity, blaster_dmg, speed, light_speed, maneuverability)

    def create_StarDestroyer(*args):
        name, alliance, shield_capacity, blaster_dmg, speed, light_speed, crew_amount, guns = args[1:]
        return StarDestroyer(name, alliance, shield_capacity, blaster_dmg, speed, light_speed, crew_amount, guns)
    

factory = SpaceshipFactory()

x1 = factory.create_XWing("mitko", "Rebel", 90, 110, 100, False, 100)
x2 = XWing("mitko", "Empire", 90, 110, 100, False, 100)

x1.fight(x2)
x1.travel("Nabu")
print(x1.name)
x2.travel("Nabu")

print()

sd1= factory.create_StarDestroyer("niki", "Rebel", 500, 900, 100, False, 70, 1000)
sd2= StarDestroyer("niki", "Empire", 500, 900, 100, False, 70, 1000)
print(sd1.name)
print(sd2.alliance)
x1.fight(x2)
x2.fight(sd1)
sd2.fight(x1)
