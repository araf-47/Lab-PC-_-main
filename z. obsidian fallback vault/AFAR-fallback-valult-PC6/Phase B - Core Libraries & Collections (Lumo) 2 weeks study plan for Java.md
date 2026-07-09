Here is your comprehensive **2-Week Phase B Study Plan for Java: Core Libraries & Collections**.

This phase transitions you from "writing logic" to "writing robust, professional applications." You will master the tools every enterprise Java developer uses daily: the Collections Framework, Exception Handling, File I/O, and the modern Streams API.

### **Prerequisites**

- **Completion:** Ensure you feel comfortable with Classes, Objects, Inheritance, and Polymorphism from Phase A.
- **Tools:** Continue using IntelliJ IDEA (or VS Code) and your preferred AI mentor (**Claude** or **Cursor**).
- **JDK Version:** Stick to **Java 17 or 21** (LTS) to ensure you learn modern best practices (e.g., `var`, Records if needed, Switch expressions).

---

### **Week 3: The Collections Framework & Generics**

_Focus: Storing, organizing, and managing large amounts of data efficiently._

#### **Day 15: The Collections Hierarchy & Lists**

- **Topics:** `Collection` interface, `List` interface, `ArrayList`, `LinkedList`. Understanding references vs. values.
- **Practice Problem:** Create a `StringListManager`.
    1. Add 10 strings to an `ArrayList`.
    2. Insert an element at index 5.
    3. Remove the first occurrence of a specific value.
    4. Iterate through and print using a standard `for` loop, an enhanced `for` loop, and an `Iterator`.
- **🤖 AI Mentor Task:**
    - _Prompt:_ "I used an `ArrayList` to store my items. Explain how `ArrayList` grows internally when it hits capacity. What happens in memory? If I were going to do millions of 'add' operations, should I change anything?"
    - _Challenge:_ "Give me a scenario where `LinkedList` is strictly better than `ArrayList`. Write code demonstrating that specific operation."

#### **Day 16: Sets & Unique Data**

- **Topics:** `Set` interface, `HashSet`, `TreeSet`, `LinkedHashSet`. Equality (`equals()` and `hashCode()` contract).
- **Practice Problem:** Create a program that reads a list of 50 names (allow duplicates) into an input list, then filters them into a `Set` to remove duplicates. Then use a `TreeSet` to sort them alphabetically automatically.
- **🤖 AI Mentor Task:**
    - _Prompt:_ "Explain the contract between `equals()` and `hashCode()`. If I put a custom Object into a `HashSet` without overriding these methods, what goes wrong? Show me a buggy example and a fixed example."
    - _Quiz:_ "Ask me which Set implementation is sorted and which relies on hash codes. Wait for my answer."

#### **Day 17: Maps (Key-Value Storage)**

- **Topics:** `Map` interface, `HashMap`, `TreeMap`, `LinkedHashMap`. Handling collisions (conceptual).
- **Practice Problem:** Build a "Phone Book". Keys = Names (String), Values = Phone Numbers (Long).
    1. Add 5 contacts.
    2. Check if a key exists before updating.
    3. Find all contacts starting with "A".
- **🤖 AI Mentor Task:**
    - _Prompt:_ "Explain how `HashMap` works under the hood using buckets. Why does changing the key object matter if you don't update `hashCode()`? Create a simple visual text diagram explaining this."
    - _Optimization:_ "If I need frequent lookups, sorting, and thread-safety, what maps should I consider? Compare `ConcurrentHashMap` vs `Hashtable` briefly."

#### **Day 18: Queues & Deques**

- **Topics:** `Queue`, `PriorityQueue`, `Deque`, `ArrayDeque`. FIFO vs LIFO.
- **Practice Problem:** Simulate a task queue.
    1. Add tasks with different priorities (integers).
    2. Use a `PriorityQueue` to process the highest priority task first.
    3. Print the order in which tasks were processed.
- **🤖 AI Mentor Task:**
    - _Prompt:_ "Show me the difference between `add()`, `offer()`, `poll()`, and `remove()` in a Queue. When would one throw an exception while another returns null? Which is safer for production code?"

#### **Day 19: Generics (Type Safety)**

