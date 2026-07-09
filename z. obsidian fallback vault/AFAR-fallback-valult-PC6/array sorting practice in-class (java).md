```java
public class sortArr {
    public static void main(String[] args) {
        int[] arr = {1, 4, 2, 3};

        // --- Selection Sort Logic ---
        for (int i = 0; i < arr.length - 1; i++) {
            // Assume the first index is the minimum
            int minIndex = i;

            // Search the rest of the array for a smaller value
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j; // Found a new minimum, update index
                }
            }

            // Swap if a new minimum was found
            if (minIndex != i) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }

        // --- Printing the Result ---
        System.out.print("Sorted array: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
```

### Explanation 1
Let’s strip away the technical jargon. Imagine you are a teacher, and you have a row of students with random heights. You want to line them up from shortest to tallest.

Here is how you do it, exactly like the code:

### The "Lineup" Analogy

1. **Start at the front:** You look at the very first student. You want to find the shortest student in the _entire group_ to put in this first spot.
    
2. **The "Search":** You walk down the line, looking at everyone. You keep the shortest person you've seen so far in your mind.
    
3. **The "Swap":** Once you've checked everyone, you take that shortest person and swap places with the person who was originally at the front.
    
4. **Move to the next spot:** Now the first person is definitely in the right spot! You ignore them and move to the second student in line. You repeat the process: find the shortest person among the _remaining_ students and swap them into the second spot.
    

---

### Understanding the Code (Simplified)

Here is your code again, but let's read it like a story:


```java
int[] arr = {1, 4, 2, 3};

// "i" is just the spot we are trying to fill right now (0, 1, 2, etc.)
for (int i = 0; i < arr.length - 1; i++) {
    
    // We assume the person currently in spot "i" is the shortest (min)
    int minIndex = i;

    // "j" is our helper who walks down the rest of the line to check everyone
    for (int j = i + 1; j < arr.length; j++) {
        // If the helper finds someone shorter than our current min...
        if (arr[j] < arr[minIndex]) {
            // ...that person is the new "shortest"
            minIndex = j; 
        }
    }

    // After the helper finishes, we swap the shortest person into our spot "i"
    int temp = arr[i];
    arr[i] = arr[minIndex];
    arr[minIndex] = temp;
}
```

### Why do we need `temp`?

This is the most common question beginners ask. Think of it like this:

- You have two cups of liquid: **Red** (at `arr[i]`) and **Blue** (at `arr[minIndex]`).
    
- If you just pour Red into the Blue cup, you lose the Blue liquid forever!
    
- You need an empty **third cup** (`temp`) to hold the Red liquid while you move the Blue liquid.
    
- Then, you pour the Red liquid from the `temp` cup into the now-empty Blue spot.
    

**The Swap in 3 steps:**

1. **`int temp = arr[i];`** (Save the value at `arr[i]` into the extra cup).
    
2. **`arr[i] = arr[minIndex];`** (Move the small value into the first spot).
    
3. **`arr[minIndex] = temp;`** (Put the saved value into the spot where the small value used to be).
    

Does this mental model of the "extra cup" and the "lineup" make the process feel a bit clearer?
