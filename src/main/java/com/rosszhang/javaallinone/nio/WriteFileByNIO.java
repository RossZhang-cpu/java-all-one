package com.rosszhang.javaallinone.nio;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class WriteFileByNIO {

    public static void main(String[] args) {

        try (FileOutputStream fout = new FileOutputStream("E:\\CodeFiles\\javafiles\\myproject\\java-all-in-one\\src\\main\\resources\\output.txt")) {
            FileChannel fc = fout.getChannel();
            ByteBuffer buffer = ByteBuffer.allocate( 1024 );

            String message = "some bytes";

            for (int i=0; i<message.getBytes().length; ++i) {
                buffer.put( message.getBytes()[i] );
            }
            buffer.flip();
            fc.write(buffer);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
