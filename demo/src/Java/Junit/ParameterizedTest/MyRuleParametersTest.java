package Java.Junit.ParameterizedTest;

import org.junit.ClassRule;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by gerard on 14-06-2016.
 */
public class MyRuleParametersTest {

    @ClassRule
    public static MyRuleParametersGenerator rule = new MyRuleParametersGenerator(Arrays.asList( "a", "b", "c" ));

    @Test
    public void someTest() {
        String s = rule.getParameter();
        System.out.println(s);
    }

    @Test
    public void someTest2() {
        String s = rule.getParameter();
        System.out.println(s);
    }
}
