package com.fcc.jdk8api.core.thread.reentrantaReadWriteLock;

/**
 * @Description:
 * @Author: CC.F
 * @Date: 20:48 2018/12/4
 */
public class Run1 {
    public static void main(String[] args) {
        //读写互斥/写读互斥
        Service service = new Service();
        ThreadA a1=new ThreadA(service);
        a1.setName("a1");
        ThreadWriteA a2=new ThreadWriteA(service);
        a2.setName("a2");
        a1.start();
        a2.start();
    }
}
