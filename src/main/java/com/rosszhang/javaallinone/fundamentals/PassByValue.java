package com.rosszhang.javaallinone.fundamentals;

class MyObject {
    int value;
}
public class PassByValue {
    public static void modifyValue(int num) {
        num = num * 2; // Modifies the copy of num
        System.out.println("Inside method: " + num); // Output: 20
    }

    public static void main(String[] args) {
        int myNumber = 10;
        modifyValue(myNumber);
        System.out.println("Outside method: " + myNumber); // Output: 10 (unchanged)
    }

}
