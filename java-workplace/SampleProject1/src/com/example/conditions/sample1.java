package com.example.conditions;

public class sample1 {
	public static void main(String[] args) {
        int number = 15;

        if (number > 0) {
            System.out.println(number + " is Positive");
        } else if (number < 0) {
            System.out.println(number + " is Negative");
        } else {
            System.out.println("Number is Zero");
        }

        // Additional if-else example
        int age = 18;
        if (age >= 18) {
            System.out.println("Eligible to vote");
        } else {
            System.out.println("Not eligible to vote");
        }
    }
}
