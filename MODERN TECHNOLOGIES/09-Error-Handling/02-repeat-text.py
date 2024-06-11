try:
    text = input()
    times = int(input())
    print(text * times)
except ValueError:
    print("Time must be integer!")