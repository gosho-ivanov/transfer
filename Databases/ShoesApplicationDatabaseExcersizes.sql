use ShoesApplicationDatabase;

SELECT s.Model, COUNT(u.id) total_orders FROM Orders o
JOIN Shoes s
ON s.id = o.ShoesID
JOIN Users u
ON u.id = o.UserID;

INSERT INTO Brands (Name)
VALUES ("Nike");

SELECT * FROM Users
WHERE Users.Email = "jhon.doe@example.com";

UPDATE Users
Set Email = "jhon.doe@example.com"
WHERE id = 1;

DELETE FROM Shoes WHERE Stock = 0;