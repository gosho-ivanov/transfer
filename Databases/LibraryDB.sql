CREATE DATABASE LibraryDB;
USE LibraryDB;

CREATE TABLE Book(
	id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    author VARCHAR(255) NOT NULL,
    pages INT NOT NULL,
    release_year INT NOT NULL,
    genre VARCHAR(255) NOT NULL,
    stock INT NOT NULL
);

CREATE TABLE User(
	id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    age INT NOT NULL
);

CREATE TABLE BookReview(
	id INT AUTO_INCREMENT PRIMARY KEY,
    book_id INT NOT NULL,
    user_id INT NOT NULL,
    book_value INT CHECK(-1 < book_value < 11) NOT NULL,
    user_thoughts TEXT NOT NULL,
    
    FOREIGN KEY(book_id) REFERENCES Book(id),
    FOREIGN KEY(user_id) REFERENCES User(id)
);

CREATE TABLE UserReadingHistory(
	book_id INT NOT NULL,
    user_id INT NOT NULL,
    last_page_read INT NOT NULL,
    date_of_entry DATE NOT NULL,
    review_id INT,
    
    FOREIGN KEY(book_id) REFERENCES Book(id),
    FOREIGN KEY(user_id) REFERENCES User(id),
    FOREIGN KEY(review_id) REFERENCES BookReview(id),
    
    PRIMARY KEY(book_id, user_id)
);




#Entries for Book:
INSERT INTO Book (title, author, pages, release_year, genre, stock) VALUES
('The Great Gatsby', 'F. Scott Fitzgerald', 180, 1925, 'Fiction', 5),
('To Kill a Mockingbird', 'Harper Lee', 281, 1960, 'Fiction', 3),
('1984', 'George Orwell', 328, 1949, 'Dystopian', 4),
('Pride and Prejudice', 'Jane Austen', 279, 1813, 'Romance', 6),
('The Catcher in the Rye', 'J.D. Salinger', 277, 1951, 'Fiction', 2),
('Moby Dick', 'Herman Melville', 585, 1851, 'Adventure', 1),
('War and Peace', 'Leo Tolstoy', 1225, 1869, 'Historical', 2),
('The Odyssey', 'Homer', 300, -800, 'Epic', 4),
('The Hobbit', 'J.R.R. Tolkien', 310, 1937, 'Fantasy', 7),
('Fahrenheit 451', 'Ray Bradbury', 158, 1953, 'Dystopian', 5),
('Brave New World', 'Aldous Huxley', 268, 1932, 'Dystopian', 3),
('The Picture of Dorian Gray', 'Oscar Wilde', 254, 1890, 'Philosophical', 4),
('The Alchemist', 'Paulo Coelho', 208, 1988, 'Adventure', 6),
('The Chronicles of Narnia', 'C.S. Lewis', 768, 1950, 'Fantasy', 8),
('The Kite Runner', 'Khaled Hosseini', 371, 2003, 'Fiction', 5),
('The Da Vinci Code', 'Dan Brown', 454, 2003, 'Mystery', 3),
('The Fault in Our Stars', 'John Green', 313, 2012, 'Young Adult', 4),
('The Hunger Games', 'Suzanne Collins', 374, 2008, 'Dystopian', 6),
('The Book Thief', 'Markus Zusak', 552, 2005, 'Historical', 2),
('The Road', 'Cormac McCarthy', 287, 2006, 'Post-Apocalyptic', 3),
('Life of Pi', 'Yann Martel', 319, 2001, 'Adventure', 5),
('The Secret Garden', 'Frances Hodgson Burnett', 331, 1911, 'Children', 4),
('The Little Prince', 'Antoine de Saint-Exupéry', 96, 1943, 'Children', 7),
('The Bell Jar', 'Sylvia Plath', 244, 1963, 'Fiction', 3),
('The Road Less Traveled', 'M. Scott Peck', 300, 1978, 'Self-Help', 2),
('Sapiens: A Brief History of Humankind', 'Yuval Noah Harari', 443, 2011, 'Non-Fiction', 5),
('The Midnight Library', 'Matt Haig', 304, 2021, 'Fiction', 10),
('Klara and the Sun', 'Kazuo Ishiguro', 320, 2021, 'Science Fiction', 5),
('Project Hail Mary', 'Andy Weir', 496, 2021, 'Science Fiction', 8),
('Malibu Rising', 'Taylor Jenkins Reid', 368, 2021, 'Contemporary Fiction', 12),
('The Last House on Needless Street', 'Catriona Ward', 352, 2021, 'Horror', 6),
('The Vanishing Half', 'Brit Bennett', 352, 2020, 'Fiction', 9),
('The Invisible Life of Addie LaRue', 'V.E. Schwab', 448, 2020, 'Fantasy', 11),
('Crescent City: House of Earth and Blood', 'Sarah J. Maas', 803, 2020, 'Fantasy', 6),
('Mexican Gothic', 'Silvia Moreno-Garcia', 301, 2020, 'Horror', 10),
('The City We Became', 'N.K. Jemisin', 448, 2020, 'Fantasy', 5),
('The Book of Cold Cases', 'Simone St. James', 368, 2022, 'Mystery', 8),
('Lessons in Chemistry', 'Bonnie Garmus', 400, 2022, 'Fiction', 10),
('The Maid', 'Nita Prose', 336, 2022, 'Mystery', 12),
('The Paris Apartment', 'Lucy Foley', 336, 2022, 'Thriller', 7),
('Tomorrow, and Tomorrow, and Tomorrow', 'Gabrielle Zevin', 416, 2022, 'Fiction', 9),
('Fourth Wing', 'Rebecca Yarros', 496, 2023, 'Fantasy', 15),
('The Covenant of Water', 'Abraham Verghese', 704, 2023, 'Fiction', 10),
('Hello Beautiful', 'Ann Napolitano', 400, 2023, 'Fiction', 8),
('The Wishing Game', 'Meg Shaffer', 384, 2023, 'Contemporary Fiction', 12),
('The Only One Left', 'Riley Sager', 368, 2023, 'Thriller', 6);


