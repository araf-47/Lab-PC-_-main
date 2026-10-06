# Lesson 3.4 — Pipes & Built-in Pipes

This lesson explains **what pipes are, why Angular has them, how they work, and the most useful built-in pipes**.

***

## 1. Theory

### What is a pipe?

A **pipe transforms a value into a different display format inside an Angular template**.

For example, suppose your component has:

```ts
price = 1250;
```

The actual value is simply:

```text
1250
```

But maybe you want the user to see:

```text
$1,250.00
```

You could write TypeScript code to manually format the number.

But Angular gives you a much cleaner way:

```html
<p>{{ price | currency }}</p>
```

The `|` symbol tells Angular:

> "Take the value on the left and pass it through this pipe."

So:

```text
price → currency pipe → formatted price
```

The important idea is that **the pipe changes how a value is displayed; it does not normally change the original value in your component.**

***

### Why do pipes exist?

Templates frequently need to display data in a human-friendly format.

For example:

```text
Raw value              What the user should see
------------------------------------------------
1250                    $1,250.00
0.75                    75%
2026-10-06              Oct 6, 2026
hello world             HELLO WORLD
```

Without pipes, you would have to write formatting logic yourself.

Pipes let you keep the template simple:

```html
<p>{{ price | currency }}</p>
<p>{{ discount | percent }}</p>
<p>{{ today | date }}</p>
<p>{{ name | uppercase }}</p>
```

***

## 2. How Pipes Work Internally

Let's look at:

```html
{{ name | uppercase }}
```

Suppose:

```ts
name = 'angular';
```

Angular sees:

```text
name | uppercase
```

and conceptually does this:

```text
"angular"
     ↓
uppercase pipe
     ↓
"ANGULAR"
```

The displayed result becomes:

```text
ANGULAR
```

The original property is still:

```ts
name = 'angular';
```

The pipe is formatting the value **for the template**.

So think of a pipe as a small **transformation step**:

```text
value → pipe → displayed value
```

### Important distinction

A pipe does **not** mean:

```ts
name = "ANGULAR";
```

Instead, it is closer to:

```text
name
 ↓
transform for display
 ↓
show transformed result
```

This is why pipes are especially useful for presentation/formatting.

***

## 3. Syntax

The basic syntax is:

```html
{{ value | pipeName }}
```

For example:

```html
{{ name | uppercase }}
```

You can also pass **parameters** to a pipe.

For example:

```html
{{ price | currency:'USD' }}
```

The general syntax is:

```html
{{ value | pipeName:parameter }}
```

Multiple pipes can also be chained:

```html
{{ name | uppercase | lowercase }}
```

The result of the first pipe becomes the input to the next pipe:

```text
name
 ↓
uppercase
 ↓
lowercase
 ↓
display
```

In practice, chaining only makes sense when each transformation is useful.

***

# 4. Built-in Pipes

Angular provides many built-in pipes.

For this lesson, focus on these common ones:

* `uppercase`
* `lowercase`
* `titlecase`
* `number`
* `currency`
* `percent`
* `date`
* `json`

***

## `uppercase`

Converts text to uppercase.

```ts
name = 'angular';
```

```html
<p>{{ name | uppercase }}</p>
```

Output:

```text
ANGULAR
```

The original `name` is still:

```text
angular
```

***

## `lowercase`

Converts text to lowercase.

```ts
message = 'HELLO ANGULAR';
```

```html
<p>{{ message | lowercase }}</p>
```

Output:

```text
hello angular
```

***

## `titlecase`

Converts text to title case.

```ts
title = 'angular is awesome';
```

```html
<p>{{ title | titlecase }}</p>
```

Output:

```text
Angular Is Awesome
```

This is useful for displaying names, titles, or labels.

***

## `number`

Formats a number for display.

Suppose:

```ts
price = 1234567.89;
```

You can write:

```html
<p>{{ price | number }}</p>
```

Angular formats the number according to its number-formatting rules.

You can also specify formatting options:

```html
<p>{{ price | number:'1.2-2' }}</p>
```

The exact meaning of `'1.2-2'` is:

```text
1   → minimum integer digits
2   → minimum decimal digits
2   → maximum decimal digits
```

So the result has at least two decimal places and at most two decimal places.

***

## `currency`

Formats a number as money.

```ts
price = 1250;
```

```html
<p>{{ price | currency }}</p>
```

You can specify the currency:

```html
<p>{{ price | currency:'USD' }}</p>
```

Or:

```html
<p>{{ price | currency:'BDT' }}</p>
```

This is useful when displaying prices, salaries, payments, etc.

### Important

The pipe is formatting the number for display.

It doesn't turn:

```ts
price = 1250;
```

into a string permanently.

Your component still has a numeric value:

```ts
price = 1250;
```

***

## `percent`

Formats a number as a percentage.

```ts
discount = 0.25;
```

```html
<p>{{ discount | percent }}</p>
```

Output:

```text
25%
```

This is important:

```text
0.25 → 25%
```

because percentage formatting interprets the value as a fraction.

For example:

```text
0.5  → 50%
0.75 → 75%
1    → 100%
```

***

## `date`

Formats a date.

Suppose:

```ts
today = new Date();
```

You can write:

```html
<p>{{ today | date }}</p>
```

Angular formats the date for display.

You can also request a particular format:

```html
<p>{{ today | date:'short' }}</p>
```

or:

```html
<p>{{ today | date:'medium' }}</p>
```

The important idea is:

