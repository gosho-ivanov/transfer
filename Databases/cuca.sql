CREATE DATABASE TattooStudio;
USE TattooStudio;


CREATE TABLE Clients (
    clientId INT AUTO_INCREMENT PRIMARY KEY,
    firstName VARCHAR(50) NOT NULL,
    lastName VARCHAR(50) NOT NULL,
    phoneNumber VARCHAR(20),
    email VARCHAR(100),
    dateOfBirth DATE
);

CREATE TABLE Artists (
    artistId INT AUTO_INCREMENT PRIMARY KEY,
    firstName VARCHAR(50) NOT NULL,
    lastName VARCHAR(50) NOT NULL,
    specialty VARCHAR(100),
    yearsOfExperience INT,
    phoneNumber VARCHAR(20)
);

CREATE TABLE Tattoos (
    tattooId INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    style VARCHAR(50),
    price DECIMAL(10, 2),
    artistId INT,
    description TEXT,
    FOREIGN KEY (artistId) REFERENCES Artists(artistId)
);

CREATE TABLE Appointments (
    appointmentId INT AUTO_INCREMENT PRIMARY KEY,
    clientId INT,
    artistId INT,
    appointmentDate DATETIME NOT NULL,
    tattooId INT,
    status VARCHAR(20),
    FOREIGN KEY (clientId) REFERENCES Clients(clientId),
    FOREIGN KEY (artistId) REFERENCES Artists(artistId),
    FOREIGN KEY (tattooId) REFERENCES Tattoos(tattooId)
);

CREATE TABLE Supplies (
    supplyId INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    type VARCHAR(50),
    quantity INT,
    price DECIMAL(10, 2),
    supplierName VARCHAR(100)
);

CREATE TABLE Reviews (
    reviewId INT AUTO_INCREMENT PRIMARY KEY,
    clientId INT,
    artistId INT,
    rating INT CHECK (rating BETWEEN 1 AND 5),
    comment TEXT,
    reviewDate DATE,
    FOREIGN KEY (clientId) REFERENCES Clients(clientId),
    FOREIGN KEY (artistId) REFERENCES Artists(artistId)
);
