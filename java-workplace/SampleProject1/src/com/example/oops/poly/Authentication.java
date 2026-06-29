package com.example.oops.poly;

public class Authentication {
    void login(String email, String password) {
        System.out.println("Logging in user with email and password");
    }

    void login(String phone, int otp) {
        System.out.println("Logging in user with phone and otp");
    }
}
