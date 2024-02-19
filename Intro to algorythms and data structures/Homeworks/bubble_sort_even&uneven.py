from numpy.random import randint

def split_even_uneven(arr):
    even = [x for x in arr if x % 2 == 0]
    odd = [y for y in arr if y % 2 != 0]
    return [even, odd]

def bubble_sort_ascending(arr):
    n = len(arr)
    swapped = True
    while swapped:
        swapped = False
        for j in range(1, n):
            if arr[j-1] > arr[j]:
                arr[j-1], arr[j] = arr[j], arr[j-1]
                swapped = True
    return arr

def bubble_sor_descending(arr):
    n = len(arr)
    swapped = True
    while swapped:
        swapped = False
        for j in range(1, n):
            if arr[j-1] < arr[j]:
                arr[j-1], arr[j] = arr[j], arr[j-1]
                swapped = True
    return arr

def main():
    N = int(input("Enter the number of elements in the list: "))
    my_arr = randint(1,100,N)
    print(f"\nOriginal list: {my_arr}")
    even_arr, odd_arr = split_even_uneven(my_arr)
    print(f"\nEven numbers: {even_arr}\nOdd numbers: {odd_arr}")
    even_arr, uneven_arr = bubble_sort_ascending(even_arr), bubble_sor_descending(odd_arr)
    print(f"\nSorted even list: {even_arr}\nSorted odd listL: {uneven_arr}")


if "__main__" == main():
    main()
