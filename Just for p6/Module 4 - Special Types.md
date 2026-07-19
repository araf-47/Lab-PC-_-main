Excellent! Welcome to **Module 4**, one of the most important modules in TypeScript.

This module teaches the **Special Types**. These are unlike `number`, `string`, or `boolean`. They have special meanings and are used in specific situations.

---

# Module 4: Special Types

## Learning Objectives

By the end of this module, you'll understand:

* `any`
* `unknown`
* `void`
* `never`

You'll also know:

* When to use each one.
* When **not** to use them.
* Why `unknown` is generally preferred over `any`.

---

# Introduction

Imagine TypeScript as a very careful security guard.

Normally, it checks every variable:

> "You're a string."

> "You're a number."

> "You're a boolean."

These four special types change how strict the guard is.

Think of them like special permissions.

---

# Lesson 1: `any`

Let's start with the most dangerous type in TypeScript.

## What is `any`?

`any` means:

> **"I don't care what type this is."**

You're telling TypeScript:

> "Stop checking this variable."

Example:

```typescript
let value: any;

value = 10;

value = "Hello";

value = true;

value = [1, 2, 3];

value = {
    name: "Araf"
};
```

Everything is allowed.

---

## Why does `any` exist?

Imagine you're converting a huge JavaScript project to TypeScript.

Initially, you might not know all the types.

Instead of fixing thousands of errors immediately, you can temporarily write:

```typescript
let data: any;
```

Then gradually replace `any` with proper types.

This makes migrating large projects practical.

---

## The Problem with `any`

Suppose you write:

```typescript
let username: any = "Araf";

console.log(username.toUpperCase());
```

Works.

Later someone changes:

```typescript
username = 100;
```

Now:

```typescript
console.log(username.toUpperCase());
```

TypeScript says nothing.

But at runtime you'll get:

```text
TypeError:
username.toUpperCase is not a function
```

You've lost TypeScript's protection.

---

## Analogy

Imagine airport security.

Normally:

```
Passenger
        │
        ▼
Security Check
        │
        ▼
Allowed on plane
```

With `any`:

```
Passenger
        │
        ▼
Skip Security
        │
        ▼
Board Immediately
```

That's why `any` should be used sparingly.

---

# Lesson 2: `unknown`

Now let's meet the safer cousin of `any`.

`unknown` means:

> "I don't know the type yet."

Notice the difference.

`any` says:

> "Don't check anything."

`unknown` says:

> "You must figure it out before using it."

---

Example:

```typescript
let value: unknown;

value = "Hello";

value = 20;

value = true;
```

Still allowed.

So far it looks exactly like `any`.

---

But watch this.

```typescript
let value: unknown = "Hello";

console.log(value.toUpperCase());
```

TypeScript reports an error.

Why?

Because it doesn't know if `value` is actually a string.

---

## Making `unknown` Safe

You must first verify the type.

```typescript
let value: unknown = "Hello";

if (typeof value === "string") {
    console.log(value.toUpperCase());
}
```

Now TypeScript is happy.

You've proved that `value` is a string before using string methods.

---

## `any` vs `unknown`

### `any`

```typescript
let value: any = "Hello";

value.toUpperCase();
```

Allowed.

Even if it later becomes a number.

---

### `unknown`

```typescript
let value: unknown = "Hello";

value.toUpperCase();
```

Error.

You must first check the type.

---

### Comparison

| Feature             | `any`  | `unknown` |
| ------------------- | ------ | --------- |
| Can store anything  | ✅      | ✅         |
| Can use immediately | ✅      | ❌         |
| Type safety         | ❌      | ✅         |
| Recommended         | Rarely | Often     |

---

# Lesson 3: `void`

This one is much simpler.

`void` means:

> **"There is no meaningful return value."**

It is mostly used for functions.

---

Example:

```typescript
function greet(): void {
    console.log("Hello!");
}
```

What does this function return?

Nothing useful.

It prints something.

That's it.

---

Without `void`:

```typescript
function greet() {
    console.log("Hello!");
}
```

TypeScript would infer the return type as `void`.

