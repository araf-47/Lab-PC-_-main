


### 2.11 Evaluating Expressions and Operator Precedence

### 2.13 Augmented Assignment Operators
```
+= Addition assignment i += 8 i = i + 8
-= Subtraction assignment i -= 8 i = i – 8
*= Multiplication assignment i *= 8 i = i * 8
/= Division assignment i /= 8 i = i / 8
% = Remainder assignment i % = 8 i = i % 8
```

### 2.14 Increment and Decrement Operators
```java
int i = 3;
System.out.println(i++);
System.out.println(--i);
System.out.println(i++);
System.out.println(i--);
```

### 2.15 Numeric Type Conversions
- `int` to `double` no need for explicit declaration.
- but `double` to `int` is different.

- `double` vs `Double` <- this is wrapper class. 

#### casting
```java
double num = 1.7;
int i = num; // error

double num = 1.7;
int j = (int) num; // correct.
```

### ~~2.16 Software Development Process~~ <- ❌

### 2.18 Common Errors and Pitfalls
`pdf pg: 88`
- integer overflow
	- `int value = 2147483647 + 1; // value will actually be -2147483648`
		- 2147483647 <- this is the max amount of `int` for 32 bit.

## Ch. 3 : selection

### 3.2 boolean Data Type
```java
        boolean ar = false;
        Boolean ar2 = true; //wrapper boolean
```

- TABLE 3.1 Relational Operators
	- Java doesn't have `===` like JS. the `==` is the same as triple equal.


### 3.3 if Statements
- Without `{}` a `if` or `else` block will take only one statement.
```java
		if (true) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
```


### 3.5 Nested if and Multi-Way if-else Statements
```java
        int b = 0;

        if (b < 0){
            System.out.println("F");
        } else {
            if (b == 0){
                System.out.println("Oh, yeah.");
            } else {
                System.out.println("fuck");
            }
        }
```

### 3.6 Common Errors and Pitfalls

- Common Error 3: ==Redundant Testing of Boolean Values==. <- job interview.
- Common Error 5: Equality Test of Two Floating-Point Values
	- Java problem not mathematical truth.


---
# Extras
- compile error <- syntax . [[runtime]] error <- logical error
- in java string + number is always results in string.
- Java doesn't have `===` like JS. the `==` is the same as triple equal.

# practice
- 2.28 What does an explicit casting from a double to an int do with the fractional part of the double value? Does casting change the variable being cast?
- 2.31 Show the output of the following code:
	double amount = 5;
	System.out.println(amount / 2);
	System.out.println(5 / 2);