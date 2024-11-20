USE bookstore;

INSERT INTO Books (title, author, price, stock)
VALUES ("Dune", "Frank Herbert", 21.99, 50);

INSERT INTO Customers (name, email, phone)
VALUES ("Georgi Ivanov", "georgiszeemod@gmail.com", "+359877070361");

INSERT INTO Customers (name, email, phone)
VALUES ("Ivan Ivanov", "georgiszeemod@gmail.com", "+359877070361");

INSERT INTO Orders (customer_id, book_id, order_date, quantity)
Values (1, 3, '2004-11-06', 4);


SELECT * FROM Books
WHERE price > 20;

SELECT name, email FROM Customers
WHERE name LIKE "I%";

UPDATE Books
SET stock = 16
WHERE book_id = 3;

UPDATE Customers
SET phone = "5558907645"
WHERE customer_id = 1;

SELECT * FROM Orders;

DELETE FROM Books
WHERE stock = 0;