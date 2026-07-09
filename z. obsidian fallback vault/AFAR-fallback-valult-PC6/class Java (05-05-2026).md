### 13.5 Interfaces
- store abstract method.
- it is a construct.
- all variables are public and final.
- interface inheritance => `implement` keyword.
	- must override abstract methods of the interface.
		- abstract methods doesn't have body. So we must override it in the child class (inheritance).
- omits modifier. (by default all are `public static final`)
- in front of method by default it has `public abstract`.

### 13.6 The Comparable Interface
compare two objects.
`compareTo` <- java default interface.
`comparable` <- interface 

### 13.7 The Cloneable Interface
#### marker interface
doesn't have any abstract method. doesn't actually has anything inside of it.
- helpful for making annotation.
- `@override` - this is a marker interface.

### 13.8 Interfaces vs. Abstract Classes
this is important for inter

| interface                  | abstract                   |
| -------------------------- | -------------------------- |
| public static final        |                            |
|                            | must write public abstract |
| it's not actually a class. |                            |
| multiple inheritance       | single inheritance         |

interface to interface `extend` is possible. they are then called sub-interface (for the child/subclass like abstract.) 

is-a relationship -> strong relationship .  (*most common*)
is-kind-of relationship -> class to interface -> weak relationship 

**naming convention**: Class names are nouns. Interface names may be adjectives or nouns.

### 13.10.1 Cohesion
single file single purpose.
### 13.10.2 Consistency
naming conventions
naming consistency
no-arg constructor
### 13.10.4 Clarity
easy to explain
independent methods
intuitive meaning
independent properties
### 13.10.6 Instance vs. Static



# learn them 
- what is `has-a` and `is-a` relationship.
- constructor work anywhere in the code, first or last.