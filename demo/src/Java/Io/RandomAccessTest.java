package Java.Io;



import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Created by gerard on 21-06-2016.
 */
public class RandomAccessTest {


    @Test
    public void randomAccessTest() throws IOException {

        File name = new File(Parameters.FILE_PATH_READ);
        RandomAccessFile f = new RandomAccessFile( name, "r" );
        int b;
        long checkSum = 0L;
        while ( (b=f.read()) != -1 )
            checkSum += b;

        System.out.println(checkSum);
    }

}
