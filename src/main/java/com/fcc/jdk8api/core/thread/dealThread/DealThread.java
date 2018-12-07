package com.fcc.jdk8api.core.thread.dealThread;

/**
 * @Description:
 * @Author: CC.F
 * @Date: 23:49 2018/12/5
 */
public class DealThread implements Runnable {
    public String userName;
    public Object lock1=new Object();
    public Object lock2=new Object();
    public void setFlag(String userName){
        this.userName=userName;
    }


    @Override
    public void run() {
        if(userName.equals("a")){
            synchronized (lock1){
                System.out.println("userName= "+userName);
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock2){
                    System.out.println("按lock1->lock2代码顺序执行了");
                }
            }
        }
        if(userName.equals("b")){
            synchronized (lock2){
                System.out.println("userName= "+userName);
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock1){
                    System.out.println("按lock2->lock1顺序执行了");
                }
            }
        }

    }
}
