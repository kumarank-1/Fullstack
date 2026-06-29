package com.example.oops.inheritance;

public class Child extends Parent {
    String fname;
    int wealth;
    String companyName;

    public Child() {
        this.fname = "Fionna";
        this.wealth = 50000;
        this.companyName = "ABC Ventures";
        System.out.println("Child object constructed with default constructor");
    }

    @Override
    void showDetails() {
        System.out.println("[Child] Details are: " + fname + " " + lname + " " + wealth + " " + companyName);
        super.showDetails();
    }
}
