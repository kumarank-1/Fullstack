package com.example.exception;

import java.util.Scanner;

public class ExceptionHandling {
    public static void main(String[] args) {
        int[] cashbacks = {100, 50, 80, 40, 20, 10, 60, 70, 90};
        Scanner scanner = new Scanner(System.in);

        System.out.println("Cash backs app started");
        int luckyNumber = -1;
        int cashback = 0;

        try {
            System.out.print("Enter your lucky number: ");
            luckyNumber = scanner.nextInt();
            cashback = cashbacks[luckyNumber];
        } catch (Exception e) {
            System.out.println("Exception occurred: " + e);
            System.out.println("Message: " + e.getMessage());
            e.printStackTrace();
        } finally {
            System.out.println("This is an important instruction.");
            scanner.close();
        }

        System.out.println("Thank you for participation, you earned a cashback of $" + cashback);
        System.out.println("Cash backs app finished");
    }
}
