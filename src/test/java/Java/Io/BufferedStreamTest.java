package Java.Io;

import org.junit.Test;

import java.io.*;

/**
 * Created by gerard on 20-06-2016.
 */
public class BufferedStreamTest {

    @Test
    public void bufferedInputStreamWithByteReadTest() throws IOException {


        BufferedInputStream f = new BufferedInputStream( BufferedStreamTest.class.getResourceAsStream(Parameters.FILE_RESOURCE_PATH));
        int b;
        long checkSum = 0L;
        while ( (b=f.read()) != -1 )
            checkSum += b;

        System.out.println(checkSum);

    }

    @Test
    public void bufferedInputStreamWithByteArrayTest() throws IOException {

        File name = new File(Parameters.FILE_PATH_READ);
        BufferedInputStream f = new BufferedInputStream(
                new FileInputStream( name ) );
        byte[] barray = new byte[Parameters.BUFFER_ARRAY_SIZE];
        long checkSum = 0L;
        int nRead;
        while ( (nRead=f.read( barray, 0, Parameters.BUFFER_ARRAY_SIZE )) != -1 )
            for ( int i=0; i<nRead; i++ )
                checkSum += barray[i];

        System.out.println(checkSum);
    }

}
