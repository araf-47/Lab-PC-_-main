# Java 1D Arrays — Complete Master Guide

Arrays are one of the most important concepts in programming.

If loops are the engine,  
arrays are the storage boxes.

Together, loops + arrays build:

- games
    
- apps
    
- databases
    
- AI systems
    
- operating systems
    
- data structures
    
- algorithms
    

Master arrays deeply and programming becomes much easier.

---

# 1. What is an Array?

An array stores multiple values of the same type in one variable.

Without array:

```java
int n1 = 10;
int n2 = 20;
int n3 = 30;
```

This becomes messy.

Using array:

```java
int[] nums = {10, 20, 30};
```

Now all values are inside one structure.

---

# 2. Real-Life Analogy

Think of an apartment building.

```text
Room 0 → 10
Room 1 → 20
Room 2 → 30
```

The array is the building.

Each room is called an INDEX.

---

# 3. Important Array Rules

---

## Rule 1: Fixed Size

Array size cannot change after creation.

Example:

```java
int[] arr = new int[5];
```

Size is permanently 5.

---

## Rule 2: Same Data Type

All elements must be same type.

Correct:

```java
int[] arr = {1, 2, 3};
```

Wrong:

```java
int[] arr = {1, "hello", 3};
```

---

## Rule 3: Index Starts at 0

Very important.

```text
Index:   0   1   2
Value:  10  20  30
```

First element is index 0.

NOT 1.

---

# 4. Declaring an Array

Syntax:

```java
dataType[] arrayName;
```

Example:

```java
int[] nums;
```

This only declares the array reference.

No memory created yet.

---

# 5. Creating an Array

Syntax:

```java
arrayName = new dataType[size];
```

Example:

```java
nums = new int[5];
```

Now memory is created for 5 integers.

---

# 6. Declaration + Creation Together

```java
int[] nums = new int[5];
```

Most common style.

---

# 7. What Happens Internally

```java
int[] nums = new int[5];
```

Java creates:

```text
Index:   0  1  2  3  4
Value:   0  0  0  0  0
```

Default values for int arrays are 0.

---

# 8. Default Values

|Type|Default|
|---|---|
|int|0|
|double|0.0|
|boolean|false|
|char|'\u0000'|
|String|null|

Example:

```java
String[] names = new String[3];
```

```text
[null, null, null]
```

---

# 9. Initializing Values

Assign manually:

```java
int[] nums = new int[3];

nums[0] = 10;
nums[1] = 20;
nums[2] = 30;
```

---

# 10. Accessing Elements

Use index.

```java
System.out.println(nums[1]);
```

Output:

```text
20
```

---

# 11. Visual Representation

```text
Index:   0   1   2
Value:  10  20  30
```

```java
nums[0] → 10
nums[1] → 20
nums[2] → 30
```

---

# 12. Array Literal Syntax

Shortcut initialization:

```java
int[] nums = {10, 20, 30};
```

Java automatically:

- creates array
    
- assigns values
    

---

# 13. Printing Arrays Incorrectly

Wrong:

```java
System.out.println(nums);
```

Output:

```text
[I@36baf30c
```

Because array is an object reference.

---

# 14. Correct Way to Print Array

Using loop:

```java
for(int i = 0; i < nums.length; i++) {
    System.out.println(nums[i]);
}
```

---

# 15. Understanding `.length`

Very important.

```java
nums.length
```

Returns array size.

Example:

```java
int[] nums = {10, 20, 30};

System.out.println(nums.length);
```

Output:

```text
3
```

---

# 16. Why `.length` Matters

Wrong:

```java
for(int i = 0; i <= nums.length; i++)
```

This causes error.

Correct:

```java
for(int i = 0; i < nums.length; i++)
```

Because last valid index is:

## Mathematical Relation

\text{last index} = \text{length} - 1

---

# 17. ArrayIndexOutOfBoundsException

Most common beginner error.

Example:

```java
int[] arr = {10, 20, 30};

System.out.println(arr[3]);
```

Error:

