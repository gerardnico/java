package Java.Io;

import org.junit.Test;

import java.io.*;

/**
 * Created by gerard on 21-06-2016.
 */
public class FileReaderWriterTest {


    @Test
    public void CopyFileByCharacter() throws IOException {

        FileReader inputStream = null;
        FileWriter outputStream = null;

        try {

            inputStream = new FileReader(Parameters.FILE_PATH_READ);
            outputStream = new FileWriter(Parameters.FILE_PATH_WRITE);

            int c;
            int counterChar = 0;
            while ((c = inputStream.read()) != -1) {
                counterChar++;
                outputStream.write(c);
            }
            System.out.println("The file has ("+counterChar+") characters.");

        } finally {

            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }

        }


    }

    @Test
    public void CopyFileByLines() throws IOException {


        BufferedReader inputStream = null;
        BufferedWriter outputStream = null;

        try {

            inputStream = new BufferedReader(new FileReader(Parameters.FILE_PATH_READ));
            outputStream = new BufferedWriter(new FileWriter(Parameters.FILE_PATH_WRITE));

            String l;
            int counterLine = 0;
            while ((l = inputStream.readLine()) != null) {
                counterLine++;
                outputStream.write(l.toCharArray());
                outputStream.newLine();
            }

            System.out.println("The File has ("+counterLine+") lines.");

        } catch (FileNotFoundException e) {

            throw new RuntimeException(e);

        } catch (IOException e) {

            throw new RuntimeException(e);

        } finally {

            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }

        }
    }

}

