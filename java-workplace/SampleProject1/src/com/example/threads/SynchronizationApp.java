package com.example.threads;

class Printer {
    private String status = "available";

    synchronized void printDocument(String docName, int copies) {
        status = "busy";
        System.out.println("Printer status: " + status);

        for (int i = 1; i <= copies; i++) {
            System.out.println("Printing " + docName + " copy #" + i);
            try { Thread.sleep(500); } catch (InterruptedException e) { e.printStackTrace(); }
        }

        status = "available";
        System.out.println("Printer status: " + status + "\n");
    }

    void showPrinterStatus() {
        System.out.println("Printer status: " + status);
    }
}

class Laptop extends Thread {
    private Printer pRef;
    void attachPrinter(Printer printer) { this.pRef = printer; }

    @Override
    public void run() {
        pRef.printDocument("John_Resume.pdf", 10);
    }
}

class Desktop extends Thread {
    private Printer pRef;
    void attachPrinter(Printer printer) { this.pRef = printer; }

    @Override
    public void run() {
        pRef.printDocument("Harry_Resume.pdf", 10);
    }
}

public class SynchronizationApp {
    public static void main(String[] args) {
        Printer printer = new Printer();
        printer.showPrinterStatus();

        Laptop laptop = new Laptop();
        Desktop desktop = new Desktop();

        laptop.attachPrinter(printer);
        desktop.attachPrinter(printer);

        laptop.start();
        desktop.start();
    }
}
