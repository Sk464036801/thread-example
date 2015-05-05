[Java Lock Example and Concurrency Lock vs synchronized](http://www.journaldev.com/2377/java-lock-example-and-concurrency-lock-vs-synchronized)


Some important interfaces and classes in Java Concurrency Lock API are:

1、Lock: This is the base interface for Lock API. It provides all the features of synchronized keyword
with additional ways to create different Conditions for locking, providing timeout for thread to wait for lock.
Some of the important methods are lock() to acquire the lock, unlock() to release the lock, tryLock() to wait for
lock for a certain period of time, newCondition() to create the Condition etc.

2、Condition: Condition objects are similar to Object wait-notify model with additional feature to create different
sets of wait. A Condition object is always created by Lock object. Some of the important methods are await() that
 is similar to wait() and signal(), signalAll() that is similar to notify() and notifyAll() methods.

3、ReadWriteLock: It contains a pair of associated locks, one for read-only operations and another one for writing. The
 read lock may be held simultaneously by multiple reader threads as long as there are no writer threads. The write lock is exclusive.

4、ReentrantLock: This is the most widely used implementation class of Lock interface. This class implements the
Lock interface in similar way as synchronized keyword. Apart from Lock interface implementation, ReentrantLock
contains some utility methods to get the thread holding the lock, threads waiting to acquire the lock etc.
synchronized block are reentrant in nature i.e if a thread has lock on the monitor object and if another
synchronized block requires to have the lock on the same monitor object then thread can enter that code block.
I think this is the reason for the class name to be ReentrantLock. Let’s understand this feature with a
simple example.

ReentrantLock <=> synchronized (keyword)

Condition <=> Object(wait and notify)
await <=> wait
signal(), signalAll <=> notify(), notifyAll()

* Lock vs synchronized

1、Lock provides more visibility and options for locking, unlike synchronized where a thread might end up waiting
indefinitely for the lock, we can use tryLock() to make sure thread waits for specific time only.

2、Synchronization code is much cleaner and easy to maintain whereas with Lock we are forced to have try-finally block
to make sure Lock is released even if some exception is thrown between lock() and unlock() method calls.

3、synchronization blocks or methods can cover only one method whereas we can acquire the lock in one method and
release it in another method with Lock API.

4、synchronized keyword doesn’t provide fairness whereas we can set fairness to true while creating ReentrantLock
object so that longest waiting thread gets the lock first.

5、We can create different conditions for Lock and different thread can await() for different conditions.

[Java Synchronization and Thread Safety Tutorial with Examples](http://www.journaldev.com/1061/java-synchronization-and-thread-safety-tutorial-with-examples)




