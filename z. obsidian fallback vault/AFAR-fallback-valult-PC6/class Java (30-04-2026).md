### Abstract || 10.2 Class Abstraction Encapsulation 
- means that the method doesn't need a body.
`public abstract void printNum();`
- if method is abstract its class must also be abstract.
	- it keeps the methods signature.
```java
public abstract class abstractEx {
    public abstract void printNum();
}
```
now the abstract method must need a body in order for it to work.
- `implementation` 
```java
public class AbstractExImpl extends AbstractEx {
    @Override
    public void printNum(){
        System.out.println(1);
    }
}
```

***
we can't construct abstract class normally. we have to mention child the `implementation` in the constructor. 
- you can't create 
```java
public class playground2 {
    public static void main(String[] args) {
        AbstractEx abs = new AbstractExImpl();
        abs.printNum();
    }
}
```

- `interface`
	- in `interface` all methods are by default abstract and public.
	- so we don't have to always write `abstract` and `public`.
```java
public interface InnerInterfaceEx {
    void printString();   
}
```
??????????

- Encapsulation 
	- learned in previous class [[class Jave (29-04-2026)]].


- default constructor is no argument constructor. 
- when ever we declare a constructor with argument in a class the no argument constructor is gone.
- constructor doesn't have any return type.
### Object oriented paradigm 
- 2 type
	- functional programming || object oriented programming.

### 10.4 Class Relationships
==definitions from the book are harder. learn them from the internet.==
`has a` dependency 
- association, 
	- a obj has another obj both are independent.
	- ~~one class inherits another class.~~
	- both are independent.
- aggregation, 
	- one independent, one dependent.
	- ~~child is dependent on parents~~
	- ownership.
		- owner vs tenant.
		- library vs book.
- composition.
	- both are dependent on each other.
`has a` relation

- inheritance (`is a` relation goes toward parents.)
	- parent child relation.

### 10.7 Processing Primitive Data Type Values as Objects
wrapper class. 
supports null.
we can call method from it.
It can be used both as object and primitive data.

```java
        char c = 'a';
        Character c2 = c;
        System.out.println(c2);
```

### 10.8 Automatic Conversion between Primitive Types and Wrapper Class Types
boxing
unboxing
autoboxing
autounboxing

every wrapper class has `toString`
### 10.9 The BigInteger and BigDecimal Classes
doesn't matter how big it will take it.

### 10.10 The String Class
immutable

- string pool
	- heap
```java
String s = "sss";
String s1 = new String();
String s1 = new String("any value");
```

`==` in java check reference. only.
```java
        String s = "sss";
        String s1 = new String("sss"); 
        System.out.println(s == s1); //false
```

```java
        String s = "sss";
        String s1 = new String("sss");
        System.out.println(s.equals(s1)); //true
```

`.replace`
`.split`

#### 10.10.4 Matching, Replacing and Splitting by Patterns
#### 10.10.5 Conversion between Strings and Arrays
#### 10.10.6 Converting Characters and Numeric Values to Strings
#### 10.10.7 Formatting Strings
#### 10.11 The StringBuilder and StringBuffer Classes
not  safe for parallel operation.
StringBuilder faster.  StringBuffer slower.
# others
