# ~~Chapter 14 : JAVAFX BASICS~~
# BINARY I/O
input output works in binary level.

- **stream** <- learn about this.

- text file - follow ASCII table.
- binary file 
	- can't be read via `Scanner`. because there is no Unicode in it.

if a file doesn't open it txt file it's binary file 

**Stream** -> is sequential binary data. `pg. 679 / 702`

stream keeps connection open until I close it.

file writer and print writer difference <- learn about it. 

### 17.3 Text I/O vs. Binary I/O
8 bit = 1 byte
text file's bytes are available in Unicode (so it can interpret).

### FIGURE 17.3 InputStream, OutputStream, and their subclasses are for performing binary I/O.

FIGURE 17.3 InputStream, OutputStream, and their subclasses are for performing 
binary I/O.

InputStream
OutputStream

- *FIGURE 17.4* The abstract InputStream class defines the methods for the input stream of bytes.
	- 1 `read()` -> I will get one byte.

### 17.4.1 FileInputStream/FileOutputStream
stream must be closed



### 17.4.2 FilterInputStream/FilterOutputStream
### 17.4.4 BufferedInputStream/BufferedOutputStream
### 17.6 Object I/O
serializable marker class.
==converting object to byte is serialization==. opposite is deserialization.
serialization and deserialization changes the reference. 





***
***
# code dump
file input and output stream
```java
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class StreamTest {
    public static void main(String[] args) {
        FileInputStreamEx("F:\\Araf R-70 (Java) (Web and mobile development)\\exam study\\mcq mid monthly study\\Class-Exam.pdf", "./mcq.pdf");
    }

    private static void FileInputStreamEx(String inputF, String outputF){
        try(
            InputStream inputS = new FileInputStream(inputF);
            OutputStream outputS = new FileOutputStream(outputF);
        ) {
            byte[] dumpStar = new byte[101];
            int byteRead;

            while ((byteRead = inputS.read(dumpStar)) != -1) {
                outputS.write(dumpStar, 0, byteRead);
            }
			
        } catch (Exception e){
            System.out.println("Eww, that gross.");
        }
    }
}
```