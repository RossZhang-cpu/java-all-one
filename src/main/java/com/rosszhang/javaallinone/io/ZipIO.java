package com.rosszhang.javaallinone.io;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ZipIO {

    public void zipInput(String pathname){
        try (ZipInputStream zip = new ZipInputStream(new FileInputStream(pathname))) {
            ZipEntry entry = null;
            while ((entry = zip.getNextEntry()) != null) {
                String name = entry.getName();
                if (!entry.isDirectory()) {
                    int n;
                    while ((n = zip.read()) != -1) {
                        System.out.println( zip.readAllBytes());
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ZipIO zipIO = new ZipIO();
        zipIO.zipInput("D:/javafiles/gitrepository/myblog.zip");
        new Thread();
        HashSet<Object> set = new HashSet<>();
        set.add(null);
    }
}
