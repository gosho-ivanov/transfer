data = list(map(int, input().split()))
new_data = ["EVEN" if x % 2 == 0 else 'ODD' for x in data]
print(" ".join(new_data))
