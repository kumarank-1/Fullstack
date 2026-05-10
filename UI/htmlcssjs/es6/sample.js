// const addition = (a,b) => a+b
// console.log(addition(4,7))




// const welcome = () =>{
//    var msg = "hello"
//    console.log(msg)
// }
// welcome()
// console.log(msg)




// const welcome = () =>{
//    var msg = "hello"
//    console.log(msg)
// }
// welcome()






// function welcome() {
//   let msg = 'Hello';
//   let greet = 'World';

//   if (msg === 'Hello') {
//     console.log(`${msg} ${greet}`);
//   }

//   console.log(`${msg} ${greet}`);
// }

// welcome();

// function sum(x=10,y=20) {
//   return x+y
// }



// console.log(sum());
// console.log(sum(10,10));
// console.log(sum(1));

// function getnumbers(...nums){
//     console.log(nums)
// }
// getnumbers(10,20,30)


// const user = {
//     email:'alex@gmail.com',
//     password:"alex123"

// }

// let myemail = user.email;
// let pass = user.password;
// console.log(myemail+ ' ' + pass);

// console.log("=================")

// let{email, password} = user;
// console.log(email)
// console.log(password)

// const pi =3.14
// // pi = 3.5
// console.log(pi)


// const numbers = [1,2,3,4,5]
// const [n1,n2,n3,n4,n5] = numbers

// console.log(n1)
// console.log(n5)



// let x = 10
// let y = 20

// [x, y] = [y, x];
// console.log(x)
// console.log(y)


// function greet() {
//     console.log("hello greet");
// }
// function world(){
//     console.log("hello world");
    
// }

// setTimeout(greet,3000);
// world()

// function greet(name, callback) {
//     console.log("hello greet");
//     callback(name); // This calls the 'world' function
// }
// function world(name){
//     console.log('hello ' + name);
    
// }

// setTimeout(greet,3000,'jhon',world);


// const isOdd = (number) => number % 2 !== 0;

// const filter = (numbers, callback) => {
//   const results = [];
  
//   for (const number of numbers) {
//     if (callback(number)) {
//       results.push(number);
//     }
//   }
  
//   return results;
// };

// const numbers = [1, 2, 4, 7, 3, 5, 6];

// console.log(filter(numbers, isOdd)); 


// Experiment 1: Basic callback with setTimeout
// function greet(name, callback) {
//   setTimeout(() => {
//     console.log(`Hello, ${name}`);
//     callback();
//   }, 1000);
// }
// greet("John", () => console.log("Greeting completed"));


// // Experiment 2: Callback with success/failure (error-first style)
// function uploadFile(fileName, callback) {
//   setTimeout(() => {
//     if (!fileName) return callback("File name missing", null);
//     callback(null, `Uploaded: ${fileName}`);
//   }, 1200);
// }
// uploadFile("report.pdf", (err, result) => {
//   if (err) return console.log("Error:", err);
//   console.log(result);
// });


// // Experiment 3: Sequential callbacks (callback chaining)
// function step1(cb) {
//   setTimeout(() => {
//     console.log("Step 1 done");
//     cb();
//   }, 500);
// }
// function step2(cb) {
//   setTimeout(() => {
//     console.log("Step 2 done");
//     cb();
//   }, 500);
// }
// function step3(cb) {
//   setTimeout(() => {
//     console.log("Step 3 done");
//     cb();
//   }, 500);
// }
// step1(() => step2(() => step3(() => console.log("All steps completed"))));


// // Experiment 4: Custom delay utility callback
// function wait(ms, callback) {
//   setTimeout(() => {
//     callback(`Waited ${ms}ms`);
//   }, ms);
// }
// wait(1500, (message) => console.log(message));


// // Experiment 5: Loop with timeout + callback per item
// function processItems(items, callback) {
//   let i = 0;
//   function next() {
//     if (i >= items.length) return callback("All items processed");
//     setTimeout(() => {
//       console.log("Processed:", items[i]);
//       i++;
//       next();
//     }, 400);
//   }
//   next();
// }
// processItems(["A", "B", "C"], (msg) => console.log(msg));

// function getUsers(){
//     return new Promise((resolve,reject)=>{
//         setTimeout(()=>{
//             resolve([
//                 {username : 'jhon',email : 'jhon@gmail.com'},
//                 {username : 'jhoni',email : 'jhoni@gmail.com'},

//             ])
//         },1000)
//     })
// }

// const promise =getUsers();
// promise.then((users)=>{
//     console.log(users);
// })

// Example 3: Nested callbacks (users -> emails)

function getUsers(callback) {
  setTimeout(() => {
    callback([
      { username: "jhon", email: "jhon@gmail.com" },
      { username: "jhoni", email: "jhoni@gmail.com" }
    ]);
  }, 1000);
}

function getEmails(users, callback) {
  setTimeout(() => {
    const emails = users.map((user) => user.email);
    callback(emails);
  }, 800);
}

getUsers((users) => {
  console.log("Example 3 Users:", users);

  getEmails(users, (emails) => {
    console.log("Example 3 Emails:", emails);
  });
});