from math import floor

voters = int(input())
underage_voters = []
adult_voters = []
for voter in range(voters):
    age = int(input())
    if age < 18:
        underage_voters.append(age)
    else:
        adult_voters.append(age)

avg_age_adults = sum(adult_voters)/len(adult_voters)
print(underage_voters)
print(adult_voters)
print(f"Count of children: {len(underage_voters)}\n"
      f"Count of adults: {len(adult_voters)}")
print(f"Average age of adults: {floor(avg_age_adults)}")
