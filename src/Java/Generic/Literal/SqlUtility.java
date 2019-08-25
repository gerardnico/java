package Java.Generic.Literal;

import java.util.ArrayList;
import java.util.Collection;

public class SqlUtility {

    /**
     *
     * @param genericFactory
     * @param query
     * @param <T>
     * @return
     */
    static public <T> Collection<T> get(GenericFactory<T> genericFactory, String query) {

        Collection<T> result = new ArrayList<T>();

        /* Run sql query using jdbc */
        /* Iterate over jdbc results. */
        for (int i=0;i<1;i++) {
            T item = genericFactory.make();
            /* Use reflection and set all of item's
             * fields from sql results.
             */
            result.add(item);
        }
        return result;
    }

    // It is natural to use the class literal as a factory object,
    // which can then be used by reflection.
    // Without generics) the code might be written
    // this would not give us a collection of the precise type we desir
    public static Collection selectWithoutGeneric(Class c, String query)  {
        Collection result = new ArrayList();
        /* Run sql query using jdbc. */
        /* Iterate over jdbc results. */
        for (int i=0;i<1;i++) {
            Object item = null;
            try {
                item = c.newInstance();
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
            /* Use reflection and set all of item's
             * fields from sql results.
             */
            result.add(item);
        }
        return result;
    }


    public static <T> Collection<T> selectWithGeneric(Class<T> c, String sqlStatement) {
        Collection<T> result = new ArrayList<T>();
        /* Run sql query using jdbc. */
        /* Iterate over jdbc results. */
        for (int i=0;i<1;i++) {
            T item = null;
            try {
                item = c.newInstance();
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
            /* Use reflection and set all of item's
             * fields from sql results.
             */
            result.add(item);
        }
        return result;
    }
}
