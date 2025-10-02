def check_sum():
    n = int(input("Enter the number of inputs: "))
    nums = []
    for i in range(n*2):
        num = int(input(f"Enter number {i + 1}: "))
        nums.append(num)
    
    sum_1 = sum(nums[:n])
    sum_2 = sum(nums[n:])
    if sum_1 == sum_2:
        print("The sums are equal.")
    else:
        print("The sums are not equal.")