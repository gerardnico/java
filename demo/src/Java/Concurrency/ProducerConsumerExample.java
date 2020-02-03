package Java.Concurrency;

/**
 * Created by gerard on 21-01-2016.
 *
 * Producer Consumer design that demonstrates thread communication through a Guarded Block design
 * @see <a href="https://docs.oracle.com/javase/tutorial/essential/concurrency/guardmeth.html">Java Tuto - Guarded Blocks</a>
 *
 * A Producer Consumer  application shares data between two threads:
 *   * the {@link Producer producer}, that creates the data ({@link Message}),
 *   * and the {@link Consumer consumer}, that does something with it.
 * The two threads communicate using a shared object.
 *
 * Coordination is essential:
 *    * the consumer thread must not attempt to retrieve the data before the producer thread has delivered it,
 *    * and the producer thread must not attempt to deliver new data if the consumer hasn't retrieved the old data.
 *
 */
public class ProducerConsumerExample {
    public static void main(String[] args) {

        //  The Drop class demonstrate guarded blocks.
        Message message = new Message();

        (new Thread(new Producer(message))).start();

        (new Thread(new Consumer(message))).start();

    }
}
