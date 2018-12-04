package com.fcc.jdk8api.core.thread;

/**
 * @Description:
 * @Author: CC.F
 * @Date: 14:36 2018/12/1
 */
public class SynchronizedThreadClass {
    public static void main(String[] args) {
        Object lock =new Object();
        Thread t = new Thread(new Runnable() {
            int i = 20;

            @Override
            public void run() {
                while (true) {
                    synchronized (lock) {

                        if (i > 0) {
                            try {
                                Thread.sleep(100);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            System.out.println("ticket——now" + i);
                            try {
                                Thread.sleep(100);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            int temp=i-1;
                            System.out.println("temp"+temp);
                            i=temp;
                            System.out.println("ticket" + i);
                            try {
                                Thread.sleep(100);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        } else {
                            break;
                        }
                    }
                }
            }
        });
        new Thread(t).start();
        new Thread(t).start();
        new Thread(t).start();
        new Thread(t).start();
        new Thread(t).start();
        new Thread(t).start();
        new Thread(t).start();
        new Thread(t).start();
        new Thread(t).start();
        new Thread(t).start();
        new Thread(t).start();
    }
}
