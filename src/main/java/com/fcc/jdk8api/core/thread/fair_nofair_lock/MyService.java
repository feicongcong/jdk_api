package com.fcc.jdk8api.core.thread.fair_nofair_lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description:
 * @Author: CC.F
 * @Date: 18:56 2018/12/4
 */
public class MyService {
    private ReentrantLock lock;
    public MyService(boolean isFair){
        lock=new ReentrantLock(isFair);
    }
    public void serviceMethod(){
        try {
            lock.lock();
            System.out.println("threadName " + Thread.currentThread().getName() + " 获得锁定");
        }finally{
            lock.unlock();
        }
    }

}
