Create Database Minions;
use Minions;

create table Minions(
	Id int auto_increment, 
	Name nvarchar(100), 
	Age int,
    primary key(Id)
);

create table Town(
	Id int auto_increment,
    Name nvarchar(50),
    primary key(Id)
);
