Here is a comprehensive **2-Week Phase A Study Plan for Java Foundations**. This plan focuses on core syntax, control flow, and the fundamental principles of Object-Oriented Programming (OOP).

Since you are using an AI mentor, every day includes a **"Mentor Challenge"** where you interact with the AI to get code reviews, explanations, or quizzes.

### **Prerequisites**

- **Install:** JDK 17 or 21 (Long Term Support versions) from [Adoptium](https://adoptium.net/).
- **IDE:** Install IntelliJ IDEA Community Edition (highly recommended for Java) or VS Code with the "Extension Pack for Java".
- **Your AI Mentor:** Use **Claude 3.5 Sonnet** (free tier) for the deepest logic checks, or **Cursor** if you want real-time feedback inside your IDE.

---

### **Week 1: Syntax, Logic, and Data Types**

#### **Day 1: Setup & The First Program**

- **Topics:** How the JVM works, `public static void main`, `System.out.println`, Comments, Basic Variables (`int`, `double`, `boolean`).
- **Practice Problem:** Create a program that declares variables for your name (String), age (int), height (double), and student status (boolean). Print them in a formatted sentence (e.g., "Name: John, Age: 20...").
- **🤖 AI Mentor Task:**
    - _Prompt:_ "I just wrote my first Java program. Here is my code: `[Paste Code]`. Check if I missed any import statements or used wrong data types. Also, explain to me: 'What actually happens when I run this file?'"
    - _Challenge:_ Ask the AI to give you a "Code Golf" challenge: "Rewrite this print statement to use only one line of code without losing readability."

#### **Day 2: Operators & Type Conversion**

- **Topics:** Arithmetic (`+ - * / %`), Relational (`== > <`), Logical (`&& || !`), Increment (`++`), Casting (Implicit vs. Explicit).
- **Practice Problem:** Write a "Temperature Converter" that takes Celsius as input and prints Fahrenheit. Then, try to force a "Lossy Conversion" error by assigning a `double` to an `int` without casting, see it fail, then fix it.
- **🤖 AI Mentor Task:**
    - _Prompt:_ "Explain the difference between `i++` and `++i` with a code example where they produce different results. Why is one often preferred over the other in loops?"
    - _Quiz:_ "Ask me 3 quick-fire questions about operator precedence. Wait for my answer before revealing the correct one."

#### **Day 3: Control Flow (Conditionals)**

- **Topics:** `if`, `else if`, `else`, Ternary Operator `?:`, `switch` statements (and modern `switch` expressions).
- **Practice Problem:** Build a "Grading System". Input a score (0-100). Output "A", "B", "C", "D", or "F". Add a `switch` statement for handling grade categories.
- **🤖 AI Mentor Task:**
    - _Prompt:_ "Here is my grading logic: `[Paste Code]`. Is this efficient? Can I refactor this using a 'Map' instead of multiple if-statements? Explain the pros and cons."

#### **Day 4: Loops (Iteration)**

- **Topics:** `for`, `while`, `do-while`, `break`, `continue`.
- **Practice Problem:**
    1. Print numbers 1 to 100. Skip multiples of 3.
    2. Calculate the factorial of a number (e.g., 5! = 120) using a `while` loop.
    3. Create a "Guess the Number" game (AI gives a random number, user guesses until correct).
- **🤖 AI Mentor Task:**
    - _Prompt:_ "I wrote a nested loop to print a pyramid of stars. Here is the code: `[Paste Code]`. Check for off-by-one errors. Explain the time complexity (Big O) of my solution."

#### **Day 5: Arrays & Strings (Immutability)**

- **Topics:** Declaring arrays, accessing indices, String vs. StringBuilder, String methods (`length`, `charAt`, `substring`, `equals`).
- **Practice Problem:**
    1. Create an array of integers, fill it with random numbers, find the max/min value.
    2. Write a method to reverse a string _without_ using `StringBuilder.reverse()`.
    3. Count the occurrences of a specific character in a sentence.
- **🤖 AI Mentor Task:**
    - _Prompt:_ "Explain why `String` is immutable in Java. What happens to memory if I do `String s = "hello"; s += " world";`? Show me how `StringBuilder` solves this."

#### **Day 6: Review & Mini-Project**

- **Topics:** Review weak points from Days 1-5.
- **Mini-Project:** **"Bank Account CLI Simulator"**
    - Create a class `BankAccount`.
    - Fields: `ownerName`, `balance` (double).
    - Methods: `deposit(double amount)`, `withdraw(double amount)`, `getBalance()`.
    - Main: Simulate a few transactions. Prevent negative balance.
- **🤖 AI Mentor Task:**
    - _Prompt:_ "Review my BankAccount code. Did I handle the case where someone tries to withdraw more than they have? Suggest how to make the `balance` field private (encapsulation) and provide getter/setter logic."

#### **Day 7: Rest & Conceptual Deep Dive**

- **Activity:** No coding. Watch a video on "How Memory works in Java (Stack vs Heap)" or read about "JVM Architecture."
- **Action:** Write down 3 questions you still have about Day 1-6. Ask your AI to answer them simply.

---

### **Week 2: Object-Oriented Programming (The Core of Java)**

#### **Day 8: Classes & Objects**

- **Topics:** Defining classes, Constructors (default vs. parameterized), `this` keyword, Instance vs. Static members.
- **Practice Problem:** Create a `Car` class. Fields: `make`, `model`, `year`, `color`. Create a constructor. In `main`, create 3 different Car objects and print their details.
- **🤖 AI Mentor Task:**
    - _Prompt:_ "I created a Car class. What is the difference between making a variable `static` vs. non-static? If I add `static int totalCars` to my class, what will happen when I create 3 objects? Run a mental simulation for me."

#### **Day 9: Encapsulation & Getters/Setters**

- **Topics:** Access Modifiers (`private`, `public`, `protected`), Data Hiding, Validation logic in setters.
- **Practice Problem:** Revisit the `Car` class. Make all fields `private`. Add getters and setters. Ensure the `setYear()` method throws an exception or rejects if the year is in the future or older than 100 years.
- **🤖 AI Mentor Task:**
    - _Prompt:_ "Why is encapsulation critical in large enterprise Java applications? Give me a real-world scenario where bad encapsulation causes a bug."

#### **Day 10: Inheritance**

- **Topics:** `extends`, `super`, Overriding methods, The `Object` class.
- **Practice Problem:** Create a base class `Animal` with a method `speak()`. Create subclasses `Dog` and `Cat` that override `speak()`. In `main`, use an `Animal` reference to call `speak()` on both (Polymorphism preview).
- **🤖 AI Mentor Task:**
    - _Prompt:_ "Explain the 'Liskov Substitution Principle' simply. If I have a `Square` class extending `Rectangle`, what could go wrong? (Hint: Think about changing sides)."

#### **Day 11: Polymorphism**

- **Topics:** Method Overloading vs. Overriding, Dynamic Binding, Upcasting.
- **Practice Problem:** Create a list of `List<Animal>`. Add 5 different animals. Loop through and call `speak()`. Observe that different sounds play even though the reference type is `Animal`.
- **🤖 AI Mentor Task:**
    - _Prompt:_ "Write a quiz question for me: 'I have a method `void eat(Food f)` in `Animal` and `void eat(Meat m)` in `Dog`. If I pass a `Meat` object to a `Dog` reference, which method runs? If I pass a `Food` object to a `Dog` reference (where Food is parent of Meat), which runs?'"

#### **Day 12: Abstract Classes & Interfaces**

- **Topics:** `abstract` keyword, `interface`, multiple inheritance via interfaces, default methods.
- **Practice Problem:**
    1. Create an interface `Flyable` with `fly()`.
    2. Create an abstract class `Bird` with `eat()`.
    3. Create a class `Eagle` that extends `Bird` and implements `Flyable`.
    4. Try to make a class implement two interfaces (e.g., `Swimable` and `Flyable`).
- **🤖 AI Mentor Task:**
    - _Prompt:_ "When should I use an Abstract Class vs. an Interface in Java? Give me a rule of thumb for 2026 development practices."

#### **Day 13: Final Project - "Library Management System" (CLI)**

- **Goal:** Combine everything.
- **Requirements:**
    - Classes: `Book` (title, author, ISBN), `Member` (name, ID), `Library`.
    - Features: `addBook`, `registerMember`, `borrowBook`, `returnBook`.
    - Logic: A member can borrow max 3 books. A book cannot be borrowed if already taken.
    - Use Arrays or Lists to store data.
- **🤖 AI Mentor Task:**
    - _Prompt:_ "I am building a Library system. Here is my class structure: `[Paste Structure]`. Critique my design. Are my relationships (Inheritance/Interfaces) correct? How would I enforce the 'max 3 books' rule robustly?"

#### **Day 14: Review & Prep for Phase B**

- **Activity:** Go back to Day 1 project and refactor it using what you learned today (Encapsulation, better naming, error handling).
- **Self-Evaluation:** Ask your AI: "Based on the code I've written this week, what are my top 3 weaknesses in Java foundations?"
- **Preparation:** Start looking at Collections (`ArrayList`, `HashMap`) to prep for Week 3.

---

### **How to Use Your AI Mentor Effectively During This Plan**

1. **Don't just copy-paste fixes.** If the AI corrects your code, ask: _"Why did my version fail? What was the specific logical error?"_
2. **Force the AI to Quiz You.** At the end of every session, type: _"Give me 3 practice problems based on today's topic. I will solve them and paste the code. Do not give the answers yet."_
3. **Debugging Strategy:** When your code fails, don't say "Fix this." Say: _"I am getting this Exception: `[Error Message]`. Walk me through how to debug this step-by-step before giving the solution."_

~~Would you like me to generate the **starter code** for the Day 1 or Day 6 project so you can begin immediately, or would you prefer to try writing it from scratch first?~~.

# 👉 [[Phase B - Core Libraries & Collections (Lumo) 2 weeks study plan for Java]]