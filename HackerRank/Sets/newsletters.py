a = int(input())
eng_newsletter = set(map(int, input().split()))
b = int(input())
french_newsletter = set(map(int, input().split()))

all_newsletters = eng_newsletter.union(french_newsletter)
print(len(all_newsletters))