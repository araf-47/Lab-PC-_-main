### 10.11 The [[StringBuilder and StringBuffer Classes (i2Java)]].
10.11.1 Modifying Strings in the StringBuilder
```java
        StringBuilder sb = new StringBuilder("Hello");

        sb.append(" Kodom Ali.");
        sb.insert(5, ",");

        String sss = sb.toString();
        System.out.println(sss);
```

- 10.11.2 The toString, capacity, length, setLength, and charAt Methods.
	- length and capacity are the same thing.

`trimToSize()`

# INHERITANCE AND POLYMORPHISM

### 11.1 Introduction
private member is not inheritable.

benefit:
	reusability 

### 11.2 Superclasses and Subclasses
parent is super-class.
child is sub-class.


multiple inheritance
single inheritance
and many more (learn from the internet.)

Java by default doesn't support multiple inheritance with classes. 
	alternative approach: you can do this with interface.


### 11.3 Using the super Keyword
if superclass has a argument constructor, subclass must call the superclass argument constructor. key word is `super(1);` (1) is just the argument for the argument constructor.
argument constructor must be handled manually.
■ To call a superclass constructor.
■ To call a superclass method.

### 11.3.2 Constructor Chaining
11.3.3 Calling Superclass Methods

### 11.4 Overriding Methods
overwriting vs overloading.

### 11.5 Overriding vs. Overloading
this is known as polymorphism.

in overloading parameter change.
	compiletime error
	
in overwriting body change.
	runtime error.
	must be related to inheritence.

### 11.6 The Object Class and Its toString() Method
Every class in Java is descended from the java.lang.Object class.

### 11.7 Polymorphism
Polymorphism means that a variable of a supertype can refer to a subtype object.
class supertype, object subtype.
same object act different in different container.
possible by overwriting and overloading.

### 11.8 Dynamic Binding
because of it the nearest subclass will be most active

### 11.9 Casting Objects and the instanceof Operator11.9 Casting Objects and the instanceof Operator
check: `sss instanceof subClass` > `sss` is a variable. `subClass` > 

### 11.10 The Object’s equals Method
it checks object's state.

### array list
it's dynamic. even though array is fixed in java. same as javaScripts array (push, pop).
only study for mcq.
==it has it's very own chapter so don't study it too hard right now.==

# EXCEPTION HANDLING AND TEXT I/O

### 12.2 Exception-Handling Overview
```java
try {
	...
} catch (Exeption e) {
	...
} finally {
	... //it will run even if no exception.
}
```

throw statement.

- 2 ways to handle 
	- 1 try catch
	- throws

### 12.3 Exception Types
error crashes the application. (i.g = ram full or hdd full.)
errors are system errors.

### 12.4.1 Declaring Exceptions
customized exception.

### 12.4.2 Throwing Exceptions

### 12.4.3 Catching Exceptions
can put multiple exception.  But the order should be child -> parent -> parent

### 12.4.4 Getting Information from Exceptions
`printStackTrace(): void`.