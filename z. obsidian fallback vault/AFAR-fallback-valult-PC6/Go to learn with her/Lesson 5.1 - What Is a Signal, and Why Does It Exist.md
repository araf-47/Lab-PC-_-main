> https://chatgpt.com/share/6accad2b-eca8-83ee-956a-7224862d19de
***
## Lesson 5.1: What Is a Signal, and Why Does It Exist?

## 1. Theory — What is a signal?

A signal is a special container for a value that Angular can track.

That value might be a number, a string, a Boolean, or even an object.

For example, imagine you are building a simple counter. The counter starts at `0`, and every time the user clicks a button, the number increases.

Without a signal, you might store the number in a normal variable:

```
count = 0;
```

When the user clicks a button, you can change the value:

```
this.count++;
```

But there is an important question:

How does Angular know that the value changed and that the displayed number might need to be updated?

This is the problem signals help solve.

A signal stores a value in a way that Angular can observe. When that value changes, Angular knows which parts of the application depend on it and can update them when necessary.

Let's compare the two approaches:

### Normal variable

```
count = 0;
```

Stores a value, but does not itself provide Angular with a way to track when that value changes.

### Signal

```
count = signal(0);
```

Stores a value and provides a tracking mechanism so Angular can react to changes in that value.

The important difference is not simply where the value is stored. It is that a signal makes the value's dependencies observable.

### Why do we need this?

Consider a real application with several pieces of information:

- A shopping cart's item count
- A user's login status
- A form's current value
- A list of tasks
- A product's selected quantity

When these values change, the user interface may need to change too.

For example, if a shopping cart contains two items, the screen might display:

```
Cart items: 2
```

When another item is added, it should display:

```
Cart items: 3
```

You want Angular to know that the displayed count depends on the underlying value, rather than manually telling Angular about every place that needs an update.

Signals give Angular a clear way to track changing state and the parts of the application that depend on it.

Here, state simply means the information an application currently holds, such as the cart count or login status.

## 2. How signals work internally

Let's build a mental model step by step.

Imagine this signal:

```
count = signal(0);
```

Think of it as a special container with three important characteristics:

```
						    Signal: count

								 0

							Current value

1\. Angular can track reads

When a template reads the signal, Angular can record that the template depends on it.

2\. The signal can change

When its value is updated, the signal notifies Angular that its value has changed.

3\. Dependent UI can refresh

Angular schedules the necessary update so the displayed value can reflect the new state.

```

There are three concepts to understand here.

### A. Reading a signal

A signal is not read like an ordinary variable. You call it as a function:

```
count()
```

This returns its current value.

If the current value is `0`, then `count()` gives you `0`.

If Angular reads this signal while evaluating a template, Angular can track that dependency.

### B. Updating a signal

Signals are designed to be updated through their supported API rather than by directly changing an ordinary variable.

In modern Angular, writable signals support methods such as `.set()` and `.update()`. We will learn their syntax and behavior in Lesson 5.2.

Conceptually, changing the signal from `0` to `1` tells Angular that the signal's value has changed.

### C. Updating the user interface

Suppose your template displays the signal's value:

```
<p>{{ count() }}</p>
```

If `count()` returns `0`, Angular displays `0`.

If the signal later changes to `1`, Angular knows the template depends on that signal and can update the displayed value.

One important detail: a signal does not directly redraw the screen by itself. It notifies Angular about a change. Angular then handles the necessary rendering work.

Also, Angular does not necessarily update the DOM immediately at the exact instant the signal changes. Rendering is coordinated by Angular.

## 3. Syntax — What does a signal look like?

The basic syntax for creating a signal is:

```
import { signal } from '@angular/core';

count = signal(0);
```

Let's understand each part.

| Code                | Meaning                                      |
| ------------------- | -------------------------------------------- |
| `import { signal }` | Imports Angular's signal function.           |
| `signal(0)`         | Creates a signal whose initial value is `0`. |
| `count`             | The variable that holds the signal.          |

Notice the difference between these two lines:

```
count = 0;
```

```
count = signal(0);
```

In the first line, `count` directly holds the number `0`.

In the second line, `count` holds a signal, and that signal currently holds the number `0`.

This is why reading them differs:

```
count       // The normal variable's value
count()     // The signal's current value
```

The second example is the modern Angular approach we will use throughout this module.

## 4. Examples — See signals in action

### Example 1: A counter

Imagine a component that displays a counter.

File: `counter.component.ts`

