package com.example.oops.interfce;

interface GooglePay {
    default void payFromGoogle(int amount) {
        System.out.println("[GooglePay] Amount paid: " + amount);
        onSuccess(101, "Transaction success");
    }

    void onSuccess(int code, String message);
    void onFailure(int code, String message);
}

interface ApplePay {
    default void payFromApple(int amount) {
        System.out.println("[ApplePay] Amount paid: " + amount);
        onSuccess(201, "Transaction success");
    }

    void onSuccess(int code, String message);
    void onFailure(int code, String message);
}

interface Payments extends GooglePay, ApplePay {
}

class FoodDeliveryAppPayments implements Payments {
    @Override
    public void onSuccess(int code, String message) {
        System.out.println("[FDA] Payment received. Code: " + code + ", Message: " + message);
    }

    @Override
    public void onFailure(int code, String message) {
        System.out.println("[FDA] Payment failed. Code: " + code + ", Message: " + message);
    }
}

public class AbstractionWithInterfaces {
    public static void main(String[] args) {
        Payments ref = new FoodDeliveryAppPayments();
        ref.payFromGoogle(3000);
        ref.payFromApple(5000);
        ref.onFailure(33120, "Bank interface down");
    }
}
