from random import randint

list = [1,2,3,4,5]
list.append(6)
# list.append([7,8,9])
list += [10,11,12]
list += [13]
print(list)

list.insert(0,0)
list.insert(13, 14)
print(list)
# print(list.index(10))

if 10 in list:
    print(list.index(10))

print(list.count(10))

list.remove(10)
print(list)


list.sort() # -> only works when all elements are of the same type
print(list)
list.sort(reverse=True)
print(list)

list.reverse()
print(list)

print(min(list), max(list), sum(list), len(list))


l = []
for i in range(10):
    l.append(randint(1,100))
print(l)

l2 = [randint(1,100) for i in range(10)]

l3 = [el for el in l2 if el % 2 == 0]
print(max(l3) if len(l3) > 0 else "No even numbers found")