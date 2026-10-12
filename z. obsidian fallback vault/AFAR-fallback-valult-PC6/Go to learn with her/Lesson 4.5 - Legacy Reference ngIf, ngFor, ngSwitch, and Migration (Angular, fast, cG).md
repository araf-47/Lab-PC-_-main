# Lesson 4.5 — Legacy Reference: `*ngIf`, `*ngFor`, `*ngSwitch`, and Migration

Module 4 — Modern Control Flow & Directives

This lesson is about understanding older Angular code and knowing how it compares with modern Angular.

In modern Angular, you generally use `@if`, `@for`, and `@switch`. Older Angular projects commonly use `*ngIf`, `*ngFor`, and `*ngSwitch`.

The goal is not to make you prefer the old syntax. It is to help you read it, understand how it works, and recognize how to migrate it to the modern syntax.

## 1. Theory — Why does legacy syntax exist?

Angular has evolved over time. Older Angular applications used structural directives to control which elements appeared in a template and how lists were rendered.

A directive is an Angular feature that adds behavior to an HTML element or changes how Angular handles it.

There are two important categories:

- Attribute directives change the appearance or behavior of an existing element.
- Structural directives change the structure of the rendered view by adding, removing, or repeating content.

The `*ngIf`, `*ngFor`, and `*ngSwitch` directives belong to the structural-directive family.

For example:

- `*ngIf` conditionally displays content.
- `*ngFor` repeats content for each item in a collection.
- `*ngSwitch` chooses which content to display based on a value.

You already learned the modern alternatives in Lessons 4.1–4.3. Here, we will compare them.

### What does the `*` actually mean?

Consider this older syntax:

```
<p *ngIf="isLoggedIn">Welcome back!</p>
```

The asterisk (`*`) is not simply decoration. It tells Angular to interpret the directive using special template syntax called microsyntax.

Angular expands the expression into a longer template structure involving an `<ng-template>`.

Conceptually, the example behaves like this:

```
<ng-template [ngIf]="isLoggedIn">
  <p>Welcome back!</p>
</ng-template>
```

This is a conceptual expansion that illustrates the relationship between the two forms. Angular handles the transformation for you; you normally write the shorter version in legacy code.

The important idea is that `*ngIf` is more than a normal HTML attribute. It gives Angular instructions about whether to create the content's view.

## 2. How it works internally

To understand the old syntax, first understand what Angular means by a view.

A view is a section of a template that Angular manages and renders. It can contain elements, text, bindings, and child components.

### How `*ngIf` works

Imagine this code:

```
<p *ngIf="isLoggedIn">Welcome back!</p>
```

And this component property:

```
isLoggedIn = false;
```

Angular evaluates `isLoggedIn`. Because it is `false`, Angular does not create the paragraph's embedded view.

If the value becomes `true`, Angular creates that view and displays the paragraph.

Angular evaluates `isLoggedIn`

`true`

Create and display the paragraph's view.

`false`

Remove the paragraph's view.

This is different from merely hiding an element with CSS. When `*ngIf` is false, Angular removes the view rather than leaving the paragraph in the DOM with `display: none`.

### How `*ngFor` works

Consider:

```
<li *ngFor="let fruit of fruits">
  {{ fruit }}
</li>
```

Angular takes the collection and creates a repeated view for each item.

If `fruits` contains three items, Angular renders three list items. If the collection is empty, no list items are created by the loop.

The variable `fruit` represents the current item during each iteration. The expression `let fruit of fruits` is part of Angular's legacy template microsyntax; it is not a regular JavaScript `for...of` loop written directly in HTML.

### How `*ngSwitch` works

`*ngSwitch` lets you choose between alternative views based on a value.

For example, a status might be `"loading"`, `"success"`, or `"error"`. Angular checks the switch value and displays the matching case.

Unlike `*ngIf`, which tests a condition, `*ngSwitch` is designed to choose among multiple alternatives.

## 3. Syntax — The three legacy directives

### A. `*ngIf` — Conditional rendering

Suppose we want to display a message only when a user is logged in.

Legacy template:

```
<p *ngIf="isLoggedIn">Welcome back!</p>
```

Component property:

```
isLoggedIn = true;
```

When `isLoggedIn` is `true`, the paragraph is rendered. When it is `false`, the paragraph's view is removed.

You can also display alternative content using `else`.

```
<p *ngIf="isLoggedIn; else loggedOut">
  Welcome back!
</p>

<ng-template #loggedOut>
  <p>Please log in.</p>
</ng-template>
```

Here is what the extra syntax means:

- `else loggedOut` tells Angular which alternative template to use.
- `#loggedOut` declares a template reference named `loggedOut`.
- `<ng-template>` defines a template that Angular can render when instructed. Its contents are not displayed by default.

Compare that with modern Angular:

```
@if (isLoggedIn) {
  <p>Welcome back!</p>
} @else {
  <p>Please log in.</p>
}
```

The modern version expresses the condition and its alternative directly in the template. You do not need to create a separate named `<ng-template>` for this simple case.

