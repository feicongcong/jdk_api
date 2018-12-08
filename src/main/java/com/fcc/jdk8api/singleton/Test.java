package com.fcc.jdk8api.singleton;

/**
 * @Description:
 * @Author: CC.F
 * @Date: 13:54 2018/12/8
 */
public class Test {
    public static void main(String[] args){
//        Singleton2 singleton1=Singleton2.getInstance();
        Singleton6 singleton6=Singleton6.INSTANCE;
        singleton6.method1();
    }

}

/**
 * 第二种（懒汉，线程安全）
 * 这种写法能够在多线程中很好的工作，而且看起来它也具备很好的lazy loading，但是，遗憾的是，效率很低，99%情况下不需要同步
 */
class Singleton2{
    private static Singleton2 instance;
    private Singleton2(){}
    public synchronized static Singleton2 getInstance(){
        if(instance==null){
            instance=new Singleton2();
        }
        return instance;
    }
}

/**
 * 第三种（饿汉）
 * 这种方式基于classloder机制避免了多线程的同步问题，不过，instance在类装载时就实例化，
 * 虽然导致类装载的原因有很多种，在单例模式中大多数都是调用getInstance方法，
 * 但是也不能确定有其他的方式（或者其他的静态方法）导致类装载，这时候初始化instance显然没有达到lazy loading的效果
 */
class Singleton3{
    private static Singleton3 instance=new Singleton3();
    private Singleton3(){}
    public static Singleton3 getInstance(){
        return instance;
    }
}

/**
 * 第五种（静态内部类）线程安全：
 */
class Singleton5{
    private static class SingletonHolder{
        private static Singleton5 instance=new Singleton5();
    }
    public Singleton5(){}
    public static Singleton5 getInstance(){
        return SingletonHolder.instance;
    }
}


/**
 * 第七种（双重校验锁/双重锁懒汉模式(Double Check Lock)）线程安全
 */
class Singleton7{
    private volatile static Singleton7 instance;
    private Singleton7(){}
    public static Singleton7 getInstance(){
        if(instance==null){
            synchronized (Singleton7.class){
                if(instance==null){
                    instance=new Singleton7();
                }
            }
        }
        return instance;
    }
}