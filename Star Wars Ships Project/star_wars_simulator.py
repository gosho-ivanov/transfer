from __future__ import annotations
from abc import ABC, abstractmethod
from enum import Enum
from typing import Dict, Type
import random

# =========================
# Alliances
# =========================

class Alliance(Enum):
    REBELS = "Rebels"
    EMPIRE = "Empire"

# =========================
# Core Ship Model
# =========================

class Battleship(ABC):
    def __init__(
        self,
        name: str,
        alliance: Alliance,
        shield_capacity: int,
        hull: int,
        blaster_dmg: int,
        speed: int,
        light_speed: bool,
    ):
        self.name = name
        self.alliance = alliance
        self.max_shield = shield_capacity
        self.shield = shield_capacity
        self.max_hull = hull
        self.hull = hull
        self.blaster_dmg = blaster_dmg
        self.speed = speed
        self.light_speed = light_speed

    # -------- Status --------
    @property
    def alive(self) -> bool:
        return self.hull > 0

    def status(self) -> str:
        return (
            f"{self.name} [{self.alliance.value}] | "
            f"Shield: {self.shield}/{self.max_shield} | "
            f"Hull: {self.hull}/{self.max_hull}"
        )

    # -------- Movement --------
    def travel(self, destination: str):
        if self.light_speed:
            print(f"{self.name} jumps to hyperspace → {destination}")
        else:
            print(f"{self.name} travels sublight to {destination}")

    # -------- Combat --------
    def receive_damage(self, dmg: int):
        if self.shield > 0:
            absorbed = min(self.shield, dmg)
            self.shield -= absorbed
            dmg -= absorbed
        if dmg > 0:
            self.hull = max(0, self.hull - dmg)

    def can_attack(self, other: "Battleship") -> bool:
        return self.alive and other.alive and self.alliance != other.alliance

    @abstractmethod
    def fight(self, enemy: "Battleship"):
        pass

# =========================
# Faction Base Classes
# =========================

class RebelShip(Battleship):
    def __init__(self, **kwargs):
        super().__init__(alliance=Alliance.REBELS, **kwargs)


class EmpireShip(Battleship):
    def __init__(self, **kwargs):
        super().__init__(alliance=Alliance.EMPIRE, **kwargs)

# =========================
# Rebel Ships
# =========================

class XWing(RebelShip):
    def fight(self, enemy: Battleship):
        if not self.can_attack(enemy):
            return
        dmg = self.blaster_dmg + random.randint(5, 20)
        print(f"X-Wing {self.name} fires lasers at {enemy.name} ({dmg})")
        enemy.receive_damage(dmg)


class YWing(RebelShip):
    def fight(self, enemy: Battleship):
        if not self.can_attack(enemy):
            return
        dmg = int(self.blaster_dmg * 1.3)
        print(f"Y-Wing {self.name} drops proton bombs on {enemy.name} ({dmg})")
        enemy.receive_damage(dmg)


class AWing(RebelShip):
    def fight(self, enemy: Battleship):
        if not self.can_attack(enemy):
            return
        dmg = self.blaster_dmg
        if random.random() < 0.3:
            dmg *= 2
            print(f"A-Wing {self.name} scores a critical hit!")
        print(f"A-Wing {self.name} attacks {enemy.name} ({dmg})")
        enemy.receive_damage(dmg)


class MillenniumFalcon(RebelShip):
    def fight(self, enemy: Battleship):
        if not self.can_attack(enemy):
            return
        dmg = int(self.blaster_dmg * 1.5)
        print(f"Millennium Falcon {self.name} fires rear cannons ({dmg})")
        enemy.receive_damage(dmg)

# =========================
# Empire Ships
# =========================

class TIEFighter(EmpireShip):
    def fight(self, enemy: Battleship):
        if not self.can_attack(enemy):
            return
        dmg = self.blaster_dmg + random.randint(0, 15)
        print(f"TIE Fighter {self.name} strafes {enemy.name} ({dmg})")
        enemy.receive_damage(dmg)


class TIEInterceptor(EmpireShip):
    def fight(self, enemy: Battleship):
        if not self.can_attack(enemy):
            return
        dmg = int(self.blaster_dmg * 1.2)
        print(f"TIE Interceptor {self.name} performs rapid attack ({dmg})")
        enemy.receive_damage(dmg)


