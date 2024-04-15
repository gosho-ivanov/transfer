import random

def partition(list, low, high):
    pivot = list[high]
    i = low-1
    
    for j in range(low, high):
        if list[j] < pivot:
            i += 1
            list[i], list[j] = list[j], list[i]
        
    i = i+1
    list[i], list[high] = list[high], list[i]
    return i

def quickSort(list, low, high):
    if low < high:
        pi = partition(list, low, high)
        quickSort(list, low, pi-1)
        quickSort(list, pi+1, high)



def input_data():
    N = int(input("Enter the amount of elements to be generated: "))
    list = random.sample(range(0,100), N)
    return list

def print_info(prompt, data=None):
    if data != None:
        print(prompt, data)
    else:
        print(prompt)