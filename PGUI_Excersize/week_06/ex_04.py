def find_num_in_list(num_list: list[int], target_num: int) -> list:
    for i in range(len(num_list)):
        if num_list[i] > target_num:
            num_list[i] = 0

    return num_list