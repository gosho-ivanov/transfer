use("restaurantDB");

db.menuItems.find({});
db.menuItems.find({ category: "Пица" });
db.menuItems.find({ price: { $gt: 10 }, available: true });

db.customers.find({});
db.customers.find({ loyaltyPoints: { $gte: 30 } });
db.customers.find({ name: "Мария Георгиева", loyaltyPoints: { $gt: 40 } });

db.employees.find({});
db.employees.find({ fullTime: true });
db.employees.find({ position: "Сервитьор", fullTime: false });

db.orders.find({});
db.orders.find({ paid: false });
db.orders.find({ customerName: "Анна Тодорова", paid: true });

db.reservations.find({});
db.reservations.find({ guests: { $gte: 4 } });
db.reservations.find({ customerName: "Иван Петров", guests: 2 });

db.menuItems.updateOne(
  { name: "Маргарита" },
  { $set: { available: false } }
);

db.customers.updateOne(
  { name: "Иван Петров" },
  { $inc: { loyaltyPoints: 10 } }
);

db.employees.updateOne(
  { name: "Иван Иванов" },
  { $set: { fullTime: true } }
);

db.orders.updateOne(
  { customerName: "Елена Стоянова" },
  { $set: { paid: true } }
);

db.reservations.updateOne(
  { customerName: "Анна Тодорова" },
  { $set: { table: 11 } }
);

db.menuItems.deleteOne({ name: "Минерална вода" });
db.customers.deleteOne({ name: "Елена Стоянова" });
db.employees.deleteOne({ name: "Станислава Ганева" });
db.orders.deleteOne({ customerName: "Даниела Илиева" });
db.reservations.deleteOne({ customerName: "Никола Иванов" });

db.menuItems.aggregate([
  { $group: { _id: "$category", totalItems: { $sum: 1 } } }
]);

db.menuItems.aggregate([
  { $group: { _id: "$category", avgPrice: { $avg: "$price" } } }
]);

db.orders.aggregate([
  { $match: { paid: true } },
  { $sort: { total: -1 } }
]);