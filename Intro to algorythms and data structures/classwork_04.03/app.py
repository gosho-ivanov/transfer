from util import input_data, print_data, selection_sort

unsorted_list = input_data()
print_data("\nUnsorted list", unsorted_list)

sorted_list = selection_sort(unsorted_list)
print_data("Sorted list using selection sort", sorted_list)