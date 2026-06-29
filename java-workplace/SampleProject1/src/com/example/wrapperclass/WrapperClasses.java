package com.example.wrapperclass;

public class WrapperClasses {
    public static void main(String[] args) {
        // Primitive variables
        int iVar = 100;
        double dVar = 2.2;
        char cVar = 'A';

        System.out.println("Primitive values:");
        System.out.println(iVar);
        System.out.println(dVar);
        System.out.println(cVar);

        // Boxing using valueOf
        Integer iRef = Integer.valueOf(iVar);
        Double dRef = Double.valueOf(dVar);
        Character cRef = Character.valueOf(cVar);

        // Unboxing using explicit methods
        int i1 = iRef.intValue();
        double d1 = dRef.doubleValue();
        char c1 = cRef.charValue();

        System.out.println("\nExtracted using value methods:");
        System.out.println(i1);
        System.out.println(d1);
        System.out.println(c1);

        // Auto-unboxing
        int i2 = iRef;
        double d2 = dRef;
        char c2 = cRef;

        System.out.println("\nAuto-unboxed values:");
        System.out.println(i2);
        System.out.println(d2);
        System.out.println(c2);
    }
}
