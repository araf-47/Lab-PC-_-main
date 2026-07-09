# CH :
- in primitive data type variable contains real value. but, array's variable only contains reference not the real value.

### Creating array
- array length is fixed.
- array default value is it's data typs default value. i.g. int -> 0, String -> null
- lowest array int is 0.
- arrays data type is `int`

```java
int num = 2;
int[] numA = {3, 5, 7};
numA[1] = 50;
System.out.println(Arrays.toString(numA));

int[] numA2 = new int[] {3, 5, 7, 9};
System.out.println(Arrays.toString(numA2));

int[] blankArr = new int[5];
System.out.println(Arrays.toString(blankArr));
```

### 7.2.3 Array Size and Default Values
- `[array_name].length()`.

### 7.2.5 Array Initializers
- `{}` <- this is a array initializer.

### 7.2.6 Processing Arrays
writing array.
```java
int[] forArr = new int[3];

for (int i = 0; i < forArr.length; i++){
	forArr[i] = (int) (Math.random() * 50);
}
System.out.println(Arrays.toString(forArr));
```

Reading arrays.
```java
int[] forArr = new int[3];
for (int i = 0; i < forArr.length; i++){
	forArr[i] = (int) (Math.random() * 50);
}
System.out.println(Arrays.toString(forArr));

// This is the part that sums them all up by reading the arrays.
int sum = 0;
for(int j = 0; j < forArr.length; j++){
	sum = sum + forArr[j];
}
System.out.println(sum);
```
### 7.2.7 Foreach Loops
```java
// this is the shortcut
for (int forArrGraber:forArr){
	System.out.println(forArrGraber);
}
```

### 7.5 Copying Arrays
longcut
```java
int[] copy = {4,6,8};
int[] paste = new int[3];
for (int i = 0; i < copy.length; i++){
	 paste[i] = copy[i];
}
System.out.println(Arrays.toString(paste));
```

Shortcut
```java
        int[] copy = {4,6,8};
        int[] paste = new int[3];
        // for (int i = 0; i < copy.length; i++){
        //     paste[i] = copy[i];
        // }
        // System.out.println(Arrays.toString(paste));
        System.arraycopy(copy, 0, paste, 0, 3);
        System.out.println(Arrays.toString(paste));
```

### 7.6 Passing Arrays to Methods

- if i work with reference then It is pass by sharing not pass by value.
	- It is not true for primitive data.

```java
        int[] abulF = {2,5,5};
        System.out.println(sum(abulF));

        int ar = 6;
        int af = 1;
        System.out.println(minus(ar, af));

    }
    
    public static int sum(int[] nums){
        int sum = 0;
        for(int num: nums){
            sum += num;
        }
        return sum;
    }

    public static int minus(int x, int y){
        int resultM = x - y;
        return resultM;
    }
```

### 7.7 Returning an Array from a Method
```java
    public static int[] sort(int[] numArr){
        Arrays.sort(numArr);
        return numArr;
    }
```
- This will always return array. because of this `int[]`.

```java
        int[] abulF = {2,10,5};
        // System.out.println(sum(abulF));
        System.out.println(Arrays.toString(sort(abulF)));

        int ar = 6;
        int af = 1;
        System.out.println(minus(ar, af));

    }
    
    public static int sum(int[] nums){
        int sum = 0;
        for(int num: nums){
            sum += num;
        }
        return sum;
    }

    public static int minus(int x, int y){
        int resultM = x - y;
        return resultM;
    }

    public static int[] sort(int[] numArr){
        Arrays.sort(numArr);
        return numArr;
    }
```

### spread operator
- it supports everything.
```java
    public static int max (int... nums) { // ... this is spread operator.
        int max = -1;
        for (int i: nums){
            if (i > max){
                max = i;
            }
        }
        return max;
    }
```

### 7.10 Searching Arrays
- Linear search
	- searches one by one through index.
```java
    public static int search(int[] ArrS, s) {

    }
```
- Binary search
	- pre condition is that the array has to be sorted.

# Code dump
```java
import java.lang.reflect.Array;
import java.util.Arrays;

public class arraysPlay {

    public static void main(String[] args) {
        // int num = 2;
        // int[] numA = {3, 5, 7};
        // numA[1] = 50;
        // System.out.println(Arrays.toString(numA));

        // int[] numA2 = new int[] {3, 5, 7, 9};
        // System.out.println(Arrays.toString(numA2));

        // int[] blankArr = new int[5];
        // System.out.println(Arrays.toString(blankArr));


        // int[] forArr = new int[3];
        // for (int i = 0; i < forArr.length; i++){
        //     forArr[i] = (int) (Math.random() * 50);
        // }
        // System.out.println(Arrays.toString(forArr));

        // // int[] forSum = new int[3];
        // int sum = 0;
        // for(int j = 0; j < forArr.length; j++){
        //     sum = sum + forArr[j];
        // }
        // System.out.println(sum);


        // for (int forArrGraber:forArr){
        //     System.out.println(forArrGraber);
        // }

        // int[] copy = {4,6,8};
        // int[] paste = new int[3];
        // // for (int i = 0; i < copy.length; i++){
        // //     paste[i] = copy[i];
        // // }
        // // System.out.println(Arrays.toString(paste));

        // System.arraycopy(copy, 0, paste, 0, 3);
        // System.out.println(Arrays.toString(paste));

        int[] abulF = {2,10,5};
        // System.out.println(sum(abulF));
        System.out.println(Arrays.toString(sort(abulF)));

        int ar = 6;
        int af = 1;
        System.out.println(minus(ar, af));

        int[] spreadArr = {5, 8, 9, 15};
        System.out.println(Arrays.toString(max(spreadArr)));

    }

    public static int search(int[] ArrS, s) {
        
    }
    
    public static int max (int... nums) {
        int max = -1;
        for (int i: nums){
            if (i > max){
                max = i;
            }
        }
        return max;
    }
    
    public static int sum(int[] nums){
        int sum = 0;
        for(int num: nums){
            sum += num;
        }
        return sum;
    }

    public static int minus(int x, int y){
        int resultM = x - y;
        return resultM;
    }

    public static int[] sort(int[] numArr){
        Arrays.sort(numArr);
        return numArr;
    }
    
}
```