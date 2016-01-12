package Time;

import java.util.Date;

/**
 * Created by gerard on 12-01-2016.
 * {@link java.util.Date} snippet
 */
public class DateDemo {

    public static void main(String[] args) {
        diff();
    }

    static void diff() {
        try {

            for (int i = 0; i < 10; i++) {

                Date startTime = new Date();
                int sleepTimeInMillis = 1000;
                Thread.sleep(sleepTimeInMillis);
                Date endTime = new Date();
                // the length of time in milliseconds
                long diff = endTime.getTime() - startTime.getTime();
                if (diff == sleepTimeInMillis) {
                    System.out.println("diff equal sleepTime: " + diff);
                } else {
                    System.out.println("diff is not equal to sleepTime: " + diff);
                }
            }


        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
