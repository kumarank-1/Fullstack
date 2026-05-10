let isInternetEnabled = true;
let GpsEnabled = true;

console.log("\nLogical Operators Demo:");
console.log(
  "Internet and GPS enabled (AND): " + (isInternetEnabled && GpsEnabled)
);

// eWallet + credit card link condition
let eWallet = 300;
let isCreditCardLinked = true;

// Example condition: payment possible if eWallet > 0 AND card linked
console.log(
  "Payment possible (eWallet > 0 && isCreditCardLinked): " +
    (eWallet > 0 && isCreditCardLinked)
);

// Change values and run condition again
eWallet = 0;
isCreditCardLinked = false;

console.log("After changing values:");
console.log("eWallet:", eWallet);
console.log("isCreditCardLinked:", isCreditCardLinked);
console.log(
  "Payment possible (eWallet > 0 && isCreditCardLinked): " +
    (eWallet > 0 && isCreditCardLinked)
);

// Logical NOT operator
console.log("NOT isCreditCardLinked: " + !isCreditCardLinked);
console.log("NOT isInternetEnabled: " + !isInternetEnabled);

