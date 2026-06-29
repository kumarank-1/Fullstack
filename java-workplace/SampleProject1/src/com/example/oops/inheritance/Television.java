package com.example.oops.inheritance;

import java.util.Arrays;

public class Television extends Product {
    int screenSize;
    String[] colors;
    String ledTechnology;

    public Television(int id, String name, String description, int price, String brand, int screenSize, String[] colors, String ledTechnology) {
        super(id, name, description, price, brand);
        this.screenSize = screenSize;
        this.colors = colors;
        this.ledTechnology = ledTechnology;
    }

    void showTelevision() {
        showProduct();
        System.out.println("Screen Size: " + screenSize);
        System.out.println("Colors: " + Arrays.toString(colors));
        System.out.println("LED Technology: " + ledTechnology);
        System.out.println();
    }
}