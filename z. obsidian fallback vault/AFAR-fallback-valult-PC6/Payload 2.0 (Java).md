
# Conditional sum
The term **"Conditional Sum"** in programming isn't a strict mathematical rule like a "square root." Instead, it is a logic pattern where you calculate a total (sum) based on a specific **condition** or **trigger**.

In the context of the code you provided, the "condition" isn't about _which_ numbers to add, but rather _when to stop_ adding.

---

## 1. The Concept

Imagine you have a piggy bank. You keep dropping coins into it one by one. You don't know how many coins you will add today; you just keep going until you decide to stop.

In your code, the "Condition" is: **"Keep adding numbers until the user types -1."**

- If the user types `5`, `10`, and `2`, the sum is `17`.
    
- The moment they type `-1`, the program "breaks" the loop and shows the final total.

In programming, `-1` is often called a **Sentinel Value**. It’s a special flag used to signal the end of a process.

---

## 2. Explaining Your Code

Let's break down your code into bite-sized pieces:

### The Setup

```java
int sum = 0; // This is your 'bucket' to hold the total.
```

You start with zero. If you don't start at zero, your total will be wrong!

### The Infinite Loop



```java
while (true) { ... }
```

This tells Java: "Keep doing the stuff inside these brackets forever." Because the condition is simply `true`, it will never stop on its own.

### The Input & The "Exit Door"



```java
int input = scanner.nextInt(); // Get a number from the user.

if (input == -1) { 
    break; // This is the 'Exit Door'. It stops the 'while' loop immediately.
}
```

### The Accumulation

Java

```
sum += input; // This is short for: sum = sum + input;
```

If the input was NOT `-1`, the program takes that number and adds it to your "bucket."

---

## 3. Simplified Version

Since you mentioned you are a "newbie," here is that same logic stripped down to the bare minimum to make it even easier to read:


```Java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int total = 0;

        System.out.println("Enter numbers (Type -1 to stop):");

        // Keep looping until the input is -1
        int input = 0; 
        while (input != -1) {
            input = sc.nextInt();
            
            if (input != -1) {
                total = total + input;
            }
        }

        System.out.println("Total Sum: " + total);
    }
}
```

### Key Differences in the Simplified Version:

- **`while (input != -1)`**: Instead of an infinite loop (`true`), the loop itself checks for the "stop" condition.
    
- **`total = total + input`**: I avoided the `+=` shortcut to make it very clear that you are taking the old total, adding a new number, and saving it back.

Does the idea of a "==Sentinel Value==" (using -1 to stop a loop) make sense to you?

# 