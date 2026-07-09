# Chapter 9 : object and class
- all data types are class in java.
- **constructor**: is a special method.
- all primitives default to `0`.
- Boolean default -> `false`.
- all the others are `null`.
- `new` is a keyword that calls constructor. without it you cant call constructor.
- folders in java are called package.

LISTING 9.2 SimpleCircle.java

class practice: 
this is the class
```java
public class ClassAraf {
    int publicKey;

    void pub (int pubArg){
        if (pubArg == 7){
            publicKey = pubArg;
            System.out.println(publicKey);
        } else {
            System.out.println("system corrupted");
        }
    }


}
```

this is object making from the class
```java
public class ObjectAndClass {
    public static void main(String[] args) {
        ClassAraf varify = new ClassAraf();

        // varify.pub(8);
        varify.pub(7);
        
    }
}
```
### 9.4 Constructing Objects Using Constructors
