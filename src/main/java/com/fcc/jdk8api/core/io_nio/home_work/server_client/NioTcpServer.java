package com.fcc.jdk8api.core.io_nio.home_work.server_client;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;

/**
 * @Description:
 * @Author: CC.F
 * @Date: 22:05 2018/12/7
 */
public class NioTcpServer {
    public static void main(String[] args){
        server();
    }
    public static void server(){
        Selector selector= null;
        ServerSocketChannel ssc=null;
        ServerSocketChannel ssc1=null;
        try {
            selector= Selector.open();
            ssc= ServerSocketChannel.open();
            ssc.configureBlocking(false);
            ssc.socket().bind(new InetSocketAddress(8888));
//            ssc1.configureBlocking(false);
//            ssc1.socket().bind(new InetSocketAddress("127.0.0.1",8081));

            ssc.register(selector, SelectionKey.OP_ACCEPT);
            while(true){
                if(selector.select(3000)==0){
                    System.out.println("==");
                    continue;
                }
                Iterator<SelectionKey> iter=selector.selectedKeys().iterator();
                while(iter.hasNext()){
                    SelectionKey key=iter.next();
                    System.out.println(key.toString());
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
