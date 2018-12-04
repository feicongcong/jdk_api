package com.fcc.jdk8api.core.executor;

import java.util.concurrent.*;

/**
 * @Description:
 * @Author: CC.F
 * @Date: 22:47 2018/12/4
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        Runnable myRunnable  = new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " run");
            }
        };

        //验证1核心线程数为6，最大线程数为10。超时时间为5秒
        //每个任务都是是直接启动一个核心线程来执行任务，一共创建了6个线程，不会放入队列中。
        // 8秒后线程池还是6个线程，核心线程默认情况下不会被回收，不收超时时间限制
//        ThreadPoolExecutor executor =
//                new ThreadPoolExecutor(6,
//                        10,
//                        5,
//                        TimeUnit.SECONDS,
//                        new SynchronousQueue<Runnable>());



        //验证2核心线程数为3，最大线程数为6。超时时间为5秒,队列是LinkedBlockingDeque
        //当任务数超过核心线程数时，会将超出的任务放在队列中，只会创建3个线程重复利用
//        ThreadPoolExecutor executor = new ThreadPoolExecutor(3,
//                6,
//                5,
//                TimeUnit.SECONDS,
//                new LinkedBlockingDeque<Runnable>());

        //验证3 核心线程数为3，最大线程数为6。超时时间为5秒,队列是SynchronousQueue
        //当队列是SynchronousQueue时，超出核心线程的任务会创建新的线程来执行，看到一共有6个线程。
        // 但是这些线程是费核心线程，收超时时间限制，
        // 在任务完成后限制超过5秒就会被回收。所以最后看到线程池还是只有三个线程。
//        ThreadPoolExecutor executor =
//                new ThreadPoolExecutor(3,
//                6,
//                        5,
//                        TimeUnit.SECONDS,
//                        new SynchronousQueue<Runnable>());


        //验证4 核心线程数是3，最大线程数是4，队列是LinkedBlockingDeque
        //LinkedBlockingDeque根本不受最大线程数影响。
        //但是当LinkedBlockingDeque有大小限制时就会受最大线程数影响了
        ThreadPoolExecutor executor =
                new ThreadPoolExecutor(3,
                        4,
                        5,
                        TimeUnit.SECONDS,
                        new LinkedBlockingDeque<Runnable>());

//        executor.execute(myRunnable);
//        executor.execute(myRunnable);
//        executor.execute(myRunnable);
        System.out.println("---先开三个---");
        System.out.println("核心线程数" + executor.getCorePoolSize());
        System.out.println("线程池数线程" + executor.getPoolSize());
        System.out.println("队列任务数" + executor.getQueue().size());
//        executor.execute(myRunnable);
//        executor.execute(myRunnable);
//        executor.execute(myRunnable);
//        System.out.println("---再开三个---");
//        System.out.println("核心线程数"+executor.getCorePoolSize());
//        System.out.println("线程池线程"+executor.getPoolSize());
//        System.out.println("队列任务数"+executor.getQueue().size());
//        Thread.sleep(8000);
//        System.out.println("---8秒之后---");
//        System.out.println("核心线程数"+executor.getCorePoolSize());
//        System.out.println("线程池线程"+executor.getPoolSize());
//        System.out.println("队列任务数"+executor.getQueue().size());
    }
}
