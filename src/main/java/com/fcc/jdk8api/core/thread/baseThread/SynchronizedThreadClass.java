package com.fcc.jdk8api.core.thread.baseThread;

/**
 * @Description:
 * @Author: CC.F
 * @Date: 14:36 2018/12/1
 */
public class SynchronizedThreadClass {
    public static void main(String[] args) {
        Object lock = new Object();
        Object lock1 = new Object();
        Thread t = new Thread(new Runnable() {
            int i = 10;

            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1);

                        synchronized (lock) {
                            System.out.println("线程1开始");

                            if (i > 0) {

                                System.out.println("ticket——now" + i);

                                int temp = i - 1;
                                System.out.println("temp" + temp);
                                i = temp;
                                System.out.println("ticket" + i);
                                Thread.sleep(100);
                                System.out.println("线程1结束");
                            } else {
                                System.out.println("线程1结束");
                                break;
                            }

                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        Thread t1 = new Thread(new Runnable() {
            int i = 20;

            @Override
            public void run() {
                while (true) {
                    synchronized (lock) {
                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("线程2开始");

                        if (i > 0) {

                            System.out.println("ticket——now" + i);

                            int temp = i - 1;
                            System.out.println("temp" + temp);
                            i = temp;
                            System.out.println("ticket" + i);
                            System.out.println("线程2结束");
                        } else {
                            System.out.println("线程2结束");
                            break;
                        }
                    }
                }
            }
        });
//        new Thread(t).start();
//        new Thread(t).start();
//        new Thread(t).start();
//        new Thread(t).start();
        new Thread(t).start();
        new Thread(t1).start();
//        new Thread(t1).start();
//        new Thread(t1).start();
//        new Thread(t1).start();
//        new Thread(t1).start();
//        new Thread(t1).start();
    }
}
