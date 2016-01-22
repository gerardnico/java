package Jmx;

/**
 * Created by NicolasGERARD on 1/22/2016.
 * <p>
 * The standard MBean implementation of {@link HelloMBean}.
 *
 * @see <a href="https://docs.oracle.com/javase/tutorial/jmx/mbeans/standard.html">Java Tuto - Standard MBeans</a>
 */
public class Hello implements HelloMBean {

    private final String name = "Reginald";
    private int cacheSize = DEFAULT_CACHE_SIZE;
    private static final int DEFAULT_CACHE_SIZE = 200;

    public void sayHello() {
        System.out.println("hello, world");
    }

    public int add(int x, int y) {
        return x + y;
    }

    public String getName() {
        return this.name;
    }

    public int getCacheSize() {
        return this.cacheSize;
    }

    public synchronized void setCacheSize(int size) {

        this.cacheSize = size;
        System.out.println("Cache size now " + this.cacheSize);

    }


}
