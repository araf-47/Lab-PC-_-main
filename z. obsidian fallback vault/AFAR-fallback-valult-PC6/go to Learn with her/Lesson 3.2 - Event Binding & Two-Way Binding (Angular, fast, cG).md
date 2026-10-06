# Lesson 3.2 — Event Binding & Two-Way Binding

***

## 1. Theory

### Event binding

**Event binding** lets your component respond to something the user does in the browser.

For example:

* Clicking a button
* Typing in an input
* Selecting an option
* Submitting a form

The basic idea is:

> **User action → Angular calls your component code**

Example:

```html
<button (click)="sayHello()">Click me</button>
```

When the button is clicked, Angular calls `sayHello()`.

***

### Two-way binding

**Two-way binding** means data can move in **both directions**:

```text
Component → HTML
HTML → Component
```

For example, suppose your component has:

```ts
name = '';
```

If the user types `"John"` into an input, `name` becomes `"John"`.

If your component changes `name` to `"Alice"`, the input displays `"Alice"`.

So:

> **Two-way binding keeps the component's data and the input's value synchronized.**

***

## 2. How it works internally

### Event binding

Think of the HTML element as producing an event:

```text
User clicks button
       ↓
click event
       ↓
Angular detects event
       ↓
Angular runs your method
```

For example:

```html
<button (click)="increase()">+</button>
```

The `(click)` tells Angular:

> "Listen for the click event."

***

### Two-way binding

Angular's two-way binding combines:

1. **Property binding** — component → HTML
2. **Event binding** — HTML → component

Conceptually:

```text
Component
   │
   │ value
   ↓
 Input
   │
   │ user changes value
   ↓
Component
```

Angular provides a convenient syntax for this:

```html
[(ngModel)]
```

This is commonly called **banana-in-a-box syntax** because of the `[( )]` shape.

***

## 3. Syntax

### Event binding

General syntax:

```html
(elementEvent)="expression"
```

Example:

```html
<button (click)="sayHello()">Hello</button>
```

You can also use the event object:

```html
<input (input)="handleInput($event)">
```

`$event` represents the browser event that occurred.

***

### Two-way binding

The syntax is:

```html
[(ngModel)]="property"
```

Example:

```html
<input [(ngModel)]="name">
```

If you use `ngModel`, the component needs Angular's `FormsModule`.

With a standalone component:

```ts
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-user',
  imports: [FormsModule],
  template: `
    <input [(ngModel)]="name">
    <p>Hello {{ name }}</p>
  `
})
export class User {
  name = '';
}
```

***

## 4. Examples

### Example 1 — Button click

Component:

```ts
export class App {
  count = 0;

  increase() {
    this.count++;
  }
}
```

Template:

```html
<p>Count: {{ count }}</p>

<button (click)="increase()">Increase</button>
```

When the user clicks:

```text
count = 0
   ↓
click
   ↓
increase()
   ↓
count = 1
```

The interpolation then displays the new value.

***

### Example 2 — Reading the input event

```ts
export class App {
  handleInput(event: Event) {
    const input = event.target as HTMLInputElement;

    console.log(input.value);
  }
}
```

```html
<input (input)="handleInput($event)">
```

When the user types, Angular calls:

```ts
handleInput($event)
```

`$event` contains information about the input event.

***

### Example 3 — Two-way binding

Component:

```ts
export class App {
  name = '';
}
```

Template:

```html
<input [(ngModel)]="name">

<p>Your name is {{ name }}</p>
```

If the user types:

```text
John
```

then:

```ts
name === 'John'
```

And:

```html
{{ name }}
```

displays:

```text
Your name is John
```

The important part is that you don't have to manually handle the input event.

***

### Example 4 — Event binding vs two-way binding

Event binding:

```html
<button (click)="increase()">Increase</button>
```

This handles an **event**.

Two-way binding:

```html
<input [(ngModel)]="name">
```

This keeps a **value synchronized in both directions**.

So remember:

```text
(click)       → respond to an event

[(ngModel)]   → synchronize a value both ways
```

***

## 5. Common mistakes

### Mistake 1 — Forgetting parentheses

Wrong:

```html
<button click="increase()">Increase</button>
```

Correct:

```html
<button (click)="increase()">Increase</button>
```

The parentheses tell Angular that this is **event binding**.

***

### Mistake 2 — Calling the method immediately

Wrong:

```html
<button (click)="increase()">Increase</button>
```

Actually, this one is correct.

The common mistake is writing:

```html
<button (click)="increase">Increase</button>
```

That passes the method reference rather than calling it.

For a normal method call, use:

```html
(click)="increase()"
```

***

### Mistake 3 — Forgetting `FormsModule`

If you write:

```html
<input [(ngModel)]="name">
```

but haven't imported `FormsModule`, Angular won't recognize `ngModel`.

For a standalone component:

```ts
imports: [FormsModule]
```

***

### Mistake 4 — Confusing one-way and two-way binding

Property binding:

```html
<input [value]="name">
```

means:

```text
Component → HTML
```

Two-way binding:

```html
<input [(ngModel)]="name">
```

means:

```text
Component ↔ HTML
```

***

## 6. Hands-on exercise

Create a small **name editor**.

Your component should have:

```ts
name = '';
```

Create an input using two-way binding:

```html
<input [(ngModel)]="name">
```

Then display:

```text
Hello, [name]
```

Also add a button:

```text
Clear
```

When the button is clicked, it should clear the name.

Your component should therefore have a method similar to:

```ts
clearName() {
  // your code
}
```

**Your task:** write the complete component yourself.

***

## 7. Quick review

### Question 1

What does this do?

```html
<button (click)="save()">Save</button>
```

> A. Creates a property binding
> B. Listens for a click event
> C. Creates two-way binding
> D. Creates a new component

**Correct answer: B** — `(click)` is event binding.

***

### Question 2

Which syntax is used for two-way binding with `ngModel`?

> A. `[ngModel]`
> B. `(ngModel)`
> C. `[(ngModel)]`
> D. `{ngModel}`

**Correct answer: C** — `[(ngModel)]` provides two-way binding.

***

### Question 3

What does `$event` represent?

> A. The current component
> B. The event that occurred
> C. The HTML template
> D. The Angular application

**Correct answer: B** — `$event` gives you the event object.

***

### Question 4

What direction does this represent?

```html
<input [(ngModel)]="name">
```

> A. Component → HTML only
> B. HTML → Component only
> C. Component ↔ HTML
> D. Neither

**Correct answer: C** — two-way binding synchronizes the value in both directions.

***

### Question 5

What must a standalone component import to use `[(ngModel)]`?

> A. `HttpClient`
> B. `Router`
> C. `FormsModule`
> D. `CommonModule`

**Correct answer: C** — `FormsModule` provides `ngModel`.

***

### Progress

**Done:** Lesson 3.2 — Event binding & Two-way binding
**Next:** Lesson 3.3 — Class binding & Style binding
