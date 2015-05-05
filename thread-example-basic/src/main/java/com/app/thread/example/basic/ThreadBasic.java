package com.app.thread.example.basic;


/**
 * Created by ke on 2015/5/2.
 */
public class ThreadBasic {

    public static void main(String[] args) {

        setCurrentThreadName();

    }

    /**
     * 线程名
     */
    private static void setCurrentThreadName() {
        String tname = Thread.currentThread().getName();

        System.out.println(" update before name = " + tname);

        Thread.currentThread().setName(tname+"-test");

        tname = Thread.currentThread().getName();

        System.out.println("updage after name = " + tname);

    }


}
