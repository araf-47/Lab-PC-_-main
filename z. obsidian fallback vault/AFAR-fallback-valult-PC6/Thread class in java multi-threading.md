`Thread` is the actual Java class that represents and controls an operating system thread.

Your `CookingJob` only contains the task (the code to run).
It does **not** know how to create or manage a real thread.

That’s why you need:

```java id="1y9khw"
Thread th = new Thread(job);
```

You are basically saying:

> “Create a real thread and make it execute this Runnable task.”

---

## What `Thread` contains internally

The `Thread` class contains functionality like:

* Creating a new execution path
* Starting a thread
* Scheduling with JVM/OS
* Sleeping
* Interrupting
* Joining
* Thread states
* Priority handling

Some important methods:

```java id="h2m3q1"
start()
run()
sleep()
join()
interrupt()
isAlive()
getName()
setPriority()
```

---

# Relationship Between `Runnable` and `Thread`

Think of it like this:

| Component  | Purpose                       |
| ---------- | ----------------------------- |
| `Runnable` | Defines WHAT work to do       |
| `Thread`   | Defines HOW and WHERE it runs |

---

# What happens in your code

```java id="m7qp2d"
CookingJob job = new CookingJob("Chicken");
```

Creates a normal object.

No thread yet.

---

```java id="b6xv4t"
Thread th = new Thread(job);
```

Creates a real thread object and stores your task (`job`) inside it.

Internally, `Thread` does something conceptually like:

```java id="f0cw8u"
class Thread {
    Runnable target;

    Thread(Runnable target){
        this.target = target;
    }

    public void run(){
        target.run();
    }
}
```

---

Then:

```java id="r9p4n2"
th.start();
```

tells JVM:

> “Start a new execution thread and call `run()` inside it.”

---

# Why not just extend `Thread`?

You can also do:

```java id="v3d1sa"
class CookingJob extends Thread {
    public void run(){
        System.out.println("Cooking...");
    }
}
```

Then:

```java id="u7n2bk"
CookingJob job = new CookingJob();
job.start();
```

works directly.

---

# Why `Runnable` is preferred

Because Java supports only single inheritance.

If you extend `Thread`, your class cannot extend anything else.

Using `Runnable` separates:

* task logic
* thread management

which is cleaner and more flexible.

