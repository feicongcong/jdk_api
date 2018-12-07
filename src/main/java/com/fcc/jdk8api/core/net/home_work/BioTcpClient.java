package com.fcc.jdk8api.core.net.home_work;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @Author: CC.F
 * @Date: 19:00 2018/12/7
 */
public class BioTcpClient {

    public static void main(String[] args){
        client();
    }
    public static void client(){
        BufferedOutputStream bos=null;
        BufferedInputStream bis=null;
        try {
            while (true) {
                TimeUnit.SECONDS.sleep(2);
                Socket socket = new Socket("127.0.0.1", 8080);
                bos = new BufferedOutputStream(socket.getOutputStream());

                bos.write("你是什么服务器？".getBytes());
                bos.flush();
//                socket.shutdownOutput();


                bis=new BufferedInputStream(socket.getInputStream());
                byte[] buf=new byte[1024];
                int len=0;
                while((len=bis.read(buf))!=-1){
                    System.out.println("得到相应："+new String(buf));
                }

                bis.close();
                bos.flush();
                bos.close();
                //socket必须关闭
                socket.close();


            }

        } catch (IOException|InterruptedException e) {
            e.printStackTrace();
        }finally {
            try {
                if(bis!=null) {

                    bis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(bos!=null) {
                    bos.flush();
                    bos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
