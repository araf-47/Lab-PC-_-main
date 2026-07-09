# Chapter 21: Set and Maps

```java
import java.util.*;
import java.util.HashMap;

public class MapSets {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();

        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");


        System.out.println(map);
```

### 21.2.1 HashSet
String that can't be reversed.
`ABC` = `656667`
idempotenci -> if there's `ABAB` the hash will still be `6566` not ~~`65666566`~~.
load factor

### Set
- [[what is Set in java (11-05-26)]].

```Java
        Set<String> set = new HashSet<>();

        set.add("A");
        set.add("B");
        set.add("C");

        System.out.println(set);

        set.remove("A");
        System.out.println(set);

        System.out.println((set.contains("B")));
```

- Duplicate free data. Using set we can achieve duplicate free data.

set are generally unsorted.
Sorted set is possible.
### 21.2.1 HashSet
can have duplicate Hash.
FIGURE 21.1 The Java Collections Framework provides three concrete set classes

### 21.2.2 LinkedHashSet
FIGURE 21.1 The Java Collections Framework provides three concrete set classes

### 21.2.3 TreeSet
headSet(toElement)
tailSet(fromElement)

LISTING 21.4 TestTreeSet.java

### 21.3 Comparing the Performance of Sets and Lists

`set.contains("anything")`. If exists, use loop to get the item out.

### 21.5 Maps
- [[What is map in java (11-05-26)]].

key to hash to array index