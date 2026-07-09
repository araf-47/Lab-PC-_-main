In Java, a **Map** is a part of the **Java Collections Framework** that stores data in **key–value pairs**.

### Simple definition

A **Map** lets you associate one value with a unique key, kind of like a real dictionary:

- **Key** → unique identifier
    
- **Value** → data linked to that key


---

### Example

```java
import java.util.HashMap;
import java.util.Map;

public class Example {
    public static void main(String[] args) {
        Map<String, Integer> ages = new HashMap<>();

        ages.put("Alice", 25);
        ages.put("Bob", 30);

        System.out.println(ages.get("Alice")); // Output: 25
    }
}
```

---

### Key points

- Keys are **unique** (no duplicates allowed)
    
- Values **can be duplicated**
    
- Each key maps to **exactly one value**
    
- Common methods:
    
    - `put(key, value)` → add/update data
        
    - `get(key)` → retrieve value
        
    - `remove(key)` → delete entry
        
    - `containsKey(key)` → check if key exists


---

### Common Map implementations

- `HashMap` → fast, no order guarantee
    
- `LinkedHashMap` → maintains insertion order
    
- `TreeMap` → sorted by keys


---

### Real-world analogy

Think of a phone book:

- Name = key
    
- Phone number = value
