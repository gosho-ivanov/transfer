from abc import ABC, abstractmethod

class Room(ABC):
    def __init__(self, room_number, price_per_night):
        self.__room_number = room_number
        self.__price_per_night = price_per_night

    def get_room_numebr(self) -> int:
        return self.__roomNumber

    def set_room_number(self, room_number: int) -> None:
        self.__room_number = room_number
    
    def get_price_per_night(self) -> float:
        return self.__price_per_night
    
    def set_price_per_night(self, price_per_night: float) -> None:
        self.__price_per_night = price_per_night

class Suite(Room):
    def __init__(self, roomNumber):
        super().__init__(roomNumber, 50)

class Apartment(Room):
    def __init__(self, roomNumber):
        if roomNumber > 10:
            super().__init__(roomNumber, 150)
        else:
            super().__init__(roomNumber, 100)




class HotelPersonel(ABC):
    def __init__(self, workerID, name):
        self.workerID = workerID
        self.name = name

    @abstractmethod
    def greet(self, tourist) -> None:
        ...
    
class Cleaner(HotelPersonel):
    def __init__(self, workerID, name, cleanedRooms: list):
        super().__init__(workerID, name)
        self.cleanedRooms = cleanedRooms

    def greet(self, tourist):
        print(f"Enjoy your stay, {tourist.get_name()}")

    def clean(self, room: Room):
        self.cleanedRooms.append(room)

class Receptionist(HotelPersonel):
    def __init__(self, workerID, name, takenRooms: list):
        super().__init__(workerID, name)
        self.takenRooms = takenRooms
    
    def greet(self, tourist):
        print(f"Enjoy your stay, {tourist.get_name}")

    def assign_room(self, tourist, room):
        self.takenRooms.append(room)
        tourist.set_room(room)

class Tourist:
    def __init__(self, name: str, stayDays: int, isAllInclusive: bool):
        self.__name = name
        self.__room = None
        self.__stayDays = stayDays
        self.__isAllInclusive = isAllInclusive
    
    def get_name(self):
        return self.__name

    def set_name(self, name):
        self.__name = name
    
    def get_room(self):
        return self.__room.roomNumber
    
    def set_room(self, room: Room):
        self.__room = room
    
