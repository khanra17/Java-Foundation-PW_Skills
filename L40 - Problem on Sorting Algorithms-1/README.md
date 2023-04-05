Moving all 0's to the end of an integer array
=======================================
Given an integer array arr, move all 0's to the end of it while maintaining the realative order of the non-zero
elements.

**Input: 0, 5, 0, 3, 4, 2 <br>
Output: 5, 3, 4, 2, 0, 0**

### Solution Code

```java
static void customBubbleSort(int[] arr) {
    int length = arr.length;

    for (int i = 0; i < length - 1; i++) {
        for (int j = 0; j < length - i - 1; j++) {
            if (arr[j] == 0) {
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
    }
}
```

### Dry Run

Let's dry run the given code with an input array `[0, 5, 0, 3, 4, 2]`.

| Iteration | State                | Action                                                                    |
|-----------|----------------------|---------------------------------------------------------------------------|
| 0         | `[0, 5, 0, 3, 4, 2]` | Original array                                                            |
| 1         | `[5, 0, 3, 4, 2, 0]` | Swap 0 and 5                                                              |
| 2         | `[5, 3, 4, 2, 0, 0]` | Swap 0 and 3                                                              |
| 3         | `[5, 3, 4, 2, 0, 0]` | No swap                                                                   |
| 4         | `[5, 3, 4, 2, 0, 0]` | No swap                                                                   |
| 5         | `[5, 3, 4, 2, 0, 0]` | No swap                                                                   |
| Final     | `[5, 3, 4, 2, 0, 0]` | Sorted array with 0's at the end, and non-zero elements in the same order |

Sorting an array of fruits in lexicographical order
=======================================
Given an array of names of fruits; you are supposed to sort it in lexicographical order using the selection sort

**Input: "papaya", "lime", "watermelon", "apple", "mango", "kiwi" <br>
Output: "apple", "kiwi", "lime", "mango", "papaya", "watermelon"**

### Solution Code

```java
static void customSelectionSort(String[] arr) {
    int length = arr.length;
    for (int i = 0; i < length - 1; i++) {
        int min_index = i;
        for (int j = i + 1; j < length; j++) {
            if (arr[j].compareTo(arr[min_index]) < 0) {
                min_index = j;
            }
        }
        if (min_index != i) {
            String temp = arr[i];
            arr[i] = arr[min_index];
            arr[min_index] = temp;
        }
    }
}
```

### Dry Run

Let's dry run the given code with an input array `["papaya", "lime", "watermelon", "apple", "mango", "kiwi"]`.

| Iteration | State                                                        | Action                                          |
|-----------|--------------------------------------------------------------|-------------------------------------------------|
| 0         | `["papaya", "lime", "watermelon", "apple", "mango", "kiwi"]` | Original array                                  |
| 1         | `["apple", "lime", "watermelon", "papaya", "mango", "kiwi"]` | Swap "apple" with "papaya" (minimum element)    |
| 2         | `["apple", "kiwi", "watermelon", "papaya", "mango", "lime"]` | Swap "kiwi" with "lime" (minimum element)       |
| 3         | `["apple", "kiwi", "lime", "papaya", "mango", "watermelon"]` | Swap "lime" with "watermelon" (minimum element) |
| 4         | `["apple", "kiwi", "lime", "mango", "papaya", "watermelon"]` | Swap "mango" with "papaya" (minimum element)    |
| 5         | `["apple", "kiwi", "lime", "mango", "papaya", "watermelon"]` | No swap                                         |
| Final     | `["apple", "kiwi", "lime", "mango", "papaya", "watermelon"]` | Sorted array in lexicographical order           |