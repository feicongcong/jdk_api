package com.fcc.jdk8api.core.thread.lockMethod;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description:
 * @Author: CC.F
 * @Date: 19:35 2018/12/4
 */
public class Service {
     ReentrantLock lock = new ReentrantLock();

    public void serviceMethod1() {
        try {
            lock.lock();
            //查询当前线程保持此锁定的个数
            System.out.println("serviceMethod1 getHoldCount=" + lock.getHoldCount());
        } finally {
            lock.unlock();
            System.out.println("serviceMethod1 getHoldCount=" + lock.getHoldCount());
        }
    }

    public void serviceMethod2() {
        try {
            lock.lock();
            //查询当前线程保持此锁定的个数
            System.out.println("serviceMethod2 " + lock.getHoldCount());
            Thread.sleep(Integer.MAX_VALUE);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
