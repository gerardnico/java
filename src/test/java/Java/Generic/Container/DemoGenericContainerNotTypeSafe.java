package Java.Generic.Container;

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

        GenContainerType<String> genContainerTypeString = new GenContainerType<String>("nico");
        GenContainerType<Integer> genContainerTypeInteger = new GenContainerType<Integer>(1);

        // List that is not typesafe
        List<GenContainerType> genContainerTypeList = new ArrayList<GenContainerType>();
        genContainerTypeList.add(genContainerTypeString);
        genContainerTypeList.add(genContainerTypeInteger);

        System.out.println("We will get a java.lang.ClassCastException: java.lang.Integer cannot be cast to java.lang.String");
        try {
            for (GenContainerType<String> genContainerType1 : genContainerTypeList) {
                String value = genContainerType1.getValue();
                System.out.println(value);
            }
        } catch (ClassCastException e) {
            System.out.println("Error !: "+e.getMessage());
        }

        System.out.println("We will get no errors");
        for (GenContainerType<String> genContainerType1 : genContainerTypeList) {
            if (genContainerType1.getValue().getClass().equals(String.class)) {
                String value = genContainerType1.getValue();
                System.out.println(value);
            }
        }

    }
}


