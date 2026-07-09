## TypeScript Type Aliases and Interfaces
object এর ক্ষেত্রে interface. data এর ক্ষেত্রে type.
## TypeScript Union Types

## TypeScript Functions
```ts
function f1(): void{
	
}
```

optional data type is `number | undefined` 
optional property always have to be after the mediatory property << don't break this sequence.
undefined handling technique is **Nullish operator**.
### Default Parameters
### Rest Parameters
### Type Alias
better to do it inside the interface.
way to declare method signature:
```ts
export interface teachd {
    address: string;
    morningWork: () => void;
}
```

```ts
export interface teachd {
    address: string;
    morningWork?: () => void;
}
```

## TypeScript Casting
### Casting with `as`
### Casting with `<>`
***
## TypeScript Classes
either assign default value or make it optional `?`
### Members: Visibility
### Parameter Properties
### Readonly
similar to java `final` and JS `const` but `const` doesn't work in class.
variable is read-only not the literal.
### Inheritance: Implements
### Inheritance: Extends
### Abstract Classes
## TypeScript Basic Generics
declaration is after the name of the method or variable.
## TypeScript `Keyof`
literal as type
## TypeScript Null & Undefined
### Optional Chaining
regular dot `.`
wildcard dot `?.`
