package com.example.wrapperclass;

import java.util.Iterator;
import java.util.PriorityQueue;

public class QueueDemo {
    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        // Add using reverse loop
        for (int i = 10; i >= 1; i--) {
            queue.add(i);
        }

        System.out.println("Queue in beginning: " + queue);
        System.out.println("Queue Size In the Beginning is: " + queue.size());

        int head = queue.peek();
        System.out.println("Head of Queue is: " + head);

        queue.poll();
        head = queue.peek();
        System.out.println("Head of Queue now is: " + head);

        // Process safely using fixed size variable
        int size = queue.size();
        System.out.println("\nPolling all elements:");
        for (int i = 1; i <= size; i++) {
            System.out.println(queue.poll());
        }

        System.out.println("Queue Size is: " + queue.size());

        // Refill queue
        for (int i = 10; i >= 1; i--) {
            queue.add(i);
        }

        // Iterator (not guaranteed sorted traversal order)
        System.out.println("\nIterating with iterator:");
        Iterator<Integer> itr = queue.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }

        System.out.println("\nQueue is: " + queue);
    }
}
