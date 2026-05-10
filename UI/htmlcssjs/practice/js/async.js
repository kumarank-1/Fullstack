let uploadFileSync = () => "File Uploaded Successfully";
let updateUserProfileSync = () => {
  let result = uploadFileSync();
  console.log("Result is: " + result);
};
updateUserProfileSync();

// Async function returning Promise
let uploadFile = async () => "File Uploaded Successfully";

let resultPromise = uploadFile();
resultPromise.then((value) => console.log("Value is: " + value));

// Async + await
let updateUserProfile = async () => {
  let result = await uploadFile();
  console.log("Result is: " + result);
};
updateUserProfile();

// Custom Promise
let isDataFetched = true;
let myPromise = new Promise(function (resolve, reject) {
  // Algo goes here
  if (isDataFetched) {
    resolve();
  } else {
    reject();
  }
});

myPromise
  .then(() => console.log("Data Fetched Successfully"))
  .catch(() => console.log("Data Fetched Operation Failed"));

// Change to false and test again
isDataFetched = false;
myPromise = new Promise(function (resolve, reject) {
  if (isDataFetched) {
    resolve();
  } else {
    reject();
  }
});

myPromise
  .then(() => console.log("Data Fetched Successfully"))
  .catch(() => console.log("Data Fetched Operation Failed"));