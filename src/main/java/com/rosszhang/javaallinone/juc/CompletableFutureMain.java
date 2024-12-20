package com.rosszhang.javaallinone.juc;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.*;


public class CompletableFutureMain {

    private static final Logger log = LoggerFactory.getLogger(CompletableFuture.class);

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFutureMain futureMain = new CompletableFutureMain();
//        String simpleCompteableFuture = futureMain.createSimpleCompteableFuture();
//        log.info(simpleCompteableFuture);
//        futureMain.createRunAsyncWithOutReturn();
//        String result = futureMain.createAsyncWithReturn();
        CompletableFuture<String> threadPool1 = futureMain.createAsyncWithReturnInCustomizedThreadPool1();
        log.info("main thread");
        throw new RuntimeException("test Runtime");
        

//        String s = threadPool1.join();
//        log.info(s);

//        String result1 = futureMain.createAsyncWithReturnInCustomizedThreadPool();
//        /* CallBack *********/
//        String result2 = futureMain.createAsyncWithApply();
//        futureMain.createAsyncWithThenRun();
//        futureMain.createAsyncWithAccept();
//        /* ****************/
//        System.out.println(result2);
//
//        /* Asynchronous Callback******/
//        futureMain.createAsyncCallBack();
        /* **********/



    }

    private String createSimpleCompteableFuture() throws ExecutionException, InterruptedException {

        CompletableFuture<String> completableFuture = new CompletableFuture<>();
        completableFuture.complete("hello completable future!");
//        log.info("sub task here");
        return completableFuture.get();
    }

    private void createRunAsyncWithOutReturn() throws ExecutionException, InterruptedException {
        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(() -> {
            try {
                log.info("sub task here");
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Thread thread = Thread.currentThread();
            System.out.printf("Thread name: %s  Thread Id: %s \n", thread.getName(), thread.getId());
            System.out.println("Hello, this is runAsync ");
        });
        completableFuture.get();
    }


    private String createAsyncWithReturn() throws ExecutionException, InterruptedException {
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Thread thread = Thread.currentThread();
            System.out.printf("Thread name: %s  Thread Id: %s \n", thread.getName(), thread.getId());
            System.out.println("Hello, this is supplyAsync ");
            return "supplyAsync";
        });
        return completableFuture.get();
    }

    private String createAsyncWithReturnInCustomizedThreadPool() throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Thread thread = Thread.currentThread();
            System.out.printf("Thread name: %s  Thread Id: %s \n", thread.getName(), thread.getId());
            System.out.println("Hello, this is supplyAsync in a customized thread pool ");
            return "supplyAsync";
        }, executor);
        return completableFuture.get();
    }

    private CompletableFuture<String> createAsyncWithReturnInCustomizedThreadPool1() throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Thread thread = Thread.currentThread();
            System.out.printf("Thread name: %s  Thread Id: %s \n", thread.getName(), thread.getId());
            System.out.println("Hello, this is supplyAsync in a customized thread pool ");
            return "supplyAsync";
        }, executor);
        return completableFuture;
    }

    /**
     * We can use thenApply() method to process and transform the result of a CompletableFuture when it arrives.
     * @throws ExecutionException
     * @throws InterruptedException
     * @return
     */
    private String createAsyncWithApply() throws ExecutionException, InterruptedException {
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Thread thread = Thread.currentThread();
            System.out.printf("Thread name: %s  Thread Id: %s \n", thread.getName(), thread.getId());
            return "this is Async with thenApply";
        }).thenApply(s -> "Hello " + s);
        return completableFuture.get();
    }

    /**
     * use thenAccept() can simply run some piece of code without return.
     * @throws ExecutionException
     * @throws InterruptedException
     */
    private void createAsyncWithAccept() throws ExecutionException, InterruptedException {
        CompletableFuture<Void> completableFuture = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Thread thread = Thread.currentThread();
            System.out.printf("Thread name: %s  Thread Id: %s \n", thread.getName(), thread.getId());
            System.out.println("Hello, this is supplyAsync ");
            return "computed task finished";
        }).thenAccept((item) -> System.out.println("Accept result: " + item));
        completableFuture.get();
    }

    /**
     * similar with thenAccept(), thenRun() method is also used as callback function which does not return anything.
     * However thenRun doesn't even have no access to Future’s result
     * @throws ExecutionException
     * @throws InterruptedException
     */
    private void createAsyncWithThenRun() throws ExecutionException, InterruptedException {
        String info;
        CompletableFuture<Void> completableFuture = CompletableFuture.supplyAsync(() -> {
            try {
   
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                handle(e);
            }
            Thread thread = Thread.currentThread();
            System.out.printf("Thread name: %s  Thread Id: %s \n", thread.getName(), thread.getId());
            System.out.println("Hello, this is supplyAsync ");
            return "computed task finished";
        }).thenRun(() -> System.out.println("This is thenRun method" ));
        completableFuture.get();
    }

    private void handle(InterruptedException e) {
        e.printStackTrace();
    }


    private void createAsyncCallBack() throws ExecutionException, InterruptedException {
        ExecutorService executors = Executors.newFixedThreadPool(3);
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Thread thread = Thread.currentThread();
                    System.out.printf("Thread name: %s  Thread Id: %s \n", thread.getName(), thread.getId());
                    return "asynchronous callback";
                }, executors).thenApplyAsync(name -> {
                    Thread thread = Thread.currentThread();
                    System.out.printf("Thread name: %s  Thread Id: %s \n", thread.getName(), thread.getId());
                    return "My name is " + name;
                }, executors).thenApplyAsync(item -> {
                    Thread thread = Thread.currentThread();
                    System.out.printf("Thread name: %s  Thread Id: %s \n", thread.getName(), thread.getId());
                    return "Hello " + item;}, executors);
        System.out.println(completableFuture.get());

    }

    //join method returning without checked exception

}
