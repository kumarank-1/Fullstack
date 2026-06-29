package com.example.oops.interfce;

import java.util.Date;

interface Plan {
    String getPlanName();
    int getPlanPrice();

    default void purchase(int amount) {
        if (amount == getPlanPrice()) {
            System.out.println("Plan purchased successfully for amount: " + amount);
            onPurchase("Plan activated from " + new Date());
        } else {
            System.out.println("Plan purchase failed. Amount mismatched");
        }
    }

    void onPurchase(String message);
}

class Plan3G implements Plan {
    public String getPlanName() { return "Unlimited plan3G"; }
    public int getPlanPrice() { return 250; }
    public void onPurchase(String message) { System.out.println("[MESSAGE] " + message); }
}

class Plan4G implements Plan {
    public String getPlanName() { return "Truly Unlimited plan4G"; }
    public int getPlanPrice() { return 470; }
    public void onPurchase(String message) { System.out.println("[MESSAGE] " + message); }
}

class Plan5G implements Plan {
    public String getPlanName() { return "NoLimits plan5G"; }
    public int getPlanPrice() { return 800; }
    public void onPurchase(String message) { System.out.println("[MESSAGE] " + message); }
}

class PlanFactory {
    public static Plan getPlan(int typeOfPlan) {
        if (typeOfPlan == 3) return new Plan3G();
        if (typeOfPlan == 4) return new Plan4G();
        if (typeOfPlan == 5) return new Plan5G();
        return null;
    }
}

public class FactoryDesignPattern {
    public static void main(String[] args) {
        Plan plan = PlanFactory.getPlan(3);
        if (plan != null) plan.purchase(250);
        else System.out.println("Invalid type of plan");
    }
}