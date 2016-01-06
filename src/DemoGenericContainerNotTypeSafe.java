import java.util.ArrayList;
import java.util.List;

/**
 * Created by gerard on 06-01-2016.
 *
 * This class will demonstrate that the default Collection (List, Map, ...) construction
 * are not typeSafe
 */
public class DemoGenericContainerNotTypeSafe {

    public static void main(String[] args) {

        GenType<String> genTypeString = new GenType<String>("nico");
        GenType<Integer> genTypeInteger = new GenType<Integer>(1);

        // List that is not typesafe
        List<GenType> genTypeList = new ArrayList<GenType>();
        genTypeList.add(genTypeString);
        genTypeList.add(genTypeInteger);

        System.out.println("We will get a java.lang.ClassCastException: java.lang.Integer cannot be cast to java.lang.String");
        try {
            for (GenType<String> genType1 : genTypeList) {
                String value = genType1.getValue();
                System.out.println(value);
            }
        } catch (ClassCastException e) {
            System.out.println("Error !: "+e.getMessage());
        }

        System.out.println("We will get no errors");
        for (GenType<String> genType1 : genTypeList) {
            if (genType1.getValue().getClass().equals(String.class)) {
                String value = genType1.getValue();
                System.out.println(value);
            }
        }

    }
}


