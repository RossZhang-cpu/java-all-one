package com.rosszhang.javaallinone.juc.lock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;

public class MyPhaser {

    private static final Logger log = LoggerFactory.getLogger(MyPhaser.class);


    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        Phaser phaser = new Phaser(3);
        for (int i = 0; i < 2; ++i) {
            executor.submit(new Task(phaser));
            executor.submit(new Task(phaser));
            executor.submit(new Task(phaser));
            int p = phaser.awaitAdvance(phaser.getPhase());
            log.info("phase is {}", p);
        }


        executor.close();
    }

    public static class Task implements Runnable {

        public Task(Phaser phaser) {
            this.phaser = phaser;
        }

        private Phaser phaser;

        @Override
        public void run() {
            //do something
            log.info("Thread {} arrived", Thread.currentThread().getName());
            phaser.arrive();
        }
    }
}
