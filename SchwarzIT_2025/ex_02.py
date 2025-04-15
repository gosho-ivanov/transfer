from abc import ABC

class DefenceStructure(ABC):
    def __init__(self, name: str, health: int):
        self.name = name
        self.health = health

    def attack(self, target: object, damage: int):
        if isinstance(target, DefenceStructure):
            target.takeDamage(damage)
    
    def takeDamage(self, damage_taken: int):
        self.health -= damage_taken
        if self.health <= 0:
            print(f"{self.name} is destroyed!")
    
    def repair(self, health_gain: int):
        self.health += health_gain
    
class ArcherTower(DefenceStructure):
    def __init__(self, name: str, health: int, range: int):
        super().__init__(name, health)
        self.range = range

    def defend(self, castle: object):
        if isinstance(castle, Castle):
            print(f"Archer Tower {self.name} is defending {castle.name}!")

class Castle(DefenceStructure):
    def __init__(self, name: str, health: int, drawbridge: bool, defenders: list, towers: list):
        super().__init__(name, health)
        self.drawbridge = drawbridge
        self.defenders = defenders
        self.towers = towers
    
    def addDefender(self, warrior: object):
        if warrior not in self.defenders and isinstance(warrior, Warrior):
            self.defenders.append(warrior)
        else:
            print("The warrior is already a defender of this castle or isn't an instance of class \"Warrior\" or it's inherited classes.")
    
    def removeDefender(self, warrior):
        if warrior in self.defenders:
            self.defenders.remove(warrior)

    def addTower(self, tower: ArcherTower):
        if tower not in self.towers:
            self.towers.append(tower)
        
    def removeTower(self, tower: ArcherTower):
        if tower in self.towers:
            self.towers.remove(tower)


class Warrior:
    def __init__(self, name: str, health: int, attack_power: int):
        self.name = name
        self.health = health
        self.attack_power = attack_power

    def attack(self, target: DefenceStructure):
        target.takeDamage(self.attack_power)

class Knight(Warrior):
    def __init__(self, name: str, health: int, attack_power: int, armour: int, weapon: str):
        super().__init__(name, health, attack_power)
        self.armour = armour
        self.weapon = weapon
    
    def defend(self, castle: Castle):
        if self.armour < 50:
            print(f"Knight {self.name} is defending {castle.name}.")
        else:
            print(f"Knight {self.name} stands strong at the gates of {castle.name}")
        
    def fight(self, opponent: Warrior):
        fight_status = False
        if isinstance(opponent, Knight):
            opponent.armour -= self.attack_power
            if opponent.armour <= 0:
                opponent.health += opponent.armour
                opponent.armour = 0
                if opponent.health <= 0:
                    fight_status = True
        else:
            opponent.health -= self.attack_power
            if opponent.health <= 0:
                fight_status = True
        
        if fight_status:
            print("Victory!")
        else:
            print("Defeat!")


def main():
    castle = Castle("Dragon's Spire", 100, False, [], [])
    t1 = ArcherTower("Tower 1", 50, 200)
    t2 = ArcherTower("Tower 2", 100, 400)
    w1 = Warrior("Goshko", 20, 30)
    w2 = Warrior("Niki", 60, 10)
    k1 = Knight("Sir Edward", 80, 40, 70, "Axe")
    k2 = Knight("Sir John", 90, 50, 80, "Sword")

    castle.addDefender(t1)
    castle.addDefender(k1)
    castle.addTower(t1)
    castle.addTower(t2)

    print(castle.health)
    k2.attack(castle)
    print(castle.health)
    k1.fight(k2)

    print(t1.health)
    w1.attack(t1)
    print(t1.health)
    t1.repair(20)
    print(t1.health)
    t1.defend(castle)
    k1.defend(castle)
    k2.defend(castle)

if __name__ == "__main__":
    main()