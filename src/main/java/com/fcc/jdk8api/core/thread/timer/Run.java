package com.fcc.jdk8api.core.thread.timer;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

/**
 * @Description:
 * @Author: CC.F
 * @Date: 20:56 2018/12/4
 */
public class Run {
    public static void main(String[] args){
        //定时器类Timer:设置计划任务；TimerTask封装计划任务
        MyTask task=new MyTask();
        Date currentDate=getCurrentDate();
        System.out.println(currentDate);
        Date currentDate10=addSecond(getCurrentDate(),10);
        System.out.println(currentDate10);
        new Timer().schedule(task,currentDate10);

    }

    public static Date getCurrentDate() {
        return getCurrentCalendar().getTime();
    }
    public static Calendar getCurrentCalendar() {
        Calendar instance = Calendar.getInstance();
        return instance;
    }
    public static Date addSecond(Date date, int seconds) {
        if (null == date) {
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.SECOND, seconds);
        return calendar.getTime();
    }
}
