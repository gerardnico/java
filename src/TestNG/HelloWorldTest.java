package TestNG;

import org.testng.annotations.Test;

/**
 * Created by gerard on 14-06-2016.
 */
@Test(dependsOnGroups = { "init" })
public class HelloWorldTest extends ExternalResources{


    public HelloWorldTest() {
        System.out.println("Hello World from constructor");
    }

    public void test2Test() {


        System.out.println("Hello World from testBasic");


    }

    public void test1Test() {


        System.out.println("Hello World from test1");


    }

}
