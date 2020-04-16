package Java.Io;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by gerard on 22-06-2016.
 * <p>
 * From out\production\Java Demo, you can invoke it from the directory (out\production\Java Demo):
 * <p>
 * From a file:
 * <p>
 * type ..\..\..\res\Java\Io\xanadu.txt | java Java/Io/PrintStandardInput
 * <p>
 * or
 * <p>
 * java Java/Io/PrintStandardInput < ..\..\..\res\Java\Io\xanadu.txt
 * <p>
 * From a progam
 * <p>
 *     * With only stdout
 *
 * java Java/Io/PrintStandardOutput | java Java/Io/PrintStandardInput pipedExample suppressLog
 *
 *     * With Stderr and stdout:
 *
 * java Java/Io/PrintStandardOutput 2>&1 | java Java/Io/PrintStandardInput printAsIs suppressLog
 */
public class PrintStandardInput {


    public static void main(String[] args) throws IOException {

        // Just to suppress the println that gives nothing for the second example
        boolean suppressLog = false;

        // Print by default the text with one line by character
        boolean printAsIs = false;

        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("suppressLog")) {
                suppressLog = true;
            }
            if (args[i].equals("printAsIs")) {
                printAsIs = true;
            }
        }

        if (!suppressLog) {
            System.out.println(PrintStandardInput.class.getSimpleName() + " started with (" + args.length + ") arguments.");
        }


        if (System.in.available() == 0) {

            System.out.println(PrintStandardInput.class.getSimpleName() + " started without a standard input stream");

        } else {

            // Print the text as it is
            if (printAsIs) {

                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
                String input;
                while ((input = bufferedReader.readLine()) != null) {
                    System.out.println(PrintStandardInput.class.getSimpleName()+", "+input);
                }

            // Print one line by characters
            } else {

                BufferedInputStream bufferedInputStream = new BufferedInputStream(System.in);
                int input = bufferedInputStream.read();
                int counter = 1;

                while (input != -1) {
                    counter++;
                    System.out.println(counter + " - " + input + " char (" + (char) input + ")");
                    input = bufferedInputStream.read();
                }

            }
        }
    }

}
