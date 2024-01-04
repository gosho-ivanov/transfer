my_string=input().split()
repeated_string=""

for word in my_string:
    repeated_string +=word*len(my_string)

print(my_string)