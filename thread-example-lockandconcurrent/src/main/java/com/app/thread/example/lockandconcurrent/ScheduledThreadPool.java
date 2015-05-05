package com.app.thread.example.lockandconcurrent;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by ke on 2015/5/5.
 */
public class ScheduledThreadPool {
    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);


        //schedule to run after sometime
        System.out.println("Current Time = "+new Date());
        for(int i=0; i<3; i++){
            Thread.sleep(1000);
            WorkerThread worker = new WorkerThread("do heavy processing");
            scheduledThreadPool.schedule(worker, 10, TimeUnit.SECONDS);
            // schedule task to execute at fixed rate
            /*
            *
            * scheduleAtFixedRate(Runnable command,long initialDelay,long period,TimeUnit unit)
            *
            * We can use this method to schedule a task to run after initial delay and then with
            * the given period. The time period is from the start of the first thread in the pool,
            * so if you are specifying period as 1 second and your thread runs for 5 second,
            * then the next thread will start executing as soon as the first worker thread finishes
            * it’s execution.
            *
            * */
//            scheduledThreadPool.scheduleAtFixedRate(worker, 0, 10, TimeUnit.SECONDS);

            /*
            *
            * scheduleWithFixedDelay(Runnable command,long initialDelay,long delay,TimeUnit unit)
            *
            * This method can be used to start the periodic execution with initial delay and then execute
            * with given delay. The delay time is from the time thread finishes it’s execution.
            * So if we have code like below:
            * */
//            scheduledThreadPool.scheduleWithFixedDelay(worker, 0, 1, TimeUnit.SECONDS);
        }

        //add some delay to let some threads spawn by scheduler
        Thread.sleep(30000);

        scheduledThreadPool.shutdown();
        while(!scheduledThreadPool.isTerminated()){
            //wait for all tasks to finish
        }
        System.out.println("Finished all threads");
    }
}
