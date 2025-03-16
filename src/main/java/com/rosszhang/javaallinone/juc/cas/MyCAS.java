package com.rosszhang.javaallinone.juc.cas;

import sun.misc.Unsafe;

public class MyCAS {

    public void CAS() {
        Unsafe unsafe = Unsafe.getUnsafe();
        int s = 0;
        boolean b = unsafe.compareAndSwapInt(s, 0L, 0, 1);
        System.out.println(b);
    }

    public static void main(String[] args) {
        MyCAS myCAS = new MyCAS();
        myCAS.CAS();
    }

}
