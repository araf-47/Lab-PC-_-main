While a **Syntax Error** is a "grammar" mistake discovered before the code even starts, a **Runtime Error** is a mistake that happens while the code is actually running.

Think of it like a recipe: a **Syntax Error** is writing "bake the cake for 30 glip-glops" (the word doesn't exist), whereas a **Runtime Error** is "put the cake in the oven" but you realize too late that you don't actually have an oven.

---

### 1. Why do they happen?

The code is written perfectly in terms of grammar, but it asks the computer to do something impossible or illogical during execution.

### 2. Common JavaScript Examples

- **ReferenceError:** You try to use a variable that hasn't been defined yet.
    
    JavaScript
    
    ```
    console.log(totalPrice); // Error! 'totalPrice' is not defined.
    ```
    
- **TypeError:** You try to perform an operation on the wrong "type" of data (like trying to "uppercase" a number).
    
    JavaScript
    
    ```
    let age = 25;
    age.toUpperCase(); // Error! Numbers don't have an 'uppercase' function.
    ```
    
- **RangeError:** You give a function a value that is outside its allowed range.
    
    JavaScript
    
    ```
    let arr = new Array(-1); // Error! You can't have an array with negative length.
    ```
    

---

### 3. How to spot them in VS Code

Unlike syntax errors, these usually won't show a red squiggly line while you are typing because the computer doesn't know there is a problem until it tries to run that specific line.

1. **Check the Terminal:** When your script crashes, the terminal will show a **Stack Trace**.
    
2. **Read the Path:** It will tell you the exact line number where the "explosion" happened.
    
3. **Use the Debugger (`F5`):** This is the best way to catch them. You can set a "breakpoint" to pause time right before the error happens and see what your variables look like.
    

---

### 4. Summary Comparison

|**Feature**|**Syntax Error**|**Runtime Error**|
|---|---|---|
|**When?**|Before the code runs.|While the code is running.|
|**VS Code indicator**|Red squiggly lines / Problems tab.|Error message in the Terminal.|
|**Analogy**|Using a word that isn't in the dictionary.|Trying to drive a car that has no wheels.|
