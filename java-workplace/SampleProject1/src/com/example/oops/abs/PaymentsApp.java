package com.example.oops.abs;

abstract class PayTmPaymentGateway {
    private boolean isBankInterfaceUp = true;

    public PayTmPaymentGateway() {
        System.out.println("[PayTM] PayTmPaymentGateway object constructed");
    }

    void setBankInterfaceUp(boolean status) {
        this.isBankInterfaceUp = status;
    }

    public void pay(int amount) {
        if (isBankInterfaceUp) {
            System.out.println("[PayTM] Payment Successfully Done for Amount: " + amount);
            onSuccess("101: Payment Success");
        } else {
            System.out.println("[PayTM] Payment failed. Please try again later");
            onFailure("201: Payment Failed");
        }
    }

    abstract void onSuccess(String message);
    abstract void onFailure(String message);
}

class EStorePayment extends PayTmPaymentGateway {
    public EStorePayment() {
        System.out.println("[EStore] EStorePayment object constructed");
    }

    @Override
    void onSuccess(String message) {
        System.out.println("[EStore] Received: " + message);
        System.out.println("Thank you for placing an order. It shall be dispatched soon.\n");
    }

    @Override
    void onFailure(String message) {
        System.out.println("[EStore] Received: " + message);
        System.out.println("Something went wrong. Please try again later.\n");
    }
}

public class PaymentsApp {
    public static void main(String[] args) {
        EStorePayment payment = new EStorePayment();

        payment.setBankInterfaceUp(true);
        payment.pay(3000);

        payment.setBankInterfaceUp(false);
        payment.pay(3000);
    }
}
