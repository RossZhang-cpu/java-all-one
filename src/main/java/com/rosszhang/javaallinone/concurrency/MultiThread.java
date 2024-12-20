package com.rosszhang.javaallinone.concurrency;

public class MultiThread {

    public static void main(String[] args) throws InterruptedException {
//        Thread thread01 = new Thread(new addThread());
//        Thread thread02 = new Thread(new decThread());
//        thread01.start();
//        thread02.start();
//        thread01.join();
//        thread02.join();
//        System.out.println(Counter.count);
//        String p = ">343";
//        String[] split = p.split(">");
//        for(String s : split){
//            System.out.println(s);
//        }
//        String ts = "1-2";
//        if("-".matches(ts))
//            System.out.println(1);

//        Calendar nowTime = Calendar.getInstance();
//
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd 23:59:59");
//        Date date = null;
//        try {
//            date = sdf.parse("2021-01-26 17:14:00");
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        nowTime.setTime(date);
//        System.out.println(nowTime.toString());

        String str = null;
        if(str == null)
            System.out.println("dfd");
        else System.out.println("sdf");
    }
}

class Counter{
    public static final Object lock = new Object();
    public static  int count = 0;
}

class addThread implements Runnable{

    @Override
    public void run() {
        synchronized (Counter.lock) {
            for (int i = 0; i < 1000; ++i) {
                ++Counter.count;
            }
        }
    }
}

class decThread implements Runnable {

    @Override
    public void run() {
        synchronized (Counter.lock) {
            for (int i = 0; i < 100; ++i) {
                --Counter.count;
            }
        }
    }
}