create database Movies;
use Movies;

create table Actors(
	Id int auto_increment,
    FirstName nvarchar(100),
    LastName nvarchar(100) not null,
    BirthYear int not null check(BirthYear between 1900 and 2000),
    primary key(Id)
);