#Entries for User:
INSERT INTO User (username, first_name, last_name, age) VALUES
('jdoe', 'John', 'Doe', 28),
('asmith', 'Alice', 'Smith', 34),
('bwhite', 'Bob', 'White', 22),
('cjohnson', 'Charlie', 'Johnson', 45),
('dlee', 'Diana', 'Lee', 30),
('emartinez', 'Eva', 'Martinez', 27),
('fgarcia', 'Frank', 'Garcia', 31),
('hkim', 'Hannah', 'Kim', 29),
('ijones', 'Isaac', 'Jones', 40),
('jroberts', 'Jessica', 'Roberts', 26),
('kthompson', 'Kevin', 'Thompson', 35),
('lmoore', 'Laura', 'Moore', 33),
('mjackson', 'Michael', 'Jackson', 24),
('nlee', 'Nancy', 'Lee', 38),
('obrown', 'Oliver', 'Brown', 41),
('pwhite', 'Patricia', 'White', 29),
('qclark', 'Quincy', 'Clark', 36),
('rallen', 'Rachel', 'Allen', 32),
('srodriguez', 'Samuel', 'Rodriguez', 37),
('tgarcia', 'Tina', 'Garcia', 25),
('ujames', 'Ulysses', 'James', 39),
('vthompson', 'Victoria', 'Thompson', 42),
('wlewis', 'William', 'Lewis', 23),
('xmartin', 'Xena', 'Martin', 34),
('yroberts', 'Yvonne', 'Roberts', 30),
('zjohnson', 'Zachary', 'Johnson', 28);

#Entries for BookReview:
INSERT INTO BookReview (book_id, user_id, book_value, user_thoughts) VALUES
(1, 1, 9, 'A classic that captures the essence of the American Dream.'),
(1, 2, 8, 'Beautifully written, but the characters are quite flawed.'),
(2, 3, 10, 'A powerful story about justice and morality.'),
(2, 4, 9, 'A must-read for everyone, especially in today\'s world.'),
(3, 5, 10, 'A chilling depiction of a dystopian future.'),
(3, 6, 7, 'Thought-provoking but a bit too dark for my taste.'),
(4, 7, 9, 'A timeless romance that still resonates today.'),
(4, 8, 8, 'The characters are relatable and the story is engaging.'),
(5, 9, 6, 'A bit overrated, but still an interesting read.'),
(5, 10, 7, 'I enjoyed the writing style, but the plot was lacking.'),
(6, 11, 8, 'An epic adventure that is beautifully written.'),
(6, 12, 9, 'A deep exploration of obsession and revenge.'),
(7, 13, 10, 'A monumental work that captures the essence of history.'),
(7, 14, 9, 'A long read, but worth every page.'),
(8, 15, 10, 'A masterpiece of storytelling and character development.'),
(8, 16, 8, 'The themes are still relevant today.'),
(9, 17, 9, 'A delightful fantasy that sparks the imagination.'),
(9, 18, 10, 'A perfect blend of adventure and life lessons.'),
(10, 19, 7, 'A gripping tale, but the pacing was slow at times.'),
(10, 20, 8, 'A unique take on censorship and freedom.'),
(11, 21, 9, 'Wilde’s wit shines through in this brilliant novel.'),
(11, 22, 8, 'A fascinating exploration of vanity and morality.'),
(12, 23, 10, 'An inspiring journey of self-discovery.'),
(12, 24, 9, 'A beautiful narrative that stays with you.'),
(13, 25, 10, 'A captivating story that transcends age.'),
(13, 1, 8, 'A great read for both children and adults.'),
(14, 2, 9, 'A heartwarming tale of friendship and loss.'),
(14, 3, 10, 'A profound exploration of the human condition.'),
(15, 4, 8, 'A thrilling mystery that keeps you guessing.'),
(15, 5, 9, 'A well-crafted plot with unexpected twists.');

#Entries for UserReadingHistory
INSERT INTO UserReadingHistory (book_id, user_id, last_page_read, date_of_entry, review_id) VALUES
(1, 1, 180, '2023-01-15', 1),
(2, 2, 281, '2023-02-20', 3),
(3, 3, 328, '2023-03-10', 5),
(4, 4, 279, '2023-04-05', 7),
(5, 5, 277, '2023-05-12', 9),
(6, 6, 585, '2023-06-01', 11),
(7, 7, 1225, '2023-07-15', 13),
(8, 8, 300, '2023-08-20', 15),
(9, 9, 310, '2023-09-10', 17),
(10, 10, 158, '2023-10-05', 19),
(11, 11, 268, '2023-11-01', 21),
(12, 12, 254, '2023-11-15', 23),
(13, 13, 208, '2023-12-01', 25),
(14, 14, 768, '2023-12-10', 1),
(15, 15, 371, '2023-12-20', 3),
(16, 16, 454, '2023-12-25', 5),
(17, 17, 313, '2023-12-30', 7),
(18, 18, 374, '2023-01-05', 9),
(19, 19, 552, '2023-01-10', 11),
(20, 20, 287, '2023-01-15', 13),
(21, 21, 319, '2023-01-20', 15),
(22, 22, 331, '2023-01-25', 17),
(23, 23, 96, '2023-02-01', 19),
(24, 24, 244, '2023-02-05', 21),
(25, 25, 300, '2023-02-10', 23);