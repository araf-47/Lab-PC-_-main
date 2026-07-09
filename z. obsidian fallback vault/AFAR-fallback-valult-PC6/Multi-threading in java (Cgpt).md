# Chapter 30: Multi-threading and Parallel Programming in Java

This is one of the most important and most confusing topics for Java beginners.
Take it slowly. Once you understand the *idea* behind threads, the syntax becomes much easier.

---

# 1. What is a Thread?

A **thread** is a small unit of execution inside a program.

Normally, a Java program runs one instruction at a time:

```java
System.out.println("A");
System.out.println("B");
System.out.println("C");
```

Output:

```text
A
B
C
```

This is called **single-threaded execution**.

The program does one thing at a time in sequence.

---

# 2. Real-Life Analogy

Imagine a restaurant.

## Single-threaded restaurant

One worker does everything:

1. Takes order
2. Cooks food
3. Cleans table
4. Serves customer

Very slow.

---

## Multi-threaded restaurant

Different workers do different jobs simultaneously.

* One cooks
* One serves
* One cleans

Much faster.

That is exactly what happens in multi-threading.

---

# 3. Why Do We Need Multi-threading?

Without threads:

* UI freezes
* Games lag
* Downloads stop app interaction
* Servers handle one client at a time

Threads allow:

✅ Background tasks
✅ Faster applications
✅ Better CPU usage
✅ Parallel execution
✅ Responsive GUIs
✅ High-performance servers

---

# 4. Process vs Thread

This question is VERY common.

| Process             | Thread                    |
| ------------------- | ------------------------- |
| Independent program | Small unit inside process |
| Has separate memory | Shares memory             |
| Heavyweight         | Lightweight               |
| Slow communication  | Fast communication        |

Example:

* Chrome browser = Process
* Each browser tab = Thread

---

# 5. Creating Threads in Java

There are two classic ways.

---

# Method 1: Extending Thread Class

```java
class MyThread extends Thread {

    public void run() {
        System.out.println("Thread is running");
    }
}

public class Main {

    public static void main(String[] args) {

        MyThread t1 = new MyThread();

        t1.start();
    }
}
```

---

# Important: `start()` vs `run()`

This is a beginner trap.

## Wrong

```java
t1.run();
```

This behaves like a normal method call.

No new thread is created.

---

## Correct

```java
t1.start();
```

This creates a NEW thread internally.

Java then calls `run()` automatically.

---

# Flow of Execution

```text
main thread starts
       |
       +---- new thread created
                 |
                 +---- run()
```

---

# Method 2: Implementing Runnable (Preferred)

```java
class MyTask implements Runnable {

    public void run() {
        System.out.println("Task is running");
    }
}

public class Main {

    public static void main(String[] args) {

        MyTask task = new MyTask();

        Thread t1 = new Thread(task);

        t1.start();
    }
}
```

---

# Why Runnable is Better

Java supports:

* Single inheritance
* Multiple interfaces

If you extend `Thread`, you cannot extend another class.

So professionals usually use `Runnable`.

---

# 6. Multiple Threads Example

```java
class A extends Thread {

    public void run() {

        for(int i = 1; i <= 5; i++) {
            System.out.println("A : " + i);
        }
    }
}

class B extends Thread {

    public void run() {

        for(int i = 1; i <= 5; i++) {
            System.out.println("B : " + i);
        }
    }
}

public class Main {

    public static void main(String[] args) {

        A t1 = new A();
        B t2 = new B();

        t1.start();
        t2.start();
    }
}
```

---

# Possible Output

```text
A : 1
B : 1
A : 2
B : 2
B : 3
A : 3
```

Notice:

The order changes every time.

Why?

Because thread scheduling is controlled by JVM + OS.

This is called:

# Concurrent Execution

---

# 7. Thread Life Cycle

A thread goes through several states.

```text
NEW
RUNNABLE
RUNNING
WAITING
TERMINATED
```

---

## NEW

```java
Thread t = new Thread();
```

Created but not started.

---

## RUNNABLE

```java
t.start();
```

Ready to run.

---

## RUNNING

CPU executes thread.

---

## WAITING / BLOCKED

Waiting for:

* resource
* lock
* sleep
* another thread

---

## TERMINATED

`run()` finishes.

---

# 8. Thread Sleep

Used to pause thread temporarily.

```java
try {
    Thread.sleep(2000);
} catch(Exception e) {

}
```

2000 milliseconds = 2 seconds

---

# Example

```java
class MyThread extends Thread {

    public void run() {

        for(int i=1; i<=5; i++) {

            System.out.println(i);

            try {
                Thread.sleep(1000);
            }
            catch(Exception e) {

            }
        }
    }
}
```

