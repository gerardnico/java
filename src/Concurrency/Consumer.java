package Concurrency;

/**
 * Created by gerard on 21-01-2016.
 * <p>
 * The consumer of the {@link Concurrency.ProducerConsumerExample}
 *
 * @see <a href="https://docs.oracle.com/javase/tutorial/essential/concurrency/guardmeth.html">Java Tuto - Guarded Blocks</a>
 */

import java.util.Random;

public class Consumer implements Runnable {

    private Message message;

    public Consumer(Message message) {
        this.message = message;
    }

    public void run() {

        Random random = new Random();
        for (String message = this.message.take();!message.equals("DONE");message = this.message.take()) {
            System.out.format("MESSAGE RECEIVED: %s%n", message);

            // Sleep is not really needed
            // But shows that with random Time
            // The guarded block design works
            try {
                Thread.sleep(random.nextInt(5000));
            } catch (InterruptedException e) {
            }
        }
    }
}
