package com.rosszhang.javaallinone.virtualthread;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.info.GraphLayout;

import java.util.concurrent.ThreadFactory;

public class MyVirtualThread {

    public static void main(String[] args) throws InterruptedException {
//        System.out.println("begin");
//        Thread.sleep(10 * 1000);
        ThreadFactory factory = Thread.ofVirtual().name("test-", 0).factory();
        Thread thread = factory.newThread(() -> {
            System.out.println("hello! this is virtual thread.");
        });
        Thread threadv1 = factory.newThread(() -> {
            System.out.println("hello! this is virtual thread.");
        });
//            try {
//                Thread.sleep(10 * 1000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        });
//        start.join();
//        MyVirtualThread virtualThread = new MyVirtualThread();
//        Thread.sleep(5 * 1000);
//        virtualThread.create1000VirtualThread();
//        Thread.sleep(10 * 1000);

        Thread thread1 = new Thread(() -> {
            System.out.println("hello! this is virtual thread.");
        });
        Thread thread2 = new Thread(() -> {
            System.out.println("hello! this is virtual thread.");
        });
        Thread thread3 = new Thread(() -> {
            System.out.println("hello! this is virtual thread.");
        });
        Thread thread4 = new Thread(() -> {
            System.out.println("hello! this is virtual thread.");
        });
//        System.out.println(GraphLayout.parseInstance(thread).add(GraphLayout.parseInstance(threadv1)).totalSize());
        System.out.println(GraphLayout.parseInstance(threadv1, thread).totalSize());
//        System.out.println(GraphLayout.parseInstance(threadv1, thread).toFootprint());
        System.out.println(GraphLayout.parseInstance(thread1, thread2, thread3, thread4).totalSize());
//        System.out.println(GraphLayout.parseInstance(thread1, thread2).toFootprint());

//        System.out.println(GraphLayout.parseInstance('1', '2').totalSize());
        System.out.println(GraphLayout.parseInstance('1', '2', '1', '1').totalSize());
    }

    public void create1000VirtualThread() throws InterruptedException {
        ThreadFactory factory = Thread.ofVirtual().name("test-", 0).factory();
        for (int i = 0; i < 100000; ++i) {
            Thread thread = factory.newThread(() -> {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
            System.out.println("i is  " + i);
//            thread.start();
//            thread.join();
        }
    }
}
