# Lesson 4.3 — `@switch`, `@case`, and `@default`

## 1. Theory: What are `@switch`, `@case`, and `@default`?

In Angular, sometimes we need to display different content depending on the value of a variable.

For example, imagine you are building a student dashboard. A student's result can have one of three values:

- `"passed"` — display a success message.
- `"failed"` — display a failure message.
- `"pending"` — display a message saying the result is not ready.

We could use multiple `@if` and `@else if` conditions. However, when we need to compare one value against several possible exact values, `@switch` is often easier to read.

Think of it as choosing one option from a menu.

The value to check

`studentResult = 'passed'`

`@case ('passed')`

Matches — display the success message.

`@case ('failed')`

Does not match.

`@case ('pending')`

Does not match.

Angular's modern control-flow syntax gives us three important pieces:

| Syntax     | Purpose                                                       |
| ---------- | ------------------------------------------------------------- |
| `@switch`  | Specifies the value we want to check.                         |
| `@case`    | Defines a possible matching value and the content to display. |
| `@default` | Defines the fallback content when no case matches.            |

### When should you use `@switch` instead of `@if`?

Use `@if` when you want to check a condition, such as whether a number is greater than 10, whether a user is logged in, or whether a list contains items.

Use `@switch` when you want to compare one expression against several possible values, such as a user's role, an order's status, or a payment's status.

Both are useful. The goal is to choose the syntax that makes your intention easiest to understand.

## 2. How it works internally

Let's understand what Angular does when it encounters a `@switch` block.

Imagine your component has this property:

```
studentResult = 'passed';
```

And your template contains:

```
@switch (studentResult) {
  @case ('passed') {
    <p>Congratulations! You passed.</p>
  }
  @case ('failed') {
    <p>Unfortunately, you failed.</p>
  }
  @case ('pending') {
    <p>Your result is not ready.</p>
  }
  @default {
    <p>Unknown result.</p>
  }
}
```

Angular conceptually follows these steps:

1. It evaluates `studentResult` and gets the value `'passed'`.
2. It compares that value with each `@case` value.
3. The `'passed'` case matches.
4. Angular displays the content belonging to that case.
5. The content belonging to the other cases is not displayed.
6. Because a case matched, the `@default` fallback is not needed.

The mental model is:

Read the value → find the matching case → display its content.

If `studentResult` changes to `'pending'`, Angular updates the displayed content to match the new value.

One important detail: Angular's `@switch` uses strict equality for matching. In simple terms, both the value and its type matter. The number `1` is not the same as the string `'1'`.

Also, `@default` is optional. You include it when you want to handle values that none of your cases explicitly covers.

## 3. Syntax: The exact structure

Here is the general syntax you will use:

```
@switch (expression) {
  @case (value1) {
    <!-- Content for value1 -->
  }
  @case (value2) {
    <!-- Content for value2 -->
  }
  @default {
    <!-- Fallback content -->
  }
}
```

Understand each part:

- `expression` is the value Angular checks.
- `value1` and `value2` are the possible values you want to match.
- The HTML inside a matching `@case` block is what Angular displays.
- `@default` handles any value that does not match a case.

You can use as many `@case` blocks as needed. The `@default` block can be omitted if you do not need a fallback.

Notice that each block uses curly braces `{ }` to group its content. The structure is similar to a set of branches: each branch has a value to match and content to display.

## 4. Examples

### Example 1: Displaying an order status

Suppose a component has an order status.

File: `order.component.ts`

```
import { Component } from '@angular/core';

@Component({
  selector: 'app-order',
  standalone: true,
  templateUrl: './order.component.html'
})
export class OrderComponent {
  status = 'shipped';
}
```

File: `order.component.html`

```
<h2>Order status</h2>

@switch (status) {
  @case ('pending') {
    <p>Your order is waiting to be processed.</p>
  }
  @case ('shipped') {
    <p>Your order is on its way!</p>
  }
  @case ('delivered') {
    <p>Your order has arrived.</p>
  }
  @default {
    <p>We could not determine your order status.</p>
  }
}
```

What happens?

The `status` property contains `'shipped'`, so Angular displays:

> Your order is on its way!

The other case messages are not displayed.

If you change the property to:

```
status = 'delivered';
```

Angular displays the delivery message instead.

Why is this useful? An order can have several possible statuses, but the user should see the message that corresponds to the current status.

### Example 2: Matching numbers versus strings

Consider this component property:

```
roleId = 2;
```

The template:

