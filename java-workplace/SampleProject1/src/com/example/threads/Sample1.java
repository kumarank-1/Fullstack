package com.example.threads;

class PrintingTask implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println("Book pages for learning python.pdf - Page number: " + i);
            try { Thread.sleep(1000); } 
            catch (InterruptedException e) { e.printStackTrace(); }
        }
    }
}

public class Sample1 {
    public static void main(String[] args) {
        System.out.println("Main thread started");

        Runnable taskRef = new PrintingTask();
        Thread th = new Thread(taskRef);
        th.setPriority(Thread.MAX_PRIORITY);
        th.setDaemon(false);
        System.out.println("State of TH is " + th.getState());

        th.start();

        for (int i = 1; i <= 10; i++) {
            System.out.println("Book pages for learning java.pdf - Page number: " + i);
            try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }
        }

        System.out.println("TH name: " + th.getName() + ", priority: " + th.getPriority());
        System.out.println("Main name: " + Thread.currentThread().getName() + ", priority: " + Thread.currentThread().getPriority());
        System.out.println("State of TH is " + th.getState());

        System.out.println("Main thread finished");
    }
}
