# Lesson 3.3 — Class Binding & Style Binding

This lesson is about controlling an element's **CSS classes and CSS styles dynamically** from your Angular component.

***

## 1. Theory

### What is class binding?

Normally, HTML lets you give an element CSS classes like this:

```html
<p class="important">Hello</p>
```

The `class` attribute is static. The class is always there.

But in an Angular application, you often want a class to depend on some data.

For example:

* If a product is available → make it green.
* If a product is unavailable → make it gray.
* If a button is active → highlight it.
* If a user has an error → show an error style.

Instead of manually changing the HTML, Angular can decide whether a CSS class should be present.

That's **class binding**.

```html
<p [class.active]="isActive">Hello</p>
```

Here:

```text
isActive = true
        ↓
class="active"
```

and:

```text
isActive = false
        ↓
class="..."
```

The `active` class is removed.

So the basic idea is:

> **Class binding connects a CSS class to a TypeScript value.**

***

### What is style binding?

Style binding is similar, but instead of adding/removing a CSS class, you directly control a CSS property.

For example:

```html
<p [style.color]="textColor">Hello</p>
```

If:

```ts
textColor = 'blue';
```

Angular effectively produces:

```html
<p style="color: blue;">Hello</p>
```

If the value changes to:

```ts
textColor = 'red';
```

Angular updates the style.

So:

> **Style binding connects an individual CSS style property to a TypeScript value.**

***

### Class binding vs style binding

The difference is important:

| Class binding                     | Style binding                           |
| --------------------------------- | --------------------------------------- |
| Adds/removes CSS classes          | Changes individual CSS properties       |
| `[class.active]`                  | `[style.color]`                         |
| Good for reusable CSS rules       | Good for specific dynamic values        |
| CSS usually lives in a stylesheet | Value can come directly from TypeScript |

For example, suppose we have:

```css
.available {
  color: green;
  font-weight: bold;
}
```

We can use:

```html
<p [class.available]="isAvailable">
  Product available
</p>
```

The CSS class contains the styling rules.

With style binding:

```html
<p [style.color]="isAvailable ? 'green' : 'gray'">
  Product status
</p>
```

The color is controlled directly by Angular.

### A useful rule

Use **class binding** when you are choosing between predefined styling rules.

Use **style binding** when you need to dynamically change a particular CSS value.

***

## 2. How it works internally

Let's build the mental model.

Suppose your component contains:

```ts
isOnline = true;
```

and your template contains:

```html
<p [class.online]="isOnline">
  User status
</p>
```

Angular sees:

```text
[class.online]
       ↓
"online" CSS class
       ↓
isOnline
       ↓
true / false
```

When `isOnline` is `true`, Angular applies the class.

When it is `false`, Angular removes the class.

So Angular is essentially keeping the DOM synchronized with your component state.

```text
Component state
      ↓
  isOnline
      ↓
   Angular
      ↓
   DOM/CSS
```

### What happens when the value changes?

Imagine:

```ts
isOnline = true;
```

Initially:

```html
<p class="online">User status</p>
```

Later the value becomes:

```ts
isOnline = false;
```

Angular updates the element:

```html
<p>User status</p>
```

You don't manually do:

```ts
element.classList.add(...)
element.classList.remove(...)
```

Angular handles that DOM update for you.

This is an important Angular idea:

> **You describe what the UI should look like based on your state. Angular handles the DOM update.**

***

### Style binding works the same way

Suppose:

```ts
fontSize = '20px';
```

and:

```html
<p [style.font-size]="fontSize">
  Hello
</p>
```

Angular connects:

```text
fontSize
   ↓
20px
   ↓
Angular
   ↓
style="font-size: 20px"
```

If the value changes:

```ts
fontSize = '30px';
```

Angular updates the DOM accordingly.

You describe the relationship; Angular performs the update.

***

# 3. Syntax

## Class binding

The basic syntax is:

