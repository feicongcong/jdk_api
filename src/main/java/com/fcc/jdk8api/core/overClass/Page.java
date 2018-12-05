package com.fcc.jdk8api.core.overClass;

import java.util.List;

/**
 * @Description:
 * @Author: CC.F
 * @Date: 1:38 2018/12/5
 */
public class Page<T> {
    private List<T> list;


    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
