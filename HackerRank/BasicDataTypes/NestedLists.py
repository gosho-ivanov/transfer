names = []
scores = []
for _ in range(int(input())):
    name = input()
    score = float(input())
    names.append(name)
    scores.append(score)
min_score = min(scores)
new_names = []
new_scores = []
for i in range(len(scores)):
    if scores[i] != min_score:
        new_names.append(names[i])
        new_scores.append(scores[i])
min_score = min(new_scores)
res = []
for i in range(len(new_names)):
    if min_score == new_scores[i]:
        res.append(new_names[i])
print("\n".join(sorted(res)))