```html
[class.className]="expression"
```

Example:

```html
<p [class.active]="isActive">
  Account
</p>
```

If:

```ts
isActive = true;
```

the `active` class is applied.

If:

```ts
isActive = false;
```

the `active` class is not applied.

***

### Class binding with a condition

You can put an expression inside the binding:

```html
<p [class.expensive]="price > 1000">
  Product
</p>
```

If:

```ts
price = 1500;
```

then:

```text
price > 1000
     ↓
   true
     ↓
expensive class applied
```

If:

```ts
price = 500;
```

then:

```text
price > 1000
     ↓
   false
     ↓
expensive class removed
```

***

## Style binding

The basic syntax is:

```html
[style.property]="expression"
```

Example:

```html
<p [style.color]="textColor">
  Hello
</p>
```

with:

```ts
textColor = 'blue';
```

You can also use CSS properties containing hyphens:

```html
<p [style.font-size]="fontSize">
  Hello
</p>
```

with:

```ts
fontSize = '20px';
```

***

### Style binding with a condition

You can use an expression:

```html
<p [style.color]="isError ? 'red' : 'green'">
  Status
</p>
```

If:

```ts
isError = true;
```

the color becomes red.

If:

```ts
isError = false;
```

the color becomes green.

***

### Style binding with units

Angular also supports a useful syntax for units:

```html
<p [style.fontSize.px]="fontSize">
  Hello
</p>
```

with:

```ts
fontSize = 24;
```

This means:

```text
fontSize = 24
     ↓
font-size: 24px
```

You can also use other units:

```html
<div [style.width.%]="width">
  Content
</div>
```

with:

```ts
width = 50;
```

which represents:

```css
width: 50%;
```

***

# 4. Examples

## Example 1 — Class binding

Component:

```ts
export class App {
  isOnline = true;
}
```

CSS:

```css
.online {
  color: green;
  font-weight: bold;
}
```

Template:

```html
<p [class.online]="isOnline">
  User is online
</p>
```

Because `isOnline` is `true`, Angular applies:

```html
class="online"
```

So the text becomes green and bold.

If we change:

```ts
isOnline = false;
```

Angular removes the `online` class.

***

## Example 2 — Class based on a comparison

Component:

```ts
export class App {
  price = 1200;
}
```

CSS:

```css
expensive {
  color: red;
}
```

Template:

```html
<p [class.expensive]="price > 1000">
  Product price: {{ price }}
</p>
```

Here the expression is:

```ts
price > 1000
```

Because:

```text
1200 > 1000
```

is `true`, Angular applies the class.

You could later change:

```ts
price = 500;
```

and Angular removes the class.

***

## Example 3 — Style binding

Component:

```ts
export class App {
  textColor = 'blue';
}
```

Template:

```html
<p [style.color]="textColor">
  This text is blue.
</p>
```

Angular uses the value of `textColor` for the CSS `color` property.

***

## Example 4 — Conditional style

Component:

```ts
export class App {
  isError = true;
}
```

Template:

```html
<p [style.color]="isError ? 'red' : 'green'">
  Something happened.
</p>
```

The expression:

```ts
isError ? 'red' : 'green'
```

means:

```text
if isError is true → red
otherwise          → green
```

So the paragraph becomes red.

***

## Example 5 — Class binding vs style binding

Suppose we want to show whether a user is online.

### Class binding

CSS:

```css
.online {
  color: green;
}

.offline {
  color: gray;
}
```

Template:

```html
<p [class.online]="isOnline">
  Online
</p>
```

This is useful when your styling consists of a predefined CSS rule.

### Style binding

```html
<p [style.color]="isOnline ? 'green' : 'gray'">
  Online
</p>
```

This directly controls the `color` property.

Both can work, but they express slightly different intentions.

***

# 5. Common mistakes

### Mistake 1 — Forgetting the square brackets

Wrong:

```html
<p class.active="isActive">
```

