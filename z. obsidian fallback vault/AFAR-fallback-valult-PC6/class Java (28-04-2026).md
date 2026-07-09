### 9.4 Constructing Objects Using Constructors
- constructor must not have a return type. not even `void`.

- class have constructor even if we didn't write it. it is hidden. in OOP default constructor is always hidden.

### 9.5 Accessing Objects via Reference Variables
An object’s data and methods can be accessed through the dot (.) operator via the 
object’s reference variable.

reference type

- everything is object except for primitive type.
### 9.5.2 Accessing an Object’s Data and Methods
- everything is object except for primitive type.
- 

### 9.5.3 Reference Data Fields and the null Value
- in empty field Java will put its default value
- only primitive data type default is 0. 
	- Boolean default is `false`.
	- all the others are `null`.

NullPointerException : this is a error type. this occurs if I put `.` after `null` like this `null.`

### 9.6 Using Classes from the Java Library

- 9.6.1 The Date Class
-  9.6.2 The Random Class


### 9.7 Static Variables, Constants, and Methods
access modifier.
modifier is a way of access.
- Static: owner is class.
without reference variable the owner is class.
- Static variable owner is `class`.

# Other
- in Java every variable must have a data type. `Student atiq = new Student()` <- this variable type is `Student` which is a class.
- function inside object is called method. Function stays outside of object.
- stack trace <- useful info for trouble shooting. starts with `at` in the error message.
- object that doesn't has reference variable is a anonymous object.