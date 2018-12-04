package com.fcc.jdk8api.core.net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {
   public static void main(String[] args) throws IOException
   {
      DatagramSocket client = new DatagramSocket();
 
      String sendStr = "HI!";
      byte[] sendBuf = sendStr.getBytes();
      // 接收消息的主机，255.255.255.255可广播给局域网内所有主机
      InetAddress addr = InetAddress.getByName("127.0.0.1");
      DatagramPacket sendPacket = new DatagramPacket(sendBuf, sendBuf.length,
            addr, 9999);
      // 发送数据包
      client.send(sendPacket);
      // 用于接收数据的缓冲数组
      byte[] recvBuf = new byte[100];
      // 实例化数据报对象
      DatagramPacket recvPacket = new DatagramPacket(recvBuf, recvBuf.length);
      // 接收消息
      client.receive(recvPacket);
      String recvStr = new String(recvPacket.getData(), 0,
            recvPacket.getLength());
      System.out.println("收到消息:" + recvStr);
      client.close();
   }
}
