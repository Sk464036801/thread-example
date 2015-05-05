package com.app.thread.example.lockandconcurrent;

/**
 * Created by ke on 2015/5/5.
 */
public class Resource {
    public void doSomething(){
        //do some operation, DB read, write etc
    }

    public void doLogging(){
        //logging, no need for thread safety
    }
}
