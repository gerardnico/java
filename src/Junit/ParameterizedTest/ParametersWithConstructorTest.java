package Junit.ParameterizedTest;

/**
 * Created by gerard on 13-06-2016.
 * See <a href="https://github.com/junit-team/junit4/wiki/Parameterized-tests">Parametrized tests</a>
 */
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.IOException;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * Created by gerard on 29-05-2016.
 */
@RunWith(value = Parameterized.class)
public class ParametersWithConstructorTest {


    // The set of test (and/of parameters) is declared below
    // The name argument below will be present in the Junit output
    @Parameterized.Parameters(name = "{index}: sub({1}-{2})={3}, add({1}+{2})={4}")
    public static Iterable<Object[]> data1() {
        return Arrays.asList(new Object[][]{
                {1, 1, 1, 0, 2},
                {2, 2, 2, 0, 4},
                {3, 8, 2, 6, 10},
                {4, 4, 5, -1, 9}
        });
    }

    // The test in the ParametersTest class
    // will be run several times with different set of the below field (Named parameters)
    private int testId;
    private int numberA;
    private int numberB;
    private int subtractionExpected;
    private final int additionExpected;

    // The Parameters are passed and initialized via this constructor
    public ParametersWithConstructorTest(int testId, int numberA, int numberB, int subtractionExpected, int additionExpected) {
        System.out.println("\nConstructor test "+testId+"\n");
        this.testId =  testId;
        this.numberA = numberA;
        this.numberB = numberB;
        this.subtractionExpected = subtractionExpected;
        this.additionExpected = additionExpected;
    }


    @Test
    public void test_subtraction() {
        System.out.println("test_substraction: test "+testId);
        assertEquals(subtractionExpected, numberA - numberB);
    }

    @Test
    public void test_addition() {
        System.out.println("test_addition: test "+testId);
        assertEquals(additionExpected, numberA + numberB);
    }

    @Before
    public void before() throws IOException {

        System.out.println("Before test "+testId);

    }


    @After
    public void after() throws IOException {

        System.out.println("After test "+testId);

    }

    @BeforeClass
    static public void beforeClass() throws IOException {

        System.out.println("Before Class test ");

    }

    @AfterClass
    static public void afterClass() throws IOException {

        System.out.println("After Class test ");

    }


}