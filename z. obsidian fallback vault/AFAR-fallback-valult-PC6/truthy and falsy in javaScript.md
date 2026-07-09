In JavaScript, **truthy** and **falsy** values determine how a variable behaves when it’s evaluated in a boolean context (like an `if` statement).

While a boolean can only be `true` or `false`, JavaScript is flexible: it will try to "coerce" any other value into a boolean.

---

### The "Falsy" List

In JavaScript, there are only **eight** values that evaluate to `false`. If it’s not on this list, it’s truthy.

|**Value**|**Description**|
|---|---|
|`false`|The keyword `false`.|
|`0`|The number zero.|
|`-0`|Negative zero.|
|`0n`|BigInt zero.|
|`""`|An empty string (no characters).|
|`null`|The absence of any value.|
|`undefined`|A variable that has been declared but not assigned.|
|`NaN`|"Not a Number."|

---

### The "Truthy" List

Everything else is considered **truthy**. This includes some values that might feel like they should be false but aren't:

- **`'0'`**: A string containing a zero is truthy.
    
- **`'false'`**: The string "false" is truthy.
    
- **`[]`**: An empty array is truthy (this trips up many developers!).
    
- **`{}`**: An empty object is truthy.
    
- **`function() {}`**: Empty functions are truthy.
    

---

### Why Does This Matter?

Understanding truthiness allows you to write shorter code, often used for **short-circuiting** or **existence checks**.

#### 1. The If-Statement Check

Instead of checking if a string is empty or a number is zero, you can just pass the variable:

JavaScript

```
let username = "";

if (username) {
  // This block won't run because "" is falsy
  console.log("Welcome, " + username);
}
```

#### 2. Short-circuit Evaluation

You can use `||` (OR) to provide default values:

JavaScript

```
let input = "";
let displayName = input || "Anonymous"; 

console.log(displayName); // "Anonymous" because input was falsy
```

> **A Quick Tip:** If you ever want to see if a value is truthy or falsy manually, you can use the double-bang operator `!!` or the `Boolean()` function.
> 
> - `!!""` results in `false`
>     
> - `!!"Hello"` results in `true`
>     
