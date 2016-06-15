package Junit.ExternalResourceAsParameter;

/**
 * Created by gerard on 14-06-2016.
 *
 * Just to be able to print:
 *    * in an object
 *    * in a static class
 */
public class MyPrints {



    static void printInsideObject(Object o, String log){
        System.out.println(o.getClass().getSimpleName()+", (object: "+o+") "+ log ) ;
    }

    static void printInsideStatic(Class claz, String log){
        System.out.println(claz.getSimpleName()+", (static) "+ log ) ;
    }

}
