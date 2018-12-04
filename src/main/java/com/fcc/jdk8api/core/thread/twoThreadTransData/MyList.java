package com.fcc.jdk8api.core.thread.twoThreadTransData;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: CC.F
 * @Date: 21:25 2018/12/4
 */
public class MyList {
    private List list=new ArrayList();
    public  void add(){
        list.add(1);
    }
    public int size(){
        return list.size();
    }
}
