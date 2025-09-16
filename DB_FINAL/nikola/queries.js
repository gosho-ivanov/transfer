use("ClothingStoreDB");


db.products.find()
db.products.find({ category: "Outerwear" })
db.products.find({ category: "Bottoms", price: { $lt: 50 } })

db.products.updateOne({ name: "Hoodie" }, { $set: { stock: 55 } })

db.products.deleteOne({ name: "Evening Gown" })

db.products.aggregate([{ $group: { _id: "$category", totalStock: { $sum: "$stock" } } }])
db.products.aggregate([{ $group: { _id: "$category", avgPrice: { $avg: "$price" } } }])
db.products.aggregate([{ $match: { stock: { $gt: 0 } } }, { $sort: { price: -1 } }])


db.customers.find()
db.customers.find({ "address.city": "Sofia" })
db.customers.find({ loyaltyPoints: { $gt: 100 }, preferences: "casual" })

db.customers.updateOne({ email: "ivan@example.com" }, { $set: { phone: "0899000000" } })

db.customers.deleteOne({ email: "todor@example.com" })

db.customers.aggregate([{ $group: { _id: "$address.city", totalCustomers: { $sum: 1 } } }])
db.customers.aggregate([{ $match: { loyaltyPoints: { $exists: true } } }, { $group: { _id: null, avgPoints: { $avg: "$loyaltyPoints" } } }])
db.customers.aggregate([{ $sort: { name: 1 } }])


db.orders.find()
db.orders.find({ status: "shipped" })
db.orders.find({ status: "pending", total: { $gt: 40 } })

db.orders.updateOne({ customerId: 2 }, { $set: { status: "shipped" } })

db.orders.deleteOne({ customerId: 4 })

db.orders.aggregate([{ $group: { _id: "$status", count: { $sum: 1 } } }])
db.orders.aggregate([{ $group: { _id: null, avgTotal: { $avg: "$total" } } }])
db.orders.aggregate([{ $match: { total: { $gt: 50 } } }, { $sort: { total: -1 } }])


db.employees.find()
db.employees.find({ role: "Cashier" })
db.employees.find({ role: "Manager", fullTime: true })

db.employees.updateOne({ name: "Ivo Zhelev" }, { $set: { salary: 2300 } })

db.employees.deleteOne({ name: "Georgi Todorov" })

db.employees.aggregate([{ $group: { _id: "$role", count: { $sum: 1 } } }])
db.employees.aggregate([{ $match: { salary: { $exists: true } } }, { $group: { _id: null, avgSalary: { $avg: "$salary" } } }])
db.employees.aggregate([{ $match: { salary: { $exists: true } } }, { $sort: { salary: -1 } }])


db.categories.find()
db.categories.find({ popular: true })
db.categories.find({ popular: false, seasonal: true })

db.categories.updateOne({ name: "Bottoms" }, { $set: { description: "All pants and lower wear" } })

db.categories.deleteOne({ name: "Children" })

db.categories.aggregate([{ $group: { _id: "$popular", total: { $sum: 1 } } }])
db.categories.aggregate([{ $match: { $or: [ { featured: true }, { seasonal: true } ] } }, { $group: { _id: null, count: { $sum: 1 } } }])
db.categories.aggregate([{ $sort: { name: 1 } }])
