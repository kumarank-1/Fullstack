package com.example.oops.inheritance;

import java.util.Arrays;

public class Shoe extends Product {
    int[] sizes;
    String[] colors;

    public Shoe(int id, String name, String description, int price, String brand, int[] sizes, String[] colors) {
        super(id, name, description, price, brand);
        this.sizes = sizes;
        this.colors = colors;
    }

    void showShoe() {
        showProduct();
        System.out.println("Sizes: " + Arrays.toString(sizes));
        System.out.println("Colors: " + Arrays.toString(colors));
        System.out.println();
    }
}