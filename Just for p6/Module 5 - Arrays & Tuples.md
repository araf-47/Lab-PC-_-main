Excellent! We're now entering one of the most frequently used topics in TypeScript. Arrays and tuples appear in almost every application you'll write.

# Module 5: Arrays & Tuples

## Learning Objectives

By the end of this module, you'll understand:

* Arrays
* Type inference with arrays
* Array type annotations
* Readonly Arrays
* Multidimensional Arrays
* Tuples
* Optional Tuple Elements
* Readonly Tuples
* Arrays vs Tuples
* Best practices

---

# Lesson 1: Arrays

Let's start with something you already know from JavaScript.

An array is a collection of multiple values stored in a single variable.

Example in JavaScript:

```javascript
let fruits = ["Apple", "Banana", "Orange"];
```

TypeScript works exactly the same.

```typescript
let fruits = ["Apple", "Banana", "Orange"];
```

But here's the interesting part.

TypeScript automatically infers the type as:

```typescript
string[]
```

It knows this array contains strings.

---

# What Does `string[]` Mean?

This syntax means:

> "An array whose elements are strings."

Visualize it like this:

```
fruits
│
├── "Apple"   ← string
├── "Banana"  ← string
└── "Orange"  ← string
```

Therefore:

```typescript
string[]
```

Think of it as:

```
Type[]
```

where `Type` is `string`.

---

# More Examples

Numbers

```typescript
let scores = [90, 85, 100];
```

Type:

```typescript
number[]
```

---

Booleans

```typescript
let answers = [true, false, true];
```

Type:

```typescript
boolean[]
```

---

# Explicit Array Types

Sometimes you want to specify the type yourself.

```typescript
let fruits: string[] = ["Apple", "Banana"];
```

or

```typescript
let marks: number[] = [70, 80, 90];
```

---

General syntax

```typescript
let variable: Type[] = [...];
```

---

# What Happens if We Add the Wrong Type?

Example:

```typescript
let fruits: string[] = ["Apple", "Banana"];
```

Now:

```typescript
fruits.push("Orange");
```

Perfect.

But:

```typescript
fruits.push(100);
```

TypeScript immediately reports an error.

Because

```
100
```

is not a string.

This is one of the biggest benefits of TypeScript.

---

# Array Methods

All JavaScript array methods still work.

Example:

```typescript
let fruits = ["Apple", "Banana", "Orange"];

fruits.push("Mango");

fruits.pop();

console.log(fruits.length);
```

TypeScript understands these methods because it knows the array contains strings.

---

# Type Inference with Empty Arrays

Now here's something beginners often get confused about.

Suppose you write:

```typescript
let numbers = [];
```

What type should this be?

TypeScript has no clues.

There are no values.

Depending on your compiler settings, it may infer `any[]`, which means you can push different kinds of values into it without type checking.

```typescript
numbers.push(10);

numbers.push("Hello");

numbers.push(true);
```

This is usually **not** what you want.

A better approach is to declare the intended element type:

```typescript
let numbers: number[] = [];
```

Now:

```typescript
numbers.push(10);
```

works.

But:

```typescript
numbers.push("Hello");
```

produces an error.

---

# Alternative Array Syntax

You may also see:

```typescript
let fruits: Array<string> = ["Apple", "Banana"];
```

instead of

```typescript
let fruits: string[] = ["Apple", "Banana"];
```

Both mean exactly the same thing.

---

## Which One Should You Use?

The TypeScript community generally prefers:

```typescript
string[]
```

because it's shorter and easier to read.

You'll still encounter `Array<T>` in documentation and generic code, so it's useful to recognize both.

---

# Lesson 2: Readonly Arrays

Sometimes you want people to read an array but not modify it.

Imagine a list of countries:

```typescript
const countries = [
    "Bangladesh",
    "Japan",
    "Canada"
];
```

Someone later writes:

```typescript
countries.push("Mars");
```

Oops.

