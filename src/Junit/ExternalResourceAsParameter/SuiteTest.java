package Junit.ExternalResourceAsParameter;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.rules.ExternalResource;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by gerard on 13-06-2016.
 */
@RunWith( Suite.class )
@Suite.SuiteClasses( {
        MyParameterizedTest.class,
        Tests2Test.class,
} )
public class SuiteTest {

    @BeforeClass
    static public void beforeClass() {
        println("beforeClass");
    }

    @AfterClass
    static public void afterClass() {
        println("afterClass");
    }

    @ClassRule
    public static ExternalResource resource = new MyExternalResource();

    static void println(String log){
        System.out.println(SuiteTest.class.getSimpleName()+", "+ log + " (static)") ;
    }

}
