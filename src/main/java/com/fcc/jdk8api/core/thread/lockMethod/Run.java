package com.fcc.jdk8api.core.thread.lockMethod;

/**
 * @Description:
 * @Author: CC.F
 * @Date: 19:36 2018/12/4
 */
public class Run {
    public static void main(String[] args) throws InterruptedException {
        //查询当前线程保持此锁定的个数lock.getHoldCount()
        Service service=new Service();
        service.serviceMethod1();

        //正等待获取此锁定的线程估计数service.lock.getQueueLength()
        Runnable runnable =new Runnable() {
            @Override
            public void run() {
                service.serviceMethod2();
            }
        };
        Thread[] threads=new Thread[10];
        for(int i=0;i<10;i++){
            threads[i]=new Thread(runnable);
        }
        for(int i=0;i<10;i++){
            threads[i].start();
        }
        Thread.sleep(2000);
        System.out.println("有线程数："+service.lock.getQueueLength()+"  在等待");
    }
}
