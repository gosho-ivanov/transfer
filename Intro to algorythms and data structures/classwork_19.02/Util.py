def bubble_sort_ff(arr):
    N = len(arr)
    for i in range(N):
        swapped = False
        for  j in range(0, N-i-1):
            if arr[j] > arr[j+1]:
                arr[j], arr[j+1] = arr[j+1], arr[j]
                swapped = True
        if not swapped:
            break
    return arr

def bubble_sort_wf(l2):
    n = len(l2)
    swapped = True
    while swapped:
        swapped = False
        for j in range(1, n):
            if l2[j-1]>l2[j]:
                l2[j-1], l2[j] = l2[j], l2[j-1]
                swapped = True
    return l2