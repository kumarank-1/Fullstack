package com.example.oops.interfce;

import java.util.Date;

interface State {
    String getStateName();
    void updateDateTimeStamp(Date d);
    Date getDateTimeStamp();
}

class Placed implements State {
    private Date dateTimeStamp;
    public String getStateName() { return "PLACED"; }
    public void updateDateTimeStamp(Date d) { this.dateTimeStamp = d; }
    public Date getDateTimeStamp() { return dateTimeStamp; }
}

class Shipped implements State {
    private Date dateTimeStamp;
    public String getStateName() { return "SHIPPED"; }
    public void updateDateTimeStamp(Date d) { this.dateTimeStamp = d; }
    public Date getDateTimeStamp() { return dateTimeStamp; }
}

class Delivered implements State {
    private Date dateTimeStamp;
    public String getStateName() { return "DELIVERED"; }
    public void updateDateTimeStamp(Date d) { this.dateTimeStamp = d; }
    public Date getDateTimeStamp() { return dateTimeStamp; }
}

class Order {
    private State state;

    public Order() {
        state = new Placed();
        state.updateDateTimeStamp(new Date());
    }

    void updateState(State newState) {
        this.state = newState;
    }

    State getState() {
        return state;
    }
}

public class StateDesignPattern {
    public static void main(String[] args) {
        Order order = new Order();
        System.out.println(order.getState().getStateName());
        System.out.println(order.getState().getDateTimeStamp());

        try { Thread.sleep(3000); } catch (InterruptedException e) { e.printStackTrace(); }

        State shipped = new Shipped();
        shipped.updateDateTimeStamp(new Date());
        order.updateState(shipped);

        System.out.println(order.getState().getStateName());
        System.out.println(order.getState().getDateTimeStamp());
    }
}
