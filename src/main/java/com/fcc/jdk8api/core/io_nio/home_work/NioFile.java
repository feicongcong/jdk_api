package com.fcc.jdk8api.core.io_nio.home_work;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Description:
 * @Author: CC.F
 * @Date: 20:48 2018/12/7
 */
public class NioFile {
    public static void main(String[] args) {
        file1();

    }

    public static void file1() {
        try {
            RandomAccessFile rfile = new RandomAccessFile("F:\\java_code\\jdk8_api\\src\\main\\resources\\in.txt", "r");
            RandomAccessFile wfile = new RandomAccessFile("F:\\java_code\\jdk8_api\\src\\main\\resources\\nio_out.txt", "rw");
            FileChannel channel = rfile.getChannel();
            FileChannel channel1 = wfile.getChannel();
            channel.transferTo(0,channel.size(),channel1);

//            ByteBuffer buf = ByteBuffer.allocate(1024);
//            int len = 0;
//            while ((len = channel.read(buf)) != -1) {
//                //准备缓冲器
//                buf.flip();
//                channel1.write(buf);
//                while (buf.hasRemaining()){
//                    //单个字节打印
//                    System.out.println((char)buf.get());
//                }
//                buf.clear();
//            }
            channel.close();
            channel1.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