class StarDestroyer(EmpireShip):
    def __init__(self, turbolasers: int, **kwargs):
        super().__init__(**kwargs)
        self.turbolasers = turbolasers

    def fight(self, enemy: Battleship):
        if not self.can_attack(enemy):
            return
        dmg = self.blaster_dmg * self.turbolasers
        print(f"Star Destroyer {self.name} unleashes turbolasers ({dmg})")
        enemy.receive_damage(dmg)


class SuperStarDestroyer(StarDestroyer):
    def fight(self, enemy: Battleship):
        if not self.can_attack(enemy):
            return
        dmg = int(self.blaster_dmg * self.turbolasers * 1.5)
        print(f"SUPER Star Destroyer {self.name} devastates {enemy.name} ({dmg})")
        enemy.receive_damage(dmg)

# =========================
# Ship Factory & Registry
# =========================

SHIP_REGISTRY: Dict[str, Type[Battleship]] = {
    "X_WING": XWing,
    "Y_WING": YWing,
    "A_WING": AWing,
    "MILLENNIUM_FALCON": MillenniumFalcon,
    "TIE_FIGHTER": TIEFighter,
    "TIE_INTERCEPTOR": TIEInterceptor,
    "STAR_DESTROYER": StarDestroyer,
    "SUPER_STAR_DESTROYER": SuperStarDestroyer,
}

SHIP_STATS = {
    "X_WING": dict(shield_capacity=100, hull=120, blaster_dmg=45, speed=120, light_speed=True),
    "Y_WING": dict(shield_capacity=140, hull=160, blaster_dmg=40, speed=90, light_speed=True),
    "A_WING": dict(shield_capacity=80, hull=90, blaster_dmg=35, speed=150, light_speed=True),
    "MILLENNIUM_FALCON": dict(shield_capacity=200, hull=250, blaster_dmg=60, speed=110, light_speed=True),
    "TIE_FIGHTER": dict(shield_capacity=60, hull=80, blaster_dmg=40, speed=130, light_speed=False),
    "TIE_INTERCEPTOR": dict(shield_capacity=70, hull=90, blaster_dmg=45, speed=150, light_speed=False),
    "STAR_DESTROYER": dict(shield_capacity=500, hull=1000, blaster_dmg=30, speed=40, light_speed=True, turbolasers=6),
    "SUPER_STAR_DESTROYER": dict(shield_capacity=900, hull=2000, blaster_dmg=40, speed=35, light_speed=True, turbolasers=10),
}


class ShipFactory:
    @staticmethod
    def create(ship_type: str, name: str) -> Battleship:
        cls = SHIP_REGISTRY[ship_type]
        stats = SHIP_STATS[ship_type].copy()
        return cls(name=name, **stats)

# =========================
# Battle Simulator
# =========================

class Battle:
    def __init__(self, ships: list[Battleship]):
        self.ships = ships

    def alive_by_alliance(self, alliance: Alliance):
        return [s for s in self.ships if s.alive and s.alliance == alliance]

    def step(self):
        random.shuffle(self.ships)
        for ship in self.ships:
            enemies = [e for e in self.ships if ship.can_attack(e)]
            if enemies:
                target = random.choice(enemies)
                ship.fight(target)

    def run(self):
        round_no = 1
        while self.alive_by_alliance(Alliance.REBELS) and self.alive_by_alliance(Alliance.EMPIRE):
            print(f"\n--- Round {round_no} ---")
            self.step()
            for s in self.ships:
                print(s.status())
            round_no += 1

        winner = (
            Alliance.REBELS if self.alive_by_alliance(Alliance.REBELS) else Alliance.EMPIRE
        )
        print(f"\n🏆 Winner: {winner.value}")

# =========================
# Demo
# =========================

if __name__ == "__main__":
    fleet = [
        ShipFactory.create("X_WING", "Red Five"),
        ShipFactory.create("A_WING", "Green Leader"),
        ShipFactory.create("MILLENNIUM_FALCON", "Falcon"),
        ShipFactory.create("TIE_FIGHTER", "Black One"),
        ShipFactory.create("STAR_DESTROYER", "Devastator"),
    ]

    battle = Battle(fleet)
    battle.run()
