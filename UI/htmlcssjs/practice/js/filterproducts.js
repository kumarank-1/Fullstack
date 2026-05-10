function filterByPrice(product, minPrice) {
  return product.price >= minPrice;
}

let filteredProducts = products.filter((p) => filterByPrice(p, 7000));
console.log("Filtered products (price >= 7000):", filteredProducts);



