package com.fcc.jdk8api.core.io_nio.home_work.server_client;

import jdk.nashorn.internal.ir.BaseNode;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * @Description:
 * @Author: CC.F
 * @Date: 21:46 2018/12/7
 */
public class NioTcpClient {
    public static void main(String[] args){
        client();
    }
    public static void client(){
        try {
            SocketChannel channel=SocketChannel.open();
            channel.configureBlocking(false);
            channel.connect(new InetSocketAddress("127.0.0.1",8080));
            if(channel.finishConnect()){
                ByteBuffer buf=ByteBuffer.allocate(1024);
                buf.clear();
                buf.put("这是来自nioClient的请求".getBytes());
                buf.flip();
                while (buf.hasRemaining()) {
                    channel.write(buf);
                }
            }
            channel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