Writing it explicitly makes your intent clear.

---

Another example:

```typescript
function saveData(): void {
    console.log("Saving...");
}
```

The goal isn't to return data.

The goal is to perform an action.

---

# Lesson 4: `never`

This is the most confusing type for beginners.

Let's build up to it.

Imagine a function:

```typescript
function stopProgram() {
    while (true) {}
}
```

Will this function ever finish?

No.

It loops forever.

So it never returns.

---

Or this:

```typescript
function crash() {
    throw new Error("Something went wrong");
}
```

Does it return?

No.

It throws an exception.

Execution stops.

---

TypeScript represents these situations with `never`.

```typescript
function crash(): never {
    throw new Error("Oops!");
}
```

or

```typescript
function infiniteLoop(): never {
    while (true) {}
}
```

---

## Why not `void`?

This is an important distinction.

### `void`

The function **finishes**.

It just doesn't return a useful value.

```typescript
function greet(): void {
    console.log("Hi");
}
```

Execution reaches the end of the function.

---

### `never`

The function **never reaches the end**.

It either:

* loops forever, or
* always throws an error.

---

## Visual Comparison

### `void`

```
Start
  │
  ▼
Do something
  │
  ▼
Finish
```

---

### `never`

```
Start
  │
  ▼
Infinite Loop
```

or

```
Start
  │
  ▼
Throw Error
```

No finish.

---

# Real-World Example of `never`

Suppose you're checking every possible traffic light color:

```typescript
type Light = "red" | "yellow" | "green";
```

You handle all three:

```typescript
function handleLight(light: Light) {
    switch (light) {
        case "red":
            console.log("Stop");
            break;

        case "yellow":
            console.log("Slow");
            break;

        case "green":
            console.log("Go");
            break;

        default:
            const impossible: never = light;
            return impossible;
    }
}
```

At first glance, that `default` branch looks unnecessary. But it's a safety net. If someone later adds `"blue"` to the `Light` type and forgets to update the `switch`, TypeScript will report an error because `light` would no longer be `never` in the `default` branch.

We'll revisit this pattern when we study **Union Types**.

---

# Summary

| Type      | Meaning                              | Typical Use                            |
| --------- | ------------------------------------ | -------------------------------------- |
| `any`     | Disable type checking                | Gradual migration, last resort         |
| `unknown` | Type not known yet                   | External data, safer than `any`        |
| `void`    | Function returns no meaningful value | Functions that perform actions         |
| `never`   | Function never completes normally    | Infinite loops, always throwing errors |

---

# Best Practices

### ✅ Use `unknown` instead of `any` whenever possible.

```typescript
let data: unknown;
```

---

### ❌ Avoid filling your project with `any`.

If everything is `any`, you're effectively back to plain JavaScript without TypeScript's safety.

---

### ✅ Use `void` for functions that perform actions but don't return useful data.

---

### ✅ Use `never` only when a function truly cannot complete normally.

---

# Hands-On Exercise

Create a file called `special-types.ts`:

```typescript
// any
let anything: any = "Hello";
anything = 123;
anything = true;
console.log(anything);

// unknown
let mystery: unknown = "TypeScript";

if (typeof mystery === "string") {
    console.log(mystery.toUpperCase());
}

// void
function sayHello(): void {
    console.log("Hello!");
}

sayHello();

// never
function throwError(message: string): never {
    throw new Error(message);
}

// Uncomment to see it in action
// throwError("Something went wrong!");
```

Compile it:

```bash
tsc special-types.ts
```

Run it:

```bash
node special-types.js
```

> **Don't** uncomment `throwError()` unless you want the program to terminate with an error—that's exactly what `never` is demonstrating.

---

# What's Next?

Next we'll begin **Module 5: Arrays & Tuples**, where you'll learn how TypeScript describes collections of data, including:

* Arrays
* Readonly Arrays
* Multidimensional Arrays
* Tuples
* Optional Tuple Elements
* Readonly Tuples

These concepts are used constantly in real TypeScript applications, especially when working with APIs and collections of objects.
***
# 👉 [[Module 5 - Arrays & Tuples]].