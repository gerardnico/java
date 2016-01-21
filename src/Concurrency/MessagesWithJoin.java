package Concurrency;

/**
 * Created by gerard on 19-01-2016.
 * <p>
 * Tutorial
 * See <a href="https://docs.oracle.com/javase/tutorial/essential/concurrency/sleep.html">Pausing Execution with Sleep</a>
 */
public class MessagesWithJoin implements Runnable {

    String importantInfo[] = {
            "Mares eat oats",
            "Does eat oats",
            "Little lambs eat ivy",
            "A kid will eat ivy too"
    };

    public static void main(String args[]) throws InterruptedException {

        Thread thread = new Thread(new MessagesWithJoin());
        thread.start();
        while (thread.isAlive()) {
            System.out.println("Main Thread - Waiting 1000 ms with a join method");
            thread.join(1000);
        }

    }

    @Override
    public void run() {

        for (int i = 0;
             i < importantInfo.length;
             i++) {
            //Pause for 2 seconds
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println("Sub Thread - The thread was interrupted");
            }
            //Print a message
            System.out.println("Sub Thread - "+importantInfo[i]);
        }

    }
}
