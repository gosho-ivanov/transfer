try:
    num = int(input())
    assert num%2 == 0

except:
    print("Odd number")
else:
    reciprocal = 1/num
    print(reciprocal)