Now the data is wrong.

---

TypeScript gives us a solution.

```typescript
let countries: readonly string[] = [
    "Bangladesh",
    "Japan",
    "Canada"
];
```

Now:

```typescript
countries.push("India");
```

Error.

---

Even:

```typescript
countries.pop();
```

Error.

---

Or:

```typescript
countries[0] = "USA";
```

Error.

The array becomes read-only.

---

## Important Note

A `readonly` array protects the array **through that variable**. It doesn't magically make the underlying data immutable in every situation. We'll discuss true immutability concepts later, but for now it's enough to think of `readonly` as "don't modify this array through this reference."

---

# Lesson 3: Multidimensional Arrays

A multidimensional array is simply an array containing other arrays.

Example:

```typescript
let matrix = [
    [1, 2],
    [3, 4]
];
```

TypeScript infers:

```typescript
number[][]
```

Read it from right to left:

```
number[][]
```

↓

```
Array of
    Array of
        Numbers
```

Visual:

```
[
   [1,2],
   [3,4]
]
```

---

Another example:

```typescript
let classroom = [
    ["Alice", "Bob"],
    ["Charlie", "David"]
];
```

Type:

```typescript
string[][]
```

---

Accessing values works the same way as JavaScript.

```typescript
console.log(matrix[1][0]);
```

Output:

```
3
```

---

# Practice So Far

Create a file named `arrays.ts`.

```typescript
// Inferred array
let fruits = ["Apple", "Banana", "Orange"];

// Explicit array
let scores: number[] = [90, 80, 100];

// Empty array
let cities: string[] = [];

cities.push("Dhaka");
cities.push("Tokyo");

// Readonly array
const months: readonly string[] = [
    "January",
    "February",
    "March"
];

// Multidimensional array
let matrix: number[][] = [
    [1, 2],
    [3, 4]
];

console.log(fruits);
console.log(scores);
console.log(cities);
console.log(months);
console.log(matrix);
```

Compile:

```bash
tsc arrays.ts
```

Run:

```bash
node arrays.js
```

---

# Summary

| Syntax              | Meaning                           |
| ------------------- | --------------------------------- |
| `string[]`          | Array of strings                  |
| `number[]`          | Array of numbers                  |
| `boolean[]`         | Array of booleans                 |
| `readonly string[]` | Read-only array of strings        |
| `number[][]`        | Array of arrays of numbers        |
| `Array<string>`     | Alternative syntax for `string[]` |

---

# Common Beginner Mistakes

### ❌ Mistake 1

```typescript
let numbers = [];
```

Without a type, TypeScript may infer `any[]` depending on your configuration, which weakens type safety.

Prefer:

```typescript
let numbers: number[] = [];
```

---

### ❌ Mistake 2

Thinking `readonly` means the variable can't change.

```typescript
const arr = [1,2,3];
```

This is **not** the same as:

```typescript
readonly number[]
```

`const` prevents you from reassigning the variable:

```typescript
arr = [4,5];
```

But it still allows:

```typescript
arr.push(4);
```

Let's compare:

```typescript
const numbers = [1, 2, 3];
numbers.push(4);      // ✅ Allowed
// numbers = [5, 6];  // ❌ Error: can't reassign a const
```

Versus:

```typescript
const numbers: readonly number[] = [1, 2, 3];
// numbers.push(4);    // ❌ Error: readonly array
```

This is a common interview question, so it's worth remembering the distinction.

---

## Before We Continue

We've covered the **Arrays** portion of Module 5.

Next, we'll move to **Tuples**, which look similar to arrays but serve a different purpose.

Here's a preview:

```typescript
let student: [string, number] = ["Araf", 22];
```

At first glance, it looks like an array—but it has stricter rules about the number of elements and their positions.

Understanding *why* tuples exist is one of the biggest "aha!" moments for TypeScript learners, and that's exactly what we'll explore next.
***
# 👉 [[Module 5 - (part 2) Tuples]].