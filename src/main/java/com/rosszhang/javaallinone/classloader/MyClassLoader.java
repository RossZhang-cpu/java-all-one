package com.rosszhang.javaallinone.classloader;

import java.awt.color.CMMException;
import java.net.URI;
import java.util.List;

public class MyClassLoader {

    public static void main(String[] args) {
        Class<?> stringClass = String.class;
        ClassLoader stringClassLoader = stringClass.getClassLoader();

        System.out.println("Class: " + stringClass.getName());
        System.out.println("ClassLoader: " + stringClassLoader); // Output will be null, representing Bootstrap


        // java.util.List is part of the Java SE Platform API
        Class<?> listClass = List.class;
        ClassLoader listClassLoader = listClass.getClassLoader();

        // java.net.URI is also part of the Java SE Platform API
        Class<?> uriClass = URI.class;
        ClassLoader uriClassLoader = uriClass.getClassLoader();


        System.out.println("Class: " + listClass.getName());
        System.out.println("ClassLoader for List: " + listClassLoader); // Output will be PlatformClassLoader

        System.out.println("\nClass: " + uriClass.getName());
        System.out.println("ClassLoader for URI: " + uriClassLoader); // Output will be PlatformClassLoader


        // MyAppClass is a class from your application (assuming it's in your classpath)
        Class<?> myAppClass = MyClassLoader.class;
        ClassLoader myAppClassLoader = myAppClass.getClassLoader();

        System.out.println("Class: " + myAppClass.getName());
        System.out.println("ClassLoader for MyAppClass: " + myAppClassLoader); // Output will be SystemClassLoader (or AppClassLoader)

        CMMException test = new CMMException("test");
        System.out.println("Class: " + test.getClass().getName());
        System.out.println("ClassLoader for MyAppClass: " + test.getClass().getClassLoader());

    }
}
