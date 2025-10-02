def get_biggest_num() -> int:
    while True:
        n = int(input("Enter the number of inputs: "))
        if n > 0:
            break
        print("Please enter a positive integer.")

    nums = []
    for i in range(n):
        num = int(input(f"Enter number {i + 1}: "))
        nums.append(num)
    return max(nums)

if __name__ == "__main__":
    biggest_num = get_biggest_num()
    print(f"The biggest number is: {biggest_num}")

    