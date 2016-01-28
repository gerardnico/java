# Java Demo - Concurrency (Parallel Work)

## Introduction
Java concurrency demo classes mostly taken from the [java concurrency tutorial](https://docs.oracle.com/javase/tutorial/essential/concurrency/index.html).

This class extends the [online documentation (gerardnico.com)](http://gerardnico.com/wiki/java/concurrency/).
 
## Thread Instantiation

  * [HelloThread](HelloThread.java) extends threads
  * [HelloRunnable](HelloRunnable.java) implements Runnable. This implementation is more general and must be used, because the Runnable object can subclass a class other than Thread.
   
## Thread Pause, Join and Interrupt

  * [MessagesSleep](MessagesSleep.java) shows a main thread pause
  * [MessagesWithJoin](MessagesWithJoin.java) shows a main thread pause with the join function
  * [MessagesWithInterrupt](MessagesWithInterrupt.java) shows how to catch a thread interruption
  
## Concurrency Problems

  * [Counter](Counter.java) shows a class with an [interleave problem] (ie Interference)](http://gerardnico.com/wiki/concurrency/interference)
  * [Deadlock](Deadlock.java) shows a class with a deadlock caused by [Thread interference](http://gerardnico.com/wiki/concurrency/interference)
  
## Thread Communication

  * [ProducerConsumerExample](ProducerConsumerExample.java) that demonstrate a guarded block design with the [Message](Message.java) shared data.

## Thread Locks

  * [Deadlock](Deadlock.java) Example of Deadlock with implicit lock (monitor) caused by [Thread interference](http://gerardnico.com/wiki/concurrency/interference)
  * [SafeLock](Safelock.java) Use of a [lock object](http://gerardnico.com/wiki/java/concurrency/locks) to resolve the [Deadlock example](Deadlock.java) 
