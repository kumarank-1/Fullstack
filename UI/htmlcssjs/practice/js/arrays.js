let menu = {
  dosa: 80,
  idli: 40,
  poori: 60,
  coffee: 30
};

let cart = [];

console.log("Cart[" + cart.length + "] Details:", cart);

// (Prompt-based input is usually interactive; using sample data here)
let sampleChoices = ["dosa", "coffee", "idli", "quit"];

for (let choice of sampleChoices) {
  if (choice === "quit") break;

  let dish = {
    name: choice,
    price: menu[choice]
  };
  cart.push(dish);
}

console.log("Final Cart[" + cart.length + "] Details:", cart);

// Iterate cart
for (let item of cart) {
  console.log(item.name + " " + item.price);
}
