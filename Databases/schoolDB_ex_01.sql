use School;

SELECT * FROM Student st
ORDER BY grade_level;

SELECT * FROM Student st
ORDER BY last_name;

SELECT Student.first_name, Student.last_name, Grade.grade 
FROM STUDENT
JOIN Grade
ON Student.student_id = Grade.student_id
WHERE Grade.grade > 5
ORDER BY Grade.grade;

SELECT cl.class_name, AVG(gr.grade) AS avg_grade 
FROM Class cl
JOIN Grade gr
ON cl.class_id = gr.class_id
GROUP BY cl.class_name
;

SELECT cl.class_name, COUNT(gr.student_id) 
FROM Class cl
JOIN Grade gr
ON cl.class_id = gr.class_id
GROUP BY cl.class_name
;

SELECT t.first_name, t.last_name, s.name 
FROM Teacher t
LEFT JOIN Class cl
ON t.teacher_id = cl.teacher_id
JOIN Subjects s
ON cl.subject_id = s.subject_id
;

SELECT st.first_name, st.last_name, cl.class_name 
FROM Student st
JOIN Attendance at
ON st.student_id = at.student_id
JOIN Class cl
ON cl.class_id = at.class_id
WHERE at.status = "Отсъствал"
;

SELECT st.first_name, st.last_name, AVG(gr.grade) avg_grade
FROM Student st
INNER JOIN Grade gr
ON st.student_id = gr.student_id
GROUP BY st.first_name, st.last_name;

SELECT st.first_name student_first_name, 
	st.last_name student_last_name, 
	p.first_name parent_first_name, 
	p.last_name parent_last_name
FROM Student st
JOIN Parent p
ON p.student_id = st.student_id;

SELECT at.date, COUNT(at.student_id) 
FROM Attendance at
WHERE at.status = "Присъствал"
GROUP BY at.date;

SELECT st.first_name, st.last_name, gr.grade
FROM Student st
JOIN Grade gr
ON gr.student_id = st.student_id
WHERE gr.grade < 4;

SELECT cl.class_name, COUNT(gr.student_id) count_students
FROM Class cl
JOIN Grade gr
ON cl.class_id = gr.class_id
GROUP BY cl.class_name
ORDER BY count_students desc;


SELECT t.first_name, t.last_name, count(s.subject_id) count_subjects
FROM Teacher t
LEFT JOIN Class cl
ON t.teacher_id = cl.teacher_id
JOIN Subjects s
ON cl.subject_id = s.subject_id
WHERE count_subjects > 1
GROUP BY s.name
;
