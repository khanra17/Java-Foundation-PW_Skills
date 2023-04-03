Selection Sort
=======================================
Selection sort is a simple sorting algorithm that works by repeatedly finding the minimum element from the unsorted part of the array and placing it at the beginning of the sorted part. This process is repeated until the entire array is sorted.

The algorithm is called selection sort because it selects the smallest element and places it at the beginning of the array in each iteration.

### How it Works
The array is divided into two parts: sorted and unsorted.
In each iteration of the outer loop, the smallest element from the unsorted part is selected.
The selected element is swapped with the leftmost element in the unsorted part, which becomes part of the sorted part.
The size of the unsorted part is reduced by 1.
Steps 2-4 are repeated until the entire array is sorted.

Here is the code for selection sort:
```java
public static void selectionSort(int[] arr) {
    int n = arr.length;
    for (int i = 0; i < n; i++) {
        int minIdx = i;
        for (int j = i + 1; j < n; j++) {
            if (arr[j] < arr[minIdx]) {
                minIdx = j;
            }
        }
        if (minIdx != i) {
            int temp = arr[i];
            arr[i] = arr[minIdx];
            arr[minIdx] = temp;
        }
    }
}
```
### Example
Let's take an example array `[7, 5, 4, 2, 1]` and see how selection sort works on it:

| Iteration | Array           | Action                                                                                  | Result          |
|-----------|-----------------|-----------------------------------------------------------------------------------------|-----------------|
| 1         | [7, 5, 4, 2, 1] | Select the smallest element (1) and swap with the first element                         | [1, 5, 4, 2, 7] |
| 2         | [1, 5, 4, 2, 7] | Select the smallest element (2) from the unsorted part and swap with the second element | [1, 2, 4, 5, 7] |
| 3         | [1, 2, 4, 5, 7] | Select the smallest element (4) from the unsorted part and swap with the third element  | [1, 2, 4, 5, 7] |
| 4         | [1, 2, 4, 5, 7] | Select the smallest element (5) from the unsorted part and swap with the fourth element | [1, 2, 4, 5, 7] |
| 5         | [1, 2, 4, 5, 7] | Select the smallest element (7) from the unsorted part, no swap needed                  | [1, 2, 4, 5, 7] |

The algorithm is now finished, and the array is sorted in ascending order.


### Time & Space Complexity
The time complexity of selection sort is O(n^2) in the worst case, average case, and best case.

The space complexity is O(1) because the algorithm sorts the array in place, without using any extra memory.

### Stability
Selection sort is not a stable sorting algorithm because it does not preserve the relative order of equal elements.

### Uses
Selection sort can be useful when the input array is large but the number of swaps needed to sort it is small. This is because selection sort only makes O(n) swaps, whereas other sorting algorithms make O(n log n) swaps. Selection sort can also be useful when memory usage is a concern because it only requires a constant amount of extra memory.