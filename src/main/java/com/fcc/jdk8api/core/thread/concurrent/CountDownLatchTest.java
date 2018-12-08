package com.fcc.jdk8api.core.thread.concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * @Description:
 * @Author: CC.F
 * @Date: 15:16 2018/12/8
 */
public class CountDownLatchTest {
    //计数器
    private static CountDownLatch c=new CountDownLatch(2);
    public static void main(String[] args) throws InterruptedException {
        Thread t= new Thread(){
            @Override
            public void run(){
                System.out.println(1);
                c.countDown();
                System.out.println(2);
                c.countDown();
            }
        };
        t.start();
        c.await();
        System.out.println("3");
    }
}
