Binary I/O in Java means reading and writing **raw bytes** instead of human-readable text.

* **Text I/O** → works with characters and strings (`A`, `Hello`, `123`)
* **Binary I/O** → works with bytes (`01010101` internally)

Binary I/O is commonly used for:
* Images
* Audio/video files
* PDFs
* Serialized objects
* Faster data storage

---

## Main Binary I/O Classes

Java uses [[stream]]s for binary I/O.

### Reading bytes

```java id="ejz9h5"
FileInputStream
BufferedInputStream
DataInputStream
```

### Writing bytes

```java id="j7q50j"
FileOutputStream
BufferedOutputStream
DataOutputStream
```

---

# Simple Example

## Writing binary data

```java id="3gl43r"
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            FileOutputStream out = new FileOutputStream("data.bin");

            out.write(65); // ASCII for 'A'
            out.write(66); // ASCII for 'B'

            out.close();

            System.out.println("Data written.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

This creates a binary file named `data.bin`.

---

## Reading binary data

```java id="2ahq6t"
import java.io.FileInputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            FileInputStream in = new FileInputStream("data.bin");

            int data;

            while ((data = in.read()) != -1) {
                System.out.println(data);
            }

            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

Output:

```text id="e73t93"
65
66
```

---

# Why use Binary I/O?

Advantages:

* Faster than text I/O
* Smaller file size
* Can store non-text data
* Good for multimedia and objects

---

# Difference Between Text and Binary I/O

| Text I/O                  | Binary I/O                       |
| ------------------------- | -------------------------------- |
| Human readable            | Not human readable               |
| Uses characters           | Uses bytes                       |
| Examples: `.txt`, `.csv`  | Examples: `.jpg`, `.mp3`, `.bin` |
| Classes like `FileReader` | Classes like `FileInputStream`   |

---

# Beginner Tip

Think of binary I/O as:

> “Sending exact byte data to/from a file.”

while text I/O is:

> “Sending readable characters.”
