package com.fcc.jdk8api.core.thread.threadLocal.home_work;

/**
 * @Description:
 * @Author: CC.F
 * @Date: 11:19 2018/12/8
 */
public class Test {
    ThreadLocal tl=new ThreadLocal();
    ThreadLocal<Integer> tlInteger=new ThreadLocal<Integer>();
    public static void main(String[] args){
        method();
    }
    public static void method(){

        Test test=new Test();
        Thread t1=new Thread(){
          @Override
          public void run(){
              test.tl.set("fcc");
              System.out.println("t1线程："+test.tl.get());
              try {
                  Thread.sleep(1000);
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }
              System.out.println("t1线程："+test.tl.get());
          }
        };

        Thread t2=new Thread(){
            @Override
            public void run(){

                System.out.println("t2线程："+test.tl.get());
                test.tl.set("fcc2");
                System.out.println("t2线程："+test.tl.get());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        t1.start();
        t2.start();

    }
}
