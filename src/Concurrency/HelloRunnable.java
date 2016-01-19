package Concurrency;

/**
 * Created by gerard on 19-01-2016.
 *
 * Tutorial
 * See <a href=https://docs.oracle.com/javase/tutorial/essential/concurrency/runthread.html>Defining and Starting a Thread</a>
 *
 * This class implements the first methode (ie extending {@link Runnable}
 * {@link HelloThread} implements the second method
 */
public class HelloRunnable implements Runnable {

    public void run() {
        System.out.println("Hello from a thread implementing Runnable!");
    }

    public static void main(String args[]) {
        (new Thread(new HelloRunnable())).start();
    }

}