An **element property** is a value that belongs to an HTML element and controls something about that element.

For example:

```html
<button disabled>Save</button>
```

The button has a property called `disabled`.

It can have a value:

```text
disabled = true
```

That means the button cannot be clicked.

Another example:

```html
<img src="photo.jpg">
```

The image has a `src` property:

```text
src = "photo.jpg"
```

It tells the browser which image to display.

### In Angular

Property binding lets Angular set these properties using your component's data:

```ts
isDisabled = true;
```

```html
<button [disabled]="isDisabled">
  Save
</button>
```

Think of it like this:

```text
Component
    ↓
isDisabled = true
    ↓
[disabled]
    ↓
<button>
```

So when I said:

> **Property binding = put data into an element's property**

I mean:

> **Angular takes a value from your component and uses it to control a property of an HTML element.**

A few common element properties:

```text
<button>  → disabled
<img>     → src
<input>   → value
<input>   → disabled
<a>       → href
```

This distinction is important because **interpolation displays text**, while **property binding controls an element's property**.
