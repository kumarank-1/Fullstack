console.log("\n===== Lesson 4 Demo 2: Strings =====");

let names = "Julia, Mia, Liam, Aria";
console.log("names: " + names + " data type: " + typeof names);
console.log("names.length: " + names.length);

console.log("Names in Uppercase: " + names.toUpperCase());

let result = names.toUpperCase();
console.log("Result is: " + result);

result = names.replace("J", "K");
console.log("Result is: " + result);

// Contact search
let contacts = ["Julia", "Mia", "Liam", "Aria", "Kiara"];
let searchKeyword = "ia";
console.log("Search results for keyword:", searchKeyword);
for (let contact of contacts) {
  if (contact.toLowerCase().includes(searchKeyword.toLowerCase())) {
    console.log(contact);
  }
}

result = names.substring(0, 7);
console.log("Substring (0,7):", result);

let splittedNames = names.split(",");
console.log("Splitted names:", splittedNames);

for (let n of splittedNames) {
  console.log("Trimmed name:", n.trim());
}

