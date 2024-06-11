#EX_01 -> .index():

vowels = ['a', 'e', 'i', 'o', 'u']
index = vowels.index("e")
print(f"The index of 'e': {index}")
index = vowels.index("i")
print(f"The index of 'i': {index}")

#EX_02 -> .append():

animals = ['cat', 'dog', 'rabbit']
animals.append('guinea pig')
print(f"Update animals list: {animals}")

#EX_03 -> .extend():

languages = ["French", "English"]
languages1 = ["Spanish", "Portuguese"]
languages.extend(languages1)
print(f"Languages list: {languages}")

#EX_04 -> .insert():

prime_numbers = [2, 3, 5, 7]
prime_numbers.insert(4, 11)
print("List:", prime_numbers)

#EX_05 -> .remove():

animals = ['cat', 'dog', 'rabbit', 'guinea pig']
animals.remove('rabbit')
print("Updated animals list:", animals)

#EX_06 -> .count():

vowels = ['a', 'e', 'i', 'o', 'i', 'u']
count = vowels.count('i')
print("The count of 'i' is:", count)
count = vowels.count('p')
print("The count of 'p' is:", count)

#EX_07 -> .pop():

languages = ["Python", "Java", "C++", "French", "C"]
return_value = languages.pop(3)
print("Return vlaue:", return_value)
print("Updated list:", languages)

#EX_08 -> .reverse():

systems = ["Windows", "MacOS", "Linux"]
print("Original list:", systems)
systems.reverse()

print("Updated list:", systems)

#EX_09 -> .sort():

prime_numbers = [11, 3, 7, 5, 2]
prime_numbers.sort()
print(prime_numbers)

#EX_10 -> .copy():

my_list = ['cat', 0, 6.7]
new_list = my_list.copy()
print("Copied list:", new_list)

#EX_11 -> .clear():

list = [{1, 2}, ("a"), ['1.1', '2.2']]
list.clear()
print("List", list)
