package com.fcc.jdk8api.core.thread.baseThread;

/**
 * @Description:
 * @Author: CC.F
 * @Date: 13:48 2018/12/1
 */
public class JoinThreadClass {
    public static void main(String[] args){
        //三个线程依次执行，A->B->C
        Thread A=new Thread(new Runnable() {
            @Override
            public void run() {
                printNum("A");
            }
        });
        Thread B=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    A.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                printNum("B");
            }
        });
        Thread C=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    B.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                printNum("C");
            }
        });
        A.start();
        B.start();
        C.start();
    }

    private static void printNum(String threadName){
        int i=0;
        while (i++<=100){
            System.out.println(threadName+":"+i);
        }
    }
}
