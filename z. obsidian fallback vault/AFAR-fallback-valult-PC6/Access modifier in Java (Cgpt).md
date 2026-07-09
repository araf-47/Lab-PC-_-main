In Java Programming, `public`, `private`, `protected`, and `default` are called **access modifiers**.

They control **who can access variables, methods, classes, or constructors**.

Think of them like doors with different permission levels.

---

# 1. `public` → Accessible Everywhere

If something is `public`, any class can use it.

```java id="q1xj0j"
public class Car {

    public String brand = "Toyota";

    public void start() {
        System.out.println("Car started");
    }
}
```

Another class can access it:

```java id="4eytn6"
Car c = new Car();

System.out.println(c.brand);
c.start();
```

✅ Accessible:

* Same class
* Same package
* Different package
* Everywhere

---

# 2. `private` → Accessible Only Inside Same Class

`private` is the most restricted.

```java id="xjlwm9"
public class BankAccount {

    private double balance = 5000;

    private void showBalance() {
        System.out.println(balance);
    }
}
```

This will NOT work outside the class:

```java id="jk7x0z"
BankAccount b = new BankAccount();

System.out.println(b.balance); // ERROR
```

✅ Accessible:

* Same class only

❌ Not accessible:

* Outside class

Why use it?

* To protect data
* To hide internal details

This is called **encapsulation**.

---

# 3. `protected` → Same Package + Child Classes

`protected` is a little more open.

```java id="f58d0w"
protected int speed;
```

✅ Accessible:

* Same class
* Same package
* Subclasses (child classes)

❌ Not accessible:

* Unrelated classes in different packages

Used mostly with **inheritance**.

Example:

```java id="u18jcv"
class Animal {
    protected void sound() {
        System.out.println("Animal sound");
    }
}

class Dog extends Animal {

    void bark() {
        sound(); // allowed
    }
}
```

---

# 4. `default` (No Modifier)

If you write nothing:

```java id="n56q4z"
class Student {

    int age;

    void display() {
        System.out.println(age);
    }
}
```

This is called **default access** or **package-private**.

✅ Accessible:

* Same class
* Same package

❌ Not accessible:

* Different package

---

# Easy Comparison Table

| Modifier    | Same Class | Same Package | Child Class | Different Package |
| ----------- | ---------- | ------------ | ----------- | ----------------- |
| `public`    | ✅          | ✅            | ✅           | ✅                 |
| `protected` | ✅          | ✅            | ✅           | ❌                 |
| `default`   | ✅          | ✅            | ❌           | ❌                 |
| `private`   | ✅          | ❌            | ❌           | ❌                 |

---

# Real-Life Analogy

Imagine a house:

* `public` → Front yard (everyone can enter)
* `protected` → Family area
* `default` → Only neighbors
* `private` → Your bedroom

---

# Most Common Usage

### Variables → Usually `private`

```java id="f7m0pn"
private int age;
```

### Methods → Often `public`

```java id="xfl6sj"
public void showData() {
}
```

---

# Beginner Tip

For now, remember this rule:

* Use `private` for data
* Use `public` for methods
* Learn `protected` later with inheritance
* `default` happens when no modifier is written

That alone is enough for most beginner Java programs.
