package com.fcc.jdk8api.core.thread.MustUseMoreCondition.home_work;

/**
 * @Description:
 * @Author: CC.F
 * @Date: 12:16 2018/12/8
 */
public class ThreadB extends Thread {
    private TestService service;

    public ThreadB(TestService service) {
        this.service = service;
    }

    @Override
    public void run() {
        service.awaitB();
    }
}
