package Junit.ExternalResourceAsParameter;

import org.junit.rules.ExternalResource;

import java.util.Arrays;
import java.util.List;

/**
 * Created by gerard on 13-06-2016.
 */
public class MyExternalResource extends ExternalResource {


    private static String externalResource1 = null;
    private static String externalResource2 = null;
    private static Integer counter =0;

    public MyExternalResource() {
        counter++;
        if (externalResource1 == null) {
            externalResource1 = "Database 1";
            externalResource2 = "Database 2";
            println("constructor, resource initialized");
        } else {
            println("constructor, resource already initialized");
        }
    }

    @Override
    protected void before() throws Throwable {

        println("before");

    }


    @Override
    protected void after() {

        if (counter > 1) {
            counter--;
            println("after, still ("+counter+") extra alive");
        } else {
            println("after, shutdown");
            externalResource1 = null;
            externalResource2 = null;
        }

    }

    public List getIterable() {

        return Arrays.asList(
            externalResource1, externalResource2
        );

    }

    
    void println(String log){
        System.out.println(this.getClass().getSimpleName()+", "+ log + " (object: "+this+")") ;
    }



}
