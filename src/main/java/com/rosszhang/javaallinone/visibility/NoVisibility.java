package com.rosszhang.javaallinone.visibility;

public class NoVisibility {
    private static boolean ready;
    private static int number;


    private static class ReaderThread extends Thread {
        public void run() {
            while (!ready) {
                Thread.yield();
            }
            System.out.println(number);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new ReaderThread().start();
        number = 42;
        ready = true;
    }
}
