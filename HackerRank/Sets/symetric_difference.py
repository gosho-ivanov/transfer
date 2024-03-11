def selection_sort(my_list):
    for i in range(len(my_list)):
        min_index = i
        for j in range(i+1, len(my_list)):
            if my_list[j] < my_list[min_index]:
                min_index = j
        my_list[i],my_list[min_index] = my_list[min_index], my_list[i]
    return my_list


if __name__ == "__main__":
    m = int(input())
    a = set(map(int, input().split()))
    n = int(input())
    b = set(map(int, input().split()))

    sym_diff = a.symmetric_difference(b)
    arr = list(sym_diff)
    sorted_sym_diff = selection_sort(arr)
    print(*sorted_sym_diff, sep="\n")