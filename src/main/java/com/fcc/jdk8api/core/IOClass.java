package com.fcc.jdk8api.core;

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
        new IOClass().test();
    }


    private void test(){
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
            File fileOut = new File("out.txt");
            if (file.exists()) {
            }else{
                try {
                    file.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            FileOutputStream os = new FileOutputStream(fileOut);
            byte[] buffer=new byte[1];
            while (is.read(buffer)!=-1){
                os.write(buffer);
            }

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
}
