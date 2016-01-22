package Jmx;

/**
 * Created by NicolasGERARD on 1/22/2016.
 *
 * @see <a href="https://docs.oracle.com/javase/tutorial/jmx/mbeans/standard.html">Java Tuto - Standard MBeans</a>
 *
 * A standard MBean is defined by writing:
 *    * a Java interface called SomethingMBean (The interface takes the name of the Java class that implements it, with the suffix MBean added.)
 *    * and a Java class called Something that implements that interface.
 *
 * This is the Hello MBean Interface
 *
 * Every method in the interface defines in the MBean either:
 *    * an (named and typed) attribute (that are readable and possibly writable)
 *    * or an (named and typed) operation (default)
 *
 * Attributes and operations are methods that follow certain design patterns.
 *    * Attributes: Getter and setter methods
 * A getter is any public method that does not return void and whose name begins with get.
 * A setter is any public method that takes a single parameter and whose name begins with set.
 *
 * @see {@link Hello the class Hello} for the implementation.
 *
 */
public interface HelloMBean {

    // Two operations
    public void sayHello();
    public int add(int x, int y);

    // Two attributes:
    //     * Name is a read-only string,
    //     * and CacheSize is an integer that can be both read and written.
    public String getName();
    public int getCacheSize();
    public void setCacheSize(int size);

}