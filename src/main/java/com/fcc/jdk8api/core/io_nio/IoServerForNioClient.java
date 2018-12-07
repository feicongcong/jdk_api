package com.fcc.jdk8api.core.io_nio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;

/**
 * @Description:
 * @Author: CC.F
 * @Date: 18:36 2018/12/6
 */
public class IoServerForNioClient {
    public static void main(String[] args){
        ServerSocket serverSocket = null;
        InputStream in = null;
        try
        {
            serverSocket = new ServerSocket(8888);
            int recvMsgSize = 0;
            byte[] recvBuf = new byte[1024];
            while(true){
                System.out.println("服务端已启动，等待客户端连接..");

                Socket clntSocket = serverSocket.accept();
                SocketAddress clientAddress = clntSocket.getRemoteSocketAddress();
                System.out.println("Handling client at "+clientAddress);
                in = clntSocket.getInputStream();

//                InputStreamReader inputStreamReader = new InputStreamReader(in);//提高效率，将自己字节流转为字符流
//                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);//加入缓冲区
//                String temp = null;
//                String info = "";
//                while ((temp = bufferedReader.readLine()) != null) {
//                    info += temp;
//                    System.out.println("已接收到客户端连接");
//                    System.out.println("服务端接收到客户端信息：" + info + ",当前客户端ip为：" +
//                            clntSocket.getInetAddress().getHostAddress());
//                }


                while((recvMsgSize=in.read(recvBuf))!=-1){
                    byte[] temp = new byte[recvMsgSize];
                    System.arraycopy(recvBuf, 0, temp, 0, recvMsgSize);
                    System.out.println(new String(temp));
                }
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally{
            try{
                if(serverSocket!=null){
                    serverSocket.close();
                }
                if(in!=null){
                    in.close();
                }
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }
}
