from Util import merge_sort, input_data, print_data

data = input_data()
print_data("")
print_data("1. Raw(unsorted) data in list: ", data)

data = merge_sort(data)
print_data("2. Sorted list by implementing Merge Sort: ", data)