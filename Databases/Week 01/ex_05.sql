create database Company;
use Company;

create table Departments(
	Id int auto_increment,
    DepartmentName nvarchar(100) unique,
    primary key(Id)
);