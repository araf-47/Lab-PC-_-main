### 5.9 Keywords break and continue
```java
for (int i = 1; i <= 10; i++){
	if (i == 5){
		continue;
	} else if (i == 6){
		continue;
	}else if (i == 10){
		continue;
	}
	// System.out.println(i);
	System.out.println("araf " + i + " fara");
}
```

```java
// break.

for (int i = 1; i <= 10; i++){
	if (i == 5){
		continue;
	} else if (i == 6){
		continue;
	}

	if (i == 9){
		break;  //it will break the loop.
	}
	
	// System.out.println(i);
	System.out.println("araf " + i + " fara");
}
```

## Chapter 6 : Methods
A group of **statements** that performs a single task.
- `void` <- it doesn't return anything
- **static** modifier means it came from a `Class` not `object`
- **public** means I can use it from ~~other class~~ any where.
-  If a method returns a value, it is called a value-returning method; otherwise it is called a void method.
- ==method's name and parameter are called signature==.
-  main method 
	- starting point of java. 
- Last in first out. 
	- Each time a method is invoked, the system creates an activation record (also called an activation frame) that stores parameters and variables for the method and places the activation record in an area of memory known as a call stack. A call stack is also known as an execution stack, runtime stack, or machine stack, and it is often shortened to just “the stack.”
### 6.3 Calling a Method
`int larger = max(3, 4);`.

### 6.6 Modularizing Code

### 6.8 Overloading Methods
- methods names are same but parameter type or amounts are different.
```java
public static double max(int num1, int num2){
	if(num1 > num2){
		System.out.println(num1 + "is max.");
	} else {
		System.out.println(num2 + "is max.");
	}
}

public static double max(long num1, long num2){
	if(num1 > num2){
		System.out.println(num1 + "is max.");
	} else {
		System.out.println(num2 + "is max.");
	}
}
```

### 6.9 The Scope of Variables
- method / block level -> local variable.
- class level -> Global variable. 

### 6.11 Method Abstraction and Stepwise Refinement
expose methods name / signature only. not what is in side the body.
- hides the methods body. only shows the name of the methods or signature.
- method without body is abstract method.
```java
// created a new file name abst.java
public interface abst {
    // any thing without the methode body
}
```
- When writing a large program, you can use the divide-and-conquer strategy, also known as stepwise refinement, to decompose it into subproblems.

### 6.11.1 Top-Down Design
- tree structure.
- it is useful while debugging.
#### Bottom up 
This is the opposite of 

### 6.11.4 Benefits of Stepwise Refinement



# HW
- how many prime numbers are in ~~10~~ 2 Billion. just show the count. How many. **listing 5.15** 
	- Runtime has to be within 60 seconds.
- **6.3** -> palindrome integer. (`pdf pg. 257`/`pg. 234`).
	- condition: you can't convert the number into string.
- **6.4**

# Others information.
- Euler project > https://projecteuler.net/archives
- LeetCode > https://leetcode.com/problemset/all-code-essentials/

