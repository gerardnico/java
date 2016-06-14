package Junit.ExternalResourceAsParameter;

/**
 * Created by gerard on 14-06-2016.
 */
public class AbstractTest {



    void printInsideObject(String log){
        System.out.println(this.getClass().getSimpleName()+", (object: "+this+") "+ log ) ;
    }

    static void printInsideStatic(Class claz, String log){
        System.out.println(claz.getSimpleName()+", (static) "+ log ) ;
    }

}
