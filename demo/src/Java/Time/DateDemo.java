package Java.Time;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by gerard on 12-01-2016.
 * {@link java.util.Date} snippet
 */
public class DateDemo {

    public static void main(String[] args) throws InterruptedException {
        diff();
        equal();
    }

    static void diff() throws InterruptedException {


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


    }

    static void equal() throws InterruptedException {

        Date date1 = new Date();
        TimeUnit.SECONDS.sleep(2);
        Date date2 = new Date();

        if (date1.compareTo(date2) != 0) {
            System.out.println("The data are not equal");
        }
        if (!date1.equals(date2)) {
            System.out.println("The data are not equal");
        }

    }
}
