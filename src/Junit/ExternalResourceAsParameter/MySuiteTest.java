package Junit.ExternalResourceAsParameter;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.rules.ExternalResource;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by gerard on 13-06-2016.
 * We have only in the suite but it gives a good view of what happens
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        MyParameterizedTest.class
})
public class MySuiteTest {

    @BeforeClass
    static public void beforeClass() {
        MyPrints.printInsideStatic(MySuiteTest.class, "beforeClass");
    }

    @AfterClass
    static public void afterClass() {
        MyPrints.printInsideStatic(MySuiteTest.class, "afterClass");
    }

    @ClassRule
    public static ExternalResource resource = new MyExternalResourceRule();


}
