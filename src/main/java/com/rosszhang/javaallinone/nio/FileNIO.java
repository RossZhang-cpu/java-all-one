package com.rosszhang.javaallinone.nio;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class FileNIO {

    public static void main(String[] args) throws IOException {
        FileNIO fileNIO = new FileNIO();
        long size = 3;
        fileNIO.truncateTo(size);


    }

    public void writeToFileFromUserInput() throws IOException {
        Scanner sc = new Scanner(System.in);
        FileOutputStream fout = null;
        FileChannel channel = null;
        try {
            fout = new FileOutputStream("E:\\CodeFiles\\javafiles\\myproject\\java-all-in-one\\src\\main\\resources\\output1.txt");
            channel = fout.getChannel();
            while (sc.hasNext()) {
                String token = sc.next();
                ByteBuffer byteBuffer = ByteBuffer.wrap(token.getBytes(StandardCharsets.UTF_8));
                int write = channel.write(byteBuffer);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            if (channel != null) {
                channel.close();
            }

            if (fout != null) {
                fout.close();
            }
        }
    }

    public void truncateTo(long size) {
        try {
            RandomAccessFile fout = new RandomAccessFile("E:\\CodeFiles\\javafiles\\myproject\\java-all-in-one\\src\\main\\resources\\output1.txt", "rw");
            FileChannel channel = fout.getChannel();
            long size1 = channel.size();
            System.out.println("origin size is " + size1);
            channel.truncate(size);
            long size2 = channel.size();
            System.out.println("final size is "+ size2);

            /*
            ByteBuffer allocate = ByteBuffer.allocate(1024);
            channel.write(allocate);
            FileInputStream fin = new FileInputStream("E:\\CodeFiles\\javafiles\\myproject\\java-all-in-one\\src\\main\\resources\\read.txt");
            FileChannel channel1 = fin.getChannel();
            channel1.read(allocate);

             */

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
