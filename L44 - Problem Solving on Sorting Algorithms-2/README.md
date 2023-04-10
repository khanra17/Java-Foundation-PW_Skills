Fix swapped elements in the array
=======================================
Given an integer array where all its elements are sorted in increasing order except two swapped elements, sort it in linear time. Assume there are no duplicates in the array.

**Input: 3, 8, 6, 7, 5, 9, 10 <br>
Output: 3, 5, 6, 7, 8, 9, 10**

### Solution Code

```java
static void sortSwappedArray(int[] arr) {
    int length = arr.length;
    int first = -1;
    int second = -1;

    // Identify the two out-of-order elements
    for (int i = 1; i < length; i++) {
        if (arr[i - 1] > arr[i]) {
            if (first == -1) {
                first = i - 1;
            } else {
                second = i;
                break; // Found both elements, exit the loop
            }
        }
    }

    // Swap the elements if found
    if (first != -1 && second != -1) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
```

### Dry Run
Let's dry run the given code with an input array `[3, 8, 6, 7, 5, 9, 10]`.

| Iteration | State                  | Action                                                              |
|-----------|------------------------|---------------------------------------------------------------------|
| -         | [3, 8, 6, 7, 5, 9, 10] | Initialize length to 7, first to -1, and second to -1.              |
| 1         | [3, 8, 6, 7, 5, 9, 10] | Compare arr[0] (3) with arr[1] (8). Not swapped, do nothing.        |
| 2         | [3, 8, 6, 7, 5, 9, 10] | Compare arr[1] (8) with arr[2] (6). Swapped, set first to 1.        |
| 3         | [3, 8, 6, 7, 5, 9, 10] | Compare arr[2] (6) with arr[3] (7). Not swapped, do nothing.        |
| 4         | [3, 8, 6, 7, 5, 9, 10] | Compare arr[3] (7) with arr[4] (5). Swapped, set second to 4.       |
| 5         | [3, 8, 6, 7, 5, 9, 10] | Compare arr[4] (5) with arr[5] (9). Not swapped, do nothing.        |
| 6         | [3, 8, 6, 7, 5, 9, 10] | Compare arr[5] (9) with arr[6] (10). Not swapped, do nothing.       |
| -         | [3, 8, 6, 7, 5, 9, 10] | Both out-of-order elements identified as arr[1] (8) and arr[4] (5). |
| -         | [3, 5, 6, 7, 8, 9, 10] | Swap arr[1] (8) with arr[4] (5).                                    |

The final output after swapping the elements is [3, 5, 6, 7, 8, 9, 10].



Segregate negative and positives in the array
=======================================
Given an array of positive and negative integers, segregate them in linear time and in constant space. The output should print all negative integers first followed by all positive integers.

**Input: 19, -20, 7, 4, -13, 11, -5, 3 <br>
Output: -20, -4, -13, -5, 7, 11, 19, 3**

### Solution Code

```java
static void segregateArray(int[] arr) {
    int l = 0, r = arr.length - 1;
    while (l < r) {
        while (arr[l] < 0) l++;
        while (arr[r] >= 0) r--;
        if (l < r) {
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }
    }
}
```

### Dry Run
Let's dry run the given code with an input array `[19, -20, 7, 4, -13, 11, -5, 3]`.

| Iteration | State                           | Action                                                                                                                                                                       |
|-----------|---------------------------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| 0         | [19, -20, 7, 4, -13, 11, -5, 3] | Initial array                                                                                                                                                                |
| 1         | [-20, 19, 7, 4, -13, 11, -5, 3] | l is at index 1 and r is at index 6. arr[l] is negative, so l is incremented. arr[r] is positive, so r is decremented. Since l is still less than r, swap arr[l] and arr[r]. |
| 2         | [-20, -5, 7, 4, -13, 11, 19, 3] | l is at index 2 and r is at index 5. arr[l] is positive, so l is not incremented. arr[r] is positive, so r is decremented. Since l is not less than r, exit the loop.        |
| Final     | [-20, -5, -13, 4, 7, 11, 19, 3] | All negative integers are at the beginning of the array, followed by all positive integers.                                                                                  |
The final output after swapping the elements is [-20, -4, -13, -5, 7, 11, 19, 3].



Sort an array of 0s, 1s, and 2s
=======================================
Given an array of size N containing only 0s, 1s, and 2s, sort the array in ascending order.

**Input: N = 6; arr[] = 0, 2, 1, 2, 0, 0 <br>
Output: -20, -4, -13, -5, 7, 11, 19, 3**

### Solution Code

```java
static void sort012(int[] arr) {
    int low = 0, high = arr.length - 1, mid = 0;
    while (mid <= high) {
        switch (arr[mid]) {
            case 0 -> {
                int temp = arr[low];
                arr[low] = arr[mid];
                arr[mid] = temp;
                low++;
                mid++;
            }
            case 1 -> {
                mid++;
            }
            case 2 -> {
                int temp = arr[mid];
                arr[mid] = arr[high];
                arr[high] = temp;
                high--;
            }
        }
    }
}
```

### Dry Run
Let's dry run the given code with an input array `[0, 2, 1, 2, 0, 0]`.

| Iteration | State                   | Action                                                           |
|-----------|-------------------------|------------------------------------------------------------------|
| 0         | arr: [0, 2, 1, 2, 0, 0] | Initialize low=0, high=5, mid=0                                  |
| 1         | arr: [0, 2, 1, 2, 0, 0] | arr[mid] is 0, swap arr[low] and arr[mid], increment low and mid |
| 2         | arr: [0, 0, 1, 2, 2, 0] | arr[mid] is 0, swap arr[low] and arr[mid], increment low and mid |
| 3         | arr: [0, 0, 1, 2, 2, 0] | arr[mid] is 1, just increment mid                                |
| 4         | arr: [0, 0, 1, 2, 2, 0] | arr[mid] is 2, swap arr[mid] and arr[high], decrement high       |
| 5         | arr: [0, 0, 1, 0, 2, 2] | arr[mid] is 2, swap arr[mid] and arr[high], decrement high       |
| 6         | arr: [0, 0, 1, 0, 2, 2] | arr[mid] is 0, swap arr[low] and arr[mid], increment low and mid |
| 7         | arr: [0, 0, 0, 1, 2, 2] | mid is now greater than high, exit the while loop                |

The final sorted array is [0, 0, 0, 1, 2, 2].