package com.example.javarrays;

import java.util.Scanner;

public class Sample3 {
	static final int TOTAL_CASES = 0;
    static final int TOTAL_RECOVERED = 1;
    static final int ACTIVE_CASES = 2;

    public static void printCases(int[][] covidCases, String[] countryNames, int filterIndex, String header) {
        System.out.println("\n--- " + header + " ---");
        for (int i = 0; i < covidCases.length; i++) {
            System.out.println(countryNames[i] + "\t" + covidCases[i][filterIndex]);
        }
    }

    public static void main(String[] args) {
        String[] countryNames = {"USA", "India", "Brazil", "UK", "France"};

        // [totalCases, totalRecovered, activeCases]
        int[][] covidCases = {
            {111000000, 108000000, 250000}, // USA
            {45000000, 44400000, 300000},   // India
            {38000000, 37000000, 500000},   // Brazil
            {25000000, 24600000, 120000},   // UK
            {40000000, 39500000, 180000}    // France
        };

        System.out.println("Country\tTotalCases\tTotalRecovered\tActiveCases");
        System.out.println("----------------------------------------------------");
        for (int i = 0; i < covidCases.length; i++) {
            System.out.print(countryNames[i] + "\t");
            for (int j = 0; j < covidCases[i].length; j++) {
                System.out.print(covidCases[i][j] + "\t\t");
            }
            System.out.println();
        }

        Scanner scanner = new Scanner(System.in);

        System.out.println("\nFilter Covid Cases:");
        System.out.println("1. By Country Name");
        System.out.println("2. Total Cases for all countries");
        System.out.println("3. Total Recovered for all countries");
        System.out.println("4. Active Cases for all countries");
        System.out.print("Enter your choice: ");

        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline

        switch (choice) {
            case 1:
                System.out.print("Enter country name: ");
                String name = scanner.nextLine();

                int index = -1;
                for (int i = 0; i < countryNames.length; i++) {
                    if (name.equalsIgnoreCase(countryNames[i])) {
                        index = i;
                        break;
                    }
                }

                if (index == -1) {
                    System.out.println("Sorry, Country not found");
                } else {
                    System.out.println("Index is: " + index);
                    System.out.println("Data for " + countryNames[index] + ":");
                    System.out.println("Total Cases: " + covidCases[index][TOTAL_CASES]);
                    System.out.println("Total Recovered: " + covidCases[index][TOTAL_RECOVERED]);
                    System.out.println("Active Cases: " + covidCases[index][ACTIVE_CASES]);
                }
                break;

            case 2:
                printCases(covidCases, countryNames, TOTAL_CASES, "Total Cases");
                break;

            case 3:
                printCases(covidCases, countryNames, TOTAL_RECOVERED, "Total Recovered");
                break;

            case 4:
                printCases(covidCases, countryNames, ACTIVE_CASES, "Active Cases");
                break;

            default:
                System.out.println("Invalid choice");
        }

        scanner.close();
    }
}
