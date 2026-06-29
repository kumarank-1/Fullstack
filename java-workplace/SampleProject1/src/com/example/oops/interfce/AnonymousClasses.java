package com.example.oops.interfce;

interface PaymentCallbacks {
    void onSuccess(String message);
    void onFailure(String message);
}

public class AnonymousClasses {
    public static void main(String[] args) {
        PaymentCallbacks callbacks = new PaymentCallbacks() {
            @Override
            public void onSuccess(String message) {
                System.out.println("Payment passed: " + message);
            }

            @Override
            public void onFailure(String message) {
                System.out.println("Payment failed: " + message);
            }
        };

        callbacks.onSuccess("Amount paid: 20000");
        callbacks.onFailure("Amount not paid: 20000");
    }
}
