package com.fcc.jdk8api.core.io_nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * @Description:
 * @Author: CC.F
 * @Date: 14:22 2018/12/6
 */
public class NioServer {
    private static final int BUF_SIZE = 1024;
    private static final int PORT = 8080;
    private static final int TIME_OUT = 3000;

    public static void main(String[] args) {
        selector();

    }

    public static void handleAccept(SelectionKey key) throws IOException {
        ServerSocketChannel ssChannel = (ServerSocketChannel) key.channel();
        SocketChannel sc = ssChannel.accept();
        sc.configureBlocking(false);
        sc.register(key.selector(), SelectionKey.OP_READ, ByteBuffer.allocateDirect(BUF_SIZE));
    }

    public static void handleRead(SelectionKey key) throws IOException {
        SocketChannel sc = (SocketChannel) key.channel();
        ByteBuffer buf = (ByteBuffer) key.attachment();
        long bytesRead = sc.read(buf);
        while (bytesRead > 0) {
            buf.flip();
            while (buf.hasRemaining()) {
                System.out.print((char) buf.get());
            }
            System.out.println();
            buf.clear();
            bytesRead = sc.read(buf);
        }
        if (bytesRead == -1) {
            sc.close();
        }
    }

    public static void handleWrite(SelectionKey key) throws IOException {
        ByteBuffer buf = (ByteBuffer) key.attachment();
        buf.flip();
        SocketChannel sc = (SocketChannel) key.channel();
        while (buf.hasRemaining()) {
            sc.write(buf);
        }
        buf.compact();
    }

    public static void selector() {
        //Selector对象的多路复用器;
        Selector selector = null;
        //ServerSocketChannel套接字的可选择通道
        // abstract  SocketChannel 	accept() 接受到此通道套接字的连接。
        //static ServerSocketChannel 	open()打开服务器套接字通道。
        //abstract  ServerSocket 	socket()获取与此通道关联的服务器套接字。
        // int 	validOps()返回一个操作集，标识此通道所支持的操作。
        //SelectionKey 	register(Selector sel, int ops, Object att)向给定的选择器注册此通道，返回一个选择键
        ServerSocketChannel ssc = null;

        try {
            //创建选择器
            selector = Selector.open();
            ssc = ServerSocketChannel.open();
            ssc.socket().bind(new InetSocketAddress(PORT));
            ssc.configureBlocking(false);
            //通道注册到选择器上，并标记该通道对什么感兴趣
            ssc.register(selector, SelectionKey.OP_ACCEPT);
            while (true) {
                // abstract  int 	select(long timeout)表示有多少通道已经就绪。
                if (selector.select(TIME_OUT) == 0) {
                    System.out.println("==");
                    continue;
                }
                Iterator<SelectionKey> iter = selector.selectedKeys().iterator();
                while (iter.hasNext()) {
                    //SelectionKey可选择通道到选择器的注册
                    SelectionKey key = iter.next();
                    if (key.isAcceptable()) {
                        handleAccept(key);
                    }
                    if (key.isReadable()) {
                        handleRead(key);
                    }
                    if (key.isWritable() && key.isValid()) {
                        handleWrite(key);
                    }
                    if (key.isConnectable()) {
                        System.out.println("isConnectable=true");
                    }
                    iter.remove();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (selector != null) {
                    selector.close();
                }
                if (ssc != null) {
                    ssc.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
