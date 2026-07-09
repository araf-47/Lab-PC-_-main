Great. These 5 ideas are the foundation of Java multithreading. If you truly understand them, you're already ahead of many beginners.

---

# 1. What a Thread Is

A **thread** is simply a sequence of instructions that a CPU executes.

Consider this code:

```java
public class Main {
    public static void main(String[] args) {

        System.out.println("A");
        System.out.println("B");
        System.out.println("C");

    }
}
```

Java executes:

```text
Step 1: Print A
Step 2: Print B
Step 3: Print C
```

The thing following these instructions is the **main thread**.

Think of a thread as a worker reading instructions from a to-do list:

```text
Worker:
✓ Print A
✓ Print B
✓ Print C
```

One worker = one thread.

---

## Multiple Threads

Now imagine hiring another worker.

```text
Worker 1:
Print A
Print B

Worker 2:
Download File
```

Now two workers are doing different tasks.

```text
Program
│
├── Main Thread
└── Download Thread
```

Both belong to the same Java program.

---

## Important Mental Model

A thread has:

* Its own execution path
* Its own call stack
* Its own current position in the code

But threads share:

* Objects
* Variables stored in objects
* Heap memory

We'll see why sharing memory causes problems later.

---

# 2. How start() Creates a New Thread

This is one of the most misunderstood things for beginners.

Suppose we have:

```java
class MyTask implements Runnable {
    public void run() {
        System.out.println("Running...");
    }
}
```

Now:

```java
Thread t = new Thread(new MyTask());
```

At this moment:

```text
Thread exists
But it is NOT running
```

Like buying a car:

```text
Car exists
Engine not started
```

---

## What happens with run()?

```java
t.run();
```

Many beginners think:

> "This starts a thread."

No.

Java simply executes the method like any other method.

Equivalent to:

```java
new MyTask().run();
```

Only the main thread is working.

```text
Main Thread
    |
    ---> run()
```

No new worker is created.

---

## What happens with start()?

```java
t.start();
```

Now Java asks the operating system:

```text
Please create a new execution path.
```

The OS creates a brand-new thread.

After creation:

```text
Main Thread
     |
     |------> continues

New Thread
     |
     |------> run()
```

Now there are two workers.

---

### Visual Example

```java
Thread t = new Thread(() -> {
    System.out.println("Hello");
});

t.start();

System.out.println("World");
```

Possible output:

```text
Hello
World
```

Or:

```text
World
Hello
```

Because two threads are now involved.

---

# 3. Why Thread Execution Order Is Unpredictable

This is where many people get confused.

Suppose:

```java
Thread t1 = new Thread(() -> {
    System.out.println("A");
});

Thread t2 = new Thread(() -> {
    System.out.println("B");
});

t1.start();
t2.start();
```

You might think:

```text
A
B
```

because you started `t1` first.

But output could be:

```text
B
A
```

Why?

---

## The Operating System Is the Boss

When you call:

```java
t1.start();
t2.start();
```

==Java doesn't directly run them==.

Instead it tells the operating system:

```text
Please schedule these threads.
```

==The OS decides==:

```text
Run Thread 1 first
```

or

```text
Run Thread 2 first
```

or

```text
Switch between them
```

==You don't control that==.

---

## Imagine a Teacher

Suppose two students raise their hands.

```text
Student A
Student B
```

The teacher decides:

```text
A first
```

or

```text
B first
```

The students don't decide.

Similarly:

```text
Threads request CPU time.
CPU decides who gets it.
```

---

## Multi-Core CPUs

Modern CPUs have multiple cores.

Example:

```text
Core 1 -> Thread A
Core 2 -> Thread B
```

Now they truly run simultaneously.

Which finishes first?

Still unpredictable.

---

# 4. What Race Conditions Are

==This is the most important multithreading problem==.

Let's create a shared variable.

```java
class Counter {
    int count = 0;
}
```

Two threads increase it.

```java
counter.count++;
```

You expect:

```text
0 -> 1 -> 2
```

Final value:

```text
2
```

Right?

Not always.

---

## The Hidden Reality

People think:

```java
count++;
```

is one step.

Actually it's roughly:

```text
1. Read count
2. Add 1
3. Write result
```

Three steps.

---

### Scenario

Initial value:

```text
count = 0
```

Thread A:

```text
Read count = 0
```

Before A writes back...

Thread B:

```text
Read count = 0
```

Now:

```text
A adds 1 -> 1
B adds 1 -> 1
```

A writes:

```text
count = 1
```

B writes:

```text
count = 1
```

Final value:

```text
1
```

instead of:

```text
2
```

One increment disappeared.

---

## Why It's Called a Race Condition

Both threads are racing to access the same data.

The final result depends on:

```text
Who gets there first?
Who writes first?
Who gets interrupted?
```

Tiny timing differences change the result.

---

### Real-Life Analogy

Imagine a whiteboard showing:

```text
0
```

Two people look at it simultaneously.

Person A sees:

```text
0
```

Person B sees:

```text
0
```

Both decide:

```text
I'll add 1.
```

A writes:

```text
1
```

B writes:

```text
1
```

Expected:

```text
2
```

Actual:

```text
1
```

That is a race condition.

---

# 5. How synchronized Protects Shared Data

Java provides a lock mechanism.

```java
synchronized void increment() {
    count++;
}
```

==Now only one thread can enter this method at a time==.

---

## Without synchronized

```text
Thread A enters
Thread B enters
Both modify count
Chaos
```

---

## With synchronized

```text
Thread A enters
Thread B waits

Thread A finishes

Thread B enters
```

Like a bathroom with one key.

---

### ✨ Bathroom Analogy

Without lock:

```text
Person A enters
Person B enters
Mess
```

With lock:

```text
Person A locks door

Person B waits

Person A leaves

Person B enters
```

The lock guarantees one person at a time.

---

## Visual Timeline

Without synchronization:

```text
Thread A: Read 0
Thread B: Read 0
Thread A: Write 1
Thread B: Write 1
```

Final:

```text
1
```

Wrong.

---

With synchronization:

```text
Thread A: Read 0
Thread A: Write 1
Thread A exits

Thread B: Read 1
Thread B: Write 2
```

Final:

```text
2
```

Correct.

---

# The Big Picture

Here's the entire story in one diagram:

```text
Program
│
├── Main Thread
├── Thread A
└── Thread B
```

### Thread

A worker executing code.

```text
Worker -> Instructions
```

### start()

Creates a new worker.

```text
Main Thread
      +
New Thread
```

### Unpredictable Order

==The OS decides who runs when==.

```text
A then B
or
B then A
or
A B A B
```

### Race Condition

==Two threads change the same data simultaneously==.

```text
Shared Data + No Protection
= Bugs
```

### synchronized

==Places a lock around critical code==.

```text
One thread enters
Others wait
```

which keeps shared data consistent.

A good next step is learning **thread stacks vs heap memory**. That's usually the moment when multithreading "clicks" for most Java learners because you can finally see *what is shared* and *what is private* between threads.