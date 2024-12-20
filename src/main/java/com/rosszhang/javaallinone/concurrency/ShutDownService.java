package com.rosszhang.javaallinone.concurrency;

public class ShutDownService {


    private String state;

    public synchronized void shutDown() {
        if ("shuttingDown".equals(state)) {
            return;
        }
        state = "shuttingDown";
//        waitAndShutDown();

    }

    public String getState() {
        return state;
    }


}
