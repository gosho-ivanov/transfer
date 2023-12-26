if __name__ == '__main__':
    N = int(input())
    l = []
    for i in range(N):
        data = input().split()
        com = data[0]
        if com == "insert":
            l.insert(int(data[1]), int(data[2]))
        elif com == "print":
            print(l)
        elif com == "remove":
            if int(data[1]) in l:
                l.remove(int(data[1]))
        elif com == "append":
            l.append(int(data[1]))
        elif com == "sort":
            l.sort()
        elif com == "pop":
            l.pop(len(l)-1)
        else:
            l.reverse()