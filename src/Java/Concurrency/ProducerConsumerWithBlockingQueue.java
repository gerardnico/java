package Java.Concurrency;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Created by gerard on 28-01-2016.
 *
 * @See <a href="http://docs.oracle.com/javase/8/docs/api/java/util/concurrent/BlockingQueue.html">Interface BlockingQueue<E></a>
 * <p>
 * The producer consumer process.
 */
public class ProducerConsumerWithBlockingQueue {

    public static void main(String[] args) throws InterruptedException {

        AtomicBoolean producerWorkIsDone = new AtomicBoolean(false);

        // SomeQueueImplementation
        BlockingQueue<List<Object>> q = new ArrayBlockingQueue<List<Object>>(20);
        ProducerWithBlockingQueue p = new ProducerWithBlockingQueue(q);
        ConsumerWithBlockingQueue c1 = new ConsumerWithBlockingQueue(q,producerWorkIsDone);
        ConsumerWithBlockingQueue c2 = new ConsumerWithBlockingQueue(q,producerWorkIsDone);
        Thread tp1 = new Thread(p);
        tp1.start();
        Thread tc1 = new Thread(c1);
        Thread tc2 = new Thread(c2);
        tc1.start();
        tc2.start();

        tp1.join();
        System.out.println("tp1 has joined");
        producerWorkIsDone.set(true);
        System.out.println("Producer work is done");

        System.out.println("Waiting consumers");
        tc1.join();
        System.out.println("tc1 has joined");
        tc2.join();
        System.out.println("tc2 has joined");


    }

}
