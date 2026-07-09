**Source**: 🍉 https://www.geeksforgeeks.org/java/java-multithreading-tutorial/
***
Multithreading in Java is a feature that allows multiple tasks to run concurrently within the same program. Instead of executing one task at a time, Java enables parallel execution using lightweight threads. This makes applications more efficient, faster and responsive in real-world scenarios like servers, games and chat systems.

### Key Features of Multithreading
- A thread is the smallest unit of execution in Java.
- Threads share the same memory space but run independently.
- Java provides the Thread class and Runnable interface to create threads.
- Multithreading ensures better CPU utilization by executing tasks simultaneously.
- Synchronization is needed to prevent data inconsistency when threads share resources.

****Example:**** Suppose a restaurant kitchen where multiple chefs are working simultaneously on different dishes. This setup ensures faster service and better CPU (chef) utilization, just like threads in Java.

****Example:**** Java Program to illustrate Creation and execution of a thread via start() and run() method in Single inheritance

```java
class MyThread1 extends Thread {

    public void run(){
        System.out.println("Thread1 is running");
    }
}

class MyThread2 extends Thread {

    public void run(){
        System.out.println("Thread2 is running");
    }
}

public class ThreadTest {

    public static void main(String[] args){
        MyThread1 obj1 = new MyThread1();
        MyThread2 obj2 = new MyThread2();
        obj1.start();
        obj2.start();
    }
}
```

## Different Ways to Create Threads

Threads can be created by using two mechanisms:

### 1. Extending the Thread class

We create a class that extends Thread and override its [run() method](https://www.geeksforgeeks.org/java/difference-between-thread-start-and-thread-run-in-java/) to define the task. Then, we make an object of this class and call [start(),](https://www.geeksforgeeks.org/java/start-function-multithreading-java/) which automatically calls run() and begins the thread’s execution.

****Example:**** Restaurant Kitchen (Extending Thread)
```java
class CookingTask extends Thread {
    private String task;

    CookingTask(String task) {
        this.task = task;
    }

    public void run() {
        System.out.println(task + " is being prepared by " +
            Thread.currentThread().getName());
    }
}

public class Restaurant {
    public static void main(String[] args) {
        Thread t1 = new CookingTask("Pasta");
        Thread t2 = new CookingTask("Salad");
        Thread t3 = new CookingTask("Dessert");
        Thread t4 = new CookingTask("Rice");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
```