Output:

```text
1
(wait 1 sec)
2
(wait 1 sec)
3
```

---

# 9. Joining Threads

Sometimes one thread must wait for another.

```java
t1.join();
```

---

# Example

```java
class MyThread extends Thread {

    public void run() {

        for(int i=1; i<=5; i++) {
            System.out.println(i);
        }
    }
}

public class Main {

    public static void main(String[] args) throws Exception {

        MyThread t1 = new MyThread();

        t1.start();

        t1.join();

        System.out.println("Finished");
    }
}
```

`Finished` prints only after thread ends.

---

# 10. Race Condition

VERY IMPORTANT topic.

---

## Problem

Two threads access same variable simultaneously.

```java
count++;
```

Looks simple.

But internally:

```text
1. Read count
2. Add 1
3. Store value
```

If two threads do this together:

❌ Wrong results occur.

---

# Example of Race Condition

```java
class Counter {

    int count = 0;

    public void increment() {
        count++;
    }
}
```

Two threads increment count 1000 times.

Expected:

```text
2000
```

Possible result:

```text
1764
1932
1987
```

Why?

Because threads interfere with each other.

---

# 11. Synchronization

Used to prevent race conditions.

---

## Synchronized Method

```java
class Counter {

    int count = 0;

    public synchronized void increment() {
        count++;
    }
}
```

Now only one thread enters method at a time.

---

# Thread Safety

A class is thread-safe if:

✅ Multiple threads can use it safely.

---

# 12. Inter-Thread Communication

Threads can communicate using:

* `wait()`
* `notify()`
* `notifyAll()`

Used in producer-consumer problems.

---

# Basic Idea

## `wait()`

Thread pauses and releases lock.

## `notify()`

Wakes one waiting thread.

---

# Example Concept

Producer creates data.

Consumer waits until data available.

---

# 13. Deadlock

A dangerous situation.

---

## Example

Thread 1 locks A then waits for B.

Thread 2 locks B then waits for A.

Both wait forever.

---

# Visualization

```text
Thread1 -> Lock A -> waiting for B
Thread2 -> Lock B -> waiting for A
```

Program freezes.

---

# Avoid Deadlock

✅ Consistent lock order
✅ Avoid nested locks
✅ Use timeout locks

---

# 14. Thread Priority

```java
t1.setPriority(10);
```

Range:

```text
1 -> MIN_PRIORITY
5 -> NORM_PRIORITY
10 -> MAX_PRIORITY
```

But modern OS may ignore priorities.

So don't rely heavily on them.

---

# 15. Daemon Threads

Background helper threads.

Example:

* Garbage collector

---

## Creating Daemon Thread

```java
t1.setDaemon(true);
```

Must call before `start()`.

---

# 16. Executor Framework (IMPORTANT)

Creating threads manually is inefficient.

Java provides thread pools.

---

# Thread Pool Concept

Instead of creating 1000 threads:

Use reusable worker threads.

This improves:

✅ Performance
✅ Memory usage
✅ Scalability

---

# ExecutorService Example

```java
import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) {

        ExecutorService executor =
                Executors.newFixedThreadPool(3);

        for(int i=1; i<=5; i++) {

            int task = i;

            executor.execute(() -> {

                System.out.println(
                    "Task " + task +
                    " executed by " +
                    Thread.currentThread().getName()
                );
            });
        }

        executor.shutdown();
    }
}
```

---

# Output Example

```text
Task 1 executed by pool-1-thread-1
Task 2 executed by pool-1-thread-2
```

---

# Why Executor Framework Matters

Modern Java applications heavily use it.

Especially:

* Spring Boot
* Web servers
* Enterprise systems

---

# 17. Callable vs Runnable

`Runnable`

```java
void run()
```

* No return value
* Cannot throw checked exceptions

---

## Callable

```java
V call()
```

* Returns value
* Can throw exceptions

---

# Example

```java
Callable<Integer> task = () -> {
    return 100;
};
```

---

# 18. Future

Represents result of async computation.

```java
Future<Integer> future =
        executor.submit(task);

Integer result = future.get();
```

`get()` waits for result.

---

# 19. Parallel Programming

Now we move beyond basic threading.

---

# Concurrency vs Parallelism

Many beginners confuse these.

---

## Concurrency

Tasks appear to run together.

One CPU rapidly switches tasks.

```text
Task A
Task B
Task A
Task B
```

---

## Parallelism

Tasks truly run simultaneously.

Requires multiple CPU cores.

```text
Core1 -> Task A
Core2 -> Task B
```

