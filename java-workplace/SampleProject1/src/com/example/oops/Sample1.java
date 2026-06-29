package com.example.oops;
import java.util.Date;

public class Sample1 {
	    public static void main(String[] args) {
	        User user1 = new User();
	        User user2 = new User();
	        User user3 = user1; // reference copy

	        System.out.println("User1 is: " + user1);
	        System.out.println("User2 is: " + user2);
	        System.out.println("User3 is: " + user3);
	        System.out.println();

	        // Write/update data
	        user1.name = "John";
	        user3.name = "John Watson"; // impacts user1 object
	        user3.phone = "+91-9999999999";
	        user3.email = "john.watson@example.com";
	        user1.gender = 'M';
	        user1.birthDate = new Date();
	        user1.password = "john@123";

	        user2.setUserData("Fionna", "+91-8888888888", "fionna@example.com", 'F', new Date(), "fionna@123");

	        User user4 = new User();
	        User user5 = new User("Leo", "+91-7777777777", "leo@example.com", 'M', new Date(), "leo@123");

	        user1.showUserData();
	        user2.showUserData();
	        user3.showUserData();
	        user4.showUserData();
	        user5.showUserData();

	        Product p1 = new Product();
	        Product p2 = new Product("Apple Watch Series", 4.7, "Smart watch with health tracking", 499.99);
	        Product p3 = new Product();
	        p3.setProductData("UltraBoost Shoe", 5.0, "Adidas comfortable ultra-boost shoes, 21", 200.0);

	        p1.showProductData();
	        p2.showProductData();
	        p3.showProductData();
	    }
}
