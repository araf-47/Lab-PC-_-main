- Static variable owner is `class`.
- `int id;` <- the owner of this is instance (/object).

### 9.8 Visibility Modifiers
`public` =
`private` = `private int age;`
protected <- only accessible inside the package/folder. `protected static int id;`
- inside class scope all methods, fields, function are members.

### 9.9 Data Field Encapsulation
- hiding data is called data encapsulation.
- according to encapsulation data must be hidden. (so no `protected`)

class file:
```java
public class ClassAraf {
    private int publicKey;
    public void keyGen(int key){
        if (key < 100){
            publicKey = (int) (Math.random() * 100);
            System.out.println("you have genareted a valid Public key. " + publicKey);
        } else {
            System.out.println("Not accepted .Do it again.");
        }
    };
}

```

main file:
```java
public class ObjectAndClass {
    public static void main(String[] args) {
        ClassAraf varify = new ClassAraf();
        // varify.publicKey = 2000;
        varify.keyGen(200);
    }
}
```

### 9.10 Passing Objects to Methods


### 9.11 Array of Objects
`int`, `double`  data type<- all of them are also class. all class in java can be declared as data type.

### 9.12 Immutable Objects and Classes
- state can be created but can't be modified.
- we can do it via `constractor()` it constructs new object every time we calls it. so the original one cant
- garbage collector

For a class to be immutable, it must meet the following requirements:
 ■ All data fields must be private.
 ■ There can’t be any mutator (setter method) methods for data fields.
 ■ No accessor methods can return a reference to a data field that is mutable. (<- not mendetory to fullfill this condition.)

### 9.13 The Scope of Variables
- all blocks are scope.
- inside class scope, all are global variables.
- inside same block you cant declare to variable with same name. but you can if it's in a different block.

### 9.14 The this Reference


- hidden variable
	- to grab it we use `this`

# HW
`txt pg: 362` - 9.9