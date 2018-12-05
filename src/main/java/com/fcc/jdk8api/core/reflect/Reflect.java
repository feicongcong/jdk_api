package com.fcc.jdk8api.core.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/**
 * @Description:
 * @Author: CC.F
 * @Date: 11:54 2018/12/5
 */
public class Reflect {
    private String name;

    public Reflect(String name) {
        this.name = name;
    }

    public Reflect() {
    }

    public static void main(String[] args) throws Exception {
        Class class1=Reflect.class;
        System.out.println(class1);//class com.fcc.jdk8api.core.reflect.Reflect
        Class class2=new Reflect().getClass();
        System.out.println(class2);//class com.fcc.jdk8api.core.reflect.Reflect
        System.out.println(class2.getName());//com.fcc.jdk8api.core.reflect.Reflect
        System.out.println(class1==class2);//true


        System.out.println(class1.getPackage());//Package 	getPackage()获取此类的包
        System.out.println(class1.getSuperclass());//


        //构造方法
        //Constructor<?>[] 	getDeclaredConstructors()返回 Constructor 对象的一个数组，这些对象反映此 Class 对象表示的类声明的所有构造方法。
        Constructor[] constructorArr=class1.getConstructors();
        for(int i=0;i<constructorArr.length;i++){
            System.out.println(constructorArr[i].toString());
        }
        //Constructor<T> 	getDeclaredConstructor(Class<?>... parameterTypes)返回一个 Constructor 对象，该对象反映此 Class 对象所表示的类或接口的指定构造方法。
        Constructor constructor=class1.getDeclaredConstructor(String.class);
        Reflect reflect=(Reflect)constructor.newInstance("fcc");



        //Field[] 	getFields()返回一个包含某些 Field 对象的数组，这些对象反映此 Class 对象所表示的类或接口的所有可访问公共(public)字段
        //Field[] 	getDeclaredFields()返回 Field 对象的一个数组，这些对象反映此 Class 对象所表示的类或接口所声明的所有字段。
        System.out.println(class1.getDeclaredFields());
        Field[] declaredFields=class1.getDeclaredFields();
        for(int i=0;i< declaredFields.length;i++){
            System.out.println(declaredFields[i].toString());
        }

    }
}
