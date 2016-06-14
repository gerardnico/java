package Junit.ExternalResourceAsParameter;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 * Created by gerard on 13-06-2016.
 */
@RunWith(value = Parameterized.class)
public class MyParameterizedTest extends AbstractTest {


    // The set of test (and/of parameters) is declared below
    // The name argument below will be present in the Junit output
    @Parameterized.Parameters(name = "{index}: Resource {0}")
    public static Iterable<Object[]> data() {
        printInsideStatic("data\n");
        return resource.getIterable();

    }

    @ClassRule
    public static MyExternalResource resource = new MyExternalResource();

    String externalResource;


    public MyParameterizedTest(String externalResource) {
        this.externalResource = externalResource;
        printInsideObject("Constructor");
    }

    @Before
    public void before() {
        printInsideObject("before with Resource ("+externalResource+")");
    }

    @After
    public void after() {
        printInsideObject("after with Resource ("+externalResource+")");
    }

    @BeforeClass
    static public void beforeClass() {
        printInsideStatic("beforeClass");
    }

    @AfterClass
    static public void afterClass() {
        printInsideStatic("afterClass");
    }

    @Test
    public void testA() {
        printInsideObject("TestB with Resource ("+externalResource+")");
    }

    @Test
    public void testB() {
        printInsideObject("TestA with Resource ("+externalResource+")");
    }


    static void printInsideStatic(String log){
        AbstractTest.printInsideStatic(MyParameterizedTest.class, log) ;
    }



}

