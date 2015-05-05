package com.app.thread.example.lockandconcurrent;

/**
 * Created by ke on 2015/5/5.
 *
 * If a thread enters foo(), it has the lock on Test object, so when it tries to execute bar() method,
 * the thread is allowed to execute bar() method since it’s already holding the lock on the Test object
 * i.e same as synchronized(this).
 */
public class Test {

    public synchronized void foo(){
        //do something
        bar();
    }

    public synchronized void bar(){
        //do some more
    }
}
