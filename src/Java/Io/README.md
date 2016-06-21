# Java - IO (Input|Output) File Operations - (Input|Reading) and (Writing|Output) 


## Introduction

[I/O Streams](https://docs.oracle.com/javase/tutorial/essential/io/streams.html) or Input/Output Operations


## Stream

### Byte

  * [File Stream (FileInputStream and FileOutputStream)](FileStreamTest.java) is a Byte Stream moving one byte at a time from the underlying file system. To reduce intern synchronization, you may ask for a char array
  * [Buffered Stream](BufferedStreamTest.java) is a Buffered Byte stream moving byte per buffer (a char array).
  
### Character

  * [File Reader and Writer](FileReaderWriterTest.java] decodes byte in character one byte at a time. You can still performs operation by char, char array and line.



## Reference

  * [Java Tutorial I/O Streams](https://docs.oracle.com/javase/tutorial/essential/io/streams.html)
  