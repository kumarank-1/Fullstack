package com.example.wrapperclass;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class SetVsListDemo {
    public static void main(String[] args) {
        // List allows duplicates + maintains insertion order
        ArrayList<String> listEmails = new ArrayList<>();
        listEmails.add("john@example.com");
        listEmails.add("jennie@example.com");
        listEmails.add("leo@example.com");
        listEmails.add("mike@example.com");
        listEmails.add("jennie@example.com");

        System.out.println("ArrayList emails are: " + listEmails);

        // HashSet removes duplicates, no insertion order guarantee
        HashSet<String> hashSetEmails = new HashSet<>();
        hashSetEmails.add("john@example.com");
        hashSetEmails.add("jennie@example.com");
        hashSetEmails.add("leo@example.com");
        hashSetEmails.add("mike@example.com");
        hashSetEmails.add("jennie@example.com");

        System.out.println("\nHashSet emails are: " + hashSetEmails);

        // Iterator over HashSet
        System.out.println("Iterating HashSet:");
        Iterator<String> itr = hashSetEmails.iterator();
        while (itr.hasNext()) {
            String email = itr.next();
            System.out.println(email);
        }

        // clear
        hashSetEmails.clear();
        System.out.println("HashSet after clear: " + hashSetEmails);

        // LinkedHashSet: unique + insertion order maintained
        LinkedHashSet<String> linkedSetEmails = new LinkedHashSet<>();
        linkedSetEmails.add("john@example.com");
        linkedSetEmails.add("jennie@example.com");
        linkedSetEmails.add("leo@example.com");
        linkedSetEmails.add("mike@example.com");
        linkedSetEmails.add("jennie@example.com");

        System.out.println("\nLinkedHashSet emails are: " + linkedSetEmails);

        // TreeSet: unique + sorted order
        TreeSet<String> treeSetEmails = new TreeSet<>();
        treeSetEmails.addAll(linkedSetEmails);
        System.out.println("TreeSet emails (sorted): " + treeSetEmails);
    }
}
