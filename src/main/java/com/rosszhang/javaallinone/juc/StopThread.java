package com.rosszhang.javaallinone.juc;

public class StopThread  extends Thread{
    @Override
    public void run() {
        while (true) {
            if (this.isInterrupted()) {
                System.out.println("停止了!");
                return;
            }
            System.out.println("timer=" + System.currentTimeMillis());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        StopThread t=new StopThread();
        t.start();
        Thread.sleep(2000);
        t.interrupt();
    }

}
