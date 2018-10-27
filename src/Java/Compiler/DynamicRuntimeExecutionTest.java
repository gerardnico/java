package Java.Compiler;

import org.junit.Test;

import javax.tools.*;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class DynamicRuntimeExecutionTest {

    @Test
    public void baselineTest() throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {


        Path temp = Paths.get(System.getProperty("java.io.tmpdir"), "java-demo");
        Files.createDirectories(temp);

        final String className = "javademo";
        Path javaSourceFile = Paths.get(temp.normalize().toAbsolutePath().toString(), className + ".java");
        System.out.println(javaSourceFile);
        String code = "public class " + className + " {" +
                "public void run() {\n" +
                "       System.out.println(\"Hello Nico\"); \n" +
                "    }" +
                "}";

        Files.write(javaSourceFile, code.getBytes());

        File[] files1 = {javaSourceFile.toFile()};

        final String javaHome = System.getProperty("java.home");
        System.out.println(javaHome);
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();

        StandardJavaFileManager fileManager = compiler.getStandardFileManager(null, null, null);
        Iterable<? extends JavaFileObject> compilationUnits =
                fileManager.getJavaFileObjectsFromFiles(Arrays.asList(files1));
        DiagnosticCollector<JavaFileObject> diagnostics = new DiagnosticCollector<JavaFileObject>();

        // Compilation unit can be created and called only once
        JavaCompiler.CompilationTask task = compiler.getTask(
                null,
                fileManager,
                diagnostics,
                null,
                null,
                compilationUnits
        );
        task.call();

        for (Diagnostic diagnostic : diagnostics.getDiagnostics())
            System.out.format("Error on line %d in %s%n",
                    diagnostic.getLineNumber(),
                    diagnostic.getSource());


        fileManager.close();

        // The parent classloader
        ClassLoader classLoader = DynamicRuntimeExecutionTest.class.getClassLoader();
        URLClassLoader urlClassLoader = new URLClassLoader(
                new URL[] { temp.toUri().toURL() },
                classLoader);
        Class javaDemoClass = urlClassLoader.loadClass(className);

        Object javaDemoInstance = javaDemoClass.newInstance();
        Method method = javaDemoInstance.getClass().getMethod("run");
        method.invoke(javaDemoInstance);


    }


}
