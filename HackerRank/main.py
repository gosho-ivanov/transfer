def print_rangoli(size):
    middle = (size*2)-1
    string = "-"*((size*3+2)//2+1) + chr(96+size) + "-"*((size*3+2)//2+1)
    l = list(string)
    print("".join(l))
    for i in range(1,size+1):
        l[middle - (2*i)], l[middle+(2*i)] = chr(96+size), chr(96+size)
        l[middle] = chr(96+size-1)
        print("".join(l))


if __name__ == '__main__':
    n = int(input())
    print_rangoli(n)