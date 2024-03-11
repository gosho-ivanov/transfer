def average(array):
    distinct_heigths = set(array)
    average_heigth = sum(distinct_heigths)/len(distinct_heigths)
    return round(average_heigth, 3)

if __name__ == "__main__":
    n = int(input())
    arr = list(map(int, input().split()))
    result = average(arr)
    print(result)