package com.fcc.jdk8api.core;

import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;
import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;

import java.io.*;
import java.net.URL;

/**
 * @Description:
 * @Author: CC.F
 * @Date: 17:16 2018/11/25
 */
public class IOClass {
    //所有输入流都是抽象类InputStream(字节输入流)或抽象类Reader(字符输入流)的子类
    //所有输出流都是抽象类OutputStream(字节输出流)或抽象类Writer(字符输出流)的子类
    public static void main(String[] args) {
        new IOClass().fileStream();
//        new IOClass().byteStream();
//        new IOClass().bufferStream();
    }



    private void fileStream(){
        URL url = this.getClass().getClassLoader().getResource("");
        File file = new File(url.getPath()+"\\in.txt");
        String path = IOClass.class.getClassLoader().getResource("").getPath();
        System.out.println(path);
        if (file.exists()) {
//            file.delete();
        }else{
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            FileInputStream is = new FileInputStream(file);
            File fileOut = new File(url.getPath()+"\\out.txt");
            if (fileOut.exists()) {
            }else{
                try {
                    fileOut.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            FileOutputStream os = new FileOutputStream(fileOut);
            BufferedOutputStream bos = new BufferedOutputStream(os);
            StringBuffer sb=new StringBuffer();
            byte[] buffer=new byte[32];
            int len=0;
            while ((len=is.read(buffer))!=-1){
                sb.append(new String(buffer,0,len));
                bos.write(buffer,0,len);
            }
            System.out.println(sb);
            bos.flush();
            bos.close();
            is.close();
            os.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        try {

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void byteStream(){
        try {
            byte[] bytes=new byte[]{97,97};
            ByteInputStream is = new ByteInputStream(bytes,10);
            ByteOutputStream os = new ByteOutputStream();
            byte[] buffer=new byte[1024];
            StringBuffer sb=new StringBuffer();
            int len=0;
            while ((len=is.read(buffer))!=-1){
                sb.append(new String(buffer,0,len));
                os.write(buffer);
            }
            System.out.println(new String(os.getBytes()));
            is.close();
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void bufferStream(){
        try {
            byte[] bytes=new byte[]{97,97};
            ByteInputStream is = new ByteInputStream(bytes,10);
            BufferedInputStream bis=new BufferedInputStream(is);
            ByteOutputStream os = new ByteOutputStream();
            BufferedOutputStream bos = new BufferedOutputStream(os);
            byte[] buffer=new byte[32];
            StringBuffer sb=new StringBuffer();
            int len=0;
            while ((len=bis.read(buffer))!=-1){
                sb.append(new String(buffer,0,len));
                bos.write(buffer);
            }
            System.out.println(sb);
            System.out.println(new String(os.getBytes()));
            is.close();
            bos.flush();
            os.close();
            bos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
