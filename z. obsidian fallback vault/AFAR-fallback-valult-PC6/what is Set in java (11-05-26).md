In Java, a **Set** is a collection that stores **unique elements** only.

That means:

- No duplicate values allowed
    
- Elements are stored as single items (not key–value pairs like `Map`)


---

## Example

```java
import java.util.HashSet;
import java.util.Set;

public class Example {
    public static void main(String[] args) {
        Set<String> fruits = new HashSet<>();

        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Apple"); // duplicate

        System.out.println(fruits);
    }
}
```

### Output

```java
[Apple, Banana]
```

The second `"Apple"` is ignored because a `Set` cannot contain duplicates.

---

## Key Features of Set

- Stores only unique values
    
- No indexing like arrays/lists
    
- Useful when duplicates must be avoided
    

---

## Common Set implementations

### 1. `HashSet`

- Fastest
    
- No order guarantee
    

```java
Set<Integer> set = new HashSet<>();
```

---

### 2. `LinkedHashSet`

- Maintains insertion order
    

```java
Set<Integer> set = new LinkedHashSet<>();
```

---

### 3. `TreeSet`

- Stores elements in sorted order
    

```java
Set<Integer> set = new TreeSet<>();
```

---

## Difference between List, Set, and Map

|Feature|List|Set|Map|
|---|---|---|---|
|Stores duplicates?|Yes|No|Keys: No|
|Ordered?|Yes|Depends|Depends|
|Stores key-value pairs?|No|No|Yes|
|Example|`[1,1,2]`|`[1,2]`|`{A=1}`|

---

## Real-world analogy

A `Set` is like a collection of unique student IDs:

- You cannot have the same ID twice.
    

If you'd like, I can also explain:

- How `HashSet` works internally
    
- Difference between `Set` and `HashMap`
    
- Interview-style examples
    
- Time complexity of Set operations