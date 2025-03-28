package com.rosszhang.javaallinone.juc;


import java.util.Hashtable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class Foo {

    private AtomicInteger firstJobDone = new AtomicInteger(0);
    private AtomicInteger secondJobDone = new AtomicInteger(0);

    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        firstJobDone.incrementAndGet();
    }

    public void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.
        while (firstJobDone.get() != 1){

        }
        printSecond.run();
        secondJobDone.incrementAndGet();

    }

    public void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.
        while (secondJobDone.get() != 1){

        }
        printThird.run();
    }

    public static void main(String[] args) {
        ConcurrentHashMap<Object, Object> hashMap = new ConcurrentHashMap<>();
        hashMap.put(null, null);

    }
}
