package com.rosszhang.javaallinone.nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ReadFileByNIO {

    public static void main(String[] args) throws IOException {
        FileChannel fc;
        try (FileInputStream fin = new FileInputStream("E:\\CodeFiles\\javafiles\\myproject\\java-all-in-one\\src\\main\\resources\\readandshow.txt")) {
            fc = fin.getChannel();
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            fc.read(buffer);

            System.out.println(new String(buffer.array()));
        } finally {
        }



    }
}
