# Java Loops — Complete Master Guide

Loops are one of the most important parts of programming.  
If you master loops, you unlock:

- automation
    
- problem solving
    
- algorithms
    
- data structures
    
- games
    
- AI logic
    
- competitive programming


In Java, loops let your program repeat actions.

---

# 1. What is a Loop?

A loop repeats code until a condition becomes false.

Example:

```java
System.out.println("Hello");
System.out.println("Hello");
System.out.println("Hello");
```

This is repetitive.

Using a loop:

```java
for(int i = 0; i < 3; i++) {
    System.out.println("Hello");
}
```

Output:

```text
Hello
Hello
Hello
```

---

# 2. Types of Loops in Java

Java has 4 main loop types:

|Loop|Use Case|
|---|---|
|`for`|Known number of repetitions|
|`while`|Unknown repetitions|
|`do-while`|Must run at least once|
|`enhanced for`|Loop through arrays/collections|

---

# 3. The `for` Loop

The most common loop.

Syntax:

```java
for(initialization; condition; update) {
    // code
}
```

Example:

```java
for(int i = 1; i <= 5; i++) {
    System.out.println(i);
}
```

Output:

```text
1
2
3
4
5
```

---

# 4. Understanding Each Part

```java
for(int i = 1; i <= 5; i++)
```

### Initialization

```java
int i = 1;
```

Runs once.

---

### Condition

```java
i <= 5
```

Loop runs while true.

---

### Update

```java
i++
```

Runs after each iteration.

---

# 5. Loop Flow

Flow of execution:

```text
1. initialization
2. condition check
3. loop body
4. update
5. repeat
```

---

# 6. Visualizing a `for` Loop

```java
for(int i = 1; i <= 3; i++) {
    System.out.println(i);
}
```

### Iteration 1

```text
i = 1
1 <= 3 → true
print 1
i becomes 2
```

### Iteration 2

```text
i = 2
2 <= 3 → true
print 2
i becomes 3
```

### Iteration 3

```text
i = 3
3 <= 3 → true
print 3
i becomes 4
```

### Iteration 4

```text
i = 4
4 <= 3 → false
STOP
```

---

# 7. Increment Operators

## `i++`

Increase by 1.

```java
i++;
```

Equivalent to:

```java
i = i + 1;
```

---

## `i--`

Decrease by 1.

```java
i--;
```

---

# 8. Counting Backward

```java
for(int i = 5; i >= 1; i--) {
    System.out.println(i);
}
```

Output:

```text
5
4
3
2
1
```

---

# 9. Skip Values

Increase by 2:

```java
for(int i = 0; i <= 10; i += 2) {
    System.out.println(i);
}
```

Output:

```text
0
2
4
6
8
10
```

---

# 10. Infinite Loops

A loop that never ends.

```java
for(;;) {
    System.out.println("Forever");
}
```

OR

```java
while(true) {
    System.out.println("Forever");
}
```

Danger:

- high CPU usage
    
- program freeze
    

Stop with:

```text
Ctrl + C
```

---

# 11. The `while` Loop

Used when repetitions are unknown.

Syntax:

```java
while(condition) {
    // code
}
```

Example:

```java
int i = 1;

while(i <= 5) {
    System.out.println(i);
    i++;
}
```

---

# 12. `for` vs `while`

## Use `for` when:

You know repetition count.

Example:

- print 1–100
    

---

## Use `while` when:

Condition decides stopping.

Example:

- keep asking password until correct
    

---

# 13. The `do-while` Loop

Runs at least once.

Syntax:

```java
do {
    // code
} while(condition);
```

Example:

```java
int i = 1;

do {
    System.out.println(i);
    i++;
} while(i <= 5);
```

---

# 14. Why `do-while` Exists

Because sometimes you must execute first.

Example:

- menu system
    
- asking user input
    

Even if condition is false initially, body runs once.

---

# 15. Difference Between `while` and `do-while`

## `while`

Condition checked FIRST.

## `do-while`

Condition checked LAST.

Example:

```java
int i = 10;

while(i < 5) {
    System.out.println("Hello");
}
```

Nothing prints.

---

But:

```java
int i = 10;

do {
    System.out.println("Hello");
} while(i < 5);
```

Prints once.

---

# 16. Enhanced `for` Loop (For-Each)

Used with arrays and collections.

Syntax:

```java
for(type variable : collection) {
    // code
}
```

Example:

```java
int[] nums = {10, 20, 30};

for(int n : nums) {
    System.out.println(n);
}
```

Output:

```text
10
20
30
```

---

# 17. Traditional vs Enhanced `for`

Traditional:

```java
for(int i = 0; i < nums.length; i++) {
    System.out.println(nums[i]);
}
```

Enhanced:

