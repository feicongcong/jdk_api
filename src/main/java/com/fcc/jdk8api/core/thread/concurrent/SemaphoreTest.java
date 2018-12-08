package com.fcc.jdk8api.core.thread.concurrent;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @Description:
 * @Author: CC.F
 * @Date: 17:23 2018/12/8
 */
public class SemaphoreTest {
    //控制并发线程数
    private static final int THREAD_COUNT = 30;
    private static ExecutorService threadPool = Executors.newFixedThreadPool(THREAD_COUNT);
    private static Semaphore s = new Semaphore(10);

    public static void main(String[] args) {
        for (int i = 0; i < THREAD_COUNT; i++) {
            int num=i;
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    try {

                        System.out.println("这是线程："+Thread.currentThread().getName()+" 准备那许可证");
                        Thread.sleep(100);
                        s.acquire();
                        System.out.println("线程："+Thread.currentThread().getName()+" 拿到许可证");
                        Thread.sleep(10000);
                        s.release();
                        System.out.println("线程："+Thread.currentThread().getName()+" 释放许可证");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        threadPool.shutdown();
    }
}
