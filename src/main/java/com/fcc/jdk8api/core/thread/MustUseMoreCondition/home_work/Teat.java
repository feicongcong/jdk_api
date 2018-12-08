package com.fcc.jdk8api.core.thread.MustUseMoreCondition.home_work;

/**
 * @Description:
 * @Author: CC.F
 * @Date: 11:50 2018/12/8
 */
public class Teat {

    public static void main(String[] args){
        method();
    }
    public static void method(){
        TestService service=new TestService();
        ThreadA a=new ThreadA(service);
        a.setName("A");
        a.setPriority(10);
        a.start();
        ThreadB b=new ThreadB(service);
        b.setName("B");
        b.setPriority(10);
        b.start();
//        Thread.currentThread().setPriority(0);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        service.signalAll_a();
        service.signalAll_b();
    }
}
