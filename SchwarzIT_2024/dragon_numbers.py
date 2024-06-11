from itertools import permutations

def TestDragonNum(num: int):
    positive_num = False
    integer = False
    bigger_equal_100 = False
    if num > 0:
        positive_num = True
    if str(num).isdigit():
        integer = True
    if num >= 100:
        bigger_equal_100 = True
    else:
        return "Normal Number"

    flag = False
    num_elements = [int(x) for x in str(num)]
    num_perms = permutations(num_elements)
    len_num = len(str(num)) 

    for perm in num_perms:
        perm = [str(x) for x in perm]
        middle_of_perm_list = len(perm) //2

        if len_num %2 == 0:
            if flag:
                break
            num1 = 0
            for x in perm[:middle_of_perm_list]:
                num1 *= 10
                num1 += int(x)

            num2 = 0
            for x in perm[middle_of_perm_list:]:
                num2 *= 10
                num2 += int(x)

        
        elif len_num >2:
            for i in range(2):
                if i % 2 == 0:
                    num1 = 0
                    for x in perm[:middle_of_perm_list]:
                        num1 *= 10
                        num1 += int(x)

                    num2 = 0
                    for x in perm[middle_of_perm_list:]:
                        num2 *= 10
                        num2 += int(x)
                else:
                    num1 = 0
                    for x in perm[:middle_of_perm_list+1]:
                        num1 *= 10
                        num1 += int(x)

                    num2 = 0
                    for x in perm[middle_of_perm_list+1:]:
                        num2 *= 10
                        num2 += int(x)

        
        if num1 * num2 == num:
            flag = True
            break



    if len_num %2 != 0:
        return "Pseudodragon"
    elif flag and positive_num and integer and bigger_equal_100:
        return "True Dragon" 
    

num = int(input())
print(TestDragonNum(num))