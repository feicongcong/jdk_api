package com.fcc.jdk8api.core;

import com.fcc.jdk8api.Cc;
import lombok.Data;

/**
 * @Description:
 * @Author: CC.F
 * @Date: 16:10 2018/11/25
 */
public class ObjectClass extends Object {
    public static void main(String[] args) {
        Object obj = new Object();
        //Object类包括clone(),equals(),finalize(),getClass(),hashCode(),notify(),notifyAll(),toString(),wait()方法
        //返回对象执行时的实例
        obj.getClass();
        System.out.println(obj);//java.lang.Object@68f7aae2,每个类如果没有重写toString()函数的话，默认是返回该类的名称 + “@” + 该对象hashCode值得十六进制数字
        System.out.println(obj.hashCode());//1761061602
        System.out.println(obj.getClass());//class java.lang.Object
        System.out.println(obj.getClass().toString());//class java.lang.Object
        System.out.println(obj.getClass().getName());//java.lang.Object
        Cc c=new Cc();
        System.out.println(c);
        Que q=new Que();
        System.out.println(q);
        //内部类调用
        new ObjectClass().new Quee().cc();

        //上转型（隐式转型）
        //下转型（显式转型，创建时的实例必须为子类，否则报错）
        Que que=new Que1();
        System.out.println(que instanceof Que);
        if(que instanceof Que1) {
            Que1 que1 = (Que1) que;
            System.out.println(que1);
        }
    }
    class Quee{
        private String cc;
        public void cc(){

        }
    }

}

/**
 * 一个.java文件可写多个class类,编译后,生成 了两个文件Demo3.class,Demo4.class
 */
@Data
class Que{
    private String cc;
}
@Data
class Que1 extends Que{
    private String cc1;
}