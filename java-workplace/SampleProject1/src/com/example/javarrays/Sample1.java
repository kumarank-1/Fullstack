package com.example.javarrays;

public class Sample1 {
	public static void main(String[] args) {
        // Primitive single-value containers
        int confirmed = 431;
        int recovered = 380;
        int deceased = 12;
        int vaccinated = 220;

        // 1D array storing similar category data in one container
        int[] covidCases = {431, 380, 12, 220}; 
        
        // Different ways to create arrays
        int[] array1 = {10, 20, 30, 40};
        int array2 = 999;               // normal int (not an array)
        int[] a3, a4;                   // both arrays
        a3 = new int[]{1, 2, 3};
        a4 = new int[]{4, 5, 6};

        // Explicit syntax with new
        int[] array3 = new int[]{100, 200, 300};
        int[] array4 = {111, 222, 333}; // implicit syntax

        // Arrays with fixed size (default values = 0)
        int[] array5 = new int[5];
        int[] array6 = new int[10];
        array5[0] = 10;
        array5[1] = 20;

        System.out.println("confirmed is: " + confirmed);
        System.out.println("covidCases array reference: " + covidCases);

        // Reference copy
        int[] data = covidCases;
        data[1] = 66412; // updates same underlying array
        System.out.println("covidCases[1] after reference update: " + covidCases[1]);

        // Basic for-loop iteration
        System.out.println("\nIterating covidCases using basic for loop:");
        for (int i = 0; i < covidCases.length; i++) {
            System.out.println("covidCases[" + i + "] = " + covidCases[i]);
        }

        // Enhanced for-loop iteration
        System.out.println("\nIterating array5 using enhanced for loop:");
        for (int element : array5) {
            System.out.print(element + " ");
        }
        System.out.println();

        System.out.println("\nOther variables:");
        System.out.println("recovered = " + recovered + ", deceased = " + deceased + ", vaccinated = " + vaccinated);
        System.out.println("array2 (normal int) = " + array2);
    }
}
