package com.fcc.jdk8api.MyHttpServer;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;

public class HTTPServer {
    public static void main(String[] args) {
        int port;
        ServerSocket serverSocket;
        try{
            port=Integer.parseInt(args[0]);
        }catch(Exception e){
            System.out.println("port=8080(默认)");
            port=8080;
            
        }
        
        try {
            serverSocket=new ServerSocket(port);
            System.out.println("服务器正在监听端口："+serverSocket.getLocalPort());
            while(true){
                Socket socket=serverSocket.accept(); //没有请求过来时会阻塞 程序停在此处
                System.out.println("建立了与客户的一个新的TCP连接，该客户的地址为:"+socket.getInetAddress()+":"+socket.getPort());
                try {
                    service(socket);
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        
    }
    
    public static void service(Socket socket) throws Exception{
        InputStream socketIn=socket.getInputStream();
        Thread.sleep(500);   
        int size=socketIn.available();
        byte[] buffer=new byte[size];
        socketIn.read(buffer);
        String request=new String(buffer);
        System.out.println(request);
        //获取HTTP请求的第一行
        String firstLineOfRequest=request.substring(0,request.indexOf("\r\n"));
        System.out.println("http请求的第一行:"+firstLineOfRequest);
        //解析HTTP请求的第一行
        String[] parts=firstLineOfRequest.split(" ");
        //获取HTTP请求中的URI
        String uri=parts[1];
        /*决定HTTP响应正文的类型*/
        String contentType;
        if(uri.indexOf("html")!=-1||uri.indexOf("htm")!=-1) {
            contentType = "text/html";
        }
        else if(uri.indexOf("jpg")!=-1||uri.indexOf("jpeg")!=-1) {
            contentType = "image/jpeg";
        }
        else if(uri.indexOf("gif")!=-1) {
            contentType = "image/gif";
        }
        else {
            contentType = "application/octet-stream"; //字节流类型
        }
        
        /*创建HTTP响应结果*/
        //HTTP响应的第一行
        String responseFirstLine="HTTP/1.1 200 OK\r\n";
        
        String responseHeader="Content-type:"+contentType+"\r\n\r\n";

        File file = new File( "F:\\java_code\\jdk8_api\\src\\abc.html");
        InputStream in=new FileInputStream(file);

//                HTTPServer.class.getResourceAsStream(uri.substring(1));
        
        /*发送HTTP响应结果*/
        OutputStream socketOut=socket.getOutputStream();
        
        socketOut.write(responseFirstLine.getBytes());
        socketOut.write(responseHeader.getBytes());
        
        //发送正文
        int len=0;
        buffer=new byte[128];
        while((len=in.read(buffer))!=-1) {
            socketOut.write(buffer, 0, len);
        }
        
        Thread.sleep(1000);
        socket.close();
        
    }

}
