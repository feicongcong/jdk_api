package com.fcc.jdk8api.core.thread.reentrantLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description:
 * @Author: CC.F
 * @Date: 14:57 2018/12/4
 */
public class MyThread implements Runnable {
    private  MyService myService;
    private int ticketNum;
    private Lock lock = new ReentrantLock();

    public MyThread(int ticketNum) {
        this.ticketNum = ticketNum;
    }

    public MyThread(MyService myService) {
        this.myService = myService;
    }

    @Override
    public void run() {
//        myService.testMethod();

        while (true) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.lock();
            if (ticketNum > 0) {
                ticketNum--;
                System.out.println("当前线程：" + Thread.currentThread().getName() + "当前票数：" + ticketNum);
            }else{
                break;
            }

            lock.unlock();
        }
    }

}
