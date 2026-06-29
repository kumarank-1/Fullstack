package com.example.wrapperclass;

import java.util.ArrayList;
import java.util.Scanner;

public class Arraylist {
    public static void main(String[] args) {
        // Create an ArrayList of Strings
        ArrayList<String> fruits = new ArrayList<>();

        // Adding elements to the ArrayList
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Mango");
        fruits.add("Orange");

        System.out.println("Initial List: " + fruits);

        // Accessing elements
        System.out.println("First fruit: " + fruits.get(0));

        // Updating an element
        fruits.set(1, "Blueberry"); // Replace Banana with Blueberry
        System.out.println("After update: " + fruits);

        // Removing an element by index
        fruits.remove(2); // Removes Mango
        System.out.println("After removing index 2: " + fruits);

        // Removing an element by value
        fruits.remove("Apple");
        System.out.println("After removing 'Apple': " + fruits);

        // Iterating using for-each loop
        System.out.println("Fruits list:");
        for (String fruit : fruits) {
            System.out.println("- " + fruit);
        }

        // Checking if an element exists
        if (fruits.contains("Orange")) {
            System.out.println("Orange is in the list.");
        } else {
            System.out.println("Orange is not in the list.");
        }

        // Getting the size of the ArrayList
        System.out.println("Total fruits: " + fruits.size());

        // Example: Taking user input and adding to ArrayList
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a fruit to add: ");
        String newFruit = scanner.nextLine().trim();

        if (!newFruit.isEmpty()) {
            fruits.add(newFruit);
            System.out.println("Updated List: " + fruits);
        } else {
            System.out.println("No fruit added.");
        }

        scanner.close();
    }
}
