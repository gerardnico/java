package Java.Concurrency;

/**
 * Created by gerard on 19-01-2016.
 * <p>
 * Tutorial
 * See <a href="https://docs.oracle.com/javase/tutorial/essential/concurrency/interrupt.html">Interrupts</a>
 * <p>
 * {@link MessagesSleep} modified to support interrupts.
 */
public class MessagesWithInterrupt implements Runnable {

    private static final String[] IMPORTANT_INFO = new String[]{
            "Mares eat oats",
            "Does eat oats",
            "Little lambs eat ivy",
            "A kid will eat ivy too"
    };

    public static void main(String args[])
            throws InterruptedException {


        Thread thread = new Thread(new MessagesWithInterrupt());
        thread.start();
        long startTime = System.currentTimeMillis();
        while (thread.isAlive()) {
            System.out.println("Main Thread - Still waiting...");
            if (System.currentTimeMillis() - startTime > 6000 && thread.isAlive()) {
                System.out.println("Main Thread - I can't wait anymore");
                thread.interrupt();
            }
            thread.join(1000);
        }



    }

    @Override
    public void run() {

        for (int i = 0; i < IMPORTANT_INFO.length; i++) {

            // Pause for 4 seconds
            // Many methods that throw InterruptedException, such as sleep, are designed
            // to cancel their current operation and return immediately when an interrupt is received.
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println("Thread - We've been interrupted (Interrupted Exception): no more messages.");
                return;
            }

            // A thread may be interrupted with the interrupt method without throwing an InterruptedException exception
            // In this case, we need the Thread.interrupted function that returns true
            // if an interrupt has been received.
            if (Thread.interrupted()) {
                System.out.println("Thread - We've been interrupted (Interrupt function): no more messages.");
                // throw new InterruptedException();
                return;
            }

            // Print a message
            System.out.println("Thread - "+IMPORTANT_INFO[i]);
        }

    }
}
