USE School;

set @Start = 5;
set @End = 6;

select * from Grade where grade between @Start and @End;

#1
DELIMITER \\
CREATE PROCEDURE AddStudent(
	IN firstName VARCHAR(50),
    IN lastName VARCHAR(50),
    IN dob DATE,
    IN address VARCHAR(255),
    IN phone VARCHAR(20),
    IN email VARCHAR(50),
    IN gradeLevvl INT
)
BEGIN
	INSERT INTO Student (first_name, last_name, date_of_birth, address, phone_number, email, frade_level)
    VALUES (firdtName, lastName, dob, address, phone, email, gradeLevel);
END\\
DELIMITER ;
call AddStudent(); /*values go here */

#2
DELIMITER $$
CREATE PROCEDURE GetStudentInfoByClass(IN className VARChAR(50)) 
BEGIN
	SELECT st.first_name, st.last_name, cl.class_name FROM Student st
    JOIN Grade gr ON gr.student_id = st.student_id
    JOIN Class cl ON cl.class_id = cl.class_id
    WHERE cl.class_name = className;
END$$
DELIMITER ;

call GetStudentInfoByClass("5В");


#3
DELIMITER $$
CREATE PROCEDURE ChangeGrade(
	IN studentID int,
    IN classID INT,
    IN newGrade DECIMAL(10,2)
)
BEGIN
	UPDATE Grade
    SET grade = newGrade
    WHERE student_id = studentID AND class_id = classID;
END$$
DELIMITER ;
call ChangeGrade(1, 1, 4.5)
	
    
#4
DELIMITER $$
CREATE PROCEDURE AddAttendance(
	IN stID INT,
    IN clID INT,
    IN dt DATE,
    IN stts VARCHAR(50)
)
BEGIN
	INSERT INTO Attendance (student_id, class_id, date, status)
    VALUES (stID, clID, dt, stts);
END$$
DELIMITER ;
call AddAttendance(1, 1, "2025-03-21", "Присъствал");

#5
DELIMITER $$
CREATE PROCEDURE GetStudentGradesByYear(
	IN YEAR VARCHAR(4),
    IN stID INT
)
BEGIN
	SELECT gr.grade FROM Grade gr
    WHERE gr.student_id = stID AND year(gr.date) = YEAR;
END$$
DELIMITER ;
call GetStudentGradesByYear("2024", 1);

#6
DELIMITER $$
CREATE PROCEDURE GetAttendanceByDay(
	in day VARCHAR(2),
	IN stID INT
)
BEGIN
	SELECT status FROM Attendance
    WHERE DAY(date) = day and student_id = stID;
END$$
DELIMITER ;
call GetAttendanceByDay("20", 1);

#7
DELIMITER $$
CREATE PROCEDURE AddEvent(
	IN Name NVARCHAR(50),
    IN descr NVARCHAR(255),
    IN dt DATE,
    IN loc NVARCHAR(255)
)
BEGIN
	INSERT INTO Event(name, description, date, location)
    VALUES (Name, descr, dt, loc);
END$$
DELIMITER ;
call AddEvent(); /* put some values in here */

#8
DELIMITER $$
CREATE PROCEDURE ChangeSchedule(
	IN schID INT
    IN clID INT,
    IN day VARCHAR(50),
    IN start TIME,
    IN end TIME
)
BEGIN
	UPDATE Schedule
    SET class_id = clID, 
		day_of_week = day, 
		start_time = start, 
		end_time = end
    WHERE schedule_id = schID;
END$$
DELIMITER ;
call ChangeSchedule() /* values go here */

