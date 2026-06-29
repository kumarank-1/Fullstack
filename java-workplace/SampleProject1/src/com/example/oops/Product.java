package com.example.oops;

public class Product {
    String name;
    double ratings;
    String description;
    double price;

    public Product() {
    }

    public Product(String name, double ratings, String description, double price) {
        this.name = name;
        this.ratings = ratings;
        this.description = description;
        this.price = price;
    }

    public void setProductData(String name, double ratings, String description, double price) {
        this.name = name;
        this.ratings = ratings;
        this.description = description;
        this.price = price;
    }

    public void showProductData() {
        System.out.println("Product " + name + " has ratings " + ratings);
        System.out.println("Product " + name + " is priced at $" + price);
        System.out.println("Product " + name + " description is " + description);
        System.out.println();
    }
}
