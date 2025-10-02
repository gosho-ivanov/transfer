def some_finc():
    while True:
        n = int(input("Enter the number of inputs: "))
        if n > 0:
            break
        print("Please enter a positive integer.")
    
    even_index_nums = []
    odd_index_nums = []
    for i in range(n):
        num = int(input(f"Enter number {i + 1}: "))
        if (i + 1) % 2 == 0:
            even_index_nums.append(num)
        else:
            odd_index_nums.append(num)

    sum_even = sum(even_index_nums)
    sum_odd = sum(odd_index_nums)
    max_even = max(even_index_nums) if even_index_nums else None
    max_odd = max(odd_index_nums) if odd_index_nums else None
    min_even = min(even_index_nums) if even_index_nums else None
    min_odd = min(odd_index_nums) if odd_index_nums else None
    print(f"Sum of numbers at even indices: {sum_even}")
    print(f"Sum of numbers at odd indices: {sum_odd}")
    print(f"Max of numbers at even indices: {max_even}")
    print(f"Max of numbers at odd indices: {max_odd}")
    print(f"Min of numbers at even indices: {min_even}")
    print(f"Min of numbers at odd indices: {min_odd}")

if __name__ == "__main__":
    some_finc()