package com.fcc.jdk8api.core.overClass;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: CC.F
 * @Date: 1:39 2018/12/5
 */
public class Test {
    private Class aClass=this.getClass();
    public static void main(String[] args)throws Exception{
        //泛型作用:定义安全类型；jdk5前对Object的引用任意化导致对象强转时发生类型转换异常
        Page<Integer> page=new Page<>();
        List<Integer>  list=new ArrayList<>();
        list.add(1);
        page.setList(list);
        System.out.println(page);
//        Class<?>[] cc=Page.class.getClasses();
        testMethod(Page.class);
    }

    public static  <T>  void testMethod( Class<T> c) throws Exception{
        T t=c.newInstance();
        System.out.println("vv");

    }
}
