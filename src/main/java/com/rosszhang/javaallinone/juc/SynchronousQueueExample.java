package com.rosszhang.javaallinone.juc;

import java.util.concurrent.*;

public class SynchronousQueueExample {
    public static void main(String[] args) {
        SynchronousQueue<Integer> queue = new SynchronousQueue<>();

        // Producer thread
        new Thread(() -> {
            try {
                System.out.println("Producing 1...");
                queue.put(1); // Blocks until consumed
//                Thread.sleep(10);
                System.out.println("Produced 1");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        // Producer thread
        new Thread(() -> {
            try {
                System.out.println("Producing 2...");
                queue.put(1); // Blocks until consumed
//                Thread.sleep(10);
                System.out.println("Produced 2");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        // Consumer thread
        new Thread(() -> {
            try {
                Thread.sleep(2000); // Simulate delay
                System.out.println("Consuming...");
                int item = queue.take(); // Blocks until produced
                System.out.println("Consumed: " + item);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}

