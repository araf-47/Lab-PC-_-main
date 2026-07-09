`ag.math = 41;` is not working because you placed it directly inside the class body of `Tempu`.

In Java, you cannot write normal statements directly inside a class body. Statements must be inside:

* a method
* a constructor
* an initializer block

Your code:

```java
class Tempu{
    Method ag = new Method();
    ag.math = 41;   // ❌ invalid
}
```

`ag.math = 41;` is a statement, so Java throws an error.

You can fix it like this:

```java
class Tempu{
    Method ag = new Method();

    Tempu() {
        ag.math = 41;
    }
}
```

Or inside a method:

```java
class Tempu{
    Method ag = new Method();

    void setValue() {
        ag.math = 41;
    }
}
```

Also, another issue in your code:

```java
public void main(String[] args)
```

should be:

```java
public static void main(String[] args)
```

because `main` must be static.

Correct full version:

```java
public class Method {

    int math = 50;

    public static void main(String[] args) {

        ageV(14);

        Method obj = new Method();
        System.out.println(obj.math);
    }

    static void ageV(int age){
        if (age >= 18){
            System.out.println("Voter.");
        } else{
            System.out.println("Not a voter.");
        }
    }
}

class Tempu {

    Method ag = new Method();

    Tempu() {
        ag.math = 41;
        System.out.println(ag.math);
    }
}
```

Output:

```text
Not a voter.
41
```
