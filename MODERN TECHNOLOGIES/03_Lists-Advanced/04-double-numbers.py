a = list(map(int,input().split("|")))
key_num = int(input())
a = [x*x for x in a if x*x>=key_num]
print(a)