package com.example.oops.interfce.app;

public class App {
    public static void main(String[] args) {
        One oRef = new One();
        oRef.defShow();
        oRef.protShow();
        oRef.pubShow();

        Two tRef = new Two();
        tRef.defShow();
        tRef.protShow();
        tRef.pubShow();
    }
}
