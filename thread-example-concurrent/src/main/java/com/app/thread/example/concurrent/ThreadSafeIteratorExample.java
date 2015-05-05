package com.app.thread.example.concurrent;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by ke on 2015/5/5.
 *
 * Java集合类都是快速失败的，这就意味着当集合被改变且一个线程在使用迭代器遍历集合的时候，迭代器的next()方法将抛出ConcurrentModificationException异常。
 * 并发容器支持并发的遍历和并发的更新。
 * 主要的类有ConcurrentHashMap, CopyOnWriteArrayList 和CopyOnWriteArraySet
 */
public class ThreadSafeIteratorExample {

    public static void main(String[] args) {
        List<String> myList = new CopyOnWriteArrayList<String>();

        myList.add("1");
        myList.add("2");
        myList.add("3");
        myList.add("4");
        myList.add("5");

        Iterator<String> it = myList.iterator();
        while(it.hasNext()){
            String value = it.next();
            System.out.println("List Value:"+value);
            if(value.equals("3")){
                myList.remove("4");
                myList.add("6");
                myList.add("7");
            }
        }
        System.out.println("List Size:"+myList.size());

        Map<String,String> myMap = new ConcurrentHashMap<String,String>();
        myMap.put("1", "1");
        myMap.put("2", "2");
        myMap.put("3", "3");

        Iterator<String> it1 = myMap.keySet().iterator();
        while(it1.hasNext()){
            String key = it1.next();
            System.out.println("Map Value:"+myMap.get(key));
            if(key.equals("1")){
                myMap.remove("3");
                myMap.put("4", "4");
                myMap.put("5", "5");
            }
        }

        System.out.println("Map Size:"+myMap.size());
    }
}
