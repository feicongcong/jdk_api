package com.fcc.jdk8api.core.net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPServer {
   public static void main(String[] args) throws IOException
   {
      DatagramSocket server = new DatagramSocket(9999);
      // 用于接收数据的缓冲数组
      byte[] recvBuf = new byte[100];
      // 实例化数据报对象
      DatagramPacket recvPacket = new DatagramPacket(recvBuf, recvBuf.length);
      // 接收消息
      server.receive(recvPacket);
      String recvStr = new String(recvPacket.getData(), 0,
            recvPacket.getLength());
      System.out.println("接收到消息：" + recvStr);
      int port = recvPacket.getPort();
      InetAddress addr = recvPacket.getAddress();
      String sendStr = "SUCCESS";
      byte[] sendBuf = sendStr.getBytes();
 
      // 创建回复数据报
      DatagramPacket sendPacket = new DatagramPacket(sendBuf, sendBuf.length,
            addr, port);
      // 发送回复
      server.send(sendPacket);
      server.close();
   }
}
