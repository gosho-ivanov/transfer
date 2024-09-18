create database School;
use School;

create table Students(
	Id int auto_increment,
    FirstName nvarchar(100) not null,
    LastName nvarchar(100) not null,
    BirthDate int,
    primary key(Id)
);