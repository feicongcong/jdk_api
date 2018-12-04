package com.fcc.jdk8api.core.thread.reentrantLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description:
 * @Author: CC.F
 * @Date: 14:36 2018/12/1
 */
public class SynchronizedThreadClass2 {
    public static void main(String[] args) {
        int ticketNum = 110;
        Thread t = new TicketThread(ticketNum);
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

class TicketThread extends Thread {

    private int ticketNum;

    public TicketThread(int ticketNum) {
        this.ticketNum = ticketNum;
    }

    @Override
    public void run() {
        Lock lock=new ReentrantLock();
        while (true) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.lock();
                if (ticketNum == 0) {
                    break;
                }
                ticketNum--;
                System.out.println("当前线程：" + Thread.currentThread().getName() + "当前票数：" + ticketNum);

            lock.unlock();
        }
    }

}
