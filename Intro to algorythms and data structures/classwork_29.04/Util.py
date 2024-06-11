import random

def input_data():
    N = int(input("Enter the number of elements to be sorted: "))
    list = random.sample(range(0,100), N)
    return list

def print_data(prompt, data=None):
    if data is None:
        print(prompt)
    else:
        print(prompt, data)

def merge(l1: list, l2: list):
    i, j = 0, 0
    res = []

    while(i<len(l1) and j<len(l2)):
        if l2[j] > l1[i]:
            res.append(l1[i])
            i += 1
        else:
            res.append(l2[j])
            j += 1

    while(i < len(l1)):
        res.append(l1[i])
        i += 1

    while(j < len(l2)):
        res.append(l2[j])
        j += 1
    
    return res
    
def merge_sort(list: list):
    if len(list) <= 1:
        return list
    
    mid = len(list) // 2
    left = merge_sort(list[:mid])
    right = merge_sort(list[mid:])
    
    return merge(left,right)