### B. `*ngFor` — Repeating content

Suppose a component has this array:

```
fruits = ['Apple', 'Banana', 'Mango'];
```

Legacy template:

```
<ul>
  <li *ngFor="let fruit of fruits">
    {{ fruit }}
  </li>
</ul>
```

Angular repeats the `<li>` element for each item in `fruits`.

The result is conceptually equivalent to:

```
<ul>
  <li>Apple</li>
  <li>Banana</li>
  <li>Mango</li>
</ul>
```

The rendered HTML does not contain the literal `*ngFor` instruction. Angular uses it to produce the repeated elements.

#### Understanding `let fruit of fruits`

This expression has two parts:

- `fruits` is the collection Angular iterates over.
- `fruit` is a local template variable representing the current item in each iteration.

For the first iteration, `fruit` is `"Apple"`. For the second, it is `"Banana"`, and so on.

You can also access the index and whether an item is first or last:

```
<li *ngFor="let fruit of fruits; index as i; first as isFirst; last as isLast">
  {{ i }}: {{ fruit }}

  <span *ngIf="isFirst">First item</span>
  <span *ngIf="isLast">Last item</span>
</li>
```

Here:

- `index as i` gives the current zero-based index.
- `first as isFirst` gives a Boolean indicating whether this is the first item.
- `last as isLast` gives a Boolean indicating whether this is the last item.

The modern equivalent is simpler:

```
<ul>
  @for (fruit of fruits; track fruit; let i = $index) {
    <li>
      {{ i }}: {{ fruit }}

      @if ($first) {
        <span>First item</span>
      }

      @if ($last) {
        <span>Last item</span>
      }
    </li>
  } @empty {
    <li>No fruits available.</li>
  }
</ul>
```

Notice two differences:

1. Modern `@for` uses `track` to help Angular associate items with their rendered views.
2. Modern `@for` has a built-in `@empty` block for an empty collection.

In this example, `track fruit` is suitable because the fruit names are unique. For objects, you would normally use a unique identifier such as `track fruit.id`.

### C. `*ngSwitch` — Choosing between alternatives

Suppose a component contains:

```
status = 'loading';
```

Legacy template:

```
<div [ngSwitch]="status">
  <p *ngSwitchCase="'loading'">Loading...</p>
  <p *ngSwitchCase="'success'">Data loaded!</p>
  <p *ngSwitchCase="'error'">Something went wrong.</p>
  <p *ngSwitchDefault>Unknown status.</p>
</div>
```

Understand each part:

- `[ngSwitch]="status"` supplies the value Angular checks.
- `*ngSwitchCase="'loading'"` displays that case when the value matches `'loading'`.
- `*ngSwitchDefault` displays the fallback when no case matches.

The single quotes inside the double quotes are intentional. They indicate a string value in the template expression.

If `status` is `'success'`, Angular displays `Data loaded!` rather than the other cases.

Modern equivalent:

```
@switch (status) {
  @case ('loading') {
    <p>Loading...</p>
  }

  @case ('success') {
    <p>Data loaded!</p>
  }

  @case ('error') {
    <p>Something went wrong.</p>
  }

  @default {
    <p>Unknown status.</p>
  }
}
```

The modern form has no need for a wrapper with `[ngSwitch]` or a separate structural directive on every case. Angular compares the switch value with each case using strict equality (`===`).

## 4. Old vs. modern syntax

| Purpose       | 🕰️ Legacy syntax                 | Modern syntax                                 |
| ------------- | --------------------------------- | --------------------------------------------- |
| Conditional   | `*ngIf="condition"`               | `@if (condition) { ... }`                     |
| Alternative   | `else templateName`               | `@else { ... }`                               |
| Repeat a list | `*ngFor="let item of items"`      | `@for (item of items; track item.id) { ... }` |
| Empty list    | Usually an additional `*ngIf`     | `@empty { ... }`                              |
| Switch        | `[ngSwitch]` with `*ngSwitchCase` | `@switch`, `@case`                            |
| Default case  | `*ngSwitchDefault`                | `@default`                                    |

The fundamental purpose is the same: decide which views to render. The main difference is how you express those instructions in the template.

Modern control-flow blocks are built into Angular's template syntax. They do not require importing `CommonModule` just to use `@if`, `@for`, or `@switch`. The older directives, by contrast, must be available through the component's imports or another applicable import arrangement.&#x20;

