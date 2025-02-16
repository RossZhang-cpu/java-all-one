package com.rosszhang.javaallinone.nestclass;


public class Animal {
    private String name;
    private int age;

    private static boolean isAlive = true;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Animal() {

    }

    private void eat() {
        System.out.println("Animal eat");
    }

    public void sleep() {
        System.out.println("Animal sleep");
    }

    public void show() {
        System.out.println("name: " + name + " age: " + age);
    }

    protected static class Dog {
        public void show() {
            boolean isAlive1 = Animal.isAlive;
//            System.out.println("name: " + name + " age: " + age);
        }
    }

    public class Cat {

    }

    public static void main(String[] args) {

    }


}
