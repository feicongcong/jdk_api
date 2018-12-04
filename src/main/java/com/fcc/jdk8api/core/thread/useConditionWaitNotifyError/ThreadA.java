package com.fcc.jdk8api.core.thread.useConditionWaitNotifyError;

/**
 * @Description:
 * @Author: CC.F
 * @Date: 17:44 2018/12/4
 */
public class ThreadA extends Thread {

    private MyService myService;

    public ThreadA(MyService myService) {
        this.myService = myService;
    }

    @Override
    public void run() {
        myService.await();
    }
}
