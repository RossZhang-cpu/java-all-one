package com.rosszhang.javaallinone.concurrency;

import java.util.concurrent.*;

public class TestCallable implements Callable {
    @Override
    public Boolean call() throws Exception {
        System.out.println("this is son thread");
        return true;
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        TestCallable callable = new TestCallable();

        /**
        ExecutorService es = Executors.newFixedThreadPool(5);
        Future<Boolean> r1 = es.submit(callable);
        boolean rs1 = r1.get();

        es.shutdown();
         **/

        FutureTask task = new FutureTask(callable);
        Thread thread = new Thread(task);
        thread.start();
        System.out.println("main");


    }
}
