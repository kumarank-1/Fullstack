function getCashBack(luckyNumber) {
  let cashbacks = [10, 20, 30, 40, 50];

  if (luckyNumber === 13) {
    let err = new Error("Unlucky number! Cashback cannot be processed.");
    throw err;
  }

  return cashbacks[luckyNumber % cashbacks.length];
}

try {
  let cashBackEarned = getCashBack(8);
  console.log("Cashback earned:", cashBackEarned);

  // Change to 13 to test exception
  cashBackEarned = getCashBack(13);
  console.log("Cashback earned:", cashBackEarned);
} catch (error) {
  console.log("Error caught:", error.message);
}

console.log("Cashback app finished");