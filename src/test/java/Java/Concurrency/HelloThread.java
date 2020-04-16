package Java.Concurrency;

/**
 * Created by gerard on 19-01-2016.
 *
 * Tutorial
 * See <a href=https://docs.oracle.com/javase/tutorial/essential/concurrency/runthread.html>Defining and Starting a Thread</a>
 *
 *
 */
public class HelloThread extends Thread {

    public void run() {
        System.out.println("Hello from a thread extending Thread!");
    }

    public static void main(String args[]) {
        (new HelloThread()).start();
    }

}