package com.fcc.jdk8api.core.thread.baseThread;

/**
 * @Description:
 * @Author: CC.F
 * @Date: 14:27 2018/12/1
 */
public class YieldThreadClass {
    /**
     *  Java线程中的Thread.yield( )线程让步方法,当一个线程使用了这个方法之后，它就会把自己CPU执行的时间让掉，
     *  让自己或者其它的线程运行，注意是让自己或者其他线程运行，并不是单纯的让给其他线程。
     *
     *  yield()的作用是让步。它能让当前线程由“运行状态”进入到“就绪状态”，从而让其它具有相同优先级的等待线程获取执行权；但是，并不能保
     *  证在当前线程调用yield()之后，其它具有相同优先级的线程就一定能获得执行权；也有可能是当前线程又进入到“运行状态”继续运行！
     *
     *
     *      但是线程是有优先级的，优先级越高的人，就一定能第一个上车吗？这是不一定的，优先级高的人仅仅只是第一个上车的概率大了一点而已，
     *
     * 最终第一个上车的，也有可能是优先级最低的人。并且所谓的优先级执行，是在大量执行次数中才能体现出来的。
     *
     */
    public static void main(String[] args){
        Thread threada = new ThreadA();
        Thread threadb = new ThreadB();
        // 设置优先级:MIN_PRIORITY最低优先级1;NORM_PRIORITY普通优先级5;MAX_PRIORITY最高优先级10
        threada.setPriority(Thread.MIN_PRIORITY);
        threadb.setPriority(Thread.MAX_PRIORITY);

        threada.start();
        threadb.start();
    }
}
class ThreadA extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("ThreadA--" + i);
            Thread.yield();
        }
    }
}

class ThreadB extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("ThreadB--" + i);
            Thread.yield();
        }
    }
}
