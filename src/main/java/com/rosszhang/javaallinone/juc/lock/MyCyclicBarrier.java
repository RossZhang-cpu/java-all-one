package com.rosszhang.javaallinone.juc.lock;

import java.util.concurrent.CyclicBarrier;

import java.util.concurrent.BrokenBarrierException;

public class MyCyclicBarrier {

    public static void main(String[] args) {
        int numberOfPlayers = 3;
        int numberOfRounds = 2; // Run the game for 2 rounds

        CyclicBarrier barrier = new CyclicBarrier(numberOfPlayers, () -> System.out.println("All players ready for next round!"));

        for (int i = 0; i < numberOfPlayers; i++) {
            final int playerId = i;
            new Thread(() -> {
                try {
                    for (int round = 1; round <= numberOfRounds; round++) {
                        System.out.println("Player " + playerId + " is performing action in round " + round + "...");
                        Thread.sleep((long) (Math.random() * 1000)); // Simulate player action
                        System.out.println("Player " + playerId + " is ready for round " + round + ".");
                        barrier.await(); // Wait for all players

                        // After barrier is tripped, continue to next round
                        System.out.println("Player " + playerId + " starting round " + round + " action!");
                    }
                    System.out.println("Player " + playerId + " finished all rounds.");
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
