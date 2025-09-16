use("ClothingStoreDB");

db.products.insertMany([
  {
    name: "Basic T-Shirt",
    category: "Tops",
    price: 19.99,
    sizes: ["S", "M", "L"],
    tags: ["cotton", "summer"],
    stock: 120,
    supplier: { name: "Textile Co", country: "Turkey" }
  },
  {
    name: "Blue Jeans",
    category: "Bottoms",
    price: 49.99,
    sizes: ["M", "L", "XL"],
    tags: ["denim"],
    stock: 80,
    supplier: { name: "DenimCraft", country: "Bangladesh" }
  },
  {
    name: "Leather Jacket",
    category: "Outerwear",
    price: 149.99,
    sizes: ["M", "L"],
    tags: ["leather", "winter"],
    stock: 20,
    supplier: { name: "StyleLux", country: "Italy" },
    discount: 15
  },
  {
    name: "Summer Dress",
    category: "Dresses",
    price: 39.99,
    sizes: ["S", "M", "L"],
    tags: ["floral", "summer"],
    stock: 45,
    supplier: { name: "FashionLine", country: "China" },
    availableColors: ["red", "blue"]
  },
  {
    name: "Hoodie",
    category: "Outerwear",
    price: 59.99,
    sizes: ["S", "M", "L", "XL"],
    tags: ["cotton", "casual"],
    stock: 60,
    supplier: { name: "UrbanWear", country: "Germany" }
  },
  {
    name: "Running Shorts",
    category: "Bottoms",
    price: 29.99,
    sizes: ["S", "M"],
    tags: ["sport", "lightweight"],
    stock: 90,
    supplier: { name: "ActivePro", country: "Vietnam" },
    seasonal: true
  },
  {
    name: "Formal Shirt",
    category: "Tops",
    price: 35.00,
    sizes: ["M", "L", "XL"],
    tags: ["formal", "business"],
    stock: 70,
    supplier: { name: "BusinessAttire", country: "India" }
  },
  {
    name: "Sweatpants",
    category: "Bottoms",
    price: 34.99,
    sizes: ["M", "L"],
    tags: ["cotton", "casual"],
    stock: 50,
    supplier: { name: "CozyClothes", country: "Bulgaria" },
    reviews: [
      { user: "Ivan", rating: 4 },
      { user: "Maria", rating: 5 }
    ]
  },
  {
    name: "Windbreaker",
    category: "Outerwear",
    price: 69.99,
    sizes: ["S", "M", "L"],
    tags: ["windproof", "lightweight"],
    stock: 30,
    supplier: { name: "OutFitters", country: "Poland" }
  },
  {
    name: "Evening Gown",
    category: "Dresses",
    price: 199.99,
    sizes: ["M", "L"],
    tags: ["formal", "luxury"],
    stock: 10,
    supplier: { name: "Glamour", country: "France" },
    limitedEdition: true
  }
]);

db.customers.insertMany([
  { name: "Ivan Petrov", email: "ivan@example.com", address: { city: "Sofia", street: "Vitosha 10" }, phone: "0888123456", preferences: ["casual", "cotton"] },
  { name: "Maria Georgieva", email: "maria@example.com", address: { city: "Plovdiv", street: "Kapana 5" }, loyaltyPoints: 120 },
  { name: "Georgi Nikolov", email: "georgi@example.com", phone: "0899111222", wishlist: ["Leather Jacket"] },
  { name: "Elena Dimitrova", email: "elena@example.com", address: { city: "Varna", street: "Slivnitsa 22" }, subscribed: true },
  { name: "Todor Ivanov", email: "todor@example.com", preferences: ["formal"] },
  { name: "Krasimira Koleva", email: "krasi@example.com", address: { city: "Burgas", street: "Aleksandrovska 3" }, phone: "0877666555" },
  { name: "Nikolay Stoyanov", email: "niko@example.com", birthday: "1991-06-15" },
  { name: "Raya Petrova", email: "raya@example.com", address: { city: "Sofia", street: "Dondukov 14" }, reviews: [{ product: "Blue Jeans", stars: 5 }] },
  { name: "Boris Vasilev", email: "boris@example.com", interests: ["sportswear", "summer"] },
  { name: "Silvia Staneva", email: "silvia@example.com", phone: "0888999888", loyaltyPoints: 90 }
]);

db.orders.insertMany([
  { customerId: 1, products: ["Basic T-Shirt", "Blue Jeans"], total: 69.98, status: "delivered", payment: { method: "card", date: "2024-06-01" } },
  { customerId: 2, products: ["Summer Dress"], total: 39.99, status: "pending" },
  { customerId: 3, products: ["Hoodie", "Running Shorts"], total: 89.98, status: "shipped" },
  { customerId: 4, products: ["Evening Gown"], total: 199.99, status: "cancelled", reason: "Out of stock" },
  { customerId: 5, products: ["Sweatpants"], total: 34.99, status: "delivered" },
  { customerId: 6, products: ["Formal Shirt", "Blue Jeans"], total: 84.99, status: "pending" },
  { customerId: 7, products: ["Windbreaker"], total: 69.99, status: "processing" },
  { customerId: 8, products: ["Leather Jacket"], total: 149.99, status: "delivered" },
  { customerId: 9, products: ["Basic T-Shirt", "Sweatpants"], total: 54.98, status: "processing" },
  { customerId: 10, products: ["Running Shorts"], total: 29.99, status: "shipped" }
]);

db.employees.insertMany([
  { name: "Desislava Ivanova", role: "Cashier", salary: 1200, schedule: { start: "08:00", end: "16:00" }, fullTime: true },
  { name: "Petar Marinov", role: "Manager", salary: 2400, fullTime: true },
  { name: "Alexandra Hristova", role: "Sales Assistant", salary: 1000, schedule: { start: "12:00", end: "20:00" }, departments: ["Tops", "Dresses"] },
  { name: "Georgi Todorov", role: "Stock Clerk", partTime: true },
  { name: "Viktoria Petrova", role: "Cashier", salary: 1100 },
  { name: "Hristo Iliev", role: "Security", salary: 1400, shift: "night" },
  { name: "Milena Stefanova", role: "Sales Assistant", salary: 1050 },
  { name: "Radostina Koleva", role: "HR", salary: 1800 },
  { name: "Ivo Zhelev", role: "IT Support", salary: 2200 },
  { name: "Tanya Mihaylova", role: "Logistics", salary: 1600 }
]);

db.categories.insertMany([
  { name: "Tops", description: "Shirts, blouses and tops", popular: true },
  { name: "Bottoms", description: "Jeans, shorts, sweatpants" },
  { name: "Outerwear", description: "Jackets, coats, hoodies", featured: true },
  { name: "Dresses", description: "Casual and formal dresses" },
  { name: "Accessories", description: "Belts, scarves, hats", popular: false },
  { name: "Shoes", description: "Sneakers, heels, boots" },
  { name: "Underwear", description: "Lingerie and socks" },
  { name: "Formal", description: "Workwear and suits" },
  { name: "Sportswear", description: "Clothing for sport and gym", seasonal: true },
  { name: "Children", description: "Clothes for kids of all ages" }
]);
