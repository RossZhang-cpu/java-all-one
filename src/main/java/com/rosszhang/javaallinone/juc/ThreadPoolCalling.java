package com.rosszhang.javaallinone.juc;

import org.springframework.web.client.RestTemplate;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadPoolCalling {
    private static RestTemplate restTemplate = new RestTemplate();

    public static void main(String[] args) {
        int nThreads = 20;
        ThreadPoolExecutor executorService = (ThreadPoolExecutor) Executors.newFixedThreadPool(nThreads);
        for (int i = 0; i < nThreads; ++i) {
            executorService.submit(ThreadPoolCalling::restCall);
        }
    }

    public static void restCall() {
        String forObject = restTemplate.getForObject("http://localhost:9550/user?userId=qz712310", String.class);
        System.out.println(forObject);
    }
}
