package Java.Concurrency;

/**
 * Created by gerard on 19-01-2016.
 *
 * Tutorial
 * See <a href="https://docs.oracle.com/javase/tutorial/essential/concurrency/sleep.html">Pausing Execution with Sleep</a>
 */
public class MessagesSleep {
    public static void main(String args[])
            throws InterruptedException {
        String importantInfo[] = {
                "Mares eat oats",
                "Does eat oats",
                "Little lambs eat ivy",
                "A kid will eat ivy too"
        };

        for (int i = 0;
             i < importantInfo.length;
             i++) {
            //Pause for 2 seconds
            Thread.sleep(2000);
            //Print a message
            System.out.println(importantInfo[i]);
        }
    }
}