```java
for(int n : nums) {
    System.out.println(n);
}
```

Enhanced loop is cleaner.

---

# 18. Nested Loops

A loop inside another loop.

Example:

```java
for(int i = 1; i <= 3; i++) {
    for(int j = 1; j <= 2; j++) {
        System.out.println(i + " " + j);
    }
}
```

Output:

```text
1 1
1 2
2 1
2 2
3 1
3 2
```

---

# 19. How Nested Loops Work

Outer loop controls rows.

Inner loop completes entirely each outer iteration.

Think:

```text
Outer loop:
    Inner loop finishes fully
Outer loop next iteration:
    Inner loop finishes fully
```

---

# 20. Pattern Problems

Very important for mastering loops.

---

## Square Pattern

```java
for(int i = 1; i <= 4; i++) {
    for(int j = 1; j <= 4; j++) {
        System.out.print("* ");
    }
    System.out.println();
}
```

Output:

```text
* * * *
* * * *
* * * *
* * * *
```

---

# 21. Triangle Pattern

```java
for(int i = 1; i <= 5; i++) {
    for(int j = 1; j <= i; j++) {
        System.out.print("* ");
    }
    System.out.println();
}
```

Output:

```text
*
* *
* * *
* * * *
* * * * *
```

---

# 22. Reverse Triangle

```java
for(int i = 5; i >= 1; i--) {
    for(int j = 1; j <= i; j++) {
        System.out.print("* ");
    }
    System.out.println();
}
```

---

# 23. Number Patterns

```java
for(int i = 1; i <= 5; i++) {
    for(int j = 1; j <= i; j++) {
        System.out.print(j + " ");
    }
    System.out.println();
}
```

Output:

```text
1
1 2
1 2 3
1 2 3 4
1 2 3 4 5
```

---

# 24. `break`

Stops loop immediately.

Example:

```java
for(int i = 1; i <= 10; i++) {

    if(i == 5) {
        break;
    }

    System.out.println(i);
}
```

Output:

```text
1
2
3
4
```

---

# 25. `continue`

Skips current iteration.

```java
for(int i = 1; i <= 5; i++) {

    if(i == 3) {
        continue;
    }

    System.out.println(i);
}
```

Output:

```text
1
2
4
5
```

---

# 26. Labeled Loops

Rare but important.

```java
outer:
for(int i = 1; i <= 3; i++) {

    for(int j = 1; j <= 3; j++) {

        if(j == 2) {
            break outer;
        }

        System.out.println(i + " " + j);
    }
}
```

Breaks outer loop.

---

# 27. Common Mistakes

---

## Forgetting Increment

```java
int i = 1;

while(i <= 5) {
    System.out.println(i);
}
```

Infinite loop.

---

## Wrong Condition

```java
for(int i = 1; i >= 5; i++)
```

Never runs.

---

## Semicolon Mistake

WRONG:

```java
for(int i = 1; i <= 5; i++);
{
    System.out.println("Hello");
}
```

Loop body is empty.

---

# 28. Loop Variable Scope

```java
for(int i = 0; i < 5; i++) {

}
```

`i` exists only inside loop.

This is invalid:

```java
System.out.println(i);
```

---

# 29. Multiple Variables in `for`

```java
for(int i = 0, j = 10; i < 5; i++, j--) {
    System.out.println(i + " " + j);
}
```

---

# 30. Omitting Parts of `for`

All optional.

```java
int i = 0;

for(; i < 5;) {
    System.out.println(i);
    i++;
}
```

---

# 31. Looping Through Arrays

```java
int[] arr = {5, 10, 15};

for(int i = 0; i < arr.length; i++) {
    System.out.println(arr[i]);
}
```

---

# 32. Understanding `.length`

Array size:

```java
arr.length
```

Very important to avoid:

```text
ArrayIndexOutOfBoundsException
```

---

# 33. Summing Numbers

```java
int sum = 0;

for(int i = 1; i <= 5; i++) {
    sum += i;
}

System.out.println(sum);
```

Output:

```text
15
```

---

# 34. Factorial

## Mathematical Formula

n! = 1 \times 2 \times 3 \times \cdots \times n

Example:

```java
int fact = 1;

for(int i = 1; i <= 5; i++) {
    fact *= i;
}

System.out.println(fact);
```

Output:

```text
120
```

---

# 35. Fibonacci Series

## Mathematical Relation

F_n = F_{n-1} + F_{n-2}

```java
int a = 0;
int b = 1;

for(int i = 1; i <= 10; i++) {
    System.out.println(a);

    int next = a + b;
    a = b;
    b = next;
}
```

---

# 36. Prime Number Check

