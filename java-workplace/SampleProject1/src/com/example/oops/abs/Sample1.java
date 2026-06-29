package com.example.oops.abs;

abstract class Cab {
    public Cab() {
        System.out.println("Cab object constructed");
    }

    abstract void bookCab(String source, String destination);

    void show() {
        System.out.println("This is show of Cabs");
    }
}

class MiniCab extends Cab {
    public MiniCab() {
        System.out.println("MiniCab object constructed");
    }

    @Override
    void bookCab(String source, String destination) {
        System.out.println("MiniCab booked from " + source + " to " + destination);
    }
}

abstract class Notification {
    abstract void notifyUser(String message);
}

class User extends Notification {
    @Override
    void notifyUser(String message) {
        System.out.println("Message is: " + message);
    }
}

class YouTubeChannel {
    Notification notification;

    void subscribe(Notification nf) {
        this.notification = nf;
    }

    void uploadVideo(String videoName) {
        String message = "A new video uploaded: " + videoName;
        notification.notifyUser(message);
    }
}

public class Sample1 {
    public static void main(String[] args) {
        Cab cab = new MiniCab();
        cab.bookCab("Home", "Work");
        cab.show();

        YouTubeChannel channel = new YouTubeChannel();
        User john = new User();
        channel.subscribe(john);
        channel.uploadVideo("Learning Java");
    }
}
