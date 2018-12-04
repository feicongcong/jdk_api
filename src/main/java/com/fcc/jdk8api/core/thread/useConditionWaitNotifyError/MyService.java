package com.fcc.jdk8api.core.thread.useConditionWaitNotifyError;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description:
 * @Author: CC.F
 * @Date: 17:41 2018/12/4
 */
public class MyService {
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();//对象监视器

    public void await() {
        try {
            //condition.await()之前获得同步监视器
            lock.lock();
            System.out.println("调用wait()");
            condition.await();
            System.out.println("调用signal()");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void signal() {
        try {
            lock.lock();
            condition.signal();
        }
        finally {
            lock.unlock();
        }
    }
}
