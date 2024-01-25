scores = {}

data = input()
while data != "":
    candidate, entry_test, math_test, physics_test = data.split()
    
    entry_test = float(entry_test)
    math_test = float(math_test)
    physics_test = float(physics_test)

    total_score = 3*entry_test + math_test + physics_test

    scores[candidate] = {"entry_test": entry_test, "math_test": math_test, "physics_test": physics_test, "total": total_score}

    data = input()

for candidate, scores in scores.items():
    print(f"{candidate} - {scores["total"]:.3f}")
