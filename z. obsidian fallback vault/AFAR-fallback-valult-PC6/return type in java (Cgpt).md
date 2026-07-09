In Java Programming, a **return type** tells what kind of value a method gives back after it finishes running.

---

# Basic Syntax

```java id="nnw9gv"
returnType methodName() {

}
```

Example:

```java id="uxg4h1"
int add() {
    return 5;
}
```

Here:

* `int` = return type
* method returns an integer value

---

# Why Return Type Is Needed

Imagine a method as a machine:

* Input goes in
* Work happens
* Output comes out

The **return type** defines the output type.

---

# Example 1: Returning an Integer

```java id="1o03yy"
public class Main {

    static int add(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {

        int result = add(5, 3);

        System.out.println(result);
    }
}
```

Output:

```text
8
```

Here:

* `int` means method returns an integer
* `return a + b;` sends the value back

---

# Example 2: Returning String

```java id="wr1m7w"
static String getName() {
    return "Rahim";
}
```

Return type is `String`.

---

# Example 3: Returning Boolean

```java id="q84r44"
static boolean isAdult(int age) {
    return age >= 18;
}
```

Returns:

* `true`
* or `false`

---

# `void` Return Type

Sometimes a method returns nothing.

Then we use `void`.

```java id="b4v3jw"
static void greet() {
    System.out.println("Hello");
}
```

`void` means:

> “This method does not return any value.”

---

# Important Rule

If a method has a return type:

```java id="mt3xqt"
int sum() {

}
```

then it MUST return something:

```java id="08v6i4"
int sum() {
    return 10;
}
```

Otherwise Java gives an error.

---

# Common Return Types

| Return Type | Meaning          | Example           |
| ----------- | ---------------- | ----------------- |
| `int`       | Integer          | `return 5;`       |
| `double`    | Decimal number   | `return 5.5;`     |
| `char`      | Single character | `return 'A';`     |
| `String`    | Text             | `return "Hello";` |
| `boolean`   | true/false       | `return true;`    |
| `void`      | Nothing          | no return value   |

---

# Real-Life Analogy

Think of a vending machine:

* You press a button
* Machine processes
* Product comes out

The product is like the **return value**.

The type of product is the **return type**.

---

# Easy Way to Remember

```text
return type = what comes back from the method
```

Examples:

```java id="7q6qkg"
int      -> returns number
String   -> returns text
boolean  -> returns true/false
void     -> returns nothing
```

---

# Mini Practice

Try to guess the return type:

```java id="v37s8u"
static double price() {
    return 99.99;
}
```

Answer:

```text
double
```

---

# One More Important Thing

This:

```java id="lgn2dy"
return 5;
```

is called a **return statement**.

It:

1. sends value back
2. stops the method immediately

---

You’re currently learning one of the most important Java concepts. Once return types become clear, methods and OOP become much easier.
