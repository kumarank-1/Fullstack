let eqX = 10;
let eqY = 10;

console.log("\nEquality Demo:");
console.log("eqX:", eqX, "eqY:", eqY);

// Double equals (value comparison)
console.log("eqX == eqY : " + (eqX == eqY));

// Triple equals (value + type comparison)
console.log("eqX === eqY : " + (eqX === eqY));

// Extra example to clearly show difference
let strTen = "10";
console.log("eqX == '10' : " + (eqX == strTen));   // true (type coercion)
console.log("eqX === '10' : " + (eqX === strTen)); // false (different types)