```text
Date object
     ↓
date pipe
     ↓
human-readable date
```

***

## `json`

The `json` pipe converts a value into a JSON-style representation.

For example:

```ts
user = {
  name: 'Rahim',
  age: 25
};
```

You can display it with:

```html
<pre>{{ user | json }}</pre>
```

This is especially useful for **debugging** because you can quickly see the contents of an object.

You generally wouldn't use `json` as the final presentation for normal users.

***

# 5. Examples

Let's put several pipes together.

### Component

```ts
import { Component } from '@angular/core';
import { CurrencyPipe, DatePipe, PercentPipe, UpperCasePipe } from '@angular/common';

@Component({
  selector: 'app-product',
  standalone: true,
  imports: [
    CurrencyPipe,
    DatePipe,
    PercentPipe,
    UpperCasePipe
  ],
  template: `
    <h2>{{ productName | uppercase }}</h2>

    <p>Price: {{ price | currency:'USD' }}</p>

    <p>Discount: {{ discount | percent }}</p>

    <p>Added: {{ createdAt | date }}</p>
  `
})
export class ProductComponent {
  productName = 'laptop';
  price = 1200;
  discount = 0.15;
  createdAt = new Date();
}
```

Notice something important here:

```ts
imports: [
  CurrencyPipe,
  DatePipe,
  PercentPipe,
  UpperCasePipe
]
```

These are Angular's standalone pipe classes being imported into the component.

Then the template can use:

```html
{{ productName | uppercase }}
{{ price | currency:'USD' }}
{{ discount | percent }}
{{ createdAt | date }}
```

Modern standalone Angular makes dependencies explicit in the component's `imports` array.

***

### Another simple example

```ts
name = 'rahim';
price = 2500;
discount = 0.20;
```

```html
<p>{{ name | titlecase }}</p>

<p>{{ price | currency:'BDT' }}</p>

<p>{{ discount | percent }}</p>
```

The user sees something like:

```text
Rahim
BDT2,500.00
20%
```

while the component still contains the original values.

***

# 6. Common Mistakes

### Mistake 1 — Confusing a pipe with the original value

If you write:

```html
{{ name | uppercase }}
```

it does **not** mean:

```ts
name = name.toUpperCase();
```

It only formats the value for that template expression.

***

### Mistake 2 — Forgetting that `percent` expects a fraction

If:

```ts
discount = 25;
```

then:

```html
{{ discount | percent }}
```

doesn't mean "25 percent."

For 25%, the value should normally be:

```ts
discount = 0.25;
```

Then:

```html
{{ discount | percent }}
```

displays:

```text
25%
```

***

### Mistake 3 — Using a pipe for business logic

Pipes are mainly for **presentation**.

Don't use them as a place to put complicated application logic.

For example, don't try to make a pipe responsible for:

```text
checking permissions
saving data
calling an API
updating application state
```

Those belong elsewhere.

Think:

> **Pipes format data for display.**

***

### Mistake 4 — Forgetting standalone imports

In a standalone component, a pipe may need to be imported:

```ts
import { UpperCasePipe } from '@angular/common';
```

and then:

```ts
imports: [UpperCasePipe]
```

Without the required import, Angular won't know that the template is allowed to use that pipe.

***

# 7. Hands-on Exercise

Create a standalone component called `ProfileComponent`.

Give it these properties:

```ts
name = 'john doe';
salary = 50000;
completion = 0.85;
joinDate = new Date();
```

Create a template that displays:

```text
Name: John Doe
Salary: [formatted as currency]
Completion: 85%
Join Date: [formatted date]
```

You should use:

* `titlecase`
* `currency`
* `percent`
* `date`

**Don't manually format the values in TypeScript. Use pipes in the template.**

Try it yourself before looking for a solution.

***

# 8. Quick Review

### Question 1

What is the primary purpose of an Angular pipe?

> **A.** Store application state
> **B.** Transform data for display
> **C.** Make HTTP requests
> **D.** Create components

**Correct answer: B — Transform data for display.**

Pipes are primarily used to transform values when displaying them in templates.

***

### Question 2

What does this do?

```html
{{ name | uppercase }}
```

> **A.** Permanently changes `name` to uppercase
> **B.** Deletes `name`
> **C.** Displays `name` in uppercase
> **D.** Creates a new component

**Correct answer: C — Displays `name` in uppercase.**

The pipe transforms the value for the template display; it doesn't normally modify the original property.

***

### Question 3

If:

```ts
discount = 0.25;
```

what does this normally display?

```html
{{ discount | percent }}
```

> **A.** 0.25%
> **B.** 2.5%
> **C.** 25%
> **D.** 250%

**Correct answer: C — 25%.**

The `percent` pipe treats `0.25` as 25/100.

***

### Question 4

Which pipe is useful for displaying an object while debugging?

> **A.** `json`
> **B.** `currency`
> **C.** `date`
> **D.** `percent`

**Correct answer: A — `json`.**

The `json` pipe gives you a readable representation of an object's contents.

***

### Question 5

What does this mean?

```html
{{ price | currency:'USD' }}
```

> **A.** Convert the price permanently into USD
> **B.** Display the price using USD currency formatting
> **C.** Change the value of `price`
> **D.** Create a USD object

**Correct answer: B — Display the price using USD currency formatting.**

The pipe controls how the value is presented in the template.

***

## Progress

**Completed:** Lesson 3.4 — Pipes & Built-in Pipes

**Next:** Lesson 4.1 — Why modern control flow? `@if` / `@else`
