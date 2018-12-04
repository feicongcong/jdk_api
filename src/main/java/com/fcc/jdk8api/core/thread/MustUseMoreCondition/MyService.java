package com.fcc.jdk8api.core.thread.MustUseMoreCondition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description:
 * @Author: CC.F
 * @Date: 18:09 2018/12/4
 */
public class MyService {
    private Lock lock = new ReentrantLock();
    public Condition conditionA = lock.newCondition();
    public Condition conditionB = lock.newCondition();

    public void awaitA() {
        try {
            lock.lock();
            System.out.println("begin await A" + System.currentTimeMillis() + "threadName: " + Thread.currentThread().getName());
            conditionA.await();
            System.out.println("end await A" + System.currentTimeMillis() + "threadName: " + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public void awaitB() {
        try {
            lock.lock();
            System.out.println("begin await B" + System.currentTimeMillis() + "threadName: " + Thread.currentThread().getName());
            conditionB.await();
            System.out.println("end await B" + System.currentTimeMillis() + "threadName: " + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void signalAll_a() {
        try {
            lock.lock();
            System.out.println("signALL A" + System.currentTimeMillis() + "threadName: " + Thread.currentThread().getName());
            conditionA.signalAll();

        } finally {
            lock.unlock();
        }
    }
    public void signalAll_b() {
        try {
            lock.lock();
            System.out.println("signALL b" + System.currentTimeMillis() + "threadName: " + Thread.currentThread().getName());
                conditionB.signalAll();

        } finally {
            lock.unlock();
        }
    }
}
