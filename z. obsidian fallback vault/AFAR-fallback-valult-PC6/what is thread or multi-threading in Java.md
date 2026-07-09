Think of a Java program as a worker doing tasks.

### What is a Thread?

A **thread** is a single path of execution inside a program.

Imagine you're cooking:

* Chop vegetables
* Boil water
* Fry onions

If you do these one after another, you're working with **one thread**.

A normal Java program starts with a single thread called the **main thread**.

Example:

```java
public class Main {
    public static void main(String[] args) {
        System.out.println("Task 1");
        System.out.println("Task 2");
        System.out.println("Task 3");
    }
}
```

Execution happens in order:

```
Task 1
Task 2
Task 3
```

One thread is doing everything.

---

## Why do we need multiple threads?

Suppose you're downloading a file and also want the user interface to remain responsive.

If one thread handles both:

```
Download file...
(wait 10 seconds)
User clicks button
```

The program may appear frozen.

Instead, we can create another thread:

* Thread 1 → User interface
* Thread 2 → Download file

Both tasks can progress independently.

This is called **multithreading**.

---

# What is Multithreading?

**Multithreading** means running multiple threads within the same program.

Think of a restaurant:

### Single-threaded restaurant

One employee:

1. Takes order
2. Cooks food
3. Serves food
4. Cleans table

Customers wait a lot.

### Multithreaded restaurant

Multiple employees:

* Employee 1 takes orders
* Employee 2 cooks
* Employee 3 serves

More work gets done in the same amount of time.

That's the basic idea of multithreading.

---

# Creating a Thread in Java

There are several ways, but beginners should start with `Runnable`.

```java
class MyTask implements Runnable {
    public void run() {
        System.out.println("Thread is running");
    }
}

public class Main {
    public static void main(String[] args) {

        Thread t = new Thread(new MyTask());

        t.start();
    }
}
```

Output:

```
Thread is running
```

### Important

Don't call:

```java
t.run();
```

Call:

```java
t.start();
```

Why?

* `run()` = normal method call
* `start()` = creates a new thread and then calls `run()`

---

# Example with Two Threads

```java
class Task1 implements Runnable {
    public void run() {
        for(int i = 1; i <= 5; i++) {
            System.out.println("Task1: " + i);
        }
    }
}

class Task2 implements Runnable {
    public void run() {
        for(int i = 1; i <= 5; i++) {
            System.out.println("Task2: " + i);
        }
    }
}

public class Main {
    public static void main(String[] args) {

        Thread t1 = new Thread(new Task1());
        Thread t2 = new Thread(new Task2());

        t1.start();
        t2.start();
    }
}
```

Possible output:

```
Task1: 1
Task2: 1
Task1: 2
Task2: 2
Task2: 3
Task1: 3
...
```

==Notice the order isn't guaranteed==.

==The operating system decides when each thread gets CPU time==.

---

# How Threads Actually Work

Many beginners think:

> "If I create 2 threads, they run at exactly the same time."

Not always.

On a single CPU core:

```
Thread A
Thread B
Thread A
Thread B
```

The CPU switches between them very quickly.

It *looks* simultaneous.

==On multiple CPU cores, threads can truly run at the same time==.

---

# Sleeping a Thread

You can pause a thread:

```java
try {
    Thread.sleep(1000);
} catch (InterruptedException e) {
    e.printStackTrace();
}
```

`1000` means 1000 milliseconds = 1 second.

Example:

```java
for(int i = 1; i <= 5; i++) {
    System.out.println(i);
    Thread.sleep(1000);
}
```

Output:

```
1
(wait 1 second)
2
(wait 1 second)
3
...
```

---

# Thread Lifecycle (Simplified)

A thread usually goes through:

```
NEW
 ↓
RUNNABLE
 ↓
RUNNING
 ↓
TERMINATED
```

### NEW

```java
Thread t = new Thread();
```

Created but not started.

### RUNNABLE

```java
t.start();
```

Ready to run.

### RUNNING

CPU is executing it.

### TERMINATED

`run()` finishes.

---

# The Biggest Problem: Shared Data

Suppose two threads access the same variable.

```java
class Counter {
    int count = 0;

    void increment() {
        count++;
    }
}
```

Two threads:

```java
counter.increment();
counter.increment();
```

You might expect:

```
count = 2
```

But sometimes you get:

```
count = 1
```

Why?

Because `count++` is not a single operation.

Internally:

```text
Read count
Add 1
Write count
```

Thread A and Thread B can interfere with each other.

This is called a **race condition**.

---

# Fixing It with synchronized

```java
class Counter {
    int count = 0;

    synchronized void increment() {
        count++;
    }
}
```

Now only one thread can execute `increment()` at a time.

This prevents corruption of shared data.

---

# Real-World Uses of Multithreading

You'll see threads everywhere:

### Web Servers

A server might handle:

* User A request
* User B request
* User C request

using different threads.

### Games

* Physics
* Sound
* Rendering
* Networking

can run on separate threads.

### Download Managers

Download multiple files simultaneously.

### Chat Applications

Listen for messages while allowing the user to type.

---

# Beginner Mental Model

If you remember only one thing, remember this:

**A process is a running program. Threads are workers inside that program.**

Example:

```text
Java Program (Process)
│
├── Main Thread
├── Thread A
├── Thread B
└── Thread C
```

All threads share the same memory and work together inside the same program.

---

# Modern Java Note

In real-world Java today, developers rarely create raw threads everywhere.

Instead, they often use:

* ExecutorService
* ThreadPoolExecutor
* CompletableFuture

These manage threads more efficiently.

For now, focus on understanding: <-- 🌠 [[5 key points of thread in java]].

1. What a thread is.
2. How `start()` creates a new thread.
3. Why thread execution order is unpredictable.
4. What race conditions are.
5. How `synchronized` helps protect shared data.

Once these concepts feel comfortable, learning advanced Java concurrency becomes much easier.
