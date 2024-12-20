package com.rosszhang.javaallinone.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Pool {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        for(int i = 0 ; i < 6; ++i){
            executor.submit(new Task(String.valueOf(i)));
        }
        System.out.println("Thread starting...");
    }
}

class Task implements Runnable{

    private final String name;

    Task(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("start task " + name);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(" end task " + name);
    }
}