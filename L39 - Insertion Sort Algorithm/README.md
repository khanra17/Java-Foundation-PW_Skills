Insertion Sort
=======================================
Insertion sort is a simple sorting algorithm that works by building a sorted array one element at a time. The algorithm has two parts: the sorted part and the unsorted part. The sorted part initially consists of the first element of the array, while the unsorted part consists of the remaining elements.

Insertion sort is called "insertion" because it inserts each element into the correct position in the sorted array.

### How it Works
In each iteration of the algorithm, it picks the first element from the unsorted part and inserts it into the correct position in the sorted part. To insert the element, the algorithm compares it with each element in the sorted part, starting from the end of the sorted part, until it finds the correct position.

Here is the code for insertion sort in Java:

```java
public static void insertionSort(int[] arr) {
    int n = arr.length;
    for (int i = 1; i < n; ++i) {
        int key = arr[i];
        int j = i - 1;

        while (j >= 0 && arr[j] > key) {
            arr[j + 1] = arr[j];
            j = j - 1;
        }
        arr[j + 1] = key;
    }
}
```
### Example
Let's take an example array `[7, 5, 4, 2, 1]` and see how insertion sort works on it:

| Iteration | Sorted Part  | Unsorted Part | Action                                                     | Result          |
|-----------|--------------|---------------|------------------------------------------------------------|-----------------|
| 1         | [7]          | [5, 4, 2, 1]  | Pick 5 from unsorted part and insert into correct position | [5, 7, 4, 2, 1] |
| 2         | [5, 7]       | [4, 2, 1]     | Pick 4 from unsorted part and insert into correct position | [4, 5, 7, 2, 1] |
| 3         | [4, 5, 7]    | [2, 1]        | Pick 2 from unsorted part and insert into correct position | [2, 4, 5, 7, 1] |
| 4         | [2, 4, 5, 7] | [1]           | Pick 1 from unsorted part and insert into correct position | [1, 2, 4, 5, 7] |

The algorithm is now finished, and the array is sorted.


### Time & Space Complexity
The time complexity of insertion sort is O(n^2) in the worst case and average case, where n is the number of elements in the array. In the best case, when the array is already sorted, the time complexity is O(n), which is the best possible time complexity for a comparison-based sorting algorithm.

The space complexity of insertion sort is O(1) because the algorithm sorts the array in place, without using any extra memory.

### Stability
Insertion sort is a stable sorting algorithm because it preserves the relative order of equal elements.

### Uses
Insertion sort is useful for sorting small arrays or partially sorted arrays because it has a low overhead and runs quickly on small inputs.