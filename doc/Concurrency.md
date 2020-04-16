# Java Demo - Concurrency (Parallel Work)

## Introduction
Java concurrency demo classes mostly taken from the [java concurrency tutorial](https://docs.oracle.com/javase/tutorial/essential/concurrency/index.html).

This class extends the [online documentation (gerardnico.com)](http://gerardnico.com/wiki/java/concurrency/).
 
## Thread Instantiation

  * [HelloThread](../src/test/java/Java/Concurrency/HelloThread.java) extends threads
  * [HelloRunnable](../src/test/java/Java/Concurrency/HelloRunnable.java) implements Runnable. This implementation is more general and must be used, because the Runnable object can subclass a class other than Thread.
   
## Thread Pause, Join and Interrupt

  * [MessagesSleep](../src/test/java/Java/Concurrency/MessagesSleep.java) shows a main thread pause
  * [MessagesWithJoin](../src/test/java/Java/Concurrency/MessagesWithJoin.java) shows a main thread pause with the join function
  * [MessagesWithInterrupt](../src/test/java/Java/Concurrency/MessagesWithInterrupt.java) shows how to catch a thread interruption
  
## Concurrency Problems

  * [Counter](../src/test/java/Java/Concurrency/Counter.java) shows a class with an [interleave problem (ie Interference)](http://gerardnico.com/wiki/concurrency/interference)
  * [Deadlock](../src/test/java/Java/Concurrency/Deadlock.java) shows a class with a deadlock caused by [Thread interference](http://gerardnico.com/wiki/concurrency/interference)
  
## Thread Communication (Synchronization)


### Thread Locks

  * [Deadlock](../src/test/java/Java/Concurrency/Deadlock.java) Example of Deadlock with implicit lock (monitor) caused by [Thread interference](http://gerardnico.com/wiki/concurrency/interference)
  * [SafeLock](../src/test/java/Java/Concurrency/SafeLock.java) Use of a [lock object](http://gerardnico.com/wiki/java/concurrency/locks) to resolve the [Deadlock example](../src/test/java/Java/Concurrency/Deadlock.java) 


### Guarded block
  * [ProducerConsumerExample](../src/test/java/Java/Concurrency/ProducerConsumerExample.java) that demonstrate a [guarded block](http://gerardnico.com/wiki/concurrency/guarded_block) design with the [Message](../src/test/java/Java/Concurrency/Message.java) shared data.
  * [ProducerConsumerWithBlockingQueue](../src/test/java/Java/Concurrency/ProducerConsumerWithBlockingQueue.java) that demonstrate a a [blocking queue](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/BlockingQueue.html) utilisation.

