package com.fcc.jdk8api.core.aop;

/**
 * @Description:
 * @Author: CC.F
 * @Date: 14:13 2018/12/5
 */
public class Test {
    public static void main(String[] args){
        //spring aop的实现是基于java的代理机制
        //切面（Aspect）：对象操作过程中的截面
        //连接点（Join point）对象操作过程中的某个阶段点
        //切入点（Point）连接点的集合
        //通知（Advice）某个切入点被横切后所采取的处理逻辑
        //目标对象（Target）所有被通知的对象(被代理对象)
        //织入（Weaving）将切面功能应用到目标对象的过程。由代理工厂创建一个代理对象，这个代理可以为目标对象执行切面功能
    }
}
