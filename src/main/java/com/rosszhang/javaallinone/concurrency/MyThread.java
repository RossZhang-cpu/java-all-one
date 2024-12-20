package com.rosszhang.javaallinone.concurrency;


import java.util.ArrayList;
import java.util.List;

public class MyThread extends Thread {

        private int count = 5;

        @Override
        public synchronized  void run() {
            super.run();
            count--;
            System.out.println("由 " + MyThread.currentThread().getName() + " 计算，count=" + count);
        }

    public static void main(String[] args) {
        List[] ll = new List[2];
        ArrayList<String> strings = new ArrayList<>();
        strings.add("ss");
        ll[0] = strings;
        strings = new ArrayList<>();
        strings.add("ppsdsds");
        ll[1] = strings;

        for(List l : ll){
            System.out.println(l.toString());
        }
    }

}


