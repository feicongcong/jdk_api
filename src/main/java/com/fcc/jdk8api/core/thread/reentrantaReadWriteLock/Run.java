package com.fcc.jdk8api.core.thread.reentrantaReadWriteLock;


/**
 * @Description:
 * @Author: CC.F
 * @Date: 20:26 2018/12/4
 */
public class Run {
    public static void main(String[] args){
        //读读共享
        Service service=new Service();
//        ThreadA a=new ThreadA(service);
//        a.setName("a");
//        ThreadB b=new ThreadB(service);
//        b.setName("b");
//        a.start();
//        b.start();

        //写写互斥
        ThreadWriteA c=new ThreadWriteA(service);
        c.setName("c");
        ThreadWriteB d=new ThreadWriteB(service);
        d.setName("d");
        c.start();
        d.start();
    }
}
