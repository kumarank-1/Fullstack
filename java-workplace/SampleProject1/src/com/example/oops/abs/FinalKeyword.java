package com.example.oops.abs;

class PaymentGateway {
    final void pay(int amount) {
        System.out.println("Payment Gateway Transaction successful for: " + amount);
    }
}

class MyGateway extends PaymentGateway {
    // Cannot override final method pay(int)
    // void pay(int amount) {}
}

final class LockedClass {
    void show() {
        System.out.println("This class cannot be inherited");
    }
}

public class FinalKeyword {
    public static void main(String[] args) {
        int age = 25;
        age = 26;

        final int score = 90;
        // score = 95; // not allowed

        final int distance;
        distance = 312;
        // distance = 400; // not allowed

        PaymentGateway gateway = new MyGateway();
        gateway.pay(1000);

        LockedClass lc = new LockedClass();
        lc.show();

        System.out.println("Age: " + age + ", Score: " + score + ", Distance: " + distance);
    }
}
