Q1 : `16/25`
Q2 : `21/25`
Q3 : `16/25`
Q4 : `18/25`
Q5 : `18/25`
Q6 : `19/25`
[Q7](https://forms.gle/k1mU4B75obXANyn88) : `18/25`
[Q8](https://forms.gle/iDeEbgzEkKE5XQmXA) : `16/25`

info for feedback form : 8 exam

### Q&A
## Checkpoint 🧠

Before moving on, answer these **without looking back**:

### 1.

What is a Spring Bean?

Answer : Spring Bean is a part of Spring that manage objects created by the container/spring.

### 2.

Who creates and manages Spring Beans?

Answer: Spring Container creates creates and manages spring bean. 

### 3.

What is the relationship between `ApplicationContext` and the Spring Container?

Answer: `ApplicationContext` gives me  access to the spring container that manages spring bean.
### 4.

What’s the difference between these two?

```
GreetingService service = new GreetingService();
```

and

```
GreetingService service =
        context.getBean(GreetingService.class);
```

Answer: First one object is managed by me and in the 2nd one object is managed by spring.
### 5.

Complete this diagram:

```
Spring Container
       ↓
       ?
       ↓
       ?
```

Answer:
```
Spring Container
       ↓
    Spring bean
       ↓
Dependency injection
```

## review
### Evaluation: ✅ Mostly correct — 8.5/10

You understood the **main Spring concept correctly**: you are getting the object from the Spring container rather than creating it yourself.

Your flow is:

```text
SpringApplication.run()
        ↓
ApplicationContext
        ↓
context.getBean(GreetingService.class)
        ↓
GreetingService Bean
        ↓
greetDflt()
        ↓
Hello from Spring!
```

That's exactly the important concept the exercise is testing.

### What you did well

✅ You used:

```java
ApplicationContext context =
        SpringApplication.run(GreetingService.class, args);
```

This starts Spring and gives you the `ApplicationContext`.

✅ You retrieved the object through Spring:

```java
GreetingService service =
        context.getBean(GreetingService.class);
```

This is the key part of the exercise.

✅ You did **not** do:

```java
GreetingService service = new GreetingService();
```

Good.

✅ `@SpringBootApplication` makes `GreetingService` a component that Spring can manage, so Spring can create the Bean.

---

### One thing to fix

The exercise specifically asked for:

```java
public void greet() {
    System.out.println("Hello from Spring!");
}
```

You wrote:

```java
public void greetDflt() {
    System.out.println("Hello from Spring!");
}
```

So simply rename `greetDflt()` → `greet()`.

Also, while your class name technically works, it's more conventional to separate the service from the application class:

```text
GreetingService
Application
```

For **this particular exercise**, though, putting everything in one class is acceptable because `@SpringBootApplication` itself makes the class a Spring-managed component.

### Corrected version of your approach

```java
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.boot.SpringApplication;

@SpringBootApplication
public class GreetingService {

    public void greet() {
        System.out.println("Hello from Spring!");
    }

    public static void main(String[] args) {

        ApplicationContext context =
                SpringApplication.run(GreetingService.class, args);

        GreetingService service =
                context.getBean(GreetingService.class);

        service.greet();
    }
}
```

### Verdict

**Concept: ✅ Correct**

**Spring Bean retrieval: ✅ Correct**

**ApplicationContext: ✅ Correct**

**No `new`: ✅ Correct**

**Required method name: ❌ Minor mistake**

So you're clearly understanding the exercise. The important thing is that you demonstrated **"Spring creates/manages the object, and I retrieve it from the container"** rather than manually constructing it.
