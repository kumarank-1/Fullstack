console.log("\n===== Lesson 4 Demo 3: Value vs Reference =====");

// Value type example
let johnAge = 10;
let friendAge = johnAge;
console.log("Before change -> johnAge:", johnAge, "friendAge:", friendAge);

johnAge = 12;
console.log("After change -> johnAge:", johnAge, "friendAge:", friendAge);

// Reference type example
let ages = [20, 25, 30];
let groupAges = ages;

groupAges[0] = 22;
groupAges[2] = 45;

console.log("ages:", ages);
console.log("groupAges:", groupAges);