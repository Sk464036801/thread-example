package com.app.thread.example.lockandconcurrent;

/**
 * Created by ke on 2015/5/5.
 */
public class SynchronizedLockExample implements Runnable {
    private Resource resource;

    public SynchronizedLockExample(Resource r){
        this.resource = r;
    }

    @Override
    public void run() {
        synchronized (resource) {
            resource.doSomething();
        }
        resource.doLogging();
    }
}
