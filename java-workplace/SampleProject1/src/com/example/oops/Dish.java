package com.example.oops;

public class Dish {
	    String name;
	    int price;
	    int quantity;

	    static int numberOfDishes = 0;
	    static int totalQuantity = 0;

	    public Dish() {
	        this("Salad", 100, 1);
	    }

	    public Dish(String name, int price, int quantity) {
	        this.name = name;
	        this.price = price;
	        this.quantity = quantity;
	        numberOfDishes++;
	        totalQuantity += quantity;
	    }

	    public void showDish() {
	        System.out.println("Dish details: " + name + " " + price + " " + quantity);
	    }

	    public void incrementQuantity() {
	        quantity++;
	        totalQuantity++;
	    }

	    public void decrementQuantity() {
	        if (quantity > 0) {
	            quantity--;
	            totalQuantity--;
	        }
	    }

	    public static void showNumberOfDishes() {
	        System.out.println("Dishes are " + numberOfDishes + ", totalQuantity " + totalQuantity);
	    }
}
