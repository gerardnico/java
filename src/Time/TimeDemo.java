package Time;

import java.time.LocalDate;

import static java.time.temporal.TemporalAdjusters.next;
import static java.time.DayOfWeek.FRIDAY;

/**
 * Created by gerard on 12-01-2016.

 * {@link java.time} snippet from
 * concepts, including:
 *    * instants: a numeric timestamp retrieved from a Clock for logging and persistence of a point in time,
 *    * durations: storage of periods and durations of time.
 *    * dates, times, time-zones and periods.
 *
 * Java Time is based on the ISO calendar system with Gregorian Rules
 * All the classes are immutable and thread-safe.
 *
 * Date printing and parsing is supported by each class See {@link java.time.format}
 */

public class TimeDemo {

    public static void main(String[] args) {
        // LocalDate is a date without a time, or any reference to an offset or time-zone
        LocalDate today = LocalDate.now();
        LocalDate offerExpiryDate = today.plusWeeks(2).with(next(FRIDAY));
        // diff = offerExpiryDate - today;

    }

    // Instant is essentially a numeric timestamp.
    // The current Instant can be retrieved from a Clock.
    // This is useful for logging and persistence of a point in time
    // and has in the past been associated with storing the result from System.currentTimeMillis().
    public void instant(){

    }
}
