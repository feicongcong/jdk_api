package com.fcc.jdk8api.core.thread.MustUseMoreCondition;

/**
 * @Description:
 * @Author: CC.F
 * @Date: 18:27 2018/12/4
 */
public class ThreadB extends Thread{
    private MyService service;

    public ThreadB(MyService service) {
        this.service = service;
    }

    @Override
    public void run(){
        service.awaitB();
    }

    
}
