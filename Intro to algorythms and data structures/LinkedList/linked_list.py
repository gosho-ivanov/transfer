#Създаваме конструкция за възлите
class Node:
    def __init__(self, data):
        self.data = data
        self.next = None

#Създаваме клас за свързания списък
class LinkedList:
    def __init__(self):
        self.head = None
    
    #Създаваме метод за добавяне на елементи
    def append(self, data):
        new_node = Node(data)

        #Проверяваме дали има предишен елемент в списъка
        if self.head == None:
            #Ако няма => слагаме нововъведения елемент като "глава"
            self.head = new_node
        else:
            #Ако има => намираме последния елемент и го свързваме с новия
            last = self.head
            while last.next:
                last = last.next
            last.next = new_node
    
    #Създаваме метод за премахване на елементите
    def delete(self, key):
        temp = self.head

        #Ако листа е празен спираме да търсим
        if temp == None:
            return

        #Проверяваме дали има елемнти в листа
        if temp is not None:
            #Ако текущия елемент(първия) = търсения => премахваме го
            if temp.data == key:
                self.head = temp.next
                temp = None
                return
        
        #Ако търцения елемент не е първия, то го намираме
        while temp is not None:
            if temp.data == key:
                break
            prev = temp
            temp = temp.next

        #Премахваме търсения елемнт
        prev.next = temp.next
        temp = None
    
    #Създаваме метод за проверка дали даден елемент е в листа
    def search(self, key):
        current = self.head

        #Преминаваме през всеки един елемент, докато не го открием
        while current:
            if key == current.data:
                #Връщаме True, ако съществува
                return True
            current = current.next
        #Връщаме False, ако не съществува
        return False
    
    #Създаваме метод за извеждане на листа в конзолата
    def print_list(self):
        node = self.head
        while node:
            print(node.data, end=" ")
            node = node.next
        print()

if __name__ == "__main__":
    List = LinkedList()
    List.append(10)
    List.append(20)
    List.append(30)
    List.print_list()

    List.delete(20)
    List.print_list()

    print(List.search(10))
    print(List.search(20))