package com.example.oops.inheritance;

public class MobilePhone extends Product {
    int ram;
    int storage;
    String os;

    public MobilePhone(int id, String name, String description, int price, String brand, int ram, int storage, String os) {
        super(id, name, description, price, brand);
        this.ram = ram;
        this.storage = storage;
        this.os = os;
    }

    void showMobilePhone() {
        showProduct();
        System.out.println("RAM: " + ram + "GB, Storage: " + storage + "GB, OS: " + os);
        System.out.println();
    }
}
