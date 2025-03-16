package com.rosszhang.javaallinone.juc;

import java.util.concurrent.*;

public class TestCallable implements Callable<Boolean> {
    @Override
    public Boolean call() throws Exception {
        System.out.println("Thread Id :" + Thread.currentThread().threadId());
        return true;
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        TestCallable callable = new TestCallable();


        ExecutorService es = Executors.newFixedThreadPool(5);
        Future<Boolean> r1 = es.submit(callable);
        boolean rs1 = r1.get();

        FutureTask<Boolean> task = new FutureTask<>(callable);
        Thread thread = new Thread(task);
        thread.start();
        Boolean b = task.get();
        System.out.println("main thread get result: " + b);

        es.shutdown();
    }
}
