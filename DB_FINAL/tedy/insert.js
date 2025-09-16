use("RestaurantDB");

db.menuItems.insertMany([
  { name: "Маргарита", category: "Пица", price: 9.99, ingredients: ["домати", "моцарела", "босилек"], available: true },
  { name: "Пеперони", category: "Пица", price: 11.99, ingredients: ["домати", "моцарела", "пеперони"], available: true },
  { name: "Цезар салата", category: "Салата", price: 7.5, ingredients: ["маруля", "пилешко", "пармезан", "крутони"], available: true },
  { name: "Пържени картофи", category: "Гарнитура", price: 4.5, ingredients: ["картофи", "сол"], available: true },
  { name: "Пиле със сос", category: "Основно", price: 13.0, ingredients: ["пилешко", "сметанов сос"], available: true },
  { name: "Тирамису", category: "Десерт", price: 5.99, ingredients: ["бишкоти", "маскарпоне", "кафе"], available: true },
  { name: "Капучино", category: "Напитка", price: 3.0, ingredients: ["кафе", "мляко"], available: true },
  { name: "Минерална вода", category: "Напитка", price: 1.5, ingredients: ["вода"], available: true },
  { name: "Супа от леща", category: "Супа", price: 6.0, ingredients: ["леща", "моркови", "лук"], available: true },
  { name: "Ризото със зеленчуци", category: "Основно", price: 11.5, ingredients: ["ориз", "тиквички", "моркови"], available: true }
]);

db.customers.insertMany([
  { name: "Иван Петров", phone: "0888123456", email: "ivan@example.com", loyaltyPoints: 25 },
  { name: "Мария Георгиева", phone: "0888234567", email: "maria@example.com", loyaltyPoints: 50 },
  { name: "Георги Димитров", phone: "0888345678", email: "georgi@example.com", loyaltyPoints: 10 },
  { name: "Елена Стоянова", phone: "0888456789", email: "elena@example.com", loyaltyPoints: 5 },
  { name: "Никола Иванов", phone: "0888567890", email: "nikola@example.com", loyaltyPoints: 15 },
  { name: "Виктория Николова", phone: "0888678901", email: "viki@example.com", loyaltyPoints: 40 },
  { name: "Кристиян Костов", phone: "0888789012", email: "kris@example.com", loyaltyPoints: 30 },
  { name: "Даниела Илиева", phone: "0888890123", email: "daniela@example.com", loyaltyPoints: 20 },
  { name: "Симеон Христов", phone: "0888901234", email: "simeon@example.com", loyaltyPoints: 35 },
  { name: "Анна Тодорова", phone: "0888012345", email: "anna@example.com", loyaltyPoints: 45 }
]);

db.employees.insertMany([
  { name: "Петър Петров", position: "Готвач", salary: 1500, fullTime: true },
  { name: "Иван Иванов", position: "Сервитьор", salary: 1000, fullTime: false },
  { name: "Мария Попова", position: "Мениджър", salary: 2000, fullTime: true },
  { name: "Десислава Василева", position: "Готвач", salary: 1400, fullTime: true },
  { name: "Георги Йорданов", position: "Сервитьор", salary: 950, fullTime: false },
  { name: "Емилия Ангелова", position: "Барман", salary: 1100, fullTime: true },
  { name: "Николай Стефанов", position: "Счетоводител", salary: 1800, fullTime: true },
  { name: "Станислава Ганева", position: "Хигиенист", salary: 800, fullTime: false },
  { name: "Антон Михайлов", position: "Снабдител", salary: 1200, fullTime: true },
  { name: "Калина Алексиева", position: "Сервитьор", salary: 1000, fullTime: false }
]);

db.orders.insertMany([
  { customerName: "Иван Петров", items: ["Маргарита", "Капучино"], total: 12.99, paid: true },
  { customerName: "Мария Георгиева", items: ["Цезар салата", "Пържени картофи"], total: 12.0, paid: true },
  { customerName: "Георги Димитров", items: ["Ризото със зеленчуци"], total: 11.5, paid: true },
  { customerName: "Елена Стоянова", items: ["Тирамису", "Минерална вода"], total: 7.49, paid: false },
  { customerName: "Никола Иванов", items: ["Пеперони", "Капучино"], total: 14.99, paid: true },
  { customerName: "Виктория Николова", items: ["Пиле със сос"], total: 13.0, paid: false },
  { customerName: "Кристиян Костов", items: ["Супа от леща", "Маргарита"], total: 15.99, paid: true },
  { customerName: "Даниела Илиева", items: ["Цезар салата", "Капучино"], total: 10.5, paid: false },
  { customerName: "Симеон Христов", items: ["Ризото със зеленчуци", "Минерална вода"], total: 13.0, paid: true },
  { customerName: "Анна Тодорова", items: ["Пиле със сос", "Тирамису"], total: 18.99, paid: true }
]);

db.reservations.insertMany([
  { customerName: "Иван Петров", table: 4, time: new Date("2025-06-20T19:00:00"), guests: 2 },
  { customerName: "Мария Георгиева", table: 2, time: new Date("2025-06-21T18:00:00"), guests: 4 },
  { customerName: "Георги Димитров", table: 6, time: new Date("2025-06-22T20:00:00"), guests: 3 },
  { customerName: "Елена Стоянова", table: 1, time: new Date("2025-06-23T17:30:00"), guests: 1 },
  { customerName: "Никола Иванов", table: 5, time: new Date("2025-06-24T19:45:00"), guests: 2 },
  { customerName: "Виктория Николова", table: 3, time: new Date("2025-06-25T18:15:00"), guests: 2 },
  { customerName: "Кристиян Костов", table: 8, time: new Date("2025-06-26T20:30:00"), guests: 5 },
  { customerName: "Даниела Илиева", table: 7, time: new Date("2025-06-27T19:00:00"), guests: 3 },
  { customerName: "Симеон Христов", table: 9, time: new Date("2025-06-28T18:00:00"), guests: 4 },
  { customerName: "Анна Тодорова", table: 10, time: new Date("2025-06-29T21:00:00"), guests: 2 }
]);
