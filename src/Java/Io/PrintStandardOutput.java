package Java.Io;

import java.io.IOException;

/**
 * Created by gerard on 22-06-2016.
 *
 *
 */
public class PrintStandardOutput {


    public static void main(String[] args) throws IOException {

        System.out.println(PrintStandardOutput.class.getSimpleName()+", a stdout message");
        System.err.println(PrintStandardOutput.class.getSimpleName()+", a stderr message");

    }

}
