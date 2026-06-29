package com.example.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LambdaLocalVarJava11 {
    public static void main(String[] args) {
        List<String> emails = Arrays.asList(
                "john@example.com",
                "fionna@example.com",
                "mike@example.com"
        );

        System.out.println("Emails: " + emails);

        String csvData = emails.stream().collect(Collectors.joining(", "));
        System.out.println("CSV Data: " + csvData);

        var text = "hello";
        System.out.println("var text: " + text);

        emails.forEach((var email) -> System.out.println("Email: " + email));
    }
}
