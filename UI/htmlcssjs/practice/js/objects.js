console.log("===== Lesson 4 Demo 1: Objects =====");

let user = {
  email: "john@example.com",
  phone: "9876543210",
  address: {
    city: "Bengaluru",
    state: "Karnataka",
    pincode: "560001"
  }
};

console.log("User object:", user);
console.log("Type of user:", typeof user);

// Add orders array with nested objects
user.orders = [
  { orderId: 101, amount: 1200, date: "2026-05-05" },
  { orderId: 102, amount: 2300, date: "2026-05-06" }
];

console.log("User with orders:", user);
console.log("First order:", user.orders[0]);
console.log("First order amount:", user.orders[0].amount);

// Product object with inventory
let product = {
  productId: 200,
  name: "Running Shoes",
  brand: "Nike",
  price: 4999,
  inventory: [
    { size: 7, units: 10 },
    { size: 8, units: 5 },
    { size: 9, units: 2 }
  ]
};

console.log("Product:", product);

// Update units at inventory zeroth index
product.inventory[0].units = 7;
console.log("Updated product inventory[0]:", product.inventory[0]);

// New product object
let newProduct = {
  productId: 201,
  name: "T-Shirt",
  brand: "Puma",
  price: 1499
};

console.log("New product:", newProduct);

