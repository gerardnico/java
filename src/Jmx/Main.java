package Jmx;

/**
 * Created by NicolasGERARD on 1/22/2016.
 */
import java.lang.management.*;
import javax.management.*;

public class Main {

    public static void main(String[] args) throws Exception {

        // A JMX Agent is just a process that starts a MBean Server.
        // Getting the server
        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();

        // Construct an (JMX) object name from the given string.
        ObjectName name = new ObjectName("com.example:type=Hello");

        // Register it
        Hello mbean = new Hello();
        mbs.registerMBean(mbean, name);

        // And the process never end
        System.out.println("Waiting forever...");
        Thread.sleep(Long.MAX_VALUE);

    }
}