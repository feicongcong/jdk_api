package com.fcc.jdk8api.core.thread.threadLocal;

public class Test {
    //ThreadLocal 线程本地变量存储
    ThreadLocal<Long> longLocal = new ThreadLocal<Long>();
    ThreadLocal<String> stringLocal = new ThreadLocal<String>();
    ThreadLocal tl = new ThreadLocal();

     
    public void set() {
        longLocal.set(Thread.currentThread().getId());
        stringLocal.set(Thread.currentThread().getName());
    }
     
    public static void main(String[] args) throws InterruptedException {
        final Test test = new Test();
         
         
        test.set();
        test.tl.set("main-tl");
        System.out.println(test.longLocal.get());
        System.out.println(test.stringLocal.get());
        System.out.println(test.tl.get());

         
        Thread thread1 = new Thread(){
            public void run() {
                test.set();
                test.tl.set("thread1-tl");
                System.out.println(test.longLocal.get());
                System.out.println(test.stringLocal.get());
                System.out.println(test.tl.get());
            };
        };
        thread1.start();
        thread1.join();

        System.out.println(test.longLocal.get());
        System.out.println(test.stringLocal.get());
        System.out.println(test.tl.get());
    }
}