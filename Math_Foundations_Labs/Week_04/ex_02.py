ip = input("Enter IP addres in the format[x.x.x.x]: ").split(".")
masked_ip = ""
real_address = True

for i in range(4):
    x = int(ip[i], 2)
    if x > 255:
        real_address = False
        break

print(real_address)
