package Nio;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by gerard on 18-05-2016.
 */
public class FileVisitor {


    public static void main(String[] args) throws IOException {


        Path start = Paths.get(".");
        Files.walkFileTree(start,new SimpleFileVisitor());

    }

}
