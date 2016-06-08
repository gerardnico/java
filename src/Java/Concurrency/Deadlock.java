package Java.Concurrency;

/**
 * Created by gerard on 21-01-2016.
 *
 * @See <a href="https://docs.oracle.com/javase/tutorial/essential/concurrency/deadlock.html">Deadlock</a>
 *
 * A strict rule of courtesy is that when you bow to a friend, you must remain bowed until your friend has a chance to
 * return the bow. Unfortunately, this rule does not account for the possibility that two friends might bow to each other
 * at the same time.
 *
 * When Deadlock runs, it's extremely likely that both threads will block when they attempt to invoke bowBack.
 * Neither block will ever end, because each thread is waiting for the other to exit bow.
 *
 * You may start it two times if it doesn't lock the first time. When using an IDE, the compile operation may add
 * an additional time.
 */

public class Deadlock {

    static class Friend {

        private final String name;

        public Friend(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }

        public synchronized void bow(Friend bower) {

            System.out.format("\"%s\": my Friend %s"
                            + " has bowed to me!%n",
                    this.name, bower.getName());

            bower.bowBack(this);

        }

        public synchronized void bowBack(Friend bower) {

            System.out.format("\"%s\": my Friend %s"
                            + " has bowed back to me!%n",
                    this.name, bower.getName());

        }

    }

    public static void main(String[] args) {

        final Friend alphonse =
                new Friend("Alphonse");

        final Friend gaston =
                new Friend("Gaston");

        //  Two friends bow to each other at the same time.
        new Thread(new Runnable() {
            public void run() {
                alphonse.bow(gaston);
            }
        }).start();

        new Thread(new Runnable() {
            public void run() {
                gaston.bow(alphonse);
            }
        }).start();

    }
}

