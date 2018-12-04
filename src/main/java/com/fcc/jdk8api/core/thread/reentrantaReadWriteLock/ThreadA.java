package com.fcc.jdk8api.core.thread.reentrantaReadWriteLock;

import com.fcc.jdk8api.core.thread.reentrantaReadWriteLock.Service;

/**
 * @Description:
 * @Author: CC.F
 * @Date: 18:27 2018/12/4
 */
public class ThreadA extends Thread{
    private Service service;

    public ThreadA(Service service) {
        this.service = service;
    }

    @Override
    public void run(){
        service.read();
    }
}
