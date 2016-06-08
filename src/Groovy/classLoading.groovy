package Groovy
/**
 * Created by gerard on 08-06-2016.
 */

// The calling of the script through an IDEA
//"C:\Program Files\Java\jdk1.8.0_45\bin\java"
//          "-Dtools.jar=C:\Program Files\Java\jdk1.8.0_45\lib\tools.jar"
//          -Dgroovy.home=C:\groovy-2.4.7
//          -Dgroovy.starter.conf=C:\groovy-2.4.7\conf\groovy-starter.conf
//          -Didea.launcher.port=7532
//          -Didea.launcher.bin.path=C:\Idea\bin
//          -Dfile.encoding=UTF-8
//          -classpath C:\groovy-2.4.7\lib\groovy-2.4.7.jar;.;D:\git_niofs_sftp\target\classes;C:\Users\gerard\.m2\repository\com\jcraft\jsch\0.1.51\jsch-0.1.51.jar;C:\groovy-2.4.7\lib\ant-1.9.4.jar;C:\groovy-2.4.7\lib\ant-antlr-1.9.4.jar;C:\groovy-2.4.7\lib\ant-junit-1.9.4.jar;C:\groovy-2.4.7\lib\ant-launcher-1.9.4.jar;C:\groovy-2.4.7\lib\bsf-2.4.0.jar;C:\groovy-2.4.7\lib\commons-cli-1.2.jar;C:\groovy-2.4.7\lib\commons-logging-1.2.jar;C:\groovy-2.4.7\lib\gpars-1.2.1.jar;C:\groovy-2.4.7\lib\groovy-ant-2.4.7.jar;C:\groovy-2.4.7\lib\groovy-bsf-2.4.7.jar;C:\groovy-2.4.7\lib\groovy-console-2.4.7.jar;C:\groovy-2.4.7\lib\groovy-docgenerator-2.4.7.jar;C:\groovy-2.4.7\lib\groovy-groovydoc-2.4.7.jar;C:\groovy-2.4.7\lib\groovy-groovysh-2.4.7.jar;C:\groovy-2.4.7\lib\groovy-jmx-2.4.7.jar;C:\groovy-2.4.7\lib\groovy-json-2.4.7.jar;C:\groovy-2.4.7\lib\groovy-jsr223-2.4.7.jar;C:\groovy-2.4.7\lib\groovy-nio-2.4.7.jar;C:\groovy-2.4.7\lib\groovy-servlet-2.4.7.jar;C:\groovy-2.4.7\lib\groovy-sql-2.4.7.jar;C:\groovy-2.4.7\lib\groovy-swing-2.4.7.jar;C:\groovy-2.4.7\lib\groovy-templates-2.4.7.jar;C:\groovy-2.4.7\lib\groovy-test-2.4.7.jar;C:\groovy-2.4.7\lib\groovy-testng-2.4.7.jar;C:\groovy-2.4.7\lib\groovy-xml-2.4.7.jar;C:\groovy-2.4.7\lib\hamcrest-core-1.3.jar;C:\groovy-2.4.7\lib\ivy-2.4.0.jar;C:\groovy-2.4.7\lib\jansi-1.11.jar;C:\groovy-2.4.7\lib\jcommander-1.47.jar;C:\groovy-2.4.7\lib\jline-2.12.jar;C:\groovy-2.4.7\lib\jsp-api-2.0.jar;C:\groovy-2.4.7\lib\jsr166y-1.7.0.jar;C:\groovy-2.4.7\lib\junit-4.12.jar;C:\groovy-2.4.7\lib\multiverse-core-0.7.0.jar;C:\groovy-2.4.7\lib\qdox-1.12.1.jar;C:\groovy-2.4.7\lib\servlet-api-2.4.jar;C:\groovy-2.4.7\lib\testng-6.8.13.jar;C:\groovy-2.4.7\lib\xmlpull-1.1.3.1.jar;C:\groovy-2.4.7\lib\xstream-1.4.7.jar;C:\Idea\lib\idea_rt.jar com.intellij.rt.execution.application.AppMain org.codehaus.groovy.tools.GroovyStarter --conf C:\groovy-2.4.7\conf\groovy-starter.conf --main groovy.ui.GroovyMain --classpath .;D:\git_niofs_sftp\target\classes;C:\Users\gerard\.m2\repository\com\jcraft\jsch\0.1.51\jsch-0.1.51.jar;C:\groovy-2.4.7\lib\ant-1.9.4.jar;C:\groovy-2.4.7\lib\ant-antlr-1.9.4.jar;C:\groovy-2.4.7\lib\ant-junit-1.9.4.jar;C:\groovy-2.4.7\lib\ant-launcher-1.9.4.jar;C:\groovy-2.4.7\lib\bsf-2.4.0.jar;C:\groovy-2.4.7\lib\commons-cli-1.2.jar;C:\groovy-2.4.7\lib\commons-logging-1.2.jar;C:\groovy-2.4.7\lib\gpars-1.2.1.jar;C:\groovy-2.4.7\lib\groovy-2.4.7.jar;C:\groovy-2.4.7\lib\groovy-ant-2.4.7.jar;C:\groovy-2.4.7\lib\groovy-bsf-2.4.7.jar;C:\groovy-2.4.7\lib\groovy-console-2.4.7.jar;C:\groovy-2.4.7\lib\groovy-docgenerator-2.4.7.jar;C:\groovy-2.4.7\lib\groovy-groovydoc-2.4.7.jar;C:\groovy-2.4.7\lib\groovy-groovysh-2.4.7.jar;C:\groovy-2.4.7\lib\groovy-jmx-2.4.7.jar;C:\groovy-2.4.7\lib\groovy-json-2.4.7.jar;C:\groovy-2.4.7\lib\groovy-jsr223-2.4.7.jar;C:\groovy-2.4.7\lib\groovy-nio-2.4.7.jar;C:\groovy-2.4.7\lib\groovy-servlet-2.4.7.jar;C:\groovy-2.4.7\lib\groovy-sql-2.4.7.jar;C:\groovy-2.4.7\lib\groovy-swing-2.4.7.jar;C:\groovy-2.4.7\lib\groovy-templates-2.4.7.jar;C:\groovy-2.4.7\lib\groovy-test-2.4.7.jar;C:\groovy-2.4.7\lib\groovy-testng-2.4.7.jar;C:\groovy-2.4.7\lib\groovy-xml-2.4.7.jar;C:\groovy-2.4.7\lib\hamcrest-core-1.3.jar;C:\groovy-2.4.7\lib\ivy-2.4.0.jar;C:\groovy-2.4.7\lib\jansi-1.11.jar;C:\groovy-2.4.7\lib\jcommander-1.47.jar;C:\groovy-2.4.7\lib\jline-2.12.jar;C:\groovy-2.4.7\lib\jsp-api-2.0.jar;C:\groovy-2.4.7\lib\jsr166y-1.7.0.jar;C:\groovy-2.4.7\lib\junit-4.12.jar;C:\groovy-2.4.7\lib\multiverse-core-0.7.0.jar;C:\groovy-2.4.7\lib\qdox-1.12.1.jar;C:\groovy-2.4.7\lib\servlet-api-2.4.jar;C:\groovy-2.4.7\lib\testng-6.8.13.jar;C:\groovy-2.4.7\lib\xmlpull-1.1.3.1.jar;C:\groovy-2.4.7\lib\xstream-1.4.7.jar
//          --encoding=UTF-8
//          D:\git_niofs_sftp\src\client\groovy\test.groovy

