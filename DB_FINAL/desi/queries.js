use("restaurantDB");

// vehicles
db.vehicles.find({});
db.vehicles.find({ make: "Toyota" });
db.vehicles.find({ make: "Ford", year: { $gte: 2015 } });

db.vehicles.updateOne({ model: "Corolla" }, { $set: { mileage: 62000 } });

db.vehicles.deleteOne({ mileage: { $gt: 100000 } });

db.vehicles.aggregate([
  { $group: { _id: "$make", totalVehicles: { $sum: 1 } } }
]);
db.vehicles.aggregate([
  { $group: { _id: null, avgMileage: { $avg: "$mileage" } } }
]);
db.vehicles.aggregate([
  { $match: { year: { $gte: 2016 } } },
  { $sort: { mileage: -1 } }
]);

// customers
db.customers.find({});
db.customers.find({ loyaltyPoints: { $gte: 100 } });
db.customers.find({ loyaltyPoints: { $gte: 50 }, vehiclesOwned: { $exists: true, $not: { $size: 0 } } });

db.customers.updateOne({ name: "Иван Петров" }, { $inc: { loyaltyPoints: 20 } });

db.customers.deleteOne({ loyaltyPoints: { $lt: 20 } });

db.customers.aggregate([
  { $group: { _id: null, totalCustomers: { $sum: 1 } } }
]);
db.customers.aggregate([
  { $group: { _id: null, avgLoyaltyPoints: { $avg: "$loyaltyPoints" } } }
]);
db.customers.aggregate([
  { $match: { loyaltyPoints: { $gte: 50 } } },
  { $sort: { loyaltyPoints: -1 } }
]);

// repairs
db.repairs.find({});
db.repairs.find({ cost: { $gte: 100 } });
db.repairs.find({ cost: { $gte: 100 }, partsUsed: { $in: ["масло"] } });

db.repairs.updateOne({ description: "смяна на масло" }, { $set: { cost: 85 } });

db.repairs.deleteOne({ cost: { $lt: 50 } });

db.repairs.aggregate([
  { $group: { _id: "$description", totalRepairs: { $sum: 1 } } }
]);
db.repairs.aggregate([
  { $group: { _id: null, totalCost: { $sum: "$cost" } } }
]);
db.repairs.aggregate([
  { $match: { cost: { $gte: 100 } } },
  { $sort: { cost: -1 } }
]);

// parts
db.parts.find({});
db.parts.find({ category: "консумативи" });
db.parts.find({ category: "консумативи", stock: { $gte: 20 } });

db.parts.updateOne({ name: "масло" }, { $inc: { stock: -5 } });

db.parts.deleteOne({ stock: { $lt: 10 } });

db.parts.aggregate([
  { $group: { _id: "$category", totalParts: { $sum: 1 } } }
]);
db.parts.aggregate([
  { $group: { _id: null, avgPrice: { $avg: "$price" } } }
]);
db.parts.aggregate([
  { $match: { stock: { $gte: 20 } } },
  { $sort: { price: 1 } }
]);

// appointments
db.appointments.find({});
db.appointments.find({ serviceType: "смяна на масло" });
db.appointments.find({ serviceType: "смяна на масло", date: { $gte: "2024-07-01" } });

db.appointments.updateOne({ serviceType: "смяна на масло" }, { $set: { notes: "Да се провери и състоянието на гумите" } });

db.appointments.deleteOne({ date: { $lt: "2024-07-01" } });

db.appointments.aggregate([
  { $group: { _id: "$serviceType", totalAppointments: { $sum: 1 } } }
]);
db.appointments.aggregate([
  { $group: { _id: null, totalAppointments: { $sum: 1 } } }
]);
db.appointments.aggregate([
  { $match: { date: { $gte: "2024-07-05" } } },
  { $sort: { date: 1, time: 1 } }
]);
