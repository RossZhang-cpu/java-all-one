package com.rosszhang.javaallinone.juc.lock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CountDownLatch;

public class StartTogether {
    private static final Logger log = LoggerFactory.getLogger(StartTogether.class);

    public void startTogether() {

        CountDownLatch startLatch = new CountDownLatch(3);
        CountDownLatch finishLatch = new CountDownLatch(3);

        Thread myTask1 = new Thread(new MyTask(startLatch, finishLatch));
        Thread myTask2 = new Thread(new MyTask(startLatch, finishLatch));
        Thread myTask3 = new Thread(new MyTask(startLatch, finishLatch));

        myTask1.start();
        myTask2.start();
        myTask3.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public class MyTask implements Runnable {

        private CountDownLatch latch;
        private CountDownLatch finishLatch;

        public MyTask(CountDownLatch latch, CountDownLatch finishLatch) {
            this.latch = latch;
            this.finishLatch = finishLatch;
        }

        @Override
        public void run() {
            latch.countDown();
            try {
                log.info("{} waiting for others", Thread.currentThread().threadId());
                latch.await();
                Thread.sleep(1);
                finishLatch.countDown();
                log.info("{} waiting other to finish", Thread.currentThread().threadId());
                finishLatch.await();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            log.info("{} exit", Thread.currentThread().threadId());

        }
    }


    public static void main(String[] args) {
        StartTogether together = new StartTogether();
        together.startTogether();
    }
}
