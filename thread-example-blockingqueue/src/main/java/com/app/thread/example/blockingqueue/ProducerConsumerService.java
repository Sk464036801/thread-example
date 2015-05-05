package com.app.thread.example.blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by ke on 2015/5/5.
 *
 * 什么是阻塞队列？如何使用阻塞队列来实现生产者-消费者模型？
 *
 * java.util.concurrent.BlockingQueue的特性是：当队列是空的时，从队列中获取或删除元素的操作将会被阻塞，或者当队列是满时，
 * 往队列里添加元素的操作会被阻塞。 阻塞队列不接受空值，当你尝试向队列中添加空值的时候，它会抛出NullPointerException。
 * 阻塞队列的实现都是线程安全的，所有的查询方法都是原子的并且使用了内部锁或者其他形式的并发控制。
 * BlockingQueue接口是java collections框架的一部分，它主要用于实现生产者-消费者问题。
 *
 * http://www.journaldev.com/1034/java-blockingqueue-example-implementing-producer-consumer-problem
 *
 */
public class ProducerConsumerService {

    public static void main(String[] args) {
        //Creating BlockingQueue of size 10
        BlockingQueue<Message> queue = new ArrayBlockingQueue<Message>(10);
        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);
        //starting producer to produce messages in queue
        new Thread(producer).start();
        //starting consumer to consume messages from queue
        new Thread(consumer).start();
        System.out.println("Producer and Consumer has been started");
    }
}