```
import { Component, signal } from '@angular/core';

@Component({
  selector: 'app-counter',
  standalone: true,
  template: `
    <p>Count: {{ count() }}</p>
    <button (click)="increase()">Increase</button>
  `
})
export class CounterComponent {
  count = signal(0);

  increase() {
    this.count.update(value => value + 1);
  }
}
```

Let's follow what happens.

1. `signal(0)` creates a signal with an initial value of `0`.
2. `{{ count() }}` reads the current value and displays it.
3. When the button is clicked, Angular calls `increase()`.
4. `update()` changes the signal's value from `0` to `1`.
5. Angular knows the template depends on this signal and updates the displayed count.

The screen changes from `Count: 0` to `Count: 1`.

You do not manually find the paragraph and change its text. Angular manages that update.

Note: `.update()` is introduced here to demonstrate the concept. We will study its exact syntax in Lesson 5.2.

### Example 2: A Boolean signal

Signals can hold values other than numbers.

```
isLoggedIn = signal(false);
```

This signal represents whether a user is logged in.

Its current value is initially `false`.

A template could use it like this:

```
@if (isLoggedIn()) {
  <p>Welcome back!</p>
} @else {
  <p>Please log in.</p>
}
```

When the signal's value changes, Angular can update which message is displayed.

This example connects signals with the modern control flow you learned in Module 4.

### Example 3: A signal containing text

```
username = signal('Alex');
```

The template can display it:

```
<p>Hello, {{ username() }}!</p>
```

Initially, the page displays:

```
Hello, Alex!
```

If the signal's value changes to another username, Angular can update the displayed text.

The same principle applies to numbers, Booleans, and other values.

## 5. Common mistakes

### Mistake 1: Forgetting the parentheses

Incorrect:

```
<p>{{ count }}</p>
```

Here, `count` refers to the signal itself, not the value stored inside it.

Correct:

```
<p>{{ count() }}</p>
```

Remember: Read a signal by calling it with parentheses.

### Mistake 2: Thinking signals are just normal variables

A normal variable stores a value, but it does not inherently provide Angular with signal dependency tracking.

A signal stores a value and exposes a mechanism Angular can observe.

That tracking is the important difference.

### Mistake 3: Thinking signals update everything in the application

Signals help Angular track dependencies. They do not mean every component or every part of the page must update whenever any signal changes.

Angular can use the dependencies it knows about to determine the necessary work.

### Mistake 4: Thinking a signal must contain a number

A signal can hold different kinds of values:

```
count = signal(0);
username = signal('Alex');
isLoggedIn = signal(false);
```

The initial value determines the type Angular's TypeScript tooling infers in these examples.

## 6. Hands-on exercise

Create a small standalone component called `StatusComponent`.

Your task:

1. Import `signal` from `@angular/core`.
2. Create a signal named `isOnline` with an initial value of `true`.
3. Display its value in the template using interpolation.
4. Use `@if` and `@else` to display:
   - `You are online.` when it is `true`.
   - `You are offline.` when it is `false`.

For this exercise, you do not need a button or any signal update methods. Focus on creating a signal and reading its value.

Paste your code when you're ready, and I'll review it.

## 7. Quick review

Choose your answers before checking the explanations.

### Question 1: What is a signal?

A. A special Angular container that holds a value and supports dependency tracking.

B. An HTML element.

C. A CSS rule.

Correct answer: A. A signal holds a value and lets Angular track dependencies on that value.

### Question 2: How do you read the current value of a signal named `count`?

A. `count.value`

B. `count()`

C. `count.read()`

Correct answer: B. Calling the signal returns its current value.

### Question 3: Why do signals exist?

A. To replace HTML.

B. To make every variable global.

C. To help Angular track changing state and update dependent parts of the UI.

Correct answer: C. Signals make dependencies on changing values observable to Angular.

### Question 4: What does this code create?

```
username = signal('Alex');
```

A. A signal containing the text `'Alex'`.

B. A function that always returns a number.

C. An HTML input field.

Correct answer: A. The signal's initial value is the string `'Alex'`.

### Question 5: If a template reads a signal, what happens when that signal changes?

A. The entire application must reload.

B. Angular can track the dependency and update the necessary UI.

C. Nothing can happen until the browser is restarted.

Correct answer: B. Angular uses the tracked dependency to determine the rendering work needed.

## Progress

- Completed: Lesson 5.1 — What is a signal? Why signals exist.
- Next: Lesson 5.2 — `signal()`, reading, `set()`, `update()`, and using signals in templates.

I'll stop here and wait for your exercise, questions, or instruction to continue.