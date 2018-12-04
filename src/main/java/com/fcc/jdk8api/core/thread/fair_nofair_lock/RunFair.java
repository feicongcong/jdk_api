package com.fcc.jdk8api.core.thread.fair_nofair_lock;

/**
 * @Description:
 * @Author: CC.F
 * @Date: 19:06 2018/12/4
 */
public class RunFair {
    //公平锁表示线程获取锁的顺序是按照线程加锁的顺序 即 FIFO
    public static void main(String[] args){
        final MyService service=new MyService(true);
        Runnable runnable =new Runnable() {
            @Override
            public void run() {
                System.out.println("线程 "+Thread.currentThread().getName());
                service.serviceMethod();
            }
        };
        Thread[] threads=new Thread[10];
        for(int i=0;i<10;i++){
            threads[i]=new Thread(runnable);
        }
        for(int i=0;i<10;i++){
            threads[i].start();
        }
    }
}
