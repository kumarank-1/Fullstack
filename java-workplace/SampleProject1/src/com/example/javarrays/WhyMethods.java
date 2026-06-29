package com.example.javarrays;

public class WhyMethods {

    // Non-static method
    int getMax(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (max < array[i]) {
                max = array[i];
            }
        }
        return max;
    }

    // Static method
    static int getMaxFromArray(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (max < array[i]) {
                max = array[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] productPrices = {1200, 800, 3300, 2400, 1500};
        int[] cricketerScores = {44, 90, 12, 67, 35};
        int[] covidCases = {431232, 817773, 125001, 444331, 220019};

        WhyMethods ref = new WhyMethods();

        // Non-static calls
        System.out.println("Maximum in product prices is " + ref.getMax(productPrices));
        System.out.println("Maximum in cricketer scores is " + ref.getMax(cricketerScores));
        System.out.println("Maximum in covid cases is " + ref.getMax(covidCases));

        // Static calls
        System.out.println("\nUsing static method:");
        System.out.println("Maximum in product prices is " + WhyMethods.getMaxFromArray(productPrices));
        System.out.println("Maximum in cricketer scores is " + WhyMethods.getMaxFromArray(cricketerScores));
        System.out.println("Maximum in covid cases is " + WhyMethods.getMaxFromArray(covidCases));
    }
}