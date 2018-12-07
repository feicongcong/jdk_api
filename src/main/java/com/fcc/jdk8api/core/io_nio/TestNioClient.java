package com.fcc.jdk8api.core.io_nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @Author: CC.F
 * @Date: 18:02 2018/12/6
 */
public class TestNioClient {
    public static void main(String[] args){
        SocketChannel sc=null;
        try {
            sc=SocketChannel.open();
            sc.configureBlocking(false);
            sc.connect(new InetSocketAddress("127.0.0.1",8888));
            if(sc.finishConnect()){
                ByteBuffer buffer=ByteBuffer.allocate(102);
                int i=0;
                while(true){
                    TimeUnit.SECONDS.sleep(1);
                    String info="I'm "+(i++)+"-th information from client";
                    buffer.clear();
                    buffer.put(info.getBytes());
                    buffer.flip();
                    if(buffer.hasRemaining()) {
                        sc.write(buffer);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if(sc!=null) {
                    sc.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
