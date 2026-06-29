package com.example.oops.inheritance;

public class Product {
    int id;
    String name;
    String description;
    int price;
    String brand;

    public Product() {}

    public Product(int id, String name, String description, int price, String brand) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.brand = brand;
    }

    void showProduct() {
        System.out.println(id + " | " + name + " | " + description + " | " + price + " | " + brand);
    }
}
