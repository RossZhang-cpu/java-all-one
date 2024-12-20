package com.rosszhang.javaallinone.juc;

public class MyThreadLocal {

    private static final ThreadLocal<String> intl = new ThreadLocal<>();


    public static void main(String[] args) throws InterruptedException {
         intl.set(Thread.currentThread().getName());
        System.out.println(Thread.currentThread().getName());

        Runnable runnable = new Runnable() {

            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
                String s = intl.get();
                System.out.println(s);
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();

        Thread.sleep(10000);
    }
}
