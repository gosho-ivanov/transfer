from numpy.random import randint
from Util import bubble_sort_wf, bubble_sort_ff

N = int(input("Enter the amount of elements for first list: "))
list_ff = randint(0, 100, N)
print(f"\nBeginning: {list_ff}")

list_ff = bubble_sort_ff(list_ff)
print(f"Sorted by FF: {list_ff}\n")

N = int(input("Enter the amount of elements for second list: "))
list_wf = randint(1, 100 , N)
print(f"\nBeggining: {list_wf}")

list_dw = bubble_sort_wf(list_wf)
print(f"Sorted by WF: {list_wf}")