```java
int n = 7;
boolean prime = true;

for(int i = 2; i < n; i++) {

    if(n % i == 0) {
        prime = false;
        break;
    }
}

System.out.println(prime);
```

---

# 37. Loop Complexity

Very important later.

---

## Single Loop

```java
for(int i = 0; i < n; i++)
```

Complexity:

```text
O(n)
```

---

## Nested Loop

```java
for(int i = 0; i < n; i++) {
    for(int j = 0; j < n; j++) {

    }
}
```

Complexity:

```text
O(n²)
```

---

# 38. Dry Run Technique

To master loops:

- write variable values on paper
    
- trace iteration by iteration
    

Example table:

|i|Output|
|---|---|
|1|1|
|2|2|
|3|3|

This is how professionals debug loops.

---

# 39. Sentinel Loops

Loop until special value entered.

Example:

```java
Scanner sc = new Scanner(System.in);

int num;

while(true) {

    num = sc.nextInt();

    if(num == -1) {
        break;
    }

    System.out.println(num);
}
```

`-1` is sentinel value.

---

# 40. Input Validation Loop

```java
Scanner sc = new Scanner(System.in);

int age;

do {
    System.out.print("Enter age: ");
    age = sc.nextInt();

} while(age < 0);
```

---

# 41. Real-Life Uses of Loops

Loops power:

- games
    
- animations
    
- web servers
    
- AI training
    
- file reading
    
- databases
    
- operating systems
    

Without loops, modern software is impossible.

---

# 42. Advanced Loop Tricks

---

## Reverse Array Traversal

```java
for(int i = arr.length - 1; i >= 0; i--) {
    System.out.println(arr[i]);
}
```

---

## Two-Dimensional Arrays

```java
int[][] matrix = {
    {1,2},
    {3,4}
};

for(int i = 0; i < matrix.length; i++) {

    for(int j = 0; j < matrix[i].length; j++) {
        System.out.print(matrix[i][j] + " ");
    }

    System.out.println();
}
```

---

# 43. Common Interview Problems

Practice these:

- factorial
    
- reverse number
    
- palindrome
    
- prime
    
- Fibonacci
    
- patterns
    
- multiplication table
    
- sum of digits
    

---

# 44. Best Practices

---

## Use meaningful names

BAD:

```java
for(int x = 0; x < 10; x++)
```

BETTER:

```java
for(int student = 0; student < 10; student++)
```

---

## Avoid infinite loops accidentally

Always verify:

- condition changes
    
- update exists
    

---

## Keep loops simple

Complex loops create bugs.

---

# 45. Loop Mental Models

Master these ideas:

---

## A loop is:

```text
repeat while condition is true
```

---

## Nested loops are:

```text
rows and columns
```

---

## Loop variables are counters

Track progress.

---

# 46. Master-Level Exercises

Do these yourself.

---

## Beginner

- print 1–100
    
- even numbers
    
- odd numbers
    
- multiplication table
    

---

## Intermediate

- factorial
    
- Fibonacci
    
- reverse digits
    
- prime checker
    

---

## Advanced

- pyramid patterns
    
- matrix operations
    
- sorting algorithms
    
- searching algorithms
    

---

# 47. The Most Important Loop Skill

The true mastery skill:

## TRACE EXECUTION

Ask:

- current variable value?
    
- current condition?
    
- next update?
    
- when does it stop?
    

If you can mentally simulate loops, you become strong at programming.

---

# 48. Golden Rules

---

## Rule 1

Initialization must happen correctly.

---

## Rule 2

Condition must eventually become false.

---

## Rule 3

Update must move toward stopping condition.

---

# 49. How Professionals Think About Loops

Professionals think in:

- iterations
    
- state changes
    
- conditions
    
- traversal
    
- complexity
    

Not just syntax.

---

# 50. Final Master Summary

You now know:

✅ `for` loop  
✅ `while` loop  
✅ `do-while`  
✅ enhanced `for`  
✅ nested loops  
✅ infinite loops  
✅ break/continue  
✅ arrays with loops  
✅ patterns  
✅ factorial  
✅ Fibonacci  
✅ prime checking  
✅ complexity  
✅ debugging  
✅ traversal logic

That is the foundation of almost all programming.

---

# Final Advice to Become Truly Good

Do not just read loops.

Type them yourself.

Then:

1. change values
    
2. predict output
    
3. run code
    
4. compare results
    

That repetition builds real skill.

---

# 10 Powerful Practice Problems

1. Print all prime numbers from 1–100
    
2. Reverse an integer
    
3. Check palindrome number
    
4. Find largest number in array
    
5. Count vowels in string
    
6. Print Floyd’s triangle
    
7. Create multiplication table
    
8. Bubble sort
    
9. Binary search
    
10. Matrix multiplication
    

Master these and loops will become natural.