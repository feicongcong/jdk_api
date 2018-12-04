package com.fcc.jdk8api.core.thread.timer;

import java.util.Date;
import java.util.TimerTask;

/**
 * @Description:
 * @Author: CC.F
 * @Date: 21:03 2018/12/4
 */
public class MyTask extends TimerTask {

    @Override
    public void run() {
        System.out.println("运行；"+new Date());
    }
}
