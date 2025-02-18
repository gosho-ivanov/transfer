USE LibraryDB;

SELECT * FROM Book b
WHERE b.release_year BETWEEN 1900 AND 1990;

SELECT b.release_year, AVG(b.pages) avg_pages_per_year FROM Book b
WHERE b.release_year BETWEEN 2018 AND 2024
GROUP BY b.release_year;

SELECT b.title, br.book_value, br.user_thoughts FROM Book b
LEFT JOIN BookReview br
ON b.id = br.book_id;

SELECT b.title, br.book_value, br.user_thoughts FROM Book b
INNER JOIN BookReview br
ON b.id = br.book_id;


SELECT b.title, COUNT(urh.user_id) times_read FROM Book b
LEFT JOIN UserReadingHistory urh
ON urh.book_id = b.id
GROUP BY b.title
ORDER BY b.title;