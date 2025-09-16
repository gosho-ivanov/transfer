# LibraryDB

## Общо описание

`LibraryDB` е MongoDB база данни, предназначена за управление на библиотечна система. Тя позволява съхранение и манипулиране на информация за книги, членове на библиотеката, заеми, автори и жанрове. Проектът демонстрира основните операции в MongoDB: създаване, четене, редактиране, изтриване (CRUD), както и използване на aggregate pipeline за анализ и обработка на данни.

## Колекции и структура на документите

### 1. `books`

Съдържа информация за книги, налични в библиотеката.

```json
{
  "title": "1984",
  "author": "George Orwell",
  "genre": "Dystopian",
  "publishedYear": 1949,
  "copies": 5
}
```

### 2. `members`

Съдържа данни за членове на библиотеката.

```json
{
  "name": "John Doe",
  "email": "john@example.com",
  "address": {
    "city": "Sofia",
    "street": "Main St",
    "number": 12
  },
  "borrowedBooks": ["1984", "Brave New World"]
}
```

### 3. `loans`

Представя информация за направените заеми.

```json
{
  "memberId": ObjectId("..."),
  "bookTitle": "1984",
  "loanDate": ISODate("2023-06-01T00:00:00Z"),
  "returnDate": ISODate("2023-06-15T00:00:00Z"),
  "returned": true
}
```

### 4. `authors`

Съдържа информация за авторите на книги.

```json
{
  "name": "George Orwell",
  "birthYear": 1903,
  "nationality": "British",
  "booksWritten": ["1984", "Animal Farm"]
}
```

### 5. `genres`

Списък с жанрове и техните популярни автори.

```json
{
  "name": "Dystopian",
  "description": "Fictional society under oppressive control",
  "popularAuthors": ["George Orwell", "Aldous Huxley"]
}
```

## Инсталация и стартиране

### Изисквания

* [Node.js](https://nodejs.org/)
* [MongoDB](https://www.mongodb.com/try/download/community)
* MongoDB Shell или GUI инструмент (MongoDB Compass)

### Стъпки

1. Клонирайте хранилището:

```bash
git clone https://github.com/your-username/LibraryDB.git
cd LibraryDB
```

2. Стартирайте MongoDB сървъра (ако не е стартирал вече):

```bash
mongod
```

3. Стартирайте MongoDB shell и изпълнете следните команди:

```bash
mongosh
```

4. Изпълнете `insert.js`, за да добавите данните:

```bash
load("insert.js")
```

5. Изпълнете `queries.js`, за да пробвате заявките:

```bash
load("queries.js")
```
