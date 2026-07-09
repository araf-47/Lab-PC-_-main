### 4.2.2 Exponent Methods
```java
        double pow = Math.pow(2,3);
        System.out.println(pow);
```
### 4.2.3 The Rounding Methods
- ceil(x) x is rounded up to its nearest integer. This integer is returned as a double value.
- floor(x) x is rounded down to its nearest integer. This integer is returned as a double value.
- ~~rint(x) x is rounded up to its nearest integer. If x is equally close to two integers, the even one is returned as a double value.~~ <- ==No need==
- round(x) Returns (int)Math.floor(x + 0.5) if x is a float and returns (long)Math.floor(x + 0.5) if x is a double.

### 4.2.4 The min, max, and abs Methods
```java
        System.out.println(Math.max(4, Math.max(5,6)));
```

### 4.2.5 The random Method
`Math.random()` <- make a random range like 0-9

### 4.3 Character Data Type and Operations

### 4.3.2 Escape Sequences for Special Characters
- TABLE 4.5 Escape Sequences
```java
        String escC = "first line ,\nsecond line.";
        System.out.println(escC);

        String escC2 = "first line \rsecond line.";
        System.out.println(escC2);
```

### 4.3.3 Casting between char and Numeric Types
- we can do arithmetic operation with character. ASCII table value will be the default value.

### 4.3.4 Comparing and Testing Characters

### 4.4 The String Type
- TABLE 4.7 Simple Methods for String Objects.
#### 4.4.5 Reading a String from the Console
`next.line()` 

# HW
4.5 <- 