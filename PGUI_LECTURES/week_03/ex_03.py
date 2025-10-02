def get_vowel_sum() -> int:
    word = input().lower()
    vowels = ('a', 'e', 'i', 'o', 'u')
    total = 0
    for char in word:
        if char in dict:
            total += vowels.index(char) + 1
    return total

if __name__ == "__main__":
    vowel_sum = get_vowel_sum()
    print(f"The vowel sum is: {vowel_sum}")