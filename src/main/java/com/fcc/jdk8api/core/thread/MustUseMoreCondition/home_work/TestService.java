package com.fcc.jdk8api.core.thread.MustUseMoreCondition.home_work;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description:
 * @Author: CC.F
 * @Date: 11:51 2018/12/8
 */
public class TestService {
    private Lock lock=new ReentrantLock(false);
    private Condition conditionA=lock.newCondition();
    private Condition conditionB=lock.newCondition();

    public void awaitA(){
        try{
            lock.lock();
            System.out.println("开始await "+System.currentTimeMillis()+
            "当前线程： "+Thread.currentThread().getName());
            conditionA.await();
            System.out.println("线程signal "+System.currentTimeMillis()+
            "当前线程："+Thread.currentThread().getName());
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void awaitB(){
        try{
            lock.lock();
            System.out.println("开始await "+System.currentTimeMillis()+
                    "当前线程： "+Thread.currentThread().getName());
            conditionB.await();
            System.out.println("线程signal "+System.currentTimeMillis()+
                    "当前线程："+Thread.currentThread().getName());
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void signalAll_a(){
        try{
            lock.lock();
            conditionA.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public void signalAll_b(){
        try{
            lock.lock();
            conditionB.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
