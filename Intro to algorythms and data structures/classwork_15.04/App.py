from Util import quickSort, input_data, print_info

data = input_data()
print_info("")
print_info("1. Raw(unsorted) data in list: ", data)

quickSort(data, 0, len(data)-1)
print_info("2. Sorted list by implementing Quick Sort: ", data)