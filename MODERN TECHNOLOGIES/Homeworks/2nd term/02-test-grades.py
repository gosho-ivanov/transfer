biology_scores = {}
student_id = 1
score_questions = input()
while score_questions != "":
    scores = list(map(int, score_questions.split(", ")))
    biology_scores[student_id] = scores
    student_id+=1
    score_questions = input()

for id, scores in biology_scores.items():
    test_score = sum(scores)
    test_grade = 2 + (test_score/60 * 4)
    print(f"{id} - score: {test_score}, grade: {test_grade:.2f}")