---

# 20. Parallel Streams

Java 8 introduced parallel streams.

---

# Sequential Stream

```java
list.stream()
```

---

# Parallel Stream

```java
list.parallelStream()
```

Java automatically uses multiple cores.

---

# Example

```java
import java.util.*;

public class Main {

    public static void main(String[] args) {

        List<Integer> list =
                Arrays.asList(1,2,3,4,5,6);

        list.parallelStream()
            .forEach(n ->
                System.out.println(
                    n + " " +
                    Thread.currentThread().getName()
                )
            );
    }
}
```

---

# Important Warning

Parallel streams are NOT always faster.

Use them when:

✅ Large datasets
✅ CPU-intensive work

Avoid for:

❌ Small tasks
❌ Database operations
❌ Shared mutable data

---

# 21. Fork/Join Framework

Used for divide-and-conquer parallelism.

---

# Idea

Split big task into smaller tasks.

Example:

```text
Big array
   |
split
 /   \
small small
```

---

# Example Uses

* Sorting
* Searching
* Image processing

---

# 22. Atomic Variables

Alternative to synchronization.

---

# Example

```java
AtomicInteger count =
        new AtomicInteger();
```

Increment safely:

```java
count.incrementAndGet();
```

No manual synchronization needed.

---

# 23. Volatile Keyword

Used when variable changes must be visible across threads.

```java
volatile boolean running = true;
```

Without `volatile`:

One thread may not see updated value.

---

# 24. Common Beginner Mistakes

---

## Mistake 1

Calling `run()` instead of `start()`.

---

## Mistake 2

Ignoring synchronization.

---

## Mistake 3

Creating too many threads.

---

## Mistake 4

Using shared mutable variables carelessly.

---

## Mistake 5

Thinking thread execution order is predictable.

It is NOT predictable.

---

# 25. Modern Java Concurrency Tools

Package:

```java
java.util.concurrent
```

Important classes:

| Class             | Purpose               |
| ----------------- | --------------------- |
| ExecutorService   | Thread pool           |
| Callable          | Task returning result |
| Future            | Async result          |
| ConcurrentHashMap | Thread-safe map       |
| AtomicInteger     | Atomic operations     |
| CountDownLatch    | Wait for tasks        |
| Semaphore         | Resource control      |

---

# 26. Best Practices

✅ Prefer ExecutorService over manual threads
✅ Keep shared data minimal
✅ Use immutable objects
✅ Avoid deadlocks
✅ Use synchronization carefully
✅ Test concurrent code thoroughly

---

# 27. Big Picture Summary

---

# Multi-threading

Allows multiple tasks to execute concurrently.

---

# Synchronization

Protects shared data.

---

# Parallel Programming

Uses multiple CPU cores for speed.

---

# Executor Framework

Professional way to manage threads.

---

# Atomic & Concurrent Utilities

Safer modern concurrency tools.

---

# 28. Learning Roadmap (Very Important)

For beginners, learn in THIS order:

### Phase 1

* Thread
* Runnable
* start()
* sleep()
* join()

### Phase 2

* Synchronization
* Race conditions
* Deadlocks

### Phase 3

* ExecutorService
* Callable
* Future

### Phase 4

* Parallel streams
* ForkJoin
* Atomic classes

---

# 29. Mini Practice Problems

Try these yourself.

---

## Easy

1. Create two threads printing numbers.
2. Use sleep().
3. Use join().

---

## Medium

4. Create shared counter.
5. Demonstrate race condition.
6. Fix using synchronized.

---

## Advanced Beginner

7. Use ExecutorService.
8. Create Callable returning sum.
9. Use AtomicInteger.

---

# 30. Final Mental Model

Think like this:

```text
Program
   |
contains multiple threads
   |
threads share resources
   |
shared resources need protection
   |
parallelism improves performance
```

---

# Most Important Interview Question

## Why is multi-threading difficult?

Because:

* Threads execute unpredictably
* Shared data causes bugs
* Timing issues are hard to reproduce
* Deadlocks and race conditions occur

---

# Recommended Next Topics

After this chapter, learn:

1. Collections Framework
2. Concurrent Collections
3. JVM Memory Model
4. Functional Programming
5. CompletableFuture
6. Reactive Programming

---

If you want, next I can also teach:

* **Complete Threading Practical Projects**
* **Synchronization deeply with diagrams**
* **ExecutorService in depth**
* **How CPU scheduling works**
* **Java Memory Model**
* **CompletableFuture**
* **Difference between concurrency and async programming**
* **Thread-safe collections**
* **Interview questions on multithreading**
* **Visual diagrams for all concepts**
