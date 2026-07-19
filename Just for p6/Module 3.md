Great! Before we leave Module 3, I want to point out something about our syllabus.

Originally, Module 3 contained:

* ✅ Simple Types
* ✅ Type Inference
* ✅ Explicit Types (Type Annotations)
* ✅ Literal Types

We've now covered all of those.

However, there are two **very important topics** that are technically part of TypeScript's type system but weren't listed in your roadmap:

1. **`const` vs `let` and how they affect types**
2. **Type widening and narrowing (basic inference behavior)**

These are so fundamental that skipping them would make later topics like Arrays, Objects, and Unions harder to understand. So I'd like to include them before moving to Module 4.

---

# Module 3 – Lesson 2: Understanding Type Inference Deeply

Today's goal is to answer a question that every TypeScript beginner eventually asks:

> **"If TypeScript can infer types, how exactly does it decide what type something is?"**

The answer isn't always as simple as "it looks at the value."

---

# Part 1 – `let` vs `const`

Consider these two examples.

```typescript
let username = "Araf";
```

and

```typescript
const username = "Araf";
```

Both compile.

Both store `"Araf"`.

So what's the difference?

In JavaScript, you already know:

* `let` → can be reassigned
* `const` → cannot be reassigned

TypeScript takes advantage of that fact.

---

## Example 1

```typescript
let username = "Araf";
```

TypeScript infers:

```typescript
let username: string;
```

Why not the literal type `"Araf"`?

Because you can later do:

```typescript
username = "John";
```

That's perfectly valid.

Since the value can change, TypeScript gives it the broader type `string`.

---

## Example 2

```typescript
const username = "Araf";
```

Now ask yourself:

Can this ever become `"John"`?

No.

It's a constant.

So TypeScript infers something much more specific:

```typescript
const username: "Araf";
```

Notice that the type is **the exact value**, not just `string`.

This is called a **literal type inference**.

---

### Visual Summary

```text
let city = "Dhaka"

Type:
string
```

because it may become

```text
"Khulna"
"Rajshahi"
"Sylhet"
```

later.

---

```text
const city = "Dhaka"
```

Type:

```text
"Dhaka"
```

because it can never change.

---

# Part 2 – Type Widening

Here's a new term:

> **Type Widening**

It sounds scary, but it's not.

It simply means: 

> **TypeScript chooses a broader type because the value might change later.**

Example:

```typescript
let score = 100;
```

TypeScript doesn't infer:

```typescript
100
```

It infers:

```typescript
number
```

Why?

Because later you might write:

```typescript
score = 250;
```

or

```typescript
score = -10;
```

Both are valid numbers.

So the type is widened from:

```text
100
```

to

```text
number
```

---

# Part 3 – Literal Inference

Now compare:

```typescript
const score = 100;
```

This becomes

```typescript
const score: 100;
```

Not

```typescript
number
```

because constants never change.

---

# Part 4 – Arrays

Now things become more interesting.

Example:

```typescript
let fruits = ["Apple", "Banana", "Orange"];
```

What type is this?

TypeScript infers:

```typescript
string[]
```

Notice it doesn't care about the exact strings.

It knows:

> This is an array of strings.

---

Example:

```typescript
let numbers = [10, 20, 30];
```

Inference:

```typescript
number[]
```

---

Mixed values:

```typescript
let data = [1, "Araf", true];
```

Inference:

```typescript
(number | string | boolean)[]
```

Don't worry about the `|` operator yet. We'll study Union Types later. For now, think of it as "this array can contain numbers, strings, or booleans."

---

# Part 5 – Objects

Suppose you write:

```typescript
let student = {
    name: "Araf",
    age: 22
};
```

TypeScript infers:

```typescript
{
    name: string;
    age: number;
}
```

It examines every property and builds an object type automatically.

You didn't have to write any annotations.

---

# Part 6 – Functions

Consider:

```typescript
function square(x: number) {
    return x * x;
}
```

We never specified the return type.

Yet TypeScript infers:

```typescript
number
```

because

```typescript
x * x
```

always produces a number.

We'll discuss function return types in detail in Module 10.

---

# Part 7 – When Inference Isn't Enough

Sometimes TypeScript needs your help.

Suppose you write:

```typescript
let value;
```

What is it?

A string?

A number?

An object?

TypeScript can't infer anything useful because there's no initial value. Depending on your compiler settings, it may infer `any`, which effectively disables type checking for that variable.

A better approach is to be explicit:

```typescript
let value: string;
```

Now TypeScript knows exactly what you intend.

---

# Best Practices

### ✅ Let TypeScript infer obvious types

```typescript
let age = 22;
let username = "Araf";
```

Clean and readable.

---

### ✅ Add annotations when the type isn't obvious

```typescript
let username: string;
```

or for function parameters:

```typescript
function greet(name: string) {
    console.log(name);
}
```

---

### ❌ Avoid unnecessary annotations

Instead of:

```typescript
let age: number = 22;
```

many developers simply write:

```typescript
let age = 22;
```

The compiler already knows it's a `number`.

---

# Quick Comparison

| Code                       | Inferred Type      |
| -------------------------- | ------------------ |
| `let age = 22`             | `number`           |
| `const age = 22`           | `22`               |
| `let name = "Araf"`        | `string`           |
| `const name = "Araf"`      | `"Araf"`           |
| `let active = true`        | `boolean`          |
| `const active = true`      | `true`             |
| `let arr = [1,2,3]`        | `number[]`         |
| `let user = {name:"Araf"}` | `{ name: string }` |

---

# Hands-On Exercise

Create a file called `inference.ts` and, **before compiling**, try to predict what type TypeScript will infer for each variable:

```typescript
let language = "TypeScript";

const framework = "React";

let year = 2026;

const pi = 3.14159;

let isOnline = false;

let colors = ["red", "green", "blue"];

let mixed = [1, "hello", true];

let teacher = {
    name: "Alice",
    subject: "Programming"
};
```

Then, in VS Code, **hover your mouse over each variable**. One of the nicest features of TypeScript is that your editor will show the inferred type without you needing to compile or run the code.

This habit—writing code, predicting the type, and then checking the editor—is one of the fastest ways to build intuition for TypeScript's type system.

---

### Next Up

In the next lesson, we'll start **Module 4: Special Types**, where we'll learn four of the most misunderstood types in TypeScript:

* `any`
* `unknown`
* `void`
* `never`

These types are powerful, but using the wrong one can either make your code much safer—or completely defeat the purpose of using TypeScript.

↪ [[Module 4 - Special Types]].