A **stream** in Java is like a flow of data.

Think of it like water flowing through a pipe:

* Data goes **into** your program → Input Stream
* Data goes **out of** your program → Output Stream

Java uses streams to read and write data.

---

# Simple Analogy

Imagine a straw:

* Drinking juice → input stream
* Blowing air out → output stream

Data flows continuously through the stream.

---

# Two Main Types

## 1. Input Stream

Used to **read** data.

Example:

```java id="n1otm5"
FileInputStream
```

Reads bytes from a file.

---

## 2. Output Stream

Used to **write** data.

Example:

```java id="o86ju0"
FileOutputStream
```

Writes bytes to a file.

---

# Visual Idea

```text id="x9k72n"
File ---> InputStream ---> Program

Program ---> OutputStream ---> File
```

---

# Example

## Writing to a file

```java id="zbx1r0"
import java.io.FileOutputStream;

public class Main {
    public static void main(String[] args) throws Exception {

        FileOutputStream out = new FileOutputStream("hello.txt");

        out.write(65); // writes byte for 'A'

        out.close();
    }
}
```

`out.write(65)` sends data through the output stream into the file.

---

# Why Streams Exist

Streams make Java flexible because the same idea works for:

* Files
* Network connections
* Keyboard input
* Memory
* Audio/video

Everything becomes “a stream of data.”

---

# Important Beginner Idea

Streams do **not** store data permanently.

They only provide a path for data to move.

Like a pipe carries water but does not keep the water forever.

---

# Common Stream Classes

| Class                  | Purpose                    |
| ---------------------- | -------------------------- |
| `FileInputStream`      | Read bytes from file       |
| `FileOutputStream`     | Write bytes to file        |
| `BufferedInputStream`  | Faster reading             |
| `BufferedOutputStream` | Faster writing             |
| `DataInputStream`      | Read Java primitive types  |
| `DataOutputStream`     | Write Java primitive types |

---

# One-Line Summary

A stream in Java is:

> A channel through which data flows between a program and a source/destination.
