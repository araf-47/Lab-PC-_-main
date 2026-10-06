# Lesson 3.1 — Interpolation & Property Binding

## 1. Theory

Angular templates need a way to display data from a component and control HTML elements using that data.

Two important tools are:

* **Interpolation** → display a value as text.
* **Property binding** → set an HTML element's property using a component value.

A simple way to remember:

> **Interpolation = put data into text.**
> **Property binding = put data into an element's property.**

***

## 2. How it works internally

Suppose your component has:

```ts
export class App {
  name = 'Alice';
  imageUrl = 'https://example.com/photo.jpg';
}
```

Angular connects the component's TypeScript data to its template.

For interpolation:

```html
<h1>Hello {{ name }}</h1>
```

Angular evaluates `name` and produces text:

```text
Hello Alice
```

For property binding:

```html
<img [src]="imageUrl">
```

Angular evaluates `imageUrl` and assigns its value to the image element's `src` property.

The important difference is **where the value goes**:

```text
Interpolation
component data → text

Property binding
component data → element property
```
- learn more ... [[What is element property (l3.1-i&pb)]].
***

## 3. Syntax

### Interpolation

Use double curly braces:

```html
{{ expression }}
```

Example:

```html
<p>{{ name }}</p>
```

You can also use simple expressions:

```html
<p>{{ price * quantity }}</p>
```

```html
<p>{{ firstName + ' ' + lastName }}</p>
```

Angular evaluates the expression and displays the result as text.

### Property binding

Use square brackets:

```html
[property]="expression"
```

Example:

```html
<img [src]="imageUrl">
```

Another example:

```html
<button [disabled]="isDisabled">
  Save
</button>
```

Here:

```html
[disabled]
```

means:

> Bind the button's `disabled` property to the component's `isDisabled` value.

***

## 4. Examples

### Example 1 — Interpolation

Component:

```ts
export class App {
  username = 'Alice';
}
```

Template:

```html
<h1>Welcome, {{ username }}</h1>
```

Result:

```text
Welcome, Alice
```

The value is being displayed as **text**.

***

### Example 2 — Multiple values

Component:

```ts
export class App {
  productName = 'Laptop';
  price = 800;
}
```

Template:

```html
<h2>{{ productName }}</h2>
<p>Price: ${{ price }}</p>
```

Result:

```text
Laptop
Price: $800
```

***

### Example 3 — Property binding

Component:

```ts
export class App {
  imageUrl = 'https://example.com/laptop.jpg';
}
```

Template:

```html
<img [src]="imageUrl">
```

Angular takes the value of `imageUrl` and assigns it to the image's `src` property.

Notice that we **do not** write:

```html
<img [src]="{{ imageUrl }}">
```

That is incorrect.

Use either interpolation:

```html
<img src="{{ imageUrl }}">
```

or property binding:

```html
<img [src]="imageUrl">
```

For property binding, the modern Angular form is:

```html
[src]="imageUrl"
```

***

### Example 4 — Boolean property

Component:

```ts
export class App {
  isDisabled = true;
}
```

Template:

```html
<button [disabled]="isDisabled">
  Save
</button>
```

Because `isDisabled` is `true`, the button is disabled.

If the value changes to:

```ts
isDisabled = false;
```

the button becomes enabled.

This is an important reason property binding exists: Angular can work with the **actual property value**, including booleans.

***

### Example 5 — Interpolation vs property binding

Consider:

```ts
export class App {
  title = 'My Website';
  isDisabled = true;
}
```

Interpolation:

```html
<h1>{{ title }}</h1>
```

Property binding:

```html
<button [disabled]="isDisabled">
  Submit
</button>
```

Think:

```text
{{ title }}
     ↓
display text

[disabled]="isDisabled"
     ↓
control element property
```

***

## 5. Common mistakes

### Mistake 1 — Putting interpolation inside property binding

❌ Don't do this:

```html
<button [disabled]="{{ isDisabled }}">
  Save
</button>
```

Use:

```html
<button [disabled]="isDisabled">
  Save
</button>
```

Property binding already evaluates the expression.

***

### Mistake 2 — Forgetting the brackets

❌ This:

```html
<button disabled="isDisabled">
  Save
</button>
```

does **not** mean "bind the `disabled` property to the component value."

Use:

```html
<button [disabled]="isDisabled">
  Save
</button>
```

***

### Mistake 3 — Confusing text with a value

Suppose:

```ts
isDisabled = false;
```

This:

```html
<button [disabled]="isDisabled">
```

passes the **boolean value**:

```text
false
```

But interpolation is primarily for producing text:

```html
<p>{{ isDisabled }}</p>
```

which displays:

```text
false
```

***

## 6. Hands-on exercise

Create a component with these properties:

```ts
productName = 'Laptop';
price = 1200;
imageUrl = 'https://example.com/laptop.jpg';
isAvailable = true;
```

Then create a template that:

1. Displays `productName` using interpolation.
2. Displays `price` using interpolation.
3. Uses property binding to set an image's `src`.
4. Uses property binding to disable a button when `isAvailable` is `false`.

**Don't worry about making the image URL actually work. The goal is practicing the bindings.**

Try it yourself before looking for the answer.

***

## 7. Quick review

### Question 1

Which syntax is used for interpolation?

> A. `[name]`
> B. `{{ name }}`
> C. `(name)`
> D. `{name}`

**Answer: B — `{{ name }}`**

Interpolation evaluates the expression and displays its result as text.

***

### Question 2

Which is property binding?

> A. `<img src="imageUrl">`
> B. `<img (src)="imageUrl">`
> C. `<img [src]="imageUrl">`
> D. `<img {{src}}="imageUrl">`

**Answer: C — `<img [src]="imageUrl">`**

Square brackets indicate property binding.

***

### Question 3

You have:

```ts
isDisabled = true;
```

Which correctly binds the button's `disabled` property?

> A. `<button disabled="isDisabled">`
> B. `<button [disabled]="isDisabled">`
> C. `<button {{disabled}}="isDisabled">`
> D. `<button (disabled)="isDisabled">`

**Answer: B — `<button [disabled]="isDisabled">`**

Property binding passes the actual boolean value to the element.

***

### Question 4

What is the main purpose of interpolation?

> A. Listen for events
> B. Create components
> C. Display component data as text
> D. Create services

**Answer: C — Display component data as text**

***

## Progress

**Completed:** Lesson 3.1 — Interpolation & Property Binding

**Next:** Lesson 3.2 — Event Binding & Two-Way Binding
