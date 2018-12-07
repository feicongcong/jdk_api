package com.fcc.jdk8api.core.thread.dealThread;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @Description:
 * @Author: CC.F
 * @Date: 23:58 2018/12/5
 */
public class Run {
    public static void main(String[] args) {
        try {
            DealThread t1 = new DealThread();
            t1.setFlag("a");
            new Thread(t1).start();

            Thread.sleep(100);
//            t1.setFlag("b");
//            new Thread(t1).start();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        AtomicBoolean b=new AtomicBoolean();
    }
}
