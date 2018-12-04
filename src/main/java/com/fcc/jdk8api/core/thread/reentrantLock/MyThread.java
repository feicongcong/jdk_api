package com.fcc.jdk8api.core.thread.reentrantLock;

/**
 * @Description:
 * @Author: CC.F
 * @Date: 14:57 2018/12/4
 */
public class MyThread implements Runnable {
    private  MyService myService;

    public MyThread(MyService myService) {
        this.myService = myService;
    }

    @Override
    public void run() {
        myService.testMethod();
    }
}
