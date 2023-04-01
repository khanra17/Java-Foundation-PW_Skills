Bubble Sort
=======================================
Bubble sort is another simple sorting algorithm that works by repeatedly swapping adjacent elements if they are in the wrong order. This process is repeated until the entire array is sorted.

The algorithm is called bubble sort because larger elements "bubble" to the top of the array in each iteration.

### How it Works
In each iteration of the outer loop, the algorithm compares each pair of adjacent elements in the array.
If the pair is in the wrong order, the elements are swapped.
This process is repeated until the entire array is sorted.
The size of the sorted part of the array is increased by 1 in each iteration, because the largest element is guaranteed to be at the end of the array after each iteration.

Here is the code for bubble sort in Java:

```java
public static void bubbleSort(int[] arr) {
    int n = arr.length;
    for (int i = 0; i < n - 1; i++) {
        for (int j = 0; j < n - i - 1; j++) {
            if (arr[j] > arr[j+1]) {
                int temp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = temp;
            }
        }
    }
}
```

### Example
Let's take an example array `[7, 5, 4, 2, 1]` and see how bubble sort works on it:

| Iteration | Array           | Action                                     | Result          |
|-----------|-----------------|--------------------------------------------|-----------------|
| 1         | [7, 5, 4, 2, 1] | Compare adjacent elements, swap if needed  | [5, 4, 2, 1, 7] |
| 2         | [5, 4, 2, 1, 7] | Compare adjacent elements, swap if needed  | [4, 2, 1, 5, 7] |
| 3         | [4, 2, 1, 5, 7] | Compare adjacent elements, swap if needed  | [2, 1, 4, 5, 7] |
| 4         | [2, 1, 4, 5, 7] | Compare adjacent elements, swap if needed  | [1, 2, 4, 5, 7] |
| 5         | [1, 2, 4, 5, 7] | Compare adjacent elements, no swaps needed | [1, 2, 4, 5, 7] |

The algorithm is now finished, and the array is sorted in ascending order.


### Optimization
An optimization can be made to bubble sort by adding a flag variable to check if any swaps were made in an iteration. If no swaps were made, then the list is already sorted and the algorithm can exit early. This optimization reduces the number of unnecessary iterations and improves the performance of bubble sort.
```java
public static void bubbleSort(int[] arr) {
    int length = arr.length;
    boolean swaped = false;

    for (int i = 0; i < length - 1; i++) {
        for (int j = 0; j < length - i - 1; j++) {
            if (arr[j] > arr[j + 1]) {
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
                swaped = true;
            }
        }
        if (!swaped) {
            break;
        }
    }
}
```

### Time & Space Complexity
For the optimized code, the time complexity is still O(n^2) in the worst case and average case because the algorithm still needs to compare every pair of elements in the array. However, in the best case, when the input array is already sorted, the time complexity becomes O(n) because the algorithm only needs to make one pass through the array to confirm that it is sorted.

The space complexity is O(1) because the algorithm sorts the array in place, without using any extra memory.

### Stability
Bubble sort is a stable sorting algorithm because it preserves the relative order of equal elements.

### Uses
Bubble sort can be useful when the input array is almost sorted or has only a few inversions, meaning that there are only a few pairs of elements that are in the wrong order. In this case, bubble sort can have a better performance than other sorting algorithms because it only swaps adjacent elements.