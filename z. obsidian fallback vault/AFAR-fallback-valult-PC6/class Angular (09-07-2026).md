
#hasToDo 
*** 
- [ ] learn about directive.
- [ ] learn about one way data binding.
- [ ] what is `ngModel`
### Truthy and falsely
in JS
***
`ngStyle`
## Chapter 11: Building directives
`ngSwitch`
`ngFor`

- Table 11-4. The ngFor Local Template Values
	- index
	- count
	- odd
	- even
### ng template

ng container and `<div>` is the same thing.

### Understanding One-Way Data Binding Restrictions
#### Using Idempotent Expressions
for same input, same output.
#### Understanding the Expression Context
expressions only runs on components.
	- component is self is a small application (a component has it's own html, css, js).

## chapter 12: Using Events and forms
> sir made two input field . when I click the button it adds them in a table below.

### Using the Event Binding
- binding a method of a component with an html event. one event one method binding.
	- method or statement.
### Using Event Data
> on hover table row background change.


>inside `app.ts`
```ts
  eventData: string = '';
}
```
> inside the `app.html`
```ts
<input type="text" (input)="eventData = $event.target.value" placeholder="Enter something..." />
<p>You entered: {{ eventData }}</p>
```

