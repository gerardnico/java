package Java.Concurrency;

/**
 * Created by gerard on 21-01-2016.
 *
 * If a Counter object is referenced from multiple threads, interference between threads may prevent this from happening as expected.
 *
 * Interference happens when two operations, running in different threads, but acting on the same data, interleave.
 * This means that the two operations consist of multiple steps, and the sequences of steps overlap.
 *
 * It might not seem possible for operations on instances of Counter to interleave, since both operations on c
 * are single, simple statements. However, even simple statements can translate to multiple steps by the virtual machine.
 *
 *    * Retrieve the current value of c.
 *    * Increment the retrieved value by 1.
 *    * Store the incremented value back in c.
 *
 * Example of a particular interleaving where Thread A data operation is lost
 *
 *    Thread A: Retrieve c.
 *    Thread B: Retrieve c.
 *    Thread A: Increment retrieved value; result is 1.
 *    Thread B: Decrement retrieved value; result is -1.
 *    Thread A: Store result in c; c is now 1.
 *    Thread B: Store result in c; c is now -1.
 *    Thread A's result is lost, overwritten by Thread B.
 *
 */
class Counter {

    private int c = 0;

    /**
     *  Even simple statements can translate to multiple steps by the virtual machine.
     *
     *    * Retrieve the current value of c.
     *    * Increment the retrieved value by 1.
     *    * Store the incremented value back in c.
     */
    public void increment() {
        c++;
    }

    /**
     *  Even simple statements can translate to multiple steps by the virtual machine.
     *
     *    * Retrieve the current value of c.
     *    * Decrement the retrieved value by 1.
     *    * Store the incremented value back in c.
     */
    public void decrement() {
        c--;
    }

    public int value() {
        return c;
    }

}