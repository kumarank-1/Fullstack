package com.example.collec;

import java.util.Arrays;
import java.util.List;

public class CollectionsJava11 {
    public static void main(String[] args) {
        String[] emailArray = {"john@example.com", "fionna@example.com", "mike@example.com"};

        List<String> emailsList = Arrays.asList(emailArray);

        String[] myEmails = emailsList.toArray(new String[0]);

        System.out.println("Emails one by one:");
        for (String email : myEmails) {
            System.out.println(email);
        }

        // Heterogeneous array example
        Object[] mixedData = {"John", 101, true, 99.9};
        System.out.println("\nHeterogeneous Object array:");
        for (Object obj : mixedData) {
            System.out.println(obj);
        }
    }
}
