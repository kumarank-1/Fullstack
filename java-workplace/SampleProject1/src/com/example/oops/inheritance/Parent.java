package com.example.oops.inheritance;

public class Parent {
    String fname;
    String lname;
    int wealth;

    public Parent() {
        this.fname = "John";
        this.lname = "Watson";
        this.wealth = 100000;
        System.out.println("Parent object constructed with default constructor");
    }

    void showDetails() {
        System.out.println("[Parent] Details are: " + fname + " " + lname + " " + wealth);
    }
}
