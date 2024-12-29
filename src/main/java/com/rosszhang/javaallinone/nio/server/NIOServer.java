package com.rosszhang.javaallinone.nio.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Set;

public class NIOServer {

    private int port = 8080;

    public void startServer() {
        try (Selector selector = Selector.open(); ServerSocketChannel socketChannel = ServerSocketChannel.open()) {
            socketChannel.bind(new InetSocketAddress(8080));
            socketChannel.configureBlocking(false);
            socketChannel.register(selector, SelectionKey.OP_ACCEPT);

            while (true) {
                while (0 == selector.select()) {
                    continue;
                }

                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                for (SelectionKey key : selectionKeys) {
                    if (key.isAcceptable()) {
                        if (key.channel() instanceof ServerSocketChannel client) {
                            SocketChannel channel = client.accept();
                            channel.configureBlocking(false);
                            channel.register(selector, SelectionKey.OP_READ);
                            System.out.println("Connection Accepted " + channel.getRemoteAddress());
                        } else {
                            throw new RuntimeException("Unknown connection");
                        }
                    }

                    if (key.isReadable()) {
                        if (key.channel() instanceof SocketChannel client) {
                            System.out.println("received message");
                            ByteBuffer buffer = ByteBuffer.allocate(5);
                            int read = 1;
                            for (;read > 0;) {
                                read = client.read(buffer);
                                buffer.flip();
                                String s = new String(buffer.array(), buffer.position(), read);
                                System.out.println(s);
                                buffer.clear();
                            }

                        }
                    }

                }
                selectionKeys.clear();


            }

        } catch (IOException e) {

        }

    }

    public static void main(String[] args) {
        new NIOServer().startServer();
    }

}
