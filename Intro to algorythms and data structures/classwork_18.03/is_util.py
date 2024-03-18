from numpy.random import randint

def input_data():
    N = int(input("Enter the number of elements to be generated: "))
    unsorted_list = list(set(randint(1, 100, N)))
    return unsorted_list

def print_info(prompt: str, data: list):
    print(prompt, end=": ")
    print(data)

def insertion_sort(data: list):
    n = len(data)
    for i in range(1, n):
        key = data[i]
        j = i - 1
        while j >= 0 and data[j] > key:
            data[j + 1] = data[j]
            j -= 1
        data[j + 1] = key
    return  data