create database Library;
use Library;

create table Books(
	Id int auto_increment,
    Title nvarchar(30),
	Author nvarchar(100),
    YearPublished int NOT NULL,
	primary key(Id)
);

