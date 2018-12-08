package com.fcc.jdk8api.core.thread.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @Description:
 * @Author: CC.F
 * @Date: 15:35 2018/12/8
 */
public class CyclicBarrierTest {
    private static CyclicBarrier cb=new CyclicBarrier(2);

    public static void main(String[] args) {
        new Thread(){
            @Override
            public void run(){
                try {
                    cb.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
                System.out.println(1);
            }
        }.start();
        try {
            cb.await();
            System.out.println(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }

    }
}
