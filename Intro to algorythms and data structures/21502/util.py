import random


def partition(arr, low, high):
    pivot = arr[high]
    i = low - 1

    for j in range(low, high):
        if arr[j] < pivot:
            i += 1
            arr[j], arr[i] = arr[i], arr[j]

    i += 1
    arr[i], arr[high] = arr[high], arr[i]
    return i


def qsort(arr, low, high):
    if low < high:
        pi = partition(arr, low, high)
        qsort(arr, low, pi-1)
        qsort(arr, pi+1, high)


def input_list():
    n = int(input("Input number of elements: "))
    my_arr = random.sample(range(1, 100), n)
    print(f"Unsorted list: {my_arr}")

    qsort(my_arr, 0, n-1)
    print(f"Sorted list: {my_arr}")