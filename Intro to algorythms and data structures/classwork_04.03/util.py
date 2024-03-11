from numpy.random import randint

def input_data():
    N = int(input("Enter the number of elements of the list: "))
    unsorted_list = randint(0,100, N)
    return unsorted_list

def print_data(prompt, list):
    print(prompt, end=": ")
    print(list)

def swap_elements(el1, el2):
    el1, el2 = el2, el1
    return [el1, el2]

def selection_sort(unsorted_list):
    for i in range(len(unsorted_list)):
        min_index = i
        for j in range(i+1, len(unsorted_list)):
            if unsorted_list[j] < unsorted_list[min_index]:
                min_index = j
        unsorted_list[i], unsorted_list[min_index] = swap_elements(unsorted_list[i], unsorted_list[min_index])
    sorted_list = unsorted_list
    return sorted_list