- **Topics:** Generic Classes `<T>`, Wildcards `<?>`, Bounded Types `<T extends Number>`. Erasure (basic concept).
- **Practice Problem:** Refactor your Day 15 `StringListManager` to be a generic class `DataManager<T>` that accepts any type (Strings, Integers, Custom Objects) safely.
- **🤖 AI Mentor Task:**
    - _Prompt:_ "I am getting a compiler error: 'Cannot convert Object to MyType'. How do wildcards solve this? Explain PECS (Producer Extends, Consumer Super) simply."
    - _Challenge:_ "Create a small class hierarchy (Animal -> Dog) and show me why `List<Dog>` is NOT a subtype of `List<Animal>`."

#### **Day 20: Algorithms & Utilities**

- **Topics:** `Collections.sort()`, `BinarySearch`, `Comparator`, `Comparable`, `Arrays.asList()`.
- **Practice Problem:** Create a `Product` class (name, price). Create a list of 10 products. Sort them first by Price (ascending), then by Name (descending) using `Comparator`.
- **🤖 AI Mentor Task:**
    - _Prompt:_ "Compare implementing `Comparable` vs passing a `Comparator`. When should I implement which? If I have an existing class I can't modify, which do I use?"
    - _Code Review:_ Paste your sorting code. Ask: "Is my lambda syntax correct? Is there a more efficient way to chain comparators?"

#### **Day 21: Review & Mini-Project 1**

- **Topic:** Consolidate Collections knowledge.
- **Mini-Project:** **"Word Frequency Counter"**
    1. Hardcode a paragraph of text (longer).
    2. Split it into words.
    3. Count frequency of each word using a `HashMap<String, Integer>`.
    4. Sort results by frequency (highest first) using a custom Comparator.
- **🤖 AI Mentor Task:**
    - _Prompt:_ "Review my Word Frequency code. Are there performance bottlenecks? Could I optimize this using Java 8 Streams? (Don't give the solution yet, just ask guiding questions)."

---

### **Week 4: Robustness, I/O, and Modern Java**

_Focus: Handling errors, reading external data, and writing clean, functional-style code._

#### **Day 22: Exception Handling Deep Dive**

- **Topics:** `try-catch-finally`, Checked vs Unchecked Exceptions, `throw` vs `throws`, Custom Exceptions.
- **Practice Problem:** Create a method `divide(int a, int b)` that throws a custom `IllegalDivisionException` if the denominator is 0 or negative. Handle it gracefully in main.
- **🤖 AI Mentor Task:**
    - _Prompt:_ "What is the 'Catch Exception Class Hierarchy'? Show me `Throwable`, `Error`, `Exception`, `RuntimeException`. Where does `NullPointerException` sit? Should I ever catch `Error`?"
    - _Scenario:_ "When is it appropriate to suppress an exception vs. re-throw it? Give me a logging example."

#### **Day 23: File I/O (Legacy & NIO)**

- **Topics:** `File`, `Scanner`, `PrintWriter`, `java.nio.file.Files`, `Paths`, `BufferedReader`, `BufferedWriter`.
- **Practice Problem:** Create a "User Logger".
    1. Prompt user for name and action.
    2. Append entry to a `log.txt` file.
    3. Read the log file back and print line-by-line.
    4. Handle `FileNotFoundException` and `IOException`.
- **🤖 AI Mentor Task:**
    - _Prompt:_ "Compare `Files.readAllLines()` vs `BufferedReader`. For a massive file (1GB), which crashes and which streams? Show me the code difference."
    - _Best Practice:_ "How should I close resources in Java 9+? Show me try-with-resources syntax."

#### **Day 24: Java 8 Lambdas**

- **Topics:** Functional Interfaces, Lambda Syntax `->`, Method References `::`.
- **Practice Problem:** Take a list of Employees (ID, Name, Salary). Write a Lambda to filter employees earning > $50k. Write a method reference to sort by name.
- **🤖 AI Mentor Task:**
    - _Prompt:_ "Explain the concept of a 'Functional Interface' and the `@FunctionalInterface` annotation. Can I add multiple abstract methods? Why or why not?"
    - _Conversion:_ "Take a standard anonymous inner class you know (e.g., Runnable) and refactor it into a lambda."

