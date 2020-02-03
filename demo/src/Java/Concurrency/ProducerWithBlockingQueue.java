package Java.Concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.BlockingQueue;

/**
 * Created by gerard on 28-01-2016.
 * <p>
 *
 * @See <a href="http://docs.oracle.com/javase/8/docs/api/java/util/concurrent/BlockingQueue.html">Interface BlockingQueue<E></a>
 *
 * The producer of the {@link ConsumerWithBlockingQueue following consumer}.
 */
class ProducerWithBlockingQueue implements Runnable {

    private final BlockingQueue<List<Object>> queue;
    private int counter = 0;
    private int putCounter = 0;

    ProducerWithBlockingQueue(BlockingQueue<List<Object>> q) {
        queue = q;
    }

    public void run() {
        try {
            while (counter < 20) {
                queue.put(produce());
                putCounter++;
                if (counter % 5 == 0) {
                    Thread.sleep(1000);
                    System.out.println("putCounter:"+putCounter);
                }
            }
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }
        System.out.println("Producer Thread terminate and put: "+putCounter);
    }

    List<Object> produce() {
        Random random = new Random();

        ArrayList<Object> objects = new ArrayList<>();
        objects.add(counter++);
        objects.add("String "+ counter);
        return objects;

    }
}
