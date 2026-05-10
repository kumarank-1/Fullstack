console.log("\n===== Lesson 6 Demo 1: Sorting =====");

let products = [
  { name: "Laptop", price: 70000 },
  { name: "Mouse", price: 700 },
  { name: "Keyboard", price: 1500 },
  { name: "Phone", price: 30000 }
];

function printArray(arr, title) {
  console.log(title);
  for (let p of arr) {
    console.log(p.name + " - " + p.price);
  }
}

printArray(products, "Before sorting:");

function sortOnPrice(a, b) {
  return a.price - b.price; // ascending
}

products.sort(sortOnPrice);
printArray(products, "After sorting by price:");
