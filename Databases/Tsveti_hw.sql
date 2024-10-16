create database ClothingStore;
use ClothingStore;

create table Stores(
	id int auto_increment primary key,
    location nvarchar(255) not null,
    size float not null,
    eployees_count int not null,
    anual_sales int not null
);

create table Products(
	id int auto_increment primary key,
    type nvarchar(255) not null,
    product_name nvarchar(255) not null,
    fabrics nvarchar(255) not null,
    price float not null
);

create table StoreInventory(
	id int auto_increment primary key,
    store_id int not null,
    size_in_m2 float not null,
    total_products int not null,
    
    foreign key(store_id) references Stores(id)
);


create table Products_Stores(
	id int auto_increment primary key,
    product_id int not null,
    store_inventory_id int not null,
    
    foreign key(product_id) references Products(id),
    foreign key(store_inventory_id) references StoreInventory(id)
);

create table Managers(
	id int auto_increment primary key,
    fName nvarchar(255) not null,
    lName nvarchar(255) not null,
    age int not null,
    salary float not null,
    store_id int not null,
    
    foreign key(store_id) references Stores(id)
);

create table Employees(
	id int auto_increment primary key,
    fName nvarchar(255) not null,
    lName nvarchar(255) not null,
    age int not null,
    salary float not null,
    manager_id int not null,
    store_id int not null,
    
    foreign key(manager_id) references Managers(id),
    foreign key(store_id) references Stores(id)
);