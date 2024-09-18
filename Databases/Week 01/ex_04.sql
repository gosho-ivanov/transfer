create database Hospital;
use Hospital;

create table Doctors(
	Id int auto_increment,
    FIrstName nvarchar(100),
    Specialty nvarchar(100) not null,
    YearsExperience int unsigned not null,
    primary key(Id)
);