package com.example.javarrays;

public class Sample2 {
	public static void main(String[] args) {
        int[] state1 = {431, 380, 12, 220};
        int[] state2 = {510, 450, 20, 300};
        int[] state3 = {220, 180, 8, 140};

        System.out.println("state1 ref: " + state1 + ", length: " + state1.length);
        System.out.println("state2 ref: " + state2 + ", length: " + state2.length);
        System.out.println("state3 ref: " + state3 + ", length: " + state3.length);

        // 2D array (array of arrays)
        int[][] covidCases = {state1, state2, state3};

        System.out.println("\n2D array ref: " + covidCases + ", length: " + covidCases.length);

        System.out.println("\nIterating with basic nested for loop:");
        for (int i = 0; i < covidCases.length; i++) {
            for (int j = 0; j < covidCases[i].length; j++) {
                System.out.print(covidCases[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("\nIterating with enhanced for loop:");
        for (int[] row : covidCases) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}
