package com.app.thread.example.pool.example2;

import com.app.thread.example.pool.WorkerThread;

import java.util.concurrent.*;

/**
 * Created by ke on 2015/5/5.
 *
 * Executors class provide simple implementation of ExecutorService using ThreadPoolExecutor
 * but ThreadPoolExecutor provides much more feature than that. We can specify the number
 * of threads that will be alive when we create ThreadPoolExecutor instance and we can limit
 * the size of thread pool and create our own RejectedExecutionHandler implementation to handle
 * the jobs that can’t fit in the worker queue.
 *
 * http://www.journaldev.com/1069/java-thread-pool-example-using-executors-and-threadpoolexecutor
 */
public class WorkerPool {

    public static void main(String args[]) throws InterruptedException{
        //RejectedExecutionHandler implementation
        RejectedExecutionHandlerImpl rejectionHandler = new RejectedExecutionHandlerImpl();
        //Get the ThreadFactory implementation to use
        ThreadFactory threadFactory = Executors.defaultThreadFactory();
        //creating the ThreadPoolExecutor
        ThreadPoolExecutor executorPool = new ThreadPoolExecutor(2, 4, 10, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(2), threadFactory, rejectionHandler);
        //start the monitoring thread
        MyMonitorThread monitor = new MyMonitorThread(executorPool, 3);
        Thread monitorThread = new Thread(monitor);
        monitorThread.start();
        //submit work to the thread pool
        for(int i=0; i<10; i++){
            executorPool.execute(new WorkerThread("cmd"+i));
        }

        Thread.sleep(30000);
        //shut down the pool
        executorPool.shutdown();
        //shut down the monitor thread
        Thread.sleep(5000);
        monitor.shutdown();

    }

}