That's just an HTML attribute. Angular isn't binding it.

Correct:

```html
<p [class.active]="isActive">
```

The `[]` tell Angular:

> "This is a property/class/style binding."

***

### Mistake 2 — Putting a TypeScript variable inside quotes

Wrong:

```html
<p [class.active]="'isActive'">
```

`'isActive'` is a string containing the word `"isActive"`.

Correct:

```html
<p [class.active]="isActive">
```

Here Angular evaluates the actual variable.

***

### Mistake 3 — Confusing class names and CSS properties

For class binding:

```html
[class.active]="isActive"
```

`active` is a **CSS class name**.

For style binding:

```html
[style.color]="textColor"
```

`color` is a **CSS property**.

Think:

```text
[class.X] → X is a class

[style.X] → X is a CSS property
```

***

### Mistake 4 — Trying to put a whole CSS rule into style binding

Don't do:

```html
<p [style]="color: red;">
```

Instead, for an individual style property:

```html
<p [style.color]="'red'">
```

Or use a CSS class when you have several related rules.

***

### Mistake 5 — Using style binding when a class would be cleaner

This can become messy:

```html
<div
  [style.color]="color"
  [style.font-size]="size"
  [style.font-weight]="weight"
  [style.background-color]="background"
>
```

If these styles represent a meaningful UI state, a CSS class is often cleaner:

```html
<div [class.highlighted]="isHighlighted">
```

with:

```css
.highlighted {
  color: white;
  font-size: 20px;
  font-weight: bold;
  background-color: blue;
}
```

***

# 6. Hands-on exercise

Create a small **product status** example.

### Component

Create these properties:

```ts
productName = 'Laptop';
price = 1200;
isAvailable = true;
```

### CSS

Create two classes:

```css
.available {
  color: green;
}

.expensive {
  font-weight: bold;
}
```

### Template

Display the product name and price.

Then:

1. Use **class binding** to apply `available` when `isAvailable` is `true`.
2. Use **class binding** to apply `expensive` when `price` is greater than `1000`.
3. Use **style binding** to make the product name blue.
4. Change `isAvailable` to `false` and `price` to `500` and observe what changes.

Try it yourself before looking for another example.

***

# 7. Quick review

### Question 1

What does this do?

```html
<p [class.active]="isActive">
```

> A. Changes the text
> B. Adds/removes the `active` CSS class
> C. Changes the `active` CSS property
> D. Creates a new component

**Correct answer: B**

It conditionally applies the `active` CSS class based on `isActive`.

***

### Question 2

Which syntax is used for style binding?

> A. `class.color`
> B. `[class.color]`
> C. `[style.color]`
> D. `style.color[]`

**Correct answer: C**

`[style.color]` binds a CSS `color` property to an Angular expression.

***

### Question 3

If:

```ts
isAvailable = false;
```

what happens here?

```html
<p [class.available]="isAvailable">
```

> A. `available` is always applied
> B. `available` is removed/not applied
> C. Angular throws an error
> D. The paragraph disappears

**Correct answer: B**

The expression evaluates to `false`, so Angular does not apply the class.

***

### Question 4

Which is generally better when you have a reusable group of CSS rules?

> A. Class binding
> B. Style binding
> C. Interpolation
> D. Event binding

**Correct answer: A**

A CSS class lets you define a group of related styles once and conditionally apply them.

***

### Question 5

What does this mean?

```html
<p [style.fontSize.px]="fontSize">
```

> A. `fontSize` is automatically converted to a string
> B. The CSS `font-size` property receives a value in pixels
> C. A CSS class called `fontSize` is created
> D. Angular creates a new stylesheet

**Correct answer: B**

For example, `fontSize = 24` results in a `font-size` value of `24px`.

***

## Progress

**Done:** Lesson 3.3 — Class binding & Style binding
**Next:** Lesson 3.4 — Pipes & Built-in pipes
