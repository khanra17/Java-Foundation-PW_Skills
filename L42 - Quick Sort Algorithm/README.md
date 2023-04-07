Quick Sort
=======================================
Quick sort is a divide-and-conquer sorting algorithm that sorts an array by partitioning it into two sub-arrays, according to a pivot element, and recursively sorting each sub-array.

Quick sort is called so because it sorts the elements of an array quickly, making it one of the most efficient sorting algorithms.

### How it Works
The quick sort algorithm selects a pivot element from the array and partitions the array into two sub-arrays: elements less than or equal to the pivot, and elements greater than the pivot. It then recursively sorts each sub-array by selecting a new pivot and partitioning again until the sub-arrays have only one element.

Here is the code for quick sort in Java:

```java
static void quickSort(int[] arr, int low, int high) {
    if (low < high) {
        int pi = partition(arr, low, high);
        quickSort(arr, low, pi - 1);
        quickSort(arr, pi + 1, high);
    }
}

static int partition(int[] arr, int low, int high) {
    int pivot = arr[high];
    int i = low - 1;
    for (int j = low; j < high; j++) {
        if (arr[j] < pivot) {
            i++;
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
    int temp = arr[i + 1];
    arr[i + 1] = arr[high];
    arr[high] = temp;
    return i + 1;
}
```
### Example
Let's take an example array [4, 1, 3, 2, 7, 5] and see how Quick Sort works on it:

| Step | Array              | Pivot | Left         | Right        | Action                               |
|------|--------------------|-------|--------------|--------------|--------------------------------------|
| 1    | [4, 1, 3, 2, 7, 5] | 5     | []           | []           | Call quickSort(arr, 0, 5)            |
| 2    | [4, 1, 3, 2, 7, 5] | 5     | [4]          | [1, 3, 2, 7] | Partition around 5, set pivotIndex=1 |
| 3    | [1, 4, 3, 2, 7, 5] | 5     | [1, 4, 3, 2] | [7]          | Partition around 7, set pivotIndex=4 |
| 4    | [1, 4, 3, 2, 5, 7] | 5     | [1, 4, 3, 2] | []           | Call quickSort(arr, 0, 3)            |
| 5    | [1, 4, 3, 2, 5, 7] | 2     | [1]          | [4, 3]       | Partition around 2, set pivotIndex=1 |
| 6    | [1, 2, 3, 4, 5, 7] | 2     | [1, 2]       | [4, 3]       | Partition around 3, set pivotIndex=2 |
| 7    | [1, 2, 3, 4, 5, 7] | -     | [1, 2, 3]    | [4, 5, 7]    | Call quickSort(arr, 0, 2)            |
| 8    | [1, 2, 3, 4, 5, 7] | -     | [4, 5, 7]    | []           | Call quickSort(arr, 3, 5)            |
| 9    | [1, 2, 3, 4, 5, 7] | -     | []           | []           | Done                                 |

The algorithm is now finished, and the array is sorted.

### Time & Space Complexity
The time complexity of Quick Sort is O(n log n) in the average case and O(n^2) in the worst case, where n is the number of elements in the array.

The space complexity of Quick Sort is O(log n) in the best case and O(n) in the worst case, due to the recursive call stack.

### Stability
Quick Sort is not a stable sorting algorithm, as the relative order of equal elements may change during the sorting process.

### Uses
Quick Sort is a widely used sorting algorithm due to its average case time complexity of O(n log n), making it efficient for large datasets. It is also used as a subroutine in other sorting algorithms such as introsort. In addition, Quick Sort is often preferred over Merge Sort in practice because of its in-place partitioning and cache-friendly memory usage.