[image](https://www.google.com/s2/favicons?domain=https://angular.dev\&sz=32)

Angular

+1



## 5. Common mistakes

### Mistake 1: Using multiple structural directives on one element

This is a common legacy pattern that does not work as expected:

```
<li *ngFor="let fruit of fruits" *ngIf="fruit !== 'Banana'">
  {{ fruit }}
</li>
```

You cannot place two asterisk-based structural directives on the same element. Each uses the same underlying template structure.

In modern Angular, you can nest control-flow blocks naturally:

```
@for (fruit of fruits; track fruit) {
  @if (fruit !== 'Banana') {
    <li>{{ fruit }}</li>
  }
}
```

### Mistake 2: Forgetting the imports

In older-style components, `*ngIf`, `*ngFor`, and `*ngSwitch` need their directives to be available. In a standalone component, that commonly means importing `CommonModule` or the individual directives.

For example:

```
import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';

@Component({
  selector: 'app-fruits',
  standalone: true,
  imports: [CommonModule],
  template: `
    <p *ngIf="fruits.length > 0">Fruits are available.</p>
  `
})
export class FruitsComponent {
  fruits = ['Apple', 'Mango'];
}
```

You will still encounter this setup in older code. With modern `@if` and `@for`, these control-flow blocks do not need `CommonModule`.

### Mistake 3: Confusing hiding with removing

`*ngIf` removes its view when the condition is false. It is not merely a CSS visibility switch.

This matters because the content may include child components, and removing their view can trigger their destruction lifecycle.

### Mistake 4: Using an unstable tracking value

With `*ngFor`, you may encounter a `trackBy` function. With modern `@for`, you use `track`.

Tracking helps Angular associate data items with rendered elements. Use a stable, unique identifier for objects whenever possible.

## 6. Migration — Converting old templates

Angular provides an official migration schematic to convert legacy control-flow syntax into modern control-flow blocks. The migration is available for Angular projects using the Angular CLI.&#x20;

[image](https://www.google.com/s2/favicons?domain=https://angular.dev\&sz=32)

Angular



### Step 1: Make sure your project is ready

Before migration, save your work and commit or back up your code so you can review changes and recover if necessary.

### Step 2: Run the migration command

From your Angular project's root directory, run:

```
ng generate @angular/core:control-flow
```

This command asks Angular to migrate supported legacy control-flow syntax across the workspace. You can also limit the migration to a particular path using the schematic's `--path` option.&#x20;

[image](https://www.google.com/s2/favicons?domain=https://angular.dev\&sz=32)

Angular



### Step 3: Review the result

For example, this legacy template:

```
<p *ngIf="isLoggedIn">Welcome!</p>
```

becomes:

```
@if (isLoggedIn) {
  <p>Welcome!</p>
}
```

Review the modified templates and run your project to check that the application still behaves as intended. A migration tool automates supported syntax changes; it does not replace testing your application.

### Important current-version note

Angular's official API documentation marks `NgIf` and `NgFor` as deprecated since Angular v20, recommending `@if` and `@for` instead. The documentation says removal of `NgFor` is intended for v22.&#x20;

[image](https://www.google.com/s2/favicons?domain=https://angular.dev\&sz=32)

Angular

+1



That makes understanding the old syntax useful for maintenance, but modern control flow should remain your default when writing new templates.

## 7. Hands-on exercise

Create a small fruit-list template using the legacy syntax only.

Assume these component properties exist:

```
isAvailable = true;

fruits = ['Apple', 'Banana', 'Mango'];

status = 'success';
```

Your tasks:

1. Use `*ngIf` to show `Fruits are available!` when `isAvailable` is true.
2. Use `*ngFor` to display each fruit in an `<li>`.
3. Use `[ngSwitch]`, `*ngSwitchCase`, and `*ngSwitchDefault` to display:
   - `Loading...` for `'loading'`
   - `Success!` for `'success'`
   - `Unknown status` for any other value.
4. Explain in your own words why the legacy syntax uses `*` and why modern `@if` does not.

Write only the template HTML for this exercise. I will review your answer when you send it.

## 8. Quick review

### Question 1

What does `*ngIf` do?

A. Changes an element's text color.

B. Conditionally creates or removes a rendered view.

C. Repeats an element for every array item.

Correct answer: B. `*ngIf` conditionally includes a template in the rendered view.

### Question 2

What does `let fruit of fruits` mean in `*ngFor`?

A. It declares a component property.

B. It imports an array.

C. It defines a local variable for the current item in the collection.

Correct answer: C. The local variable represents each item as Angular iterates over the collection.

### Question 3

Why is this invalid legacy syntax?

```
<li *ngFor="let fruit of fruits" *ngIf="fruit">
  {{ fruit }}
</li>
```

A. A single element cannot use two asterisk-based structural directives this way.

B. Angular cannot render list items.

C. `*ngIf` only works on `<div>` elements.

Correct answer: A. Each structural directive uses the same underlying template structure, so you must use a wrapper or another structure.

### Question 4

Which modern syntax replaces `[ngSwitch]` and `*ngSwitchCase`?

A. `@for` and `@empty`

B. `@if` and `@else`

C. `@switch`, `@case`, and `@default`

Correct answer: C. These built-in control-flow blocks handle multiple alternatives.

### Question 5

Which command runs Angular's control-flow migration schematic?

A. `ng update @angular/core`

B. `ng generate @angular/core:control-flow`

C. `ng new control-flow`

Correct answer: B. The schematic converts supported legacy control-flow syntax to the modern syntax.

## Progress

- Completed: Lesson 4.5 — Legacy Reference
- Next: Module 5, Lesson 5.1 — What is a signal? Why signals exist

I'll wait for your exercise answer or questions about this lesson.