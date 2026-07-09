https://www.geeksforgeeks.org/java/arraylist-in-java/
***
ArrayList in Java is a resizable array provided in the [java.util package](https://www.geeksforgeeks.org/java/java-util-package-java/). Unlike normal [arrays](https://www.geeksforgeeks.org/java/arrays-in-java/), its size can grow or shrink dynamically as elements are added or removed.

- Elements can be accessed using their indices, similar to arrays.
- Duplicates are allowed.
- Elements are stored in the order they are inserted.
- ArrayList is not thread-safe. To make it thread-safe, we must wrap it manually using [Collections.synchronizedList()](https://www.geeksforgeeks.org/java/collections-synchronizedlist-method-in-java-with-examples/).
***
****Note:**** ArrayList cannot hold primitive types like int, double, or char directly. we must use their wrapper classes instead:
- Use Integer instead of int
- Use Double instead of double
- Use Character instead of char
***
