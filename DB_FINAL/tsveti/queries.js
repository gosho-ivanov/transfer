// READ OPERATIONS

db.medicines.find();
db.medicines.find({ category: "антибиотици" });
db.medicines.find({ category: "обезболяващи", price: { $lt: 6 } });

db.customers.find();
db.customers.find({ allergies: { $ne: [] } });
db.customers.find({ prescriptions: { $ne: [] }, allergies: [] });

db.prescriptions.find();
db.prescriptions.find({ doctor: "Д-р Георгиев" });
db.prescriptions.find({ prescribedDate: { $regex: "^2024-06" }, quantity: { $gt: 20 } });

db.employees.find();
db.employees.find({ fullTime: true });
db.employees.find({ fullTime: true, position: "фармацевт", salary: { $gt: 1800 } });

db.sales.find();
db.sales.find({ saleDate: "2024-06-10" });
db.sales.find({ totalPrice: { $gt: 50 }, quantity: { $gte: 10 } });

// UPDATE OPERATIONS

db.medicines.updateOne({ name: "Парацетамол" }, { $set: { stock: 100 } });
db.customers.updateOne({ name: "Иван Петров" }, { $set: { phone: "0888000000" } });
db.prescriptions.updateOne({ prescriptionId: 1 }, { $set: { quantity: 25 } });
db.employees.updateOne({ name: "Мария Петрова" }, { $set: { salary: 1300 } });
db.sales.updateOne({ saleId: 1 }, { $set: { totalPrice: 20 } });

// DELETE OPERATIONS

db.medicines.deleteOne({ name: "Аспирин" });
db.customers.deleteOne({ name: "Росица Иванова" });
db.prescriptions.deleteOne({ prescriptionId: 10 });
db.employees.deleteOne({ name: "Ваня Иванова" });
db.sales.deleteOne({ saleId: 10 });

// AGGREGATION PIPELINES

db.medicines.aggregate([
  { $group: { _id: "$category", totalStock: { $sum: "$stock" } } }
]);
db.medicines.aggregate([
  { $group: { _id: null, avgPrice: { $avg: "$price" } } }
]);
db.medicines.aggregate([
  { $match: { price: { $gt: 5 } } },
  { $sort: { price: -1 } }
]);

db.customers.aggregate([
  { $group: { _id: { hasAllergies: { $gt: [ { $size: "$allergies" }, 0 ] } }, count: { $sum: 1 } } }
]);
db.customers.aggregate([
  { $group: { _id: null, avgPrescriptions: { $avg: { $size: "$prescriptions" } } } }
]);
db.customers.aggregate([
  { $match: { allergies: { $ne: [] } } },
  { $sort: { name: 1 } }
]);

db.prescriptions.aggregate([
  { $group: { _id: "$doctor", totalQuantity: { $sum: "$quantity" } } }
]);
db.prescriptions.aggregate([
  { $group: { _id: null, count: { $sum: 1 } } }
]);
db.prescriptions.aggregate([
  { $match: { quantity: { $gt: 20 } } },
  { $sort: { prescribedDate: -1 } }
]);

db.employees.aggregate([
  { $group: { _id: "$position", count: { $sum: 1 } } }
]);
db.employees.aggregate([
  { $group: { _id: null, avgSalary: { $avg: "$salary" } } }
]);
db.employees.aggregate([
  { $match: { fullTime: true } },
  { $sort: { salary: -1 } }
]);

db.sales.aggregate([
  { $group: { _id: "$medicineId", totalRevenue: { $sum: "$totalPrice" } } }
]);
db.sales.aggregate([
  { $group: { _id: null, count: { $sum: 1 } } }
]);
db.sales.aggregate([
  { $match: { quantity: { $gte: 10 } } },
  { $sort: { totalPrice: -1 } }
]);