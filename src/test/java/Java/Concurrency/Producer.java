package Java.Concurrency;

/**
 * Created by gerard on 21-01-2016.
 * <p>
 * The producer of the {@link Java.Concurrency.ProducerConsumerExample}
 *
 * @see <a href="https://docs.oracle.com/javase/tutorial/essential/concurrency/guardmeth.html">Java Tuto - Guarded Blocks</a>
 */

import java.util.Random;

public class Producer implements Runnable {

    private Message message;

    public Producer(Message message) {
        this.message = message;
    }

    public void run() {

        String importantInfo[] = {
                "Mares eat oats",
                "Does eat oats",
                "Little lambs eat ivy",
                "A kid will eat ivy too"
        };

        Random random = new Random();

        for (int i = 0; i < importantInfo.length; i++) {

            message.put(importantInfo[i]);

            // Sleep is not really needed
            // But shows that with random Time
            // The guarded block design works
            try {
                Thread.sleep(random.nextInt(5000));
            } catch (InterruptedException e) {
            }
        }

        message.put("DONE");

    }
}