```
@switch (roleId) {
  @case (1) {
    <p>Administrator</p>
  }
  @case (2) {
    <p>Editor</p>
  }
  @case (3) {
    <p>Viewer</p>
  }
  @default {
    <p>Unknown role</p>
  }
}
```

Angular displays `Editor` because the number `2` matches the number `2`.

But suppose you change the property to:

```
roleId = '2';
```

Now the value is a string, not a number. It does not match `@case (2)`, so Angular displays `Unknown role`.

This is why the type of the value matters, not just how it looks.

### Example 3: Try changing the value

You can experiment with the following example. Select a different order status and observe which message appears.

Current order status

Pending

Shipped

Delivered

Cancelled

Displayed message

Your order is on its way!

This interactive preview demonstrates the same branching behavior. In your Angular template, you would implement it using `@switch` and `@case`.

## 5. Common mistakes

### Mistake 1: Forgetting the parentheses

Incorrect:

```
@switch status {
  ...
}
```

Correct:

```
@switch (status) {
  ...
}
```

The expression being checked must be inside parentheses.

### Mistake 2: Forgetting the braces

Incorrect:

```
@case ('shipped')
  <p>Your order is on its way!</p>
```

Correct:

```
@case ('shipped') {
  <p>Your order is on its way!</p>
}
```

Each case's content must be enclosed in braces.

### Mistake 3: Using a string case for a number

Incorrect if `roleId` is the number `2`:

```
@switch (roleId) {
  @case ('2') {
    <p>Editor</p>
  }
}
```

Correct:

```
@switch (roleId) {
  @case (2) {
    <p>Editor</p>
  }
}
```

Match the actual type and value.

### Mistake 4: Assuming `@default` is mandatory

This is perfectly valid:

```
@switch (status) {
  @case ('shipped') {
    <p>Shipped</p>
  }
  @case ('delivered') {
    <p>Delivered</p>
  }
}
```

If no case matches, neither message is displayed. Use `@default` when you need a fallback.

### Mistake 5: Using `@switch` for every kind of condition

For a condition such as `age >= 18`, use `@if`:

```
@if (age >= 18) {
  <p>Adult</p>
} @else {
  <p>Minor</p>
}
```

For checking whether `status` equals `'shipped'`, `'delivered'`, or `'pending'`, `@switch` is often clearer.

## 6. Hands-on exercise

Build a small payment status display using `@switch`, `@case`, and `@default`.

Create a component named `payment.component.ts` with this property:

```
paymentStatus = 'paid';
```

In its template, implement these requirements:

1. If the status is `'paid'`, display `Payment successful!`
2. If the status is `'pending'`, display `Waiting for payment...`
3. If the status is `'failed'`, display `Payment failed. Please try again.`
4. For any other value, display `Unknown payment status.`

Your task: Write the template code in `payment.component.html`. You do not need to rewrite the TypeScript component.

Test your template by changing `paymentStatus` to `'pending'`, `'failed'`, and `'refunded'`. Check which message appears for each value.

Paste your solution when you're ready, and I'll review it.

## 7. Quick review

### Question 1

What is the main purpose of `@switch`?

- A. To repeat HTML elements for a list.
- B. To compare one value against several possible values.
- C. To create a new component.
- D. To declare a TypeScript variable.

Correct answer: B. `@switch` chooses content based on which case matches a value.

### Question 2

What does `@case` define?

- A. A possible value to match and the content to display.
- B. A fallback for all unmatched values.
- C. A component's CSS styles.
- D. A new service.

Correct answer: A. Each `@case` represents a possible matching value.

### Question 3

When does `@default` run?

- A. Every time `@switch` runs.
- B. Only when the first case matches.
- C. When none of the cases matches.
- D. Only when the value is a number.

Correct answer: C. `@default` provides fallback content when no case matches.

### Question 4

What happens when `userRole = 2` and the template contains `@case ('2')`?

- A. The case matches because both values look like 2.
- B. The case does not match because one value is a number and the other is a string.
- C. Angular automatically converts the string to a number.
- D. Angular displays every case.

Correct answer: B. Angular uses strict equality, so the number `2` and string `'2'` are different.

### Question 5

Which syntax is generally more suitable for checking several exact order statuses?

- A. `@switch` with multiple `@case` blocks.
- B. `@for`.
- C. `@empty`.
- D. `@defer`.

Correct answer: A. `@switch` clearly organizes several possible values and their corresponding content.

## Progress

- Completed: Lesson 4.3 — `@switch`, `@case`, `@default`
- Next: Lesson 4.4 — What are directives? Attribute directives, `ngClass`, `ngStyle`

I'll wait for your exercise solution or your next instruction.