// To reproduce the above, you need to modify startGroovy.bat to accept to modify the class path
// set STARTER_CLASSPATH=%STARTER_CLASSPATH%;%GROOVY_HOME%\lib\groovy-2.4.7.jar


@GrabConfig(systemClassLoader=true)
@Grapes([
        @Grab(group='com.gerardnico', module='niofs-sftp', version='1.0.0'),
        ])

import java.nio.file.spi.FileSystemProvider

println()
println("Class loader: ")
println("System: "+ ClassLoader.getSystemClassLoader().toString());
println("Current Thread: "+ Thread.currentThread().getContextClassLoader().toString());

prinln()
println("The default System class loader load only on the path and this is the loader of NIO: ")
println "java.class.path: "+System.getProperty("java.class.path");

println();
println("Load Service with Groovy Class Loader: ");
ServiceLoader<FileSystemProvider> loader = ServiceLoader.load(FileSystemProvider.class);
for (FileSystemProvider provider: loader) {
    println "Provider: "+provider.class.toString()+" with scheme "+provider.getScheme();
}

println();
println("FileSystemProvider: Installed");
for (FileSystemProvider provider: FileSystemProvider.installedProviders()) {
    println "Provider: "+provider.class.toString()+" with scheme "+provider.getScheme();
}

println();
println("FileSystemProvider: The detailed function from loadInstalledProviders");
ServiceLoader<FileSystemProvider> sl = ServiceLoader.load(FileSystemProvider.class, ClassLoader.getSystemClassLoader());
for (FileSystemProvider provider: sl) {
    println "Provider: "+provider.class.toString()+" with scheme "+provider.getScheme();
}

