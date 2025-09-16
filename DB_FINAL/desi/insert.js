use("carRepairDB");

// Колекция 1: vehicles
db.vehicles.insertMany([
  { make: "Toyota", model: "Corolla", year: 2018, mileage: 60000, ownerId: 1, serviceHistory: [{ date: "2023-01-15", service: "смяна на масло" }] },
  { make: "Ford", model: "Focus", year: 2017, mileage: 75000, ownerId: 2, serviceHistory: [{ date: "2022-12-10", service: "смяна на накладки" }] },
  { make: "Volkswagen", model: "Golf", year: 2015, mileage: 90000, ownerId: 3 },
  { make: "BMW", model: "320i", year: 2019, mileage: 40000, ownerId: 4, serviceHistory: [] },
  { make: "Audi", model: "A4", year: 2016, mileage: 85000, ownerId: 5, serviceHistory: [{ date: "2023-03-20", service: "смяна на гуми" }] },
  { make: "Mercedes", model: "C200", year: 2014, mileage: 100000, ownerId: 6 },
  { make: "Toyota", model: "RAV4", year: 2020, mileage: 30000, ownerId: 7, serviceHistory: [{ date: "2023-05-10", service: "пълна диагностика" }] },
  { make: "Ford", model: "Fiesta", year: 2013, mileage: 110000, ownerId: 8 },
  { make: "Nissan", model: "Qashqai", year: 2018, mileage: 65000, ownerId: 9 },
  { make: "Honda", model: "Civic", year: 2017, mileage: 70000, ownerId: 10 }
]);

// Колекция 2: customers
db.customers.insertMany([
  { name: "Иван Петров", email: "ivan.petrov@example.com", phone: "0888123456", loyaltyPoints: 150, vehiclesOwned: [1,7] },
  { name: "Мария Георгиева", email: "maria.georgieva@example.com", phone: "0899123456", loyaltyPoints: 80, vehiclesOwned: [2] },
  { name: "Георги Иванов", email: "georgi.ivanov@example.com", phone: "0876123456", loyaltyPoints: 100, vehiclesOwned: [3] },
  { name: "Елена Стоянова", email: "elena.stoyanova@example.com", phone: "0887456123", loyaltyPoints: 40, vehiclesOwned: [4] },
  { name: "Димитър Димитров", email: "dimitar.dim@example.com", phone: "0899876543", loyaltyPoints: 200, vehiclesOwned: [5] },
  { name: "Калоян Илиев", email: "kaloyan.iliev@example.com", phone: "0888999777", loyaltyPoints: 10, vehiclesOwned: [6] },
  { name: "Анна Тодорова", email: "anna.todorova@example.com", phone: "0899888777", loyaltyPoints: 65, vehiclesOwned: [8] },
  { name: "Петър Георгиев", email: "petar.georgiev@example.com", phone: "0877333555", loyaltyPoints: 90, vehiclesOwned: [9] },
  { name: "Светла Христова", email: "svetla.hristova@example.com", phone: "0888777666", loyaltyPoints: 110, vehiclesOwned: [10] },
  { name: "Радостин Колев", email: "radostin.kolev@example.com", phone: "0899444333", loyaltyPoints: 120, vehiclesOwned: [] }
]);

