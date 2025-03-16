package com.rosszhang.javaallinone.juc.lock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;


public class MyCountDownLatch {

    private static final Logger log = LoggerFactory.getLogger(MyCountDownLatch.class);

    public static void main(String[] args) throws InterruptedException {
        List<String> list = new ArrayList<>(Arrays.asList("present1", "present2", "present3"));

        CountDownLatch countDownLatch = new CountDownLatch(list.size());
        Random random = new Random();

        Thread thread1 = new Thread(() -> {
            pickPresent(random, list, countDownLatch);
        });

        Thread thread2 = new Thread(() -> {
            pickPresent(random, list, countDownLatch);
        });

        Thread thread3 = new Thread(() -> {
            pickPresent(random, list, countDownLatch);
        });

        thread1.start();
        thread2.start();
        thread3.start();
        countDownLatch.await();
    }

    private static synchronized void pickPresent(Random random, List<String> list, CountDownLatch countDownLatch) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        int i = random.nextInt(list.size());
        log.info("index is {}", i);
        String remove = list.remove(i);
        log.info("Current Thread {} present: {}", Thread.currentThread().getName(), remove);
        countDownLatch.countDown();
    }
}
