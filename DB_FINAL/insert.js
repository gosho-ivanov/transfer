// insert.js

// Switch to the libraryDB database (creates it if it doesn't exist)
use ("LibraryDB");

// Insert books
// Each book has title, author, genre, publishedYear, copies, tags (array), and publisher (object)
db.books.insertMany([
  {
    title: "1984",
    author: "George Orwell",
    genre: "Dystopian",
    publishedYear: 1949,
    copies: 5,
    tags: ["classic", "politics"],
    publisher: { name: "Secker & Warburg", country: "UK" }
  },
  {
    title: "To Kill a Mockingbird",
    author: "Harper Lee",
    genre: "Fiction",
    publishedYear: 1960,
    copies: 4,
    tags: ["classic", "racism"],
    publisher: { name: "J. B. Lippincott & Co.", country: "USA" }
  },
  {
    title: "Brave New World",
    author: "Aldous Huxley",
    genre: "Dystopian",
    publishedYear: 1932,
    copies: 6,
    tags: ["classic", "science fiction"],
    publisher: { name: "Chatto & Windus", country: "UK" }
  },
  {
    title: "The Great Gatsby",
    author: "F. Scott Fitzgerald",
    genre: "Fiction",
    publishedYear: 1925,
    copies: 3,
    tags: ["classic", "1920s"],
    publisher: { name: "Charles Scribner's Sons", country: "USA" }
  },
  {
    title: "Animal Farm",
    author: "George Orwell",
    genre: "Political Satire",
    publishedYear: 1945,
    copies: 7,
    tags: ["classic", "politics"],
    publisher: { name: "Secker & Warburg", country: "UK" }
  },
  {
    title: "Moby-Dick",
    author: "Herman Melville",
    genre: "Adventure",
    publishedYear: 1851,
    copies: 4,
    tags: ["classic", "sea story"],
    publisher: { name: "Harper & Brothers", country: "USA" }
  },
  {
    title: "Pride and Prejudice",
    author: "Jane Austen",
    genre: "Romance",
    publishedYear: 1813,
    copies: 5,
    tags: ["classic", "love story"],
    publisher: { name: "T. Egerton", country: "UK" }
  },
  {
    title: "The Catcher in the Rye",
    author: "J.D. Salinger",
    genre: "Fiction",
    publishedYear: 1951,
    copies: 4,
    tags: ["classic", "coming of age"],
    publisher: { name: "Little, Brown and Company", country: "USA" }
  },
  {
    title: "The Hobbit",
    author: "J.R.R. Tolkien",
    genre: "Fantasy",
    publishedYear: 1937,
    copies: 6,
    tags: ["classic", "fantasy"],
    publisher: { name: "George Allen & Unwin", country: "UK" }
  },
  {
    title: "Fahrenheit 451",
    author: "Ray Bradbury",
    genre: "Dystopian",
    publishedYear: 1953,
    copies: 5,
    tags: ["classic", "science fiction"],
    publisher: { name: "Ballantine Books", country: "USA" }
  }
]);

