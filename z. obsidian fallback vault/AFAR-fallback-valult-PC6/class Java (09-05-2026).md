### 18.10 Tail Recursion


# Chapter : 19 Generics
Generics enable you to detect errors at compile time rather than at runtime.

you must use wrapper class in generic.

- **Generic in class and object** : declare first then use.
```java
public class GenericEx <Araf, Fara> { // this is generic inside <> .
    Araf a;
    Fara b;

    public GenericEx(Araf a){
        this.a = a;
    }

    // public GenericEx(Fara b){ // this is incorrect overloading. 
    //     this.a = a;
    //     this.b = b;
    // }

    public GenericEx(Araf a ,Fara b){
        this.a = a;
        this.b = b;
    }

    public Araf getA(){
        return a;
    }

    public Fara getB(){
        return b;
    }
}
```

```java
public class genericTest {
    public static void main(String[] args) {
        // GenericEx<Integer> age = new GenericEx<Integer>(25);
        // System.out.println(age.getA());
        // GenericEx<String> name = new GenericEx<String>("Araf is my name.");
        // System.out.println(name.getA());
        GenericEx<String, String> name = new GenericEx<String, String>("Araf", "Arifa");
        System.out.println(name.getA() + " " + name.getB()); 
        // I also could have done this: GenericEx<String, Integer> name = new GenericEx<String, Integer>("Araf", "Arifa");
    }
}
```

### 19.4 Generic Methods
we can use generic in method too.
```java
	public <C> void Grrr(C c){
		System.out.println(c + "is GAAAAY.");
	}
```

```java
        name.<String>Grrr("Modi ");
```

method's generic in limited to that method. same goes for class.

### 19.6 Raw Types and Backward Compatibility

### 19.7 Wildcard Generic Types
- **unbounded wildcard**:- `<Object, ?>` <- here anything can come in. 
- **boundary wildcard**:- `Object, ? extends Number` <- here only numbers subclasses or child can be here. This is *upper bound*.
	- `Object, ? super Number` <- now only the Numbers parents can be here. This is *lower bound*.

### 19.8 Erasure and Restrictions on Generics
it's just an approach.

- Restriction 3: A Generic Type Parameter of a Class Is Not Allowed in a Static Context
- Restriction 4: Exception Classes Cannot Be Generic
	- there is no generic in exception.
- 