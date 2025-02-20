package com.rosszhang.javaallinone.math;

import com.rosszhang.javaallinone.myenum.MyEnum;

import java.util.Random;

public class MyRandom {

    public static void main(String[] args) {

        new MyEnum.Test();
        // First sequence
        Random rand1 = new Random(123); // Set seed to 123
        for(int i = 0; i < 5; i++) {
            System.out.print(rand1.nextInt(10) + " ");
        }
        // Output: 6 3 7 1 4

        // Second sequence - same seed
        Random rand2 = new Random(123); // Same seed 123
        for(int i = 0; i < 5; i++) {
            System.out.print(rand2.nextInt(10) + " ");
        }
        // Output: 6 3 7 1 4  (exactly same sequence)

        // Different seed
        Random rand3 = new Random(456); // Different seed
        for(int i = 0; i < 5; i++) {
            System.out.print(rand3.nextInt(10) + " ");
        }
        // Output: 2 8 5 9 0  (different sequence)
    }
}
