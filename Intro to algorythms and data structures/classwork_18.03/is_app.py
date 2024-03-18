from is_util import input_data, print_info, insertion_sort

radnom_list = input_data()
print_info("\nUnsorted elements", radnom_list)
sorted_list = insertion_sort(radnom_list)
print_info("\nSorted elements using insertion sort", sorted_list)