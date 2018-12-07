package com.fcc.jdk8api.core.io_nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @Author: CC.F
 * @Date: 14:02 2018/12/6
 */
public class NioClient {
    public static void main(String[] args){
        ByteBuffer buffer= ByteBuffer.allocate(1024);
        //针对面向流的连接套接字的可选择通道
        SocketChannel socketChannel=null;

        try {
            // static SocketChannel 	open()打开套接字通道。
            socketChannel =SocketChannel.open();
            socketChannel.configureBlocking(false);
            socketChannel.connect(new InetSocketAddress("127.0.0.1",8888));
            if(socketChannel.finishConnect()){
                int i=0;
                while(true){
                    TimeUnit.SECONDS.sleep(2);
                    String info="I'm "+(i++)+"-th information from client";
                    buffer.clear();
                    buffer.put(info.getBytes());
                    buffer.flip();
                    if(buffer.hasRemaining()) {
                        socketChannel.write(buffer);
                    }
                }
            }
        } catch (IOException|InterruptedException e) {
            e.printStackTrace();
        }finally{
            try {
                if (socketChannel != null) {
                    socketChannel.close();
                }
            }catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
