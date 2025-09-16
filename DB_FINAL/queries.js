use("LibraryDB");

db.books.find({});
db.books.find({ genre: "Dystopian" });
db.books.find({ author: "George Orwell", publishedYear: { $gt: 1940 } });

db.members.find({});
db.members.find({ "address.city": "Sofia" });
db.members.find({ name: "John Doe", "address.city": "Sofia" });

db.loans.find({});
db.loans.find({ returned: false });
db.loans.find({ memberId: ObjectId("64cfc5f10f0b8a0e6fef0011"), returned: true });

db.authors.find({});
db.authors.find({ nationality: "British" });
db.authors.find({ nationality: "British", booksWritten: { $size: 2 } });

db.genres.find({});
db.genres.find({ name: "Dystopian" });
db.genres.find({ popularAuthors: "George Orwell" });

db.members.updateOne(
  { name: "John Doe" },
  { $set: { email: "john.doe@newmail.com" } }
);
db.books.updateOne(
  { title: "1984" },
  { $inc: { copies: 2 } }
);
db.authors.updateOne(
  { name: "George Orwell" },
  { $push: { booksWritten: "Homage to Catalonia" } }
);
db.loans.updateOne(
  { returned: false },
  { $set: { returned: true } }
);
db.genres.updateOne(
  { name: "Dystopian" },
  { $addToSet: { popularAuthors: "Margaret Atwood" } }
);

db.books.deleteOne({ title: "1984" });
db.members.deleteOne({ name: "John Doe" });
db.loans.deleteOne({ _id: ObjectId("64cfc5f10f0b8a0e6fef0011") });
db.authors.deleteOne({ name: "George Orwell" });
db.genres.deleteOne({ name: "Obsolete Genre" });

db.books.aggregate([
  { $group: { _id: "$genre", count: { $sum: 1 } } }
]);
db.books.aggregate([
  { $group: { _id: "$genre", avgCopies: { $avg: "$copies" } } }
]);
db.books.aggregate([
  { $match: { copies: { $gt: 2 } } },
  { $sort: { copies: -1 } }
]);

db.members.aggregate([
  { $group: { _id: "$address.city", totalMembers: { $sum: 1 } } }
]);
db.members.aggregate([
  { $group: { _id: null, avgBorrowed: { $avg: { $size: "$borrowedBooks" } } } }
]);
db.members.aggregate([
  { $match: { "address.city": "Sofia" } },
  { $sort: { name: 1 } }
]);

db.loans.aggregate([
  { $group: { _id: "$returned", total: { $sum: 1 } } }
]);
db.loans.aggregate([
  { $group: { _id: null, avgLoanDuration: { $avg: { $subtract: ["$returnDate", "$loanDate"] } } } }
]);
db.loans.aggregate([
  { $match: { returned: true } },
  { $sort: { loanDate: -1 } }
]);

db.authors.aggregate([
  { $group: { _id: "$nationality", totalAuthors: { $sum: 1 } } }
]);
db.authors.aggregate([
  { $project: { name: 1, booksCount: { $size: "$booksWritten" } } },
  { $group: { _id: null, avgBooksWritten: { $avg: "$booksCount" } } }
]);
db.authors.aggregate([
  { $match: { nationality: "British" } },
  { $sort: { name: 1 } }
]);

db.genres.aggregate([
  { $group: { _id: "$name", totalAuthors: { $sum: { $size: "$popularAuthors" } } } }
]);
db.genres.aggregate([
  { $project: { name: 1, authorsCount: { $size: "$popularAuthors" } } },
  { $group: { _id: null, avgAuthorsPerGenre: { $avg: "$authorsCount" } } }
]);
db.genres.aggregate([
  { $match: { popularAuthors: "George Orwell" } },
  { $sort: { name: 1 } }
]);