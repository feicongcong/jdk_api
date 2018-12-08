package com.fcc.jdk8api.core.thread.concurrent;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description:
 * @Author: CC.F
 * @Date: 17:49 2018/12/8
 */
public class ExchangerTest {
    private static final Exchanger<String> exgr=new Exchanger<String>();
    private static ExecutorService threadPool=Executors.newFixedThreadPool(2);

    public static void main(String[] args){
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                String A="银行流水A";
                try {
                    exgr.exchange(A);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                String B="银行流水B";
                try {
                    String A=exgr.exchange(B);
                    System.out.println("A和B的数据是否一致："+A.equals(B)+
                    ",A录入的是："+A+",B录入的是："+B);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        threadPool.shutdown();
    }
}