// Insert members
// Each member has name, email, membershipDate, borrowedBooks (array), address (object)
db.members.insertMany([
  {
    name: "John Doe",
    email: "john@example.com",
    membershipDate: new Date("2020-01-15"),
    borrowedBooks: [],
    address: { street: "123 Maple St", city: "Sofia", zip: "1000" }
  },
  {
    name: "Anna Ivanova",
    email: "anna.ivanova@example.com",
    membershipDate: new Date("2019-03-22"),
    borrowedBooks: [],
    address: { street: "45 Vitosha Blvd", city: "Sofia", zip: "1000" }
  },
  {
    name: "Petar Georgiev",
    email: "petar.georgiev@example.com",
    membershipDate: new Date("2021-06-10"),
    borrowedBooks: [],
    address: { street: "78 Tsarigradsko Shose", city: "Plovdiv", zip: "4000" }
  },
  {
    name: "Maria Petrova",
    email: "maria.petrova@example.com",
    membershipDate: new Date("2018-11-05"),
    borrowedBooks: [],
    address: { street: "12 Levski St", city: "Varna", zip: "9000" }
  },
  {
    name: "Georgi Dimitrov",
    email: "georgi.dimitrov@example.com",
    membershipDate: new Date("2022-02-14"),
    borrowedBooks: [],
    address: { street: "34 Ivan Vazov St", city: "Burgas", zip: "8000" }
  },
  {
    name: "Elena Koleva",
    email: "elena.koleva@example.com",
    membershipDate: new Date("2017-07-20"),
    borrowedBooks: [],
    address: { street: "56 Stefan Stambolov", city: "Ruse", zip: "7000" }
  },
  {
    name: "Ivan Nikolov",
    email: "ivan.nikolov@example.com",
    membershipDate: new Date("2023-01-01"),
    borrowedBooks: [],
    address: { street: "89 Hristo Botev St", city: "Sofia", zip: "1000" }
  },
  {
    name: "Diana Markova",
    email: "diana.markova@example.com",
    membershipDate: new Date("2019-09-15"),
    borrowedBooks: [],
    address: { street: "22 Petko Slaveykov St", city: "Plovdiv", zip: "4000" }
  },
  {
    name: "Stefan Vasilev",
    email: "stefan.vasilev@example.com",
    membershipDate: new Date("2021-12-03"),
    borrowedBooks: [],
    address: { street: "7 Hristo Smirnenski St", city: "Varna", zip: "9000" }
  },
  {
    name: "Katerina Ivanova",
    email: "katerina.ivanova@example.com",
    membershipDate: new Date("2020-05-30"),
    borrowedBooks: [],
    address: { street: "15 Georgi Rakovski St", city: "Burgas", zip: "8000" }
  }
]);

// Insert loans
// Each loan has memberId, bookId, loanDate, returnDate, returned
// NOTE: Replace ObjectId("...") with actual member and book _id values after insertion
db.loans.insertMany([
  {
    memberId: ObjectId("INSERT_MEMBER_ID_HERE"),
    bookId: ObjectId("INSERT_BOOK_ID_HERE"),
    loanDate: new Date("2023-01-10"),
    returnDate: new Date("2023-01-20"),
    returned: true
  },
  {
    memberId: ObjectId("INSERT_MEMBER_ID_HERE"),
    bookId: ObjectId("INSERT_BOOK_ID_HERE"),
    loanDate: new Date("2023-02-05"),
    returnDate: new Date("2023-02-15"),
    returned: true
  },
  {
    memberId: ObjectId("INSERT_MEMBER_ID_HERE"),
    bookId: ObjectId("INSERT_BOOK_ID_HERE"),
    loanDate: new Date("2023-03-12"),
    returnDate: new Date("2023-03-22"),
    returned: false
  },
  {
    memberId: ObjectId("INSERT_MEMBER_ID_HERE"),
    bookId: ObjectId("INSERT_BOOK_ID_HERE"),
    loanDate: new Date("2023-04-01"),
    returnDate: new Date("2023-04-11"),
    returned: true
  },
  {
    memberId: ObjectId("INSERT_MEMBER_ID_HERE"),
    bookId: ObjectId("INSERT_BOOK_ID_HERE"),
    loanDate: new Date("2023-05-15"),
    returnDate: new Date("2023-05-25"),
    returned: false
  },
  {
    memberId: ObjectId("INSERT_MEMBER_ID_HERE"),
    bookId: ObjectId("INSERT_BOOK_ID_HERE"),
    loanDate: new Date("2023-06-20"),
    returnDate: new Date("2023-06-30"),
    returned: true
  },
  {
    memberId: ObjectId("INSERT_MEMBER_ID_HERE"),
    bookId: ObjectId("INSERT_BOOK_ID_HERE"),
    loanDate: new Date("2023-07-07"),
    returnDate: new Date("2023-07-17"),
    returned: false
  },
  {
    memberId: ObjectId("INSERT_MEMBER_ID_HERE"),
    bookId: ObjectId("INSERT_BOOK_ID_HERE"),
    loanDate: new Date("2023-08-14"),
    returnDate: new Date("2023-08-24"),
    returned: true
  },
  {
    memberId: ObjectId("INSERT_MEMBER_ID_HERE"),
    bookId: ObjectId("INSERT_BOOK_ID_HERE"),
    loanDate: new Date("2023-09-05"),
    returnDate: new Date("2023-09-15"),
    returned: true
  },
  {
    memberId: ObjectId("INSERT_MEMBER_ID_HERE"),
    bookId: ObjectId("INSERT_BOOK_ID_HERE"),
    loanDate: new Date("2023-10-01"),
    returnDate: new Date("2023-10-11"),
    returned: false
  }
]);
