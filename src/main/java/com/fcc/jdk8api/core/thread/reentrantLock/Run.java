package com.fcc.jdk8api.core.thread.reentrantLock;

/**
 * @Description:
 * @Author: CC.F
 * @Date: 14:56 2018/12/4
 */
public class Run {
    public static void main(String[] args) {
        MyService myService=new MyService();

        new Thread(new MyThread(myService)).start();
        new Thread(new MyThread(myService)).start();
        new Thread(new MyThread(myService)).start();
        Thread t=new Thread(new MyThread(myService));
        new Thread(t).start();
        new Thread(t).start();
        new Thread(t).start();
    }
}
