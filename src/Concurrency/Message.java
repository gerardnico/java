package Concurrency;

/**
 * Created by gerard on 21-01-2016.
 *
 * @see <a href="https://docs.oracle.com/javase/tutorial/essential/concurrency/guardmeth.html">Java Tuto - Guarded Blocks</a>
 *
 * The shared data of the {@link ProducerConsumerExample}.
 *
 * The Message class was written in order to demonstrate guarded blocks.
 * To avoid re-inventing the wheel, examine the existing data structures in the Java Collections Framework
 * before trying to code your own data-sharing objects.
 *
 * @See <a href="http://gerardnico.com/wiki/java/concurrency/queue">Queues with Concurrency implementation</a>
 */
public class Message {

    // Message sent from producer
    // to consumer.
    private String message;

    // True if consumer should wait
    // for producer to send message,
    // false if producer should wait for
    // consumer to retrieve message.
    private boolean messageFieldIsEmpty = true;

    public synchronized String take() {

        // Wait until message is available (ie no more empty, null)
        while (messageFieldIsEmpty) {
            try {
                wait();
            } catch (InterruptedException e) {}
        }
        // Toggle status.
        messageFieldIsEmpty = true;
        // Notify producer that status has changed.
        notifyAll();
        return message;

    }

    public synchronized void put(String message) {

        // Wait until message has been retrieved.
        while (!messageFieldIsEmpty) {
            try {
                wait();
            } catch (InterruptedException e) {}
        }
        // Toggle status.
        messageFieldIsEmpty = false;
        // Store message.
        this.message = message;
        // Notify consumer that status
        // has changed.
        notifyAll();

    }
}
