package com.fcc.jdk8api.core.thread;

/**
 * @Description:
 * @Author: CC.F
 * @Date: 14:09 2018/12/1
 */
public class InterruptedThreadClass {
    public static void main(String[] args){
        //如果线程是因为使用sleep()或wait()方法进入就绪状态，可以使用interupt()方法使线程抛出InterruptedException异常
        //用户捕获异常后处理线程结束
        Thread a=new Thread(new Runnable() {
            int i=0;
            @Override
            public void run() {
                while (i++<10){
                    if(i==6){
                        try {
                            Thread.sleep(5000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            break;
                        }
                    }
                    System.out.println(i);
                }
            }
        });
        a.start();
        a.interrupt();
    }
}
