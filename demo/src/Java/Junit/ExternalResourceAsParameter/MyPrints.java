package Java.Junit.ExternalResourceAsParameter;

/**
 * Created by gerard on 14-06-2016.
 *
 * Just to be able to print:
 *    * in an object
 *    * in a static class
 */
public class MyPrints {



    static void printInsideObject(Object o, String log){
        String s = o.toString();
        String objectId;
        if (s.lastIndexOf("@")!=-1) {
            objectId = s.substring(s.lastIndexOf("@")+1);
        } else {
            objectId = s;
        }

        System.out.println(o.getClass().getSimpleName()+", (object: "+ objectId +") "+ log ) ;
    }

    static void printInsideStatic(Class claz, String log){
        System.out.println(claz.getSimpleName()+", (static method) "+ log ) ;
    }

}
