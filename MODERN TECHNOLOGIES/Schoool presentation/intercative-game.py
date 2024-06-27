import random

hidden_num = 72
guess = int(input("Въведете число: "))

while guess != hidden_num:
    print("Числото, което въведохте e различно от скритото.", end = " ")
    
    if guess > hidden_num:
        print("Пробвайте c по-малко число.")
    else:
        print("Пробвайте c по-голямо число.")

    guess = int(input("Въведете число: "))

print("\nПоздравления! Вие познахте числото.")