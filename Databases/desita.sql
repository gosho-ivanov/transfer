Create database School;
use School;

Create table Classes(
	id int auto_increment primary key,
    classNumber int not null,
    studentCount int not null,
    homeroomTeacherID int not null,
    studentID int not null
);

Create Table Students(
	id INT auto_increment primary key,
    numberInClass int not null,
    Name nvarchar(255) not null,
    gpa float not null,
    classID int not null,
    
    foreign key(classID) references Classes(id)
);

Create table Teachers(
	id int auto_increment primary key,
    salary int not null,
    name nvarchar(255) not null,
    classID int not null,
    subjectID int not null,
    
    foreign key(classID) references CLasses(id)
);


Create table Subjects(
	id int auto_increment primary key,
    name nvarchar(255) not null,
    type nvarchar(255) not null,
    teacherID int not null,
    classID int not null,
    
    foreign key(teacherID) references Teachers(id)
);

Create table class_subjects(
	id int auto_increment primary key,
    classID int not null,
    subjectID int not null,
    
    foreign key(classID) references Classes(id),
    foreign key(subjectID) references Subjects(id)
);

Create table Classroom(
	id int auto_increment primary key,
    roomNumber int not null,
    subjectID int not null,
    classID int not null,
    teacherID int not null,
    
    foreign key(classID) references Classes(id),
    foreign key(subjectID) references Subjects(id),
    foreign key(teacherID) references Teachers(id)
);