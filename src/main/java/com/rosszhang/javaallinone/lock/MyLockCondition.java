package com.rosszhang.javaallinone.lock;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MyLockCondition {


    public static void main(String[] args) throws InterruptedException {
        ReentrantLock lock = new ReentrantLock();
        ReentrantLock lock1 = new ReentrantLock();
        Condition condition = lock.newCondition();
        Thread t1 = new Thread(() -> {
            try {
                lock.lock();
//                lock1.lock();
                System.out.println(Thread.currentThread().getName() + " waiting");
                condition.await();
                System.out.println(Thread.currentThread().getName() + " wait over");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }finally {
//                lock1.unlock();
                lock.unlock();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                Thread.sleep(300);
                System.out.println((Thread.currentThread().getName() + " signal"));
                condition.signal();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        t1.start();
        t2.start();
        Thread.sleep(10000);
    }
}
