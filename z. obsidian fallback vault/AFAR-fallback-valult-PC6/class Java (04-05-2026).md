
### 12.10 The File Class
relative path . absolute path .
It can read files and write files.
`file.exists()`
```java
 3 java.io.File file = new java.io.File("image/us.gif");
 4 System.out.println("Does it exist? " + file.exists());
 5 System.out.println("The file has " + file.length() + " bytes");
 6 System.out.println("Can it be read? " + file.canRead());
 7 System.out.println("Can it be written? " + file.canWrite());
 8 System.out.println("Is it a directory? " + file.isDirectory());
 9 System.out.println("Is it a file? " + file.isFile());
10 System.out.println("Is it absolute? " + file.isAbsolute());
11 System.out.println("Is it hidden? " + file.isHidden());
12 System.out.println("Absolute path is " +
13 file.getAbsolutePath());
14 System.out.println("Last modified on " +
15 new java.util.Date(file.lastModified()));
```

```java
import java.io.File;
import java.util.Date;

public class Araf {
    public static void main(String[] args) {
        File file = new File("nnn.txt");

        System.out.println("--- File Property Report ---");
        System.out.println("Does it exist? " + file.exists());
        System.out.println("The file has " + file.length() + " bytes");
        System.out.println("Can it be read? " + file.canRead());
        System.out.println("Can it be written? " + file.canWrite());
        System.out.println("Is it a directory? " + file.isDirectory());
        System.out.println("Is it a file? " + file.isFile());
        System.out.println("Is it absolute? " + file.isAbsolute());
        System.out.println("Is it hidden? " + file.isHidden());
        System.out.println("Absolute path is " + file.getAbsolutePath());
        System.out.println("Last modified on " + new Date(file.lastModified()));
        
        System.out.println("---------------------------");
    }
}
```

```bash
--- File Property Report ---
Does it exist? true
The file has 904 bytes
Can it be read? true
Can it be written? true
Is it a directory? false
Is it a file? true
Is it absolute? false
Is it hidden? false
Absolute path is C:\Users\PWAD\Desktop\mid monthly (java)\nnn.txt
Last modified on Mon May 04 14:48:59 GMT+06:00 2026
```

### 12.11.3 Reading Data Using Scanner
### 12.11.4 How Does Scanner Work?
### 12.12 Reading Data from the Web
learn **string builder** for this.

# ABSTRACT CLASSES AND INTERFACES
- where we have only abstract method.
- abstract method doesn't has body.
- abstract class can't construct anything with constructor. we can't use constructor. constructor not allowed. 
- another good alternative for it is `interface`.
- abstract class, constructor can't be called. 
- if parent has argument constructor, the child must have argument constructor.

### 13.2.2 Interesting Points about Abstract Classes
- in abstract class you can write non abstract method. you can write everything almost.
- non abstract method can be converted into abstract method. but in the normal parent we must override this.