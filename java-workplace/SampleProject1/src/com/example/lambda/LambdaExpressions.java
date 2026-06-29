package com.example.lambda;

import java.util.ArrayList;

@FunctionalInterface
interface Register {
    void validate();
}

@FunctionalInterface
interface Login {
    void login(String email, String password);
}

@FunctionalInterface
interface PromoCode {
    double getDiscount(double amount, String promoCode);
}

public class LambdaExpressions {
    public static void main(String[] args) {
        Register register = () -> System.out.println("User registered");
        register.validate();

        Login login = (email, password) -> {
            if (email.equalsIgnoreCase("admin@example.com") && password.equals("pass123")) {
                System.out.println("Login successful");
            } else {
                System.out.println("Login failed");
            }
        };

        login.login("admin@example.com", "pass123");
        login.login("john@example.com", "john123");

        PromoCode discountRef = (amount, promoCode) ->
                promoCode.equalsIgnoreCase("jumbo") ? amount - (0.40 * amount) : amount - (0.10 * amount);

        double amountToPay = discountRef.getDiscount(2000, "jumbo");
        System.out.println("Amount to pay: " + amountToPay);

        double amountToPay2 = discountRef.getDiscount(2000, "bingo");
        System.out.println("Amount to pay: " + amountToPay2);

        ArrayList<String> promoCodes = new ArrayList<>();
        promoCodes.add("BINGO");
        promoCodes.add("JUMBO");
        promoCodes.add("HUNGRY50");
        promoCodes.add("THANKS");
        promoCodes.add("NEW100");

        promoCodes.forEach(System.out::println);

        Runnable task = () -> System.out.println("Uploading profile picture...");
        new Thread(task).start();
    }
}
