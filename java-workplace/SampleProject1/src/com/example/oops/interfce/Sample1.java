package com.example.oops.interfce;

interface PayTMPaymentGateway {
    void payWithPayTM(double amount);
}

interface Razorpay {
    void payWithRazorpay(double amount);
}

interface PayPal {
    void payWithPayPal(double amount);
}

interface Notification {
    void notifyMessage(String text);
}

interface ElectricityBillPayment {
    int BILL_ACCOUNT_NUMBER = 154213012; // public static final by default
    void billGenerated();
    void payBillNotification();
}

interface INF extends Notification, ElectricityBillPayment {
}

interface MyINF {
    default void hello() {
        System.out.println("Hello of MyINF");
    }

    static void show() {
        System.out.println("This is show of MyINF");
    }

    void bye();
}

class MyPaymentPage implements PayTMPaymentGateway, Razorpay, PayPal {
    @Override
    public void payWithPayTM(double amount) {
        System.out.println("[PayTM] Paid: " + amount);
    }

    @Override
    public void payWithRazorpay(double amount) {
        System.out.println("[Razorpay] Paid: " + amount);
    }

    @Override
    public void payWithPayPal(double amount) {
        System.out.println("[PayPal] Paid: " + amount);
    }
}

class User implements Notification, ElectricityBillPayment, INF {
    String name;

    User(String name) {
        this.name = name;
    }

    @Override
    public void notifyMessage(String text) {
        System.out.println("[" + name + "] Notification: " + text);
    }

    @Override
    public void billGenerated() {
        System.out.println("[" + name + "] Bill generated. Please pay your bill on time.");
    }

    @Override
    public void payBillNotification() {
        System.out.println("[" + name + "] Thank you for paying your bill.");
    }
}

class ElectricityApp {
    private ElectricityBillPayment payment;

    void subscribeForBill(ElectricityBillPayment payment) {
        this.payment = payment;
    }

    void broadcastBills() {
        payment.billGenerated();
        payment.payBillNotification();
    }
}

class CA implements MyINF {
    @Override
    public void bye() {
        System.out.println("This is bye from CA");
    }
}

public class Sample1 {
    public static void main(String[] args) {
        MyPaymentPage page = new MyPaymentPage();
        page.payWithPayTM(500);
        page.payWithRazorpay(300);
        page.payWithPayPal(700);

        User john = new User("John");
        ElectricityApp app = new ElectricityApp();
        app.subscribeForBill(john);
        app.broadcastBills();

        System.out.println("Bill Account Number: " + ElectricityBillPayment.BILL_ACCOUNT_NUMBER);

        MyINF ref = new CA();
        ref.hello();
        ref.bye();
        MyINF.show();
    }
}