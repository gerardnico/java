package Junit.ExternalResourceAsParameter;

import org.junit.rules.ExternalResource;

import java.util.Arrays;
import java.util.List;

/**
 * Created by gerard on 13-06-2016.
 */
public class MyExternalResourceRule extends ExternalResource {


    private static String immutableExternalResource = null;
    private MyDatabase mutableExternalResource = new MyDatabase("Database");;
    private static Integer counter =0;


    /**
     * You need to initialize here your static immutable resources (ie that are not passed as pointer)
     */
    public MyExternalResourceRule() {

        counter++;
        if (immutableExternalResource == null) {
            immutableExternalResource = "Immutable Resource (String)";
            MyPrints.printInsideObject(this,"constructor, immutable resource created");
        } else {
            MyPrints.printInsideObject(this,"constructor, immutable resource already initialized");
        }
    }

    @Override
    protected void before() throws Throwable {

        if (mutableExternalResource.getStatus().equals("Not Open")) {
            mutableExternalResource.open();
            MyPrints.printInsideObject(this,"before, mutable resource open "+mutableExternalResource);
        } else {
            MyPrints.printInsideObject(this,"before, mutable resource already open "+mutableExternalResource);
        }


    }


    @Override
    protected void after() {

        if (counter > 1) {
            counter--;
            MyPrints.printInsideObject(this,"after, still ("+counter+") extra alive");
        } else {
            MyPrints.printInsideObject(this,"after, shutdown");
            immutableExternalResource = null;
            mutableExternalResource.close();
        }

    }

    public List getIterable() {

        return Arrays.asList(
                immutableExternalResource, mutableExternalResource
        );

    }





}
