package com.rosszhang.javaallinone.collection;

import java.util.PriorityQueue;

public class MyPriorityQueue {

    public void iterateQueue() {
        PriorityQueue<Integer > queue = new PriorityQueue<>();
        //add three values
        queue.offer(10);
        queue.offer(3);
        queue.offer(1);
        queue.offer(3);

        queue.forEach(System.out::println);
        System.out.println("peek: " + queue.poll());
        System.out.println("peek: " + queue.poll());
        System.out.println("peek: " + queue.poll());

    }

    public static void main(String[] args) {
        MyPriorityQueue myPriorityQueue = new MyPriorityQueue();
        myPriorityQueue.iterateQueue();
    }
}