// Колекция 3: repairs
db.repairs.insertMany([
  { vehicleId: 1, date: "2023-01-15", description: "смяна на масло", cost: 80, partsUsed: ["масло", "филтър"] },
  { vehicleId: 2, date: "2022-12-10", description: "смяна на накладки", cost: 120, partsUsed: ["накладки"] },
  { vehicleId: 5, date: "2023-03-20", description: "смяна на гуми", cost: 400, partsUsed: ["гуми"] },
  { vehicleId: 7, date: "2023-05-10", description: "пълна диагностика", cost: 60, partsUsed: [] },
  { vehicleId: 3, date: "2023-04-05", description: "смяна на спирачна течност", cost: 50, partsUsed: ["спирачна течност"] },
  { vehicleId: 4, date: "2023-06-01", description: "смяна на филтър", cost: 30, partsUsed: ["въздушен филтър"] },
  { vehicleId: 8, date: "2023-02-14", description: "ремонт на окачване", cost: 350, partsUsed: ["амортисьори"] },
  { vehicleId: 9, date: "2023-07-01", description: "смяна на батерия", cost: 150, partsUsed: ["батерия"] },
  { vehicleId: 10, date: "2023-01-22", description: "смяна на масло", cost: 75, partsUsed: ["масло", "филтър"] },
  { vehicleId: 6, date: "2023-06-15", description: "смяна на ангренажен ремък", cost: 300, partsUsed: ["ремък"] }
]);

// Колекция 4: parts
db.parts.insertMany([
  { name: "масло", category: "консумативи", price: 20, stock: 50, suppliers: [{ name: "AutoParts Ltd", contact: "auto@example.com" }] },
  { name: "филтър", category: "консумативи", price: 15, stock: 30, suppliers: [{ name: "FilterCo", contact: "filter@example.com" }] },
  { name: "накладки", category: "спирачна система", price: 40, stock: 20, suppliers: [{ name: "BrakeMaster", contact: "brake@example.com" }] },
  { name: "гуми", category: "гуми", price: 100, stock: 10, suppliers: [{ name: "TireWorld", contact: "tire@example.com" }] },
  { name: "спирачна течност", category: "консумативи", price: 12, stock: 60, suppliers: [{ name: "FluidSupplies", contact: "fluid@example.com" }] },
  { name: "въздушен филтър", category: "консумативи", price: 25, stock: 25, suppliers: [{ name: "FilterCo", contact: "filter@example.com" }] },
  { name: "амортисьори", category: "окачване", price: 150, stock: 5, suppliers: [{ name: "ShockAbsorb", contact: "shock@example.com" }] },
  { name: "батерия", category: "електрическа система", price: 180, stock: 8, suppliers: [{ name: "BatteryCorp", contact: "battery@example.com" }] },
  { name: "ремък", category: "двигател", price: 90, stock: 15, suppliers: [{ name: "EngineParts", contact: "engine@example.com" }] },
  { name: "маслен филтър", category: "консумативи", price: 18, stock: 40, suppliers: [{ name: "FilterCo", contact: "filter@example.com" }] }
]);

// Колекция 5: appointments
db.appointments.insertMany([
  { customerId: 1, vehicleId: 1, date: "2024-07-01", time: "10:00", serviceType: "смяна на масло", notes: "Да се провери спирачките" },
  { customerId: 2, vehicleId: 2, date: "2024-07-02", time: "11:00", serviceType: "смяна на накладки", notes: "" },
  { customerId: 3, vehicleId: 3, date: "2024-07-03", time: "09:30", serviceType: "смяна на гуми", notes: "Клиент иска бързо обслужване" },
  { customerId: 4, vehicleId: 4, date: "2024-07-04", time: "14:00", serviceType: "пълна диагностика", notes: "" },
  { customerId: 5, vehicleId: 5, date: "2024-07-05", time: "13:00", serviceType: "смяна на ангренажен ремък", notes: "" },
  { customerId: 6, vehicleId: 6, date: "2024-07-06", time: "12:00", serviceType: "ремонт на окачване", notes: "" },
  { customerId: 7, vehicleId: 7, date: "2024-07-07", time: "15:00", serviceType: "смяна на батерия", notes: "Клиент иска оригинални части" },
  { customerId: 8, vehicleId: 8, date: "2024-07-08", time: "10:30", serviceType: "смяна на масло", notes: "" },
  { customerId: 9, vehicleId: 9, date: "2024-07-09", time: "11:30", serviceType: "смяна на филтър", notes: "" },
  { customerId: 10, vehicleId: 10, date: "2024-07-10", time: "09:00", serviceType: "пълна диагностика", notes: "" }
]);
