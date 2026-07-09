### 7.11 Sorting Arrays
`pdf pg: 269`

[[array sorting practice in-class (java)]].

### Parallel sort

### partial sort
```java
        double[] dbl21  = {2.2,1.1,1.3,1.5,1.6,1.10};
        Arrays.sort(dbl21, 2, 4);
        System.out.println(Arrays.toString(dbl21));
```
### 7.12 The Arrays Class
#### Fill method
```java
        double[] dbl21  = {2.2,1.1,1.3,1.5,1.6,1.10};
        // Arrays.sort(dbl21, 2, 4);
        Arrays.fill(dbl21, 2, 4, 69.69);
        System.out.println(Arrays.toString(dbl21));
```

### 7.13 Command-Line Arguments
`public static void main(String[] args){ ... }` <- here `String[]` is data type and `args` is the name.

`Integer.parseInt(args[0])` <- convert to number.

# ch: 8 Multidimensional arrays
### Two dimensional array.
```java
        int[][] matrix = {
            // two dimensional array
            {1,2,3}
            {1,2,3}
            {1,2,3}
        };

        int[][][] matrix = {
            // three dimensional array
            {{1},{2},{3}}
            {{1},{2},{3}}
            {{1},{2},{3}}
        };
```

- read and write array
```java
        int[][] matrix = {
            // two dimensional array
            {1,2,3},
            {1,2,3},
            {1,2,3}
        };

        matrix[1][1] = 10; //write
        System.out.println(matrix[0][0]); //read
```

### 8.3 Processing Two-Dimensional Arrays


--- Chapter done---

# imp
-> https://drive.google.com/drive/folders/1DZX7kxaDqR4Uu4DgjrQ1bVo3Hut6hm66 
	-> https://drive.google.com/file/d/1G9gfPDW91kSe2mm5t9okk9jdWwi3_CsO/view
	-> https://drive.google.com/file/d/1Z-y_p9qtffEpfyXz8JhoGRZV7SpeDD9O/view
