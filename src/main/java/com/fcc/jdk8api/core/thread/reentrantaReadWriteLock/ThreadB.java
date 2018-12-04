package com.fcc.jdk8api.core.thread.reentrantaReadWriteLock;


/**
 * @Description:
 * @Author: CC.F
 * @Date: 18:27 2018/12/4
 */
public class ThreadB extends Thread{
    private Service service;

    public ThreadB(Service service) {
        this.service = service;
    }

    @Override
    public void run(){
        service.read();
    }

    
}
