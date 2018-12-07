package com.fcc.jdk8api.core.io_nio;

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




        //RandomAccessFile(String name, String mode)
        //          创建从中读取和向其中写入（可选）的随机访问文件流，该文件具有指定名称
        RandomAccessFile aFile=null;
        RandomAccessFile outFile=null;
        try {
            aFile=new RandomAccessFile("src/nomal_in.txt","rw");
            outFile=new RandomAccessFile("src/nio_out.txt","rw");
            //文件通道
            FileChannel fileChannel=aFile.getChannel();
            //字节缓冲区类
            ByteBuffer buf=ByteBuffer.allocate(1024);
            // abstract  int 	read(ByteBuffer dst)
            //          将字节序列从此通道读入给定的缓冲区。
            int len=0;
            while ((len=fileChannel.read(buf))!=-1){
                //  Buffer 	flip()
                //          反转此缓冲区。
                buf.flip();
                System.out.print(new String(buf.array()));
                outFile.write(buf.array());
//                while (buf.hasRemaining()){
//                    //单个字节打印
//                    System.out.print((char)buf.get());
//                }
                // abstract  ByteBuffer 	compact()
                //          压缩此缓冲区（可选操作）。
                //调用clear()方法或者compact()方法
                buf.compact();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }finally{
            try{
                if(aFile!=null){
                    aFile.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
