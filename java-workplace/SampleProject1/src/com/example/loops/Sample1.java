package com.example.loops;

public class Sample1 {
	public static void main(String[] args) {
        System.out.println("=== for loop ===");
        for (int i = 1; i <= 5; i++) {
            System.out.println("i = " + i);
        }

        System.out.println("\n=== while loop ===");
        int j = 1;
        while (j <= 5) {
            System.out.println("j = " + j);
            j++;
        }

        System.out.println("\n=== do-while loop ===");
        int k = 1;
        do {
            System.out.println("k = " + k);
            k++;
        } while (k <= 5);

        System.out.println("\n=== Enhanced for loop ===");
        int[] nums = {10, 20, 30, 40, 50};
        for (int num : nums) {
            System.out.println("num = " + num);
        }
    }
}
