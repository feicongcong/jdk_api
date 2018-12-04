package com.fcc.jdk8api.core.thread.baseThread;

/**
 * @Description:
 * @Author: CC.F
 * @Date: 15:00 2018/12/1
 */
public class WaitNotifyThread {
    /**
     * 两个线程交叉执行
     * wait()使线程进入等待状态，必须使用notify()方法才能唤醒
     * @param args
     */
    public static void main(String[] args){
        Object lock = new Object();
        Thread A = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    System.out.println("A 1");
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("A 2");
                    System.out.println("A 3");
                }
            }
        });
        A.start();
        Thread B = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    System.out.println("B 1");
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("B 2");
                    System.out.println("B 3");

                }
            }
        });
        B.start();

        Thread C = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    System.out.println("C 1");
                    System.out.println("C 2");
                    System.out.println("C 3");
                    lock.notifyAll();
                }
            }
        });
        C.start();
    }
}
