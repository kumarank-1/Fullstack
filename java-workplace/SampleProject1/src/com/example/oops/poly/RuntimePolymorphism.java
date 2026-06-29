package com.example.oops.poly;

class Cab {
    int baseFare = 50;
    public Cab() { System.out.println("Cab object constructed"); }

    void bookCab(String from, String to) {
        System.out.println("Cab booked from " + from + " to " + to + ". Please pay " + baseFare);
    }
}

class MiniCab extends Cab {
    boolean isStreamingAvailable = true;
    public MiniCab() {
        baseFare += 30;
        System.out.println("MiniCab object constructed");
    }
    @Override
    void bookCab(String from, String to) {
        System.out.println("MiniCab booked from " + from + " to " + to + ". Please pay " + baseFare);
        System.out.println("Streaming available: " + isStreamingAvailable);
    }
}

class SharedCab extends Cab {
    int numberOfPeople = 4;
    public SharedCab() {
        baseFare -= 20;
        System.out.println("SharedCab object constructed");
    }
    @Override
    void bookCab(String from, String to) {
        System.out.println("SharedCab booked from " + from + " to " + to + ". Please pay " + baseFare);
        System.out.println("You will share with " + (numberOfPeople - 1) + " passengers");
    }
}

class LuxuryCab extends Cab {
    int softDrinks = 3;
    int chips = 5;
    public LuxuryCab() {
        baseFare += 50;
        System.out.println("LuxuryCab object constructed");
    }
    @Override
    void bookCab(String from, String to) {
        System.out.println("LuxuryCab booked from " + from + " to " + to + ". Please pay " + baseFare);
        System.out.println("Soft drinks: " + softDrinks + ", chips: " + chips);
    }
}

class CabBookingApp {
    static Cab book(int type) {
        if (type == 1) return new MiniCab();
        else if (type == 2) return new SharedCab();
        else return new LuxuryCab();
    }
}

public class RuntimePolymorphism {
    public static void main(String[] args) {
        Cab cab = CabBookingApp.book(1);
        cab.bookCab("Home", "Work");

        cab = CabBookingApp.book(2);
        cab.bookCab("Home", "Work");

        cab = CabBookingApp.book(3);
        cab.bookCab("Home", "Work");
    }
}
