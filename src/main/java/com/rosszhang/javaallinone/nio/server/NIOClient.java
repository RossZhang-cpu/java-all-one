package com.rosszhang.javaallinone.nio.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

public class NIOClient {

    public void startClient() {
        try (SocketChannel client = SocketChannel.open()){
            client.connect(new InetSocketAddress(8080));
            client.configureBlocking(false);

            ByteBuffer buffer = ByteBuffer.allocate(1024);
            Scanner scanner = new Scanner(System.in);
            System.out.println("please input message in the below:");

            while (true ) {
                String line = scanner.nextLine();
                if ("exit".equals(line)) {
                    break;
                }

                buffer.clear().put(line.getBytes()).flip();
                while (buffer.hasRemaining()) {
                    client.write(buffer);
                }
                buffer.clear();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void main(String[] args) {
//        new NIOClient().startClient();
        System.out.println(300000 / 7.3202 * (1.041) * 7.28);
    }
}
