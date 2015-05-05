package com.app.thread.example.feturetask;

import java.util.concurrent.Callable;

/**
 * Created by ke on 2015/5/5.
 */
public class MyCallable implements Callable<String> {

    private long waitTime;

    public MyCallable(int timeInMillis){
        this.waitTime=timeInMillis;
    }
    @Override
    public String call() throws Exception {
        Thread.sleep(waitTime);
        //return the thread name executing this callable task
        return Thread.currentThread().getName();
    }
}
