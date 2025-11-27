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

class EmpialShip(Battleship):
    def __init__(self, name: str, alliance: str, shield_capacity: int, blaster_dmg: int, speed: int, light_speed: bool, stealth_mode: bool):
        super().__init__(name,alliance, shield_capacity, blaster_dmg, speed, light_speed)
        self.stealth_mode = stealth_mode

    def travel(self, destination):
        if self.light_speed == False:
            print(f"Empial Ship {self.name} is en route to {destination}")
        else:
            print(f"Empial Ship {self.name} eneters lightspeed hyperspace en route to {destination}")
    
    def fight(self, enemy: object):
        if self.alliance == enemy.alliance:
            return None
        else:
            if isinstance(enemy, StarDestroyer):
                return "Defeat!"
            if self.blaster_dmg > enemy.shield_capacity:
                print("Victory!")
            elif enemy.shield_capacity > self.blaster_dmg:
                if enemy.blaster_dmg > self.shield_capacity:
                    print("Defeat!")
            else:
                print("Stalemate!")

            
class RebellShip(Battleship):
    def __init__(self, name: str, alliance: str, shield_capacity: int, blaster_dmg: int, speed: int, light_speed: bool, cloaking_device: bool):
        super().__init__(name,alliance, shield_capacity, blaster_dmg, speed, light_speed)
        self.cloaking_device = cloaking_device

    def travel(self, destination):
        if self.light_speed == False:
            print(f"Rebell Ship {self.name} is en route to {destination}")
        else:
            print(f"Rebell Ship {self.name} eneters lightspeed hyperspace en route to {destination}")
    
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
                print("Stalemate!")


class StarDestroyer(Battleship):
    def __init__(self,name: str, alliance: str, shield_capacity: int, blaster_dmg: int, speed: int, light_speed: bool, crew_amount: int, guns_amount: int):
        super().__init__(name,alliance, shield_capacity, blaster_dmg, speed, light_speed)
        self.crew_amount = crew_amount
        self.guns_amount = guns_amount

    def travel(self, destination):
        if self.light_speed == False:
            print(f"Star Destroyer {self.name} is en route to {destination}")
        else:
            print(f"Star Destroyer {self.name} eneters lightspeed hyperspace en route to {destination}")
    
    def fight(self, enemy: object):
        if self.alliance == enemy.alliance:
            return None
        else:
            if isinstance(enemy, XWing):
                return "Defeat!"
            if self.blaster_dmg > enemy.shield_capacity:
                print("Victory!")
            elif enemy.shield_capacity > self.blaster_dmg:
                if enemy.blaster_dmg > self.shield_capacity:
                    print("Defeat!")
            else:
                print("Stalemate!")

class TieFighter(Battleship):
    def __init__(self, name: str, alliance: str, shield_capacity: int, blaster_dmg: int, speed: int, light_speed: bool, agility: int):
        super().__init__(name,alliance, shield_capacity, blaster_dmg, speed, light_speed)
        self.agility = agility

    def dodge(self, enemy):
        if isinstance(enemy, TieFighter) == True:
            if self.agility > enemy.agility:
               return True
            else:
                return False
        else:
            pass

    
    def travel(self, destination):
        if self.light_speed == False:
            print(f"Tie Fighter {self.name} is en route to {destination}")
        else:
            print(f"Tie Fighter {self.name} eneters lightspeed hyperspace en route to {destination}")
    
    def fight(self, enemy: object):
        if self.alliance == enemy.alliance:
            return None
        else:
            if isinstance(enemy, StarDestroyer):
                return "Defeat!"
            if self.blaster_dmg > enemy.shield_capacity:
                print("Victory!")
            elif enemy.shield_capacity > self.blaster_dmg:
                if enemy.blaster_dmg > self.shield_capacity:
                    print("Defeat!")
            else:
                if self.dodge(enemy) == True:
                    print("Battle Evaded!")
                else:
                    print("Defeat!")

class YWing(Battleship):
    def __init__(self, name: str, alliance : str, shield_capacity: int, blaster_dmg: int, speed: int, light_speed: bool, bomb_capacity: int):
        super().__init__(name,alliance, shield_capacity, blaster_dmg, speed, light_speed)
        self.bomb_capacity = bomb_capacity

    def travel(self, destination):
        if self.light_speed == False:
            print(f"YWing {self.name} is en route to {destination}")
        else:
            print(f"YWing {self.name} eneters lightspeed hyperspace en route to {destination}")
    
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
                print("Stalemate!")

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

