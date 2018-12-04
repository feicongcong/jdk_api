package com.fcc.jdk8api.core;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Description:
 * @Author: CC.F
 * @Date: 12:26 2018/12/2
 */
public class IoNioClass {
    public static void main(String[] args){
        method1();
    }

    public static void method2(){
        InputStream in = null;
        try{
            in = new BufferedInputStream(new FileInputStream("src/nomal_io.txt"));
            byte [] buf = new byte[1024];
            int bytesRead = in.read(buf);
            while(bytesRead != -1)
            {
                for(int i=0;i<bytesRead;i++) {
                    System.out.print((char) buf[i]);
                }
                bytesRead = in.read(buf);
            }
        }catch (IOException e)
        {
            e.printStackTrace();
        }finally{
            try{
                if(in != null){
                    in.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    public static void method1(){
        RandomAccessFile aFile = null;
        try{
            aFile = new RandomAccessFile("src/nomal_io.txt","rw");
            FileChannel fileChannel = aFile.getChannel();
            ByteBuffer buf = ByteBuffer.allocate(10);
            int bytesRead = fileChannel.read(buf);

            while(bytesRead != -1)
            {
//                System.out.println(bytesRead);
                buf.flip();
                while(buf.hasRemaining())
                {
                    System.out.print((char)buf.get());
                }
                buf.compact();
                bytesRead = fileChannel.read(buf);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally{
            try{
                if(aFile != null){
                    aFile.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
