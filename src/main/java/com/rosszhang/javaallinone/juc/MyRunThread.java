package com.rosszhang.javaallinone.juc;

public class MyRunThread implements Runnable {
    @Override
    public void run() {
        System.out.println("this is son thread");
    }

    public static void main(String[] args) {
        MyRunThread thread = new MyRunThread();
        new Thread(thread).start();  //静态代理
        System.out.println("main");
    }
}
