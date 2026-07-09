# Typescript
from w3 school

type script is a library
## TypeScript Simple Types
=> https://www.w3schools.com/typescript/typescript_simple_types.php

Boolean
Number
>String
>```js
>let sentence: string = `Hello, my name is ${fullName} and I'll be ${age + 1} next year.`;
>```

BigInt
Symbol


## TypeScript Explicit Types and Inference
- **Explicit Typing**: You explicitly declare the type of a variable
- **Type Inference**: TypeScript automatically determines the type based on the assigned value

#### Explicit Type Annotations

Explicit typing means you tell TypeScript exactly what type a variable should be:

#### Type Inference
When Inference Shines

#### Type Safety in Action

parameter এর data type inference হয় না। এটা explicitly বলা লাগে 
```ts
function add(a: number, b: number): number {
	return a + b;
}
```


## Let's get started
= > https://www.w3schools.com/typescript/typescript_getstarted.php

`https://www.w3schools.com/typescript/typescript_getstarted.php`

## TypeScript Special Types
### Type: any
not type safe. and no need for type check

## Type: unknown
any but type safe
but we must check type with `if`
### Type: never
### Type: undefined & null
- Optional Parameters and Properties
- Nullish Coalescing and Optional Chaining : it checks for null. it is like NVL in oracle, if null > a default value.
	- `??` 
	- `||`

## TypeScript Arrays
> https://www.w3schools.com/typescript/typescript_arrays.php
### Readonly

## TypeScript Tuples
https://www.w3schools.com/typescript/typescript_tuples.php
### Readonly Tuple
### . . .

## TypeScript Object Types
https://www.w3schools.com/typescript/typescript_object_types.php

## TypeScript Enums
is a constant class where we can declare constant.
devs use this to check data integrity.
value either numeric or string.
value idndex দিয়ে বসে 