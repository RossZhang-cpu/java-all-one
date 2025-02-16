package com.rosszhang.javaallinone.classloader;

public class String {

    public static void main(java.lang.String[] args) {
        String string = new String();
        System.out.println(string.getClass().getClassLoader());

    }
}
