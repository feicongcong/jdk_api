package com.fcc.jdk8api.core.thread.MustUseMoreCondition;

/**
 * @Description:
 * @Author: CC.F
 * @Date: 18:45 2018/12/4
 */
public class Run {
    public static void main(String[] args){
        MyService service=new MyService();
        ThreadA a=new ThreadA(service);
        a.setName("A");
        a.start();
        ThreadB     b =new ThreadB(service);
        b.setName("B");
        b.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        service.signalAll_a();
    }
}
