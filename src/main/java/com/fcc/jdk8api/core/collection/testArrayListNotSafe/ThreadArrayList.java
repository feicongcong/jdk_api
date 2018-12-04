package com.fcc.jdk8api.core.collection.testArrayListNotSafe;

import java.util.ArrayList;
import java.util.Vector;

/**
 * @Description:
 * @Author: CC.F
 * @Date: 15:29 2018/12/4
 */
public class ThreadArrayList extends Thread {
    private ArrayList<Integer> arrayList;
    private Vector<Integer> vector;

    public ThreadArrayList(ArrayList<Integer> arrayList, Vector<Integer> vector) {
        this.arrayList = arrayList;
        this.vector = vector;
    }

    @Override
    public void run() {
        while (arrayList.size() < 10) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            arrayList.add(1);
            System.out.println(Thread.currentThread().getName() + " arrayList " +"实际size"+ arrayList.size());
            int vectorSize=vector.size()+1;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            vector.add(1);

            System.out.println(Thread.currentThread().getName() + " vector " +"应有size"+vectorSize+"实际size"+ vector.size());
        }

    }
}
