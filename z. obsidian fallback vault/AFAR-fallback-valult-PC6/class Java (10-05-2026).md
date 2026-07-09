# Ch. LISTS, STACKS, QUEUES, AND PRIORITY QUEUES
- data structure are all live inside `Collection` framework
	- Framework: a set of interface, classes and everything.
- Data structure: manageable architecture of data.
- array is a type of data structure.
- object : `key : value` pair
	- key : value, key : value, key : value,

### 20.2 Collections
FIGURE 20.1 A collection is a container that stores objects.
most used to least : HashSet TreeSet || ArrayList
- Iterator
	- +hasNext(): boolean
	- +next(): E
	- +remove(): void

```java
import java.util.Collection;
import java.util.ArrayList;

public class CollectionA {
    public static void main(String[] args) {
        Collection<String> aCollection = new ArrayList<>();

        aCollection.add("Araf");
        aCollection.add("Afar");
        aCollection.add("Fara");
        aCollection.add("Aarf");
        aCollection.add("Faar");
        aCollection.add("Araf2");
        aCollection.add("Araf3");
        aCollection.add("Araf4");
        aCollection.add("Araf5");
        aCollection.add("Araf6");

        aCollection.remove("Araf3");
        System.out.println(aCollection);
        System.out.println(aCollection.hashCode());

        Collection<String> a2Collection = new ArrayList<>();
        a2Collection.add("Araf 7");
        a2Collection.add("Araf 8");
        // a2Collection.clear();
        System.out.println("is the collection empty? : " + a2Collection.isEmpty());
        System.out.println(a2Collection.equals(aCollection));
        System.out.println(a2Collection);
    }
}
```

### 20.3 Iterators
it is an object. I has different methods.

+hasNext(): boolean
+next(): E
+remove(): void
### 20.4 Lists
- is array length = array size . space Full.
- if the space is full new array will be double in length to previous. and then the previous data will be copied to the new double sized array.

- list: is a linear data structure. [storing elements in a sequential order] like with index.
	- FIGURE 20.3 The List interface stores elements in sequence and permits duplicates.
		- FIGURE 20.4 ListIterator enables traversal of a list bidirectionally.

#### 20.4.2 The ArrayList and LinkedList Classes
cons array list
	double length for extending the array each time.
		Solution to this is LinkList
	single time operation.

- **LinkedList**
	- java link list is advance it's double link list.
	- n time operation.

- FIGURE 20.5 ArrayList implements List using an array.
- FIGURE 20.6 LinkedList provides methods for adding and inserting elements at both ends of the list.

list can have duplicate items.

### 20.5 The Comparator Interface

same class same object comparable . Different class different object `Comparator`.

### 20.6 Static Methods for Lists and Collections
FIGURE 20.7 The Collections class contains static methods for manipulating lists and collections

### 20.8 Vector and Stack Classes
vector thread safe. arraylist is not thread safe.
vector is synchronized, one thread at a time.

FIGURE 20.10 Starting in Java 2, the Vector class extends AbstractList and also retains all the methods in the original

 `Enumeration<E>` - same as iterator.
##### Stack
Last in first out.

- FIGURE 20.11 The Stack class extends Vector to provide a last-in, first-out data  structure.

### 20.9 Queues and Priority Queues
#### Queues
First in first out.
- FIGURE 20.12 The Queue interface extends Collection to provide additional insertion, extraction, and inspection operations.

#### Priority Queues
FIGURE 20.14 The PriorityQueue class implements a priority queue.

***
# HW
String brackets; //[], [{()}], 
I will input something like "[({})]" and It will output whether it is valid or invalid
***
**from Sir himself.**
```text
    // boolean validateBrackers(String brackets)
    // Sample input -> "[{()}][]()"
    // 2 rules 
    // 1. Every opening bracket must have a closing bracket
    // 2. The brackets must be closed in the correct order
```