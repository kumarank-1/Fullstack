package com.example.exception;

public class CustomException {
    public static void main(String[] args) throws InvalidPhoneNumberException {
        System.out.println("Customer management app started");

        String phone = "";
        String email = "";

        if (phone.isEmpty()) {
            throw new InvalidPhoneNumberException("Phone number cannot be empty");
        }

        if (email.isEmpty()) {
            throw new InvalidEmailException("Email cannot be empty");
        }

        System.out.println("Customer management app finished");
    }
}
