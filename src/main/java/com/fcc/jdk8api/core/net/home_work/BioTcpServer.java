package com.fcc.jdk8api.core.net.home_work;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Description:
 * @Author: CC.F
 * @Date: 22:46 2018/12/6
 */
public class BioTcpServer {
    public static void main(String[] args) {
        server();
    }

    public static void server() {
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("tcp服务器启动...");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("收到请求");
                InputStream is = socket.getInputStream();
                bis = new BufferedInputStream(is);
                byte[] buf = new byte[1024];
                int len = 0;
                if ((len = bis.read(buf)) != -1) {
                    System.out.println("请求信息为：" + new String(buf));
                }


                bos = new BufferedOutputStream(socket.getOutputStream());
                bos.write("我是bioTcp服务器".getBytes());
                bos.flush();
                socket.shutdownOutput();
                bos.close();
//
//
//
                bis.close();
                //socket必须关闭
                socket.close();

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bis != null) {
                    bis.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                if (bos != null) {
                    bos.flush();
                    bos.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

