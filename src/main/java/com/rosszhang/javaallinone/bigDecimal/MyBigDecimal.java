package com.rosszhang.javaallinone.bigDecimal;

import java.math.BigDecimal;

public class MyBigDecimal {

    public static void main(String[] args) {
        BigDecimal bigDecimal = new BigDecimal("0.0000007");
        System.out.println(bigDecimal);
        System.out.println(bigDecimal.toPlainString());


        bigDecimal = new BigDecimal(0.0000007);
        System.out.println(bigDecimal);
        System.out.println(bigDecimal.toPlainString());



    }
}
