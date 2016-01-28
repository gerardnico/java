package Concurrency;

import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Created by gerard on 28-01-2016.
 *
 * @See <a href="http://docs.oracle.com/javase/8/docs/api/java/util/concurrent/BlockingQueue.html">Interface BlockingQueue<E></a>
 *
 * The consumer of the {@link ProducerWithBlockingQueue following producer} for a
 * {@link ProducerConsumerWithBlockingQueue producer consumer with blocking queue}
 *
 */
class ConsumerWithBlockingQueue implements Runnable {

    private final BlockingQueue<List<Object>> queue;
    private AtomicBoolean producerWorkIsDone;
    private int counter = 0;

    ConsumerWithBlockingQueue(BlockingQueue<List<Object>> q, AtomicBoolean producerWorkIsDone) {
        this.queue = q;
        this.producerWorkIsDone = producerWorkIsDone;
    }

    public void run() {
        try {
            while (!producerWorkIsDone.get()) {
                consume(queue.take());
                counter++;
                if (counter % 5 == 0) {
                    System.out.println("queueSize From Consumer:"+queue.size());
                    System.out.println("producerWorkIsDone For Consumer:"+producerWorkIsDone);
                    Thread.sleep(3000);
                }
                System.out.println("takeCounter:"+counter);
            }
        } catch (InterruptedException ex) {
            System.out.println("InterruptedException");
            throw new RuntimeException(ex);
        }
        System.out.println("Consumer Thread terminate and got: "+counter);
    }

    void consume(List<Object> x) {
        for (Object object : x) {
            //System.out.println(object.toString());
        }
    }
}