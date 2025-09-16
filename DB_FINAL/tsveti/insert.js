use("pharmacyDB");

db.medicines.insertMany([
  { medicineId: 1, name: "Парацетамол", category: "обезболяващи", price: 3.50, stock: 120, ingredients: ["парацетамол"] },
  { medicineId: 2, name: "Ибупрофен", category: "обезболяващи", price: 4.20, stock: 90, ingredients: ["ибупрофен"] },
  { medicineId: 3, name: "Амоксицилин", category: "антибиотици", price: 7.00, stock: 50, ingredients: ["амоксицилин"] },
  { medicineId: 4, name: "Ципрофлоксацин", category: "антибиотици", price: 8.00, stock: 30, ingredients: ["ципрофлоксацин"] },
  { medicineId: 5, name: "Витамин C", category: "витамини", price: 5.00, stock: 200, ingredients: ["аскорбинова киселина"] },
  { medicineId: 6, name: "Аспирин", category: "обезболяващи", price: 3.00, stock: 110, ingredients: ["ацетилсалицилова киселина"] },
  { medicineId: 7, name: "Лоперамид", category: "противодиарийни", price: 6.50, stock: 40, ingredients: ["лоперамид"] },
  { medicineId: 8, name: "Метформин", category: "антидиабетни", price: 9.00, stock: 60, ingredients: ["метформин"] },
  { medicineId: 9, name: "Псилиум", category: "фибри", price: 12.00, stock: 70, ingredients: ["псилиум"] },
  { medicineId: 10, name: "Хлорхексидин", category: "антисептици", price: 4.50, stock: 100, ingredients: ["хлорхексидин"] }
]);

db.customers.insertMany([
  { customerId: 1, name: "Мария Георгиева", phone: "0899123456", prescriptions: [3, 4], allergies: ["пеницилин"] },
  { customerId: 2, name: "Иван Петров", phone: "0888777666", prescriptions: [8], allergies: [] },
  { customerId: 3, name: "Петър Стоянов", phone: "0877333444", prescriptions: [], allergies: ["аспирин"] },
  { customerId: 4, name: "Елена Иванова", phone: "0899555777", prescriptions: [1, 6], allergies: [] },
  { customerId: 5, name: "Георги Димитров", phone: "0888111222", prescriptions: [], allergies: ["ибупрофен"] },
  { customerId: 6, name: "Светлана Николаева", phone: "0899888777", prescriptions: [5], allergies: [] },
  { customerId: 7, name: "Димитър Христов", phone: "0877222333", prescriptions: [7], allergies: [] },
  { customerId: 8, name: "Анна Тодорова", phone: "0899666555", prescriptions: [2], allergies: [] },
  { customerId: 9, name: "Николай Василев", phone: "0888444333", prescriptions: [], allergies: [] },
  { customerId: 10, name: "Росица Иванова", phone: "0899000111", prescriptions: [9], allergies: [] }
]);

db.prescriptions.insertMany([
  { prescriptionId: 1, customerId: 1, medicineId: 3, prescribedDate: "2024-06-01", quantity: 20, doctor: "Д-р Петров" },
  { prescriptionId: 2, customerId: 1, medicineId: 4, prescribedDate: "2024-06-01", quantity: 15, doctor: "Д-р Петров" },
  { prescriptionId: 3, customerId: 2, medicineId: 8, prescribedDate: "2024-05-15", quantity: 30, doctor: "Д-р Иванова" },
  { prescriptionId: 4, customerId: 4, medicineId: 1, prescribedDate: "2024-06-10", quantity: 10, doctor: "Д-р Георгиев" },
  { prescriptionId: 5, customerId: 4, medicineId: 6, prescribedDate: "2024-06-10", quantity: 20, doctor: "Д-р Георгиев" },
  { prescriptionId: 6, customerId: 6, medicineId: 5, prescribedDate: "2024-05-20", quantity: 50, doctor: "Д-р Стоянова" },
  { prescriptionId: 7, customerId: 7, medicineId: 7, prescribedDate: "2024-06-05", quantity: 15, doctor: "Д-р Петров" },
  { prescriptionId: 8, customerId: 8, medicineId: 2, prescribedDate: "2024-06-12", quantity: 25, doctor: "Д-р Иванова" },
  { prescriptionId: 9, customerId: 10, medicineId: 9, prescribedDate: "2024-06-07", quantity: 40, doctor: "Д-р Георгиев" },
  { prescriptionId: 10, customerId: 3, medicineId: 1, prescribedDate: "2024-05-25", quantity: 10, doctor: "Д-р Петров" }
]);

db.employees.insertMany([
  { employeeId: 1, name: "Иван Иванов", position: "фармацевт", fullTime: true, salary: 1800 },
  { employeeId: 2, name: "Мария Петрова", position: "асистент-фармацевт", fullTime: false, salary: 1200 },
  { employeeId: 3, name: "Георги Георгиев", position: "фармацевт", fullTime: true, salary: 1900 },
  { employeeId: 4, name: "Елена Стоянова", position: "мениджър", fullTime: true, salary: 2200 },
  { employeeId: 5, name: "Димитър Николов", position: "фармацевт", fullTime: false, salary: 1300 },
  { employeeId: 6, name: "Светлана Димитрова", position: "асистент-фармацевт", fullTime: true, salary: 1400 },
  { employeeId: 7, name: "Радослав Петров", position: "фармацевт", fullTime: true, salary: 1850 },
  { employeeId: 8, name: "Ваня Иванова", position: "асистент-фармацевт", fullTime: false, salary: 1100 },
  { employeeId: 9, name: "Николай Стоянов", position: "фармацевт", fullTime: true, salary: 2000 },
  { employeeId: 10, name: "Роси Георгиева", position: "мениджър", fullTime: true, salary: 2300 }
]);

db.sales.insertMany([
  { saleId: 1, medicineId: 1, customerId: 4, quantity: 5, saleDate: "2024-06-11", totalPrice: 17.5 },
  { saleId: 2, medicineId: 2, customerId: 8, quantity: 10, saleDate: "2024-06-13", totalPrice: 42 },
  { saleId: 3, medicineId: 5, customerId: 6, quantity: 20, saleDate: "2024-06-22", totalPrice: 100 },
  { saleId: 4, medicineId: 9, customerId: 10, quantity: 10, saleDate: "2024-06-10", totalPrice: 120 },
  { saleId: 5, medicineId: 3, customerId: 1, quantity: 5, saleDate: "2024-06-05", totalPrice: 35 },
  { saleId: 6, medicineId: 7, customerId: 7, quantity: 3, saleDate: "2024-06-06", totalPrice: 19.5 },
  { saleId: 7, medicineId: 4, customerId: 1, quantity: 2, saleDate: "2024-06-07", totalPrice: 16 },
  { saleId: 8, medicineId: 6, customerId: 4, quantity: 8, saleDate: "2024-06-08", totalPrice: 24 },
  { saleId: 9, medicineId: 8, customerId: 2, quantity: 10, saleDate: "2024-06-10", totalPrice: 90 },
  { saleId: 10, medicineId: 10, customerId: 9, quantity: 7, saleDate: "2024-06-12", totalPrice: 31.5 }
]);