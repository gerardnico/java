package Java.Io;


import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by gerard on 20-06-2016.
 */
public class FileStreamTest {

    @Test
    public void fileInputStreamInByteTest() throws IOException {

        FileInputStream f = new FileInputStream(Parameters.FILE_PATH_READ);
        int b;
        long checkSum = 0L;
        while ((b = f.read()) != -1)
            checkSum += b;


    }

    // To reduce the synchronization overhead, read multiple bytes at once into a buffer array of bytes
    @Test
    public void fileInputStreamInBufferTest() throws IOException {


        FileInputStream f = new FileInputStream(Parameters.FILE_PATH_READ);
        byte[] barray = new byte[Parameters.BUFFER_ARRAY_SIZE];
        long checkSum = 0L;
        int nRead;
        while ((nRead = f.read(barray, 0, Parameters.BUFFER_ARRAY_SIZE)) != -1)
            for (int i = 0; i < nRead; i++)
                checkSum += barray[i];


    }

    @Test
    public void copyFiles() throws IOException {

        FileInputStream in = null;
        FileOutputStream out = null;

        try {
            in = new FileInputStream(Parameters.FILE_PATH_READ);
            out = new FileOutputStream(Parameters.FILE_PATH_WRITE);
            int c;

            while ((c = in.read()) != -1) {
                out.write(c);
            }
        } finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }
    }

}
