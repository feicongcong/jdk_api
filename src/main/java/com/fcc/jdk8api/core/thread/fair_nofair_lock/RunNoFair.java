package com.fcc.jdk8api.core.thread.fair_nofair_lock;

/**
 * @Description:
 * @Author: CC.F
 * @Date: 19:23 2018/12/4
 */
public class RunNoFair {
    public static void main(String[] args){
        final MyService service=new MyService(false);
        Runnable runnable=new Runnable() {
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