#### **Day 25: Streams API (Processing)**

- **Topics:** Intermediate Operations (`filter`, `map`, `sorted`), Terminal Operations (`collect`, `forEach`, `reduce`), Parallel Streams.
- **Practice Problem:** Using your Employee list again:
    1. Get names of all high earners.
    2. Calculate total salary cost.
    3. Group employees by Department (using `Collectors.groupingBy`).
- **🤖 AI Mentor Task:**
    - _Prompt:_ "Explain 'Lazy Evaluation' in Streams. Does `filter()` run immediately? What triggers the execution?"
    - _Debug:_ "My stream throws a NullPointer somewhere. How do I debug a stream pipeline step-by-step?"

#### **Day 26: Date & Time API (`java.time`)**

- **Topics:** `LocalDate`, `LocalTime`, `LocalDateTime`, `ZonedDateTime`, `Period`, `Duration`, Formatting (`DateTimeFormatter`).
- **Practice Problem:** Build a "Meeting Scheduler".
    1. Parse two date strings.
    2. Calculate the duration between them.
    3. Check if a meeting overlaps with an existing booking time slot.
- **🤖 AI Mentor Task:**
    - _Prompt:_ "Why was the old `java.util.Date` deprecated? List 3 major issues with it regarding immutability and timezone handling."
    - _Challenge:_ "Write a utility method that adds exactly 3 business days to a date, skipping weekends."

#### **Day 27: Capstone Project - "Student Record System"**

- **Goal:** Combine Collections, File I/O, Exceptions, and Logic.
- **Requirements:**
    1. **Data:** Store Students (Name, ID, Grades List). Use a `HashMap<Integer, Student>`.
    2. **Persistence:** Save to a `.txt` or `.json` file on exit, Load on startup.
    3. **Operations:** Add Student, Remove Student, Update Grade, Calculate Average.
    4. **Validation:** Prevent duplicate IDs, Invalid grades (0-100). Use Custom Exceptions for validation failures.
    5. **Reporting:** Export a report of top 3 students using Sorting.
- **🤖 AI Mentor Task:**
    - _Prompt:_ "I have finished my Student Record System. Here is my class diagram/code. Act as a Lead Developer. Critique my architecture. Where is the Single Responsibility Principle violated? How would I prepare this for Unit Testing?"

#### **Day 28: Review & Prep for Phase C**

- **Activity:** Revisit the Word Frequency Counter (Day 21) and refactor it entirely using Streams API.
- **Interview Prep:** Ask AI: "What are the top 5 Java Collections interview questions? Quiz me on them one by one."
- **Next Steps:** Begin researching Concurrency, Spring Boot, or Databases (Phase C).

---

### **Phase B Specific AI Prompts**

To get the most out of your mentor during this phase, use these specialized prompts:

1. **For Performance Questions:**
    
    > "I am choosing between `ArrayList` and `LinkedList` for [Insert Use Case]. Walk me through the Big O complexity for insertion, deletion, and access. Which wins for read-heavy vs write-heavy scenarios?"
    
2. **For Debugging:**
    
    > "I am getting a `ClassCastException` when iterating over a Collection. Explain the most common causes for this in Java Generics. Help me fix my loop."
    
3. **For Modernization:**
    
    > "Here is a loop using iterators and manual condition checks. Refactor this into a Java Stream Pipeline. Explain why the Stream version might be more readable or performant."
    

### **Critical Warning for Phase B**

- **Memory Leaks:** Collections hold references. If you add objects to a List and forget to remove them, they stay in memory. Ask your AI: _"Does this collection grow indefinitely in my loop? How can I prove it doesn't leak?"_
- **Thread Safety:** Standard Collections (`ArrayList`, `HashMap`) are **not** thread-safe. If you eventually touch concurrency, ask: _"Which concurrent collections replace HashMap/ArrayList for multi-threaded environments?"_

Would you like me to provide a **starter template** for the Day 27 Capstone Project, including the basic `Student` class structure and file handling skeleton, so you can jump straight into building the logic?

# ➡ [[Phase C - Enterprise Patterns & Concurrency]]