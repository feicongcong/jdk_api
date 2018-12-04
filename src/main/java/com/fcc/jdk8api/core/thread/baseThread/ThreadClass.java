package com.fcc.jdk8api.core.thread.baseThread;

/**
 * @Description:
 * @Author: CC.F
 * @Date: 17:31 2018/11/30
 */

/**
 * https://blog.csdn.net/haozhugogo/article/details/55050681
 *  1、新建状态（New）：新创建了一个线程对象。
 * 2、就绪状态（Runnable）：线程对象创建后，其他线程调用了该对象的start()方法。该状态的线程位于可运行线程池中，变得可运行，等待获取CPU的使用权。
 * 3、运行状态（Running）：就绪状态的线程获取了CPU，执行程序代码。
 * 4、阻塞状态（Blocked）：阻塞状态是线程因为某种原因放弃CPU使用权，暂时停止运行。直到线程进入就绪状态，才有机会转到运行状态。阻塞的情况分三种：
 * （一）、等待阻塞：运行的线程执行wait()方法，JVM会把该线程放入等待池中。(wait会释放持有的锁)
 * （二）、同步阻塞：运行的线程在获取对象的同步锁时，若该同步锁被别的线程占用，则JVM会把该线程放入锁池中。
 * （三）、其他阻塞：运行的线程执行sleep()或join()方法，或者发出了I/O请求时，JVM会把该线程置为阻塞状态。当sleep()状态超时、join()等待线程终止或者超时、或者I/O处理完毕时，线程重新转入就绪状态。（注意,sleep是不会释放持有的锁）
 * 5、死亡状态（Dead）：线程执行完了或者因异常退出了run()方法，该线程结束生命周期。
 */
public class ThreadClass {
    //Thread implements Runnable
    //线程的生命周期:出生new,就绪start,执行run,等待wait,休眠sleep,死亡,阻塞
    //操作线程的方法（改变线程状态的方法）:
    // 休眠sleep(long millis),
    // 加入join(),
    // 停止stop()/中断(run()中用无限循环的方式，用一布尔值控制循环结束)
    public static void main(String[] args) {
        System.out.println(Thread.State.NEW);
        // 获得当前main函数所在线程

//        ThreadTest thread1=new ThreadTest();
//        System.out.println(thread1.getName());
//        thread1.start();
//        new Thread(new TestRunnable()).start();
        Object lock = new Object();
        Thread A = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    System.out.println("A 1");
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("A 2");
                    System.out.println("A 3");
                }
            }
        });
        A.start();
        Thread B = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    System.out.println("B 1");
                    System.out.println("B 2");
                    System.out.println("B 3");
                    lock.notify();
                }
            }
        });
        B.start();

    }
}
class ThreadTest extends Thread{
    private int count=10;
    @Override
    public void run(){
        while (true){
            System.out.println("thread:"+count);

            if(count--==0){
                if(count==8){
                    System.out.println("睡眠5s");
                    try {
                        //sleep()方法要加InterruptedException捕获
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                return;
            }
        }
    }
}

class TestRunnable implements Runnable{
    private int count=100;
    @Override
    public void run() {
        while (true){
            System.out.println("runnable:"+count);
            if(count++==110){
                return;
            }
        }
    }
}