package Java.Integer;

import org.junit.Test;

/**
 * Created by gerard on 17-06-2016.
 */
public class IntegerTest {

    /**
     * 3 means: 0 to 2
     */
    @Test(expected = java.lang.ArrayIndexOutOfBoundsException.class)
    public void initLength() {

        String[] anArray = new String[3];
        anArray[3]="Youou";

    }

}
