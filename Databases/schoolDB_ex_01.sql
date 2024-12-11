use School;

#1
SELECT * FROM Student st
ORDER BY grade_level;

#2
SELECT * FROM Student st
ORDER BY last_name;

#3
SELECT Student.first_name, Student.last_name, Grade.grade 
FROM STUDENT
JOIN Grade
ON Student.student_id = Grade.student_id
WHERE Grade.grade > 5
ORDER BY Grade.grade;

#4
SELECT cl.class_name, AVG(gr.grade) AS avg_grade 
FROM Class cl
JOIN Grade gr
ON cl.class_id = gr.class_id
GROUP BY cl.class_name
;

#5
SELECT cl.class_name, COUNT(gr.student_id) 
FROM Class cl
JOIN Grade gr
ON cl.class_id = gr.class_id
GROUP BY cl.class_name
;

#6
SELECT t.first_name, t.last_name, s.name 
FROM Teacher t
LEFT JOIN Class cl
ON t.teacher_id = cl.teacher_id
JOIN Subjects s
ON cl.subject_id = s.subject_id
;

#7
SELECT st.first_name, st.last_name, cl.class_name 
FROM Student st
JOIN Attendance at
ON st.student_id = at.student_id
JOIN Class cl
ON cl.class_id = at.class_id
WHERE at.status = "Отсъствал"
;

#8
SELECT st.first_name, st.last_name, AVG(gr.grade) avg_grade
FROM Student st
INNER JOIN Grade gr
ON st.student_id = gr.student_id
GROUP BY st.first_name, st.last_name;

#9
SELECT st.first_name student_first_name, 
	st.last_name student_last_name, 
	p.first_name parent_first_name, 
	p.last_name parent_last_name
FROM Student st
JOIN Parent p
ON p.student_id = st.student_id;

#10
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


SELECT t.first_name, 
	   t.last_name, count(s.subject_id) count_subjects
FROM Teacher t
LEFT JOIN Class cl
ON t.teacher_id = cl.teacher_id
JOIN Subjects s
ON cl.subject_id = s.subject_id
WHERE count_subjects > 1
GROUP BY s.name
;


#new set of excersizes

#10
SELECT s.first_name, s.last_name, a.award_name FROM Student s
INNER JOIN Award a
ON s.student_id = a.student_id;

#11
SELECT b.title, l.due_date FROM Book b
INNER JOIN Loan l
ON l.book_id = b.book_id;

#12
SELECT s.first_name, s.last_name, b.title, l.loan_date FROM Student s
JOIN Loan l
ON l.student_id = s.student_id
JOIN Book b
ON b.book_id = l.book_id;

#13
SELECT s.first_name, s.last_name, a.status FROM Attendance a
LEFT JOIN Student s
ON a.student_id = s.student_id;

#14
SELECT t.first_name, t.last_name, s.name, sc.day_of_week, sc.start_time, sc.end_time FROM Teacher t
JOIN Class cl
ON cl.teacher_id = t.teacher_id
JOIN Schedule sc
ON sc.class_id = cl.class_id
JOIN Subjects s
ON s.subject_id = cl.subject_id;

#15
SELECT s.first_name, s.last_name, gr.grade FROM Student s
LEFT JOIN Grade gr
ON gr.student_id = s.student_id;

#16
SELECT ac.name, t.first_name, t.last_name FROM Teacher t
RIGHT JOIN Activity ac
ON ac.teacher_id = t.teacher_id;

#17
SELECT st.first_name student_first_name, 
	st.last_name student_last_name, 
	p.first_name parent_first_name, 
	p.last_name parent_last_name
FROM Student st
JOIN Parent p
ON p.student_id = st.student_id;

#18
SELECT s.first_name, s.last_name, a.name FROM Activity a
INNER JOIN Class cl
ON a.teacher_id = cl.teacher_id
INNER JOIN Grade gr
ON gr.class_id = cl.class_id
RIGHT JOIN Student s
ON s.student_id = gr.student_id;

#19
SELECT s.first_name, s.last_name, da.action_type FROM DisciplinaryAction da
JOIN Student s
ON s.student_id = da.student_id;

#20
SELECT s.first_name, s.last_name, b.title FROM Student s
LEFT JOIN Loan l
ON l.student_id = s.student_id
LEFT JOIN Book b
ON b.book_id = l.book_id
UNION
SELECT s.first_name, s.last_name, b.title FROM Student s
RIGHT JOIN Loan l
ON l.student_id = s.student_id
RIGHT JOIN Book b
ON b.book_id = l.book_id;


#new set of exercizess

#10
SELECT Student.first_name, Student.last_name, Grade.grade 
FROM STUDENT
JOIN Grade
ON Student.student_id = Grade.student_id
WHERE Grade.grade < 4
ORDER BY Grade.grade;

#11
SELECT cl.class_name, COUNT(gr.student_id) count_students
FROM Class cl
JOIN Grade gr
ON cl.class_id = gr.class_id
GROUP BY cl.class_name
ORDER BY count_students desc;

#12
SELECT t.first_name, t.last_name, COUNT(cl.subject_id) subject_count FROM Teacher t
JOIN Class cl
ON cl.teacher_id = t.teacher_id
GROUP BY t.first_name, t.last_name
HAVING subject_count > 1; #--> #HAVING IS ALWAYS LAST

#13
SELECT s.first_name, s.last_name, a.award_name FROM Student s
INNER JOIN Award a
ON s.student_id = a.student_id;

#14
SELECT cl.class_name, sc.start_time, sc.end_time FROM Schedule sc
JOIN Class cl
ON cl.class_id = sc.class_id
WHERE sc.day_of_week = "Понеделник";

#15
SELECT s.first_name, s.last_name, COUNT(a.status) attendance_count FROM Student s
JOIN Attendance a
ON a.student_id = s.student_id
WHERE a.status = "Присъствал"
GROUP BY s.first_name, s.last_name;

#16
SELECT s.first_name, s.last_name, b.title FROM Student s
JOIN Loan l
ON l.student_id = s.student_id
JOIN Book b
ON b.book_id = l.book_id;

#17
SELECT cl.class_name, AVG(gr.grade) FROM Class cl
JOIN Grade gr
ON cl.class_id = gr.class_id
GROUP BY cl.class_name;

#18
SELECT s.first_name, s.last_name, l.locker_number FROM Student s
JOIN Locker l
ON l.student_id = s.student_id;

#19
SELECT s.first_name, s.last_name, COUNT(a.status) attendance_count FROM Student s
LEFT JOIN Attendance a
ON a.student_id = s.student_id
WHERE a.status = "Отсъствал"
GROUP BY s.first_name, s.last_name;

SELECT t.first_name, t.last_name, t.employment_date FROM Teacher t
ORDER BY t.employment_date DESC;