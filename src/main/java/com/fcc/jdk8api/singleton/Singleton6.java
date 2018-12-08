package com.fcc.jdk8api.singleton;

/**
 * @Description: 枚举单例满足线程安全、序列化等标准
 * 枚举类本身就实现了单例
 * @Author: CC.F
 * @Date: 14:37 2018/12/8
 */
public enum Singleton6 {
    INSTANCE;
    public void method1(){
        System.out.println("cc");
    }
}
