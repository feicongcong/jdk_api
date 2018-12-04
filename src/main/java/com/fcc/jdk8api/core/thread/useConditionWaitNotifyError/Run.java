package com.fcc.jdk8api.core.thread.useConditionWaitNotifyError;

/**
 * @Description:
 * @Author: CC.F
 * @Date: 17:46 2018/12/4
 */
public class Run {
    public static  void main(String[] args) throws InterruptedException {
        MyService myService=new MyService();
        new ThreadA(myService).start();
        Thread.sleep(2000);
        myService.signal();
        System.out.println("signal");
    }
}
