### Gist of UML Generalization

**Generalization** is an **"is-a" relationship** between a more general class (parent/superclass) and a more specific class (child/subclass).

The key idea is:

> A specific thing is a type of a more general thing.

Example from the taxonomy:

* Cat is a kind of Mammal
* Mammal is a kind of Animal
* Animal is a kind of Living Thing
* Tiger is a kind of Cat

So:

**Tiger → Cat → Mammal → Animal → Living Thing**

Each lower-level class **inherits all the properties and relationships** of the higher-level class and can also have **additional features** of its own.

### In UML

Suppose:

* Vehicle (general class)
* Car (specific class)
* Motorcycle (specific class)

A **Car is a Vehicle** and a **Motorcycle is a Vehicle**.

Therefore:

* Car inherits all attributes and behaviors of Vehicle.
* Motorcycle inherits all attributes and behaviors of Vehicle.
* Car and Motorcycle may also have their own unique attributes.

### One-line exam answer

**Generalization is a hierarchical "is-a" relationship where a specialized class inherits all properties and relationships of a more general class and may add its own additional features.**
