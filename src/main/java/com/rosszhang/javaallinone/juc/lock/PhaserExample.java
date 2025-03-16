package com.rosszhang.javaallinone.juc.lock;

import java.util.concurrent.Phaser;

public class PhaserExample {

    public static void main(String[] args) {
        Phaser phaser = new Phaser(1); // Register main thread

        createAndStart("Thread 1", phaser);
        createAndStart("Thread 2", phaser);
        createAndStart("Thread 3", phaser);

        phaser.arriveAndAwaitAdvance(); // Wait for phase 1 to complete
        System.out.println("Phase 1 completed.");

        phaser.arriveAndAwaitAdvance(); // Wait for phase 2 to complete
        System.out.println("Phase 2 completed.");

        phaser.arriveAndDeregister(); // Deregister main thread
        System.out.println("Main thread finished.");
    }

    static void createAndStart(String name, Phaser phaser) {
        phaser.register(); // Register thread
        new Thread(() -> {
            System.out.println(name + " starting phase 1.");
            phaser.arriveAndAwaitAdvance(); // Wait for phase 1

            System.out.println(name + " starting phase 2.");
            phaser.arriveAndAwaitAdvance(); // Wait for phase 2

            System.out.println(name + " finished.");
            phaser.arriveAndDeregister(); // Deregister thread
        }).start();
    }
}