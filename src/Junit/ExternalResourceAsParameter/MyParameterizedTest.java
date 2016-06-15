package Junit.ExternalResourceAsParameter;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 * Created by gerard on 13-06-2016.
 */
@RunWith(value = Parameterized.class)
public class MyParameterizedTest  {


    // The set of test (and/of parameters) is declared below
    // The name argument below will be present in the Junit output
    @Parameterized.Parameters(name = "{index}: Resource {0}")
    public static Iterable<Object[]> data() {
        printInsideStatic("data\n");
        return resource.getIterable();

    }

    @ClassRule
    public static MyExternalResourceRule resource = new MyExternalResourceRule();

    // Object because we got a string and a database Object
    Object externalResource;


    public MyParameterizedTest(Object externalResource) {
        this.externalResource = externalResource;
        MyPrints.printInsideObject(this,"Constructor\n");
    }

    @Before
    public void before() {
        MyPrints.printInsideObject(this,"before with Resource ("+externalResource+")");
    }

    @After
    public void after() {
        MyPrints.printInsideObject(this,"after with Resource ("+externalResource+")");
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
        MyPrints.printInsideObject(this,"TestB with Resource ("+externalResource+")");
    }

    @Test
    public void testB() {
        MyPrints.printInsideObject(this,"TestA with Resource ("+externalResource+")");
    }


    static void printInsideStatic(String log){
        MyPrints.printInsideStatic(MyParameterizedTest.class, log) ;
    }



}

