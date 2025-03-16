package com.rosszhang.javaallinone.juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Reentrantlock {

    public void main(String[] args) throws InterruptedException {
        Thread thread01 = new Thread(new addThread01());
        Thread thread02 = new Thread(new decThread01());
        thread01.start();
        thread02.start();
        thread01.join();
        thread02.join();
        System.out.println(Counter.count);

    }
}

class Counter01{
    public static final Lock lock = new ReentrantLock();
    public static  int count = 0;
}

class addThread01 implements Runnable{

    @Override
    public void run() {
        Counter01.lock.lock();
        for (int i = 0; i < 1000; ++i) {
            ++Counter01.count;

        }
        Counter01.lock.unlock();
    }
}

class decThread01 implements Runnable{

    @Override
    public void run() {
        Counter01.lock.lock();
        for (int i = 0; i < 100; ++i) {
            --Counter01.count;
        }
        Counter01.lock.unlock();
    }
}