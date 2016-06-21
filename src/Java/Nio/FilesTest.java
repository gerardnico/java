package Java.Nio;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.*;

/**
 * Created by gerard on 17-06-2016.
 */
public class FilesTest {

    @Test(expected = java.nio.file.NoSuchFileException.class)
    public void copy() throws IOException {
        Path readMeFile = Paths.get("README.md");
        Path targetFile = Paths.get("out","out","README.md");
        java.nio.file.Files.copy(readMeFile,targetFile);
    }

    @Test()
    public void copyWithFileCreation() throws IOException {

        Path readMeFile = Paths.get("README.md");
        Path targetFile = Paths.get("out","out","README.md");

        if (Files.notExists(targetFile)){
            if (Files.notExists(targetFile.getParent())){
                Files.createDirectories(targetFile.getParent());
            };
            Files.createFile(targetFile);
        }
        java.nio.file.Files.copy(readMeFile,targetFile, StandardCopyOption.REPLACE_EXISTING);
    }

}
