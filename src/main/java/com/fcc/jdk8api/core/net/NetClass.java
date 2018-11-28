package com.fcc.jdk8api.core.net;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @Description:
 * @Author: CC.F
 * @Date: 0:28 2018/11/29
 */
public class NetClass {
    public static void main(String[] args){
        //局域网LAN=local area network ;WAN=wide area network
        //IP=Internet Protocol,是一种网络协议
        //Internet网络采用的协议是TCP/IP协议
        new NetClass().getAddress();
    }

    public void getAddress(){

        try {
            //实例化对象
            InetAddress ip=InetAddress.getLocalHost();
            System.out.println(ip.getHostName());
            System.out.println(ip.getHostAddress());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
