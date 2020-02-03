package TestNG;

import org.testng.annotations.Test;

/**
 * Created by gerard on 14-06-2016.
 */

public abstract class ExternalResources {

    @Test(groups = {"init"})
    public void testDb() throws Exception {

        System.out.println("Set up the database");

    }

}
