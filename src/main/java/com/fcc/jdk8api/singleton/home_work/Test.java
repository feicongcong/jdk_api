package com.fcc.jdk8api.singleton.home_work;

/**
 * @Description:
 * @Author: CC.F
 * @Date: 14:49 2018/12/8
 */
public class Test {
    public static void main(String[] args){

    }

}

class Singleton7{
    private volatile static Singleton7 instance;
    private Singleton7(){}
    public static Singleton7 getInstance(){
        if(instance==null){
            synchronized(Singleton7.class){
                if(instance==null){
                    instance=new Singleton7();
                }
            }
        }
        return instance;
    }
}