```text
ArrayIndexOutOfBoundsException
```

Valid indices:

- 0
    
- 1
    
- 2

NOT 3.

---

# 18. Traversing an Array

Traversal means visiting every element.

```java
int[] nums = {5, 10, 15, 20};

for(int i = 0; i < nums.length; i++) {
    System.out.println(nums[i]);
}
```

---

# 19. Enhanced For Loop with Arrays

Cleaner syntax.

```java
int[] nums = {10, 20, 30};

for(int n : nums) {
    System.out.println(n);
}
```

---

# 20. Traditional vs Enhanced Loop

Traditional:

```java
for(int i = 0; i < nums.length; i++) {
    System.out.println(nums[i]);
}
```

Enhanced:

```java
for(int n : nums) {
    System.out.println(n);
}
```

---

# 21. When to Use Traditional Loop

Use traditional loop when:

- you need index
    
- you want reverse traversal
    
- modifying elements
    

---

# 22. When to Use Enhanced Loop

Use enhanced loop when:

- only reading values
    
- cleaner code needed
    

---

# 23. Taking Array Input

Using Scanner:

```java
Scanner sc = new Scanner(System.in);

int[] nums = new int[5];

for(int i = 0; i < nums.length; i++) {
    nums[i] = sc.nextInt();
}
```

---

# 24. Printing User Input Array

```java
for(int n : nums) {
    System.out.println(n);
}
```

---

# 25. Sum of Array Elements

```java
int[] nums = {10, 20, 30};

int sum = 0;

for(int n : nums) {
    sum += n;
}

System.out.println(sum);
```

Output:

```text
60
```

---

# 26. Average of Array

## Mathematical Formula

\text{average} = \frac{\text{sum}}{\text{number of elements}}

```java
int[] nums = {10, 20, 30};

int sum = 0;

for(int n : nums) {
    sum += n;
}

double avg = (double)sum / nums.length;

System.out.println(avg);
```

---

# 27. Finding Maximum Value

```java
int[] nums = {4, 8, 1, 9, 3};

int max = nums[0];

for(int i = 1; i < nums.length; i++) {

    if(nums[i] > max) {
        max = nums[i];
    }
}

System.out.println(max);
```

Output:

```text
9
```

---

# 28. Finding Minimum Value

```java
int min = nums[0];

for(int i = 1; i < nums.length; i++) {

    if(nums[i] < min) {
        min = nums[i];
    }
}
```

---

# 29. Searching in Array (Linear Search)

```java
int target = 20;
boolean found = false;

for(int n : nums) {

    if(n == target) {
        found = true;
        break;
    }
}

System.out.println(found);
```

---

# 30. Reverse Traversal

```java
for(int i = nums.length - 1; i >= 0; i--) {
    System.out.println(nums[i]);
}
```

---

# 31. Modifying Array Elements

```java
nums[1] = 100;
```

Arrays are mutable.

---

# 32. Swapping Elements

```java
int temp = nums[0];
nums[0] = nums[1];
nums[1] = temp;
```

Very important for sorting algorithms.

---

# 33. Reversing an Array

```java
int[] arr = {1, 2, 3, 4, 5};

int start = 0;
int end = arr.length - 1;

while(start < end) {

    int temp = arr[start];
    arr[start] = arr[end];
    arr[end] = temp;

    start++;
    end--;
}
```

---

# 34. Copying Arrays

Manual copy:

```java
int[] copy = new int[arr.length];

for(int i = 0; i < arr.length; i++) {
    copy[i] = arr[i];
}
```

---

# 35. Array Reference Concept

Very important.

```java
int[] a = {1,2,3};

int[] b = a;
```

Now BOTH point to same array.

Changing:

```java
b[0] = 100;
```

Also changes `a`.

---

# 36. Memory Visualization

```text
a ──┐
    ├──> [100,2,3]
b ──┘
```

---

# 37. Comparing Arrays

Wrong:

```java
a == b
```

Checks reference, NOT contents.

Use:

```java
Arrays.equals(a, b)
```

