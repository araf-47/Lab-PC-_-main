The difference between file input stream and buffer input stream 

### 17.7 Random-Access Files
It is not widely used 
***
I can write stuffs randomly in the file . in the middle or anywhere else. It is not sequential. 
It can both read and write.

**FIGURE 17.18**  `pg. 698/721`
must have `mode` in order for it to work.

`+write(b: byte[])` <- write takes byte array.


# Chapter 18: Recursion 
when a function calls itself.
is runs around in a loop.
this is function stack

```java
public class recursion {
    public static void main(String[] args) {
        recursionsss();
    }

    public static void recursionsss(){
        recursionsss();
    }
}
```

**Tree structure**, for recursion.

- direct recursion 
- indirect recursion

the job of loop can be done with recursion. <- *but it's expensive*. 

### 18.5 Recursive Helper Methods
whoever starts recursion is the helper method.

### 18.5.1 Recursive Selection Sort

### 18.5.2 Recursive Binary Search 

### 18.9 Recursion vs. Iteration
faster then loop
Iteration is just loop
`pg. 726` **hw**.





***
***
# HW 
7.9 = `pg. 702` (do it in terminal, not in the java fx) (take input in the terminal) (make a binary file, read, write, update and ==do it with random access file==.)
object input stream. and, object output stream <- it's easier but we can't do it with object (restricted).

