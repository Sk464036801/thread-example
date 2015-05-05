package com.app.thread.example.lockandconcurrent;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by ke on 2015/5/5.
 *
 * As you can see that, I am using tryLock() method to make sure my thread waits only for definite time
 * and if it’s not getting the lock on object, it’s just logging and exiting. Another important point to
 * note is the use of try-finally block to make sure lock is released even if doSomething() method call
 * throws any exception.
 *
 * http://www.journaldev.com/2377/java-lock-example-and-concurrency-lock-vs-synchronized
 */
public class ConcurrencyLockExample implements Runnable {

    private Resource resource;
    private Lock lock;

    public ConcurrencyLockExample(Resource r){
        this.resource = r;
        this.lock = new ReentrantLock();
    }

    @Override
    public void run() {
        try {
            if(lock.tryLock(10, TimeUnit.SECONDS)){
                resource.doSomething();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally{
            //release lock
            lock.unlock();
        }
        resource.doLogging();
    }
}