Need import:

```java
import java.util.Arrays;
```

---

# 38. Sorting Arrays

Using built-in sort:

```java
Arrays.sort(nums);
```

Example:

```java
int[] nums = {4,1,3,2};

Arrays.sort(nums);
```

Result:

```text
[1,2,3,4]
```

---

# 39. Printing Arrays Easily

```java
System.out.println(Arrays.toString(nums));
```

Example output:

```text
[1, 2, 3, 4]
```

---

# 40. Importing Arrays Utility

```java
import java.util.Arrays;
```

---

# 41. Common Mistakes

---

## Mistake 1: Wrong Index

```java
arr[arr.length]
```

Wrong.

Correct:

```java
arr[arr.length - 1]
```

---

## Mistake 2: Forgetting Initialization

```java
int[] arr;

arr[0] = 10;
```

NullPointerException.

---

## Mistake 3: Using Wrong Loop Condition

Wrong:

```java
i <= arr.length
```

Correct:

```java
i < arr.length
```

---

# 42. Arrays and Time Complexity

---

## Access by Index

```java
arr[5]
```

Complexity:

```text
O(1)
```

Very fast.

---

## Searching

Linear search:

```text
O(n)
```

---

## Traversal

```text
O(n)
```

---

# 43. Arrays Are Contiguous Memory

Internally:

```text
[10][20][30][40]
```

Stored continuously in memory.

This makes arrays fast.

---

# 44. Limitations of Arrays

---

## Fixed Size

Cannot grow dynamically.

---

## Insertion Costly

Middle insertion requires shifting.

---

## Deletion Costly

Elements shift left.

---

# 45. Real-Life Uses of Arrays

Arrays are used in:

- image processing
    
- game boards
    
- matrices
    
- databases
    
- AI tensors
    
- sorting algorithms
    
- searching algorithms
    

---

# 46. Dry Run Example

```java
int[] nums = {2,4,6};

for(int i = 0; i < nums.length; i++) {
    System.out.println(nums[i]);
}
```

Trace:

|i|nums[i]|
|---|---|
|0|2|
|1|4|
|2|6|

---

# 47. Important Mental Models

---

## Array = Indexed Storage

```text
index → value
```

---

## Loop + Array = Powerful Combination

Loops traverse arrays.

Arrays store data.

Together they solve most beginner problems.

---

# 48. Beginner Practice Problems

---

## Easy

- print array
    
- sum array
    
- average
    
- find max/min
    

---

## Medium

- reverse array
    
- count even/odd
    
- search element
    
- copy array
    

---

## Harder

- rotate array
    
- remove duplicates
    
- merge arrays
    
- sorting
    

---

# 49. Interview-Level Problems

Important:

- linear search
    
- binary search
    
- bubble sort
    
- selection sort
    
- insertion sort
    
- Kadane’s algorithm
    
- two-sum problem
    

All rely heavily on arrays.

---

# 50. Final Master Summary

You now know:

✅ what arrays are  
✅ indexing  
✅ declaration  
✅ creation  
✅ initialization  
✅ traversal  
✅ `.length`  
✅ enhanced loop  
✅ searching  
✅ max/min  
✅ reversing  
✅ copying  
✅ sorting  
✅ array references  
✅ time complexity  
✅ common mistakes

This is the complete foundation of Java 1D arrays.

---

# Golden Advice

To truly master arrays:

Do this repeatedly:

1. create arrays
    
2. dry run on paper
    
3. trace indices
    
4. predict outputs
    
5. solve problems
    

Arrays become easy only through repetition.

---

# 15 Powerful Practice Problems

1. Find largest element
    
2. Find second largest
    
3. Reverse array
    
4. Count even/odd
    
5. Search element
    
6. Remove duplicates
    
7. Rotate array
    
8. Merge arrays
    
9. Check palindrome array
    
10. Sort ascending
    
11. Sort descending
    
12. Find missing number
    
13. Move zeros to end
    
14. Find duplicate element
    
15. Binary search
