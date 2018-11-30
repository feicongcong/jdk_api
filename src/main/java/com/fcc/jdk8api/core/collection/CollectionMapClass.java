package com.fcc.jdk8api.core.collection;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @Description:
 * @Author: CC.F
 * @Date: 14:49 2018/11/30
 */
public class CollectionMapClass {
    public static void main(String[] args) {
        //根接口Map<K,V> 和 根接口Collection<E>(继承Iterable<E>接口)
        Collection<String> list = new ArrayList<>();
        //Collection<E>下的方法
        //boolean add(E e)
        list.add("cc");
        System.out.println(list);
        //boolean addAll(Collection<? extends E> c)
        Collection<String> addList = new ArrayList<>();
//        addList.add("aa");
        list.addAll(addList);
        System.out.println(list);
        //boolean clear()
//        list.clear();
        System.out.println(list);
        //boolean contains(Object o)
        System.out.println(list.contains("cc"));
        //boolean containsAll(Collection<?> c)
        Collection<String> containsList = new ArrayList<>();
        containsList.add("cc");
        System.out.println(list.containsAll(containsList));
        //boolean 	equals(Object o)
        System.out.println(list.equals(containsList));
        //boolean 	isEmpty()
        System.out.println(list.isEmpty());
        //Iterator<E> 	iterator() 返回在此 collection 的元素上进行迭代的迭代器
        Iterator<String> iterator= list.iterator();
        //boolean 	remove(Object o)
        list.remove("cc");
        System.out.println(list);
        Collection<Long> longList = new ArrayList<>();
        longList.add(new Long(1));
        System.out.println(longList);
        longList.remove(new Long(1));
        System.out.println(longList);
        //boolean 	removeAll(Collection<?> c)
        Collection<String> removeAllList = new ArrayList<>();
        removeAllList.add("cc");
        list.removeAll(removeAllList);
        System.out.println(list);
        //boolean 	retainAll(Collection<?> c) 仅保留此 collection 中那些也包含在指定 collection 的元素（可选操作）。
        list.add("aa");
        list.add("cc");
        Collection<String> retainAllList = new ArrayList<>();
        retainAllList.add("cc");
        list.retainAll(retainAllList);
        System.out.println(list);
        //int 	size()
        //Object[] 	toArray()
        //<T> T[]	toArray(T[] a)返回包含此 collection 中所有元素的数组；返回数组的运行时类型与指定数组的运行时类型相同。
        Collection<Object> objectList = new ArrayList<>();
        objectList.add("aa");
        objectList.add("bb");
        objectList.add("cc");
//        objectList.add(new Integer(1));
//        objectList.add(new Integer(2));
        System.out.println(objectList.toArray());
        System.out.println(Arrays.toString(objectList.toArray()));
        System.out.println(objectList.toArray(new String[0]));
//        System.out.println(objectList.toArray(new Integer[0]));

        //Map<K,V>下的方法
        Map<Long,Long> map=new HashMap<>();
        map.put(new Long(1),new Long(1));
        map.put(new Long(2),new Long(1));
        System.out.println(map);

        //void 	clear()从此映射中移除所有映射关系（可选操作）。
        //boolean 	containsKey(Object key)如果此映射包含指定键的映射关系，则返回 true。
        //boolean 	containsValue(Object value)如果此映射将一个或多个键映射到指定值，则返回 true。
        //Set<Map.Entry<K,V>> 	entrySet()返回此映射中包含的映射关系的 Set 视图。
        Set<Map.Entry<Long,Long>> set=map.entrySet();
        for(Map.Entry<Long,Long> item : map.entrySet()){
            System.out.println(item.getKey()+":"+item.getValue());
        }
        //boolean 	equals(Object o)比较指定的对象与此映射是否相等。
        //V 	get(Object key)返回指定键所映射的值；如果此映射不包含该键的映射关系，则返回 null。
        //int 	hashCode()返回此映射的哈希码值。
        //boolean 	isEmpty()如果此映射未包含键-值映射关系，则返回 true。
        //Set<K> 	keySet()返回此映射中包含的键的 Set 视图。
        //V 	put(K key, V value)将指定的值与此映射中的指定键关联（可选操作）。
        //void 	putAll(Map<? extends K,? extends V> m)从指定映射中将所有映射关系复制到此映射中（可选操作）。
        //V 	remove(Object key)如果存在一个键的映射关系，则将其从此映射中移除（可选操作）。
        System.out.println(map.remove(new Long(1)));
        //int 	size()返回此映射中的键-值映射关系数。
        //Collection<V> 	values()返回此映射中包含的值的 Collection 视图。
    }

}
