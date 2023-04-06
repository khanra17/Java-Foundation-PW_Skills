Merge Sort
=======================================
Merge sort is a divide-and-conquer sorting algorithm that sorts an array by breaking it down into smaller sub-arrays, sorting those sub-arrays, and then merging them back together in a sorted manner.

The algorithm consists of two main steps: dividing the array into sub-arrays, and then merging the sub-arrays back together.

### How it Works
The merge sort algorithm divides the array into halves until each sub-array has only one element. It then merges each pair of sub-arrays together in a sorted manner, resulting in sub-arrays that are twice the size. It continues to divide and merge the sub-arrays until the entire array is sorted.

Here is the code for merge sort in Java:

```java
static void mergeSort(int[] arr, int start, int end) {
    if (start >= end) return;
    int mid = (start + end) / 2;
    mergeSort(arr, start, mid);
    mergeSort(arr, mid + 1, end);
    merge(arr, start, mid, end);
}

static void merge(int[] arr, int start, int mid, int end) {
    int[] temp = new int[end - start + 1];
    int i = start;
    int j = mid + 1;
    int k = 0;
    while (i <= mid && j <= end) {
        if (arr[i] <= arr[j]) {
            temp[k++] = arr[i++];
        } else {
            temp[k++] = arr[j++];
        }
    }
    while (i <= mid) {
        temp[k++] = arr[i++];
    }
    while (j <= end) {
        temp[k++] = arr[j++];
    }
    System.arraycopy(temp, 0, arr, start, temp.length);
}
```
### Example
Let's take an example array `[4, 1, 3, 2, 7, 5]` and see how Merge Sort works on it:

| Step | arr                | start | mid | end | Action                                      |
|------|--------------------|-------|-----|-----|---------------------------------------------|
| 1    | [4, 1, 3, 2, 7, 5] | 0     | 2   | 5   | Call mergeSort(arr, 0, 5)                   |
| 2    | [4, 1, 3, 2, 7, 5] | 0     | 1   | 2   | Call mergeSort(arr, 0, 2)                   |
| 3    | [4, 1, 3, 2, 7, 5] | 0     | 0   | 1   | Call mergeSort(arr, 0, 1)                   |
| 4    | [4, 1, 3, 2, 7, 5] | 0     | -   | -   | return (base case)                          |
| 5    | [4, 1, 3, 2, 7, 5] | 1     | 1   | 2   | Call mergeSort(arr, 1, 2)                   |
| 6    | [4, 1, 3, 2, 7, 5] | 1     | -   | -   | return (base case)                          |
| 7    | [4, 1, 3, 2, 7, 5] | 0     | 1   | 2   | Call merge(arr, 0, 1, 2)                    |
| 8    | [1, 4, 3, 2, 7, 5] | 0     | 1   | 2   | Merge left=[4], right=[1,3] to temp=[1,4,3] |
| 9    | [1, 4, 3, 2, 7, 5] | 0     | -   | -   | Copy temp=[1,4,3] back to arr=[1,4,3,2,7,5] |
| 10   | [1, 4, 3, 2, 7, 5] | 3     | 4   | 5   | Call mergeSort(arr, 3, 5)                   |
| 11   | [1, 4, 3, 2, 7, 5] | 3     | 4   | 4   | Call mergeSort(arr, 3, 4)                   |
| 12   | [1, 4, 3, 2, 7, 5] | 3     | -   | -   | return (base case)                          |
| 13   | [1, 4, 3, 2, 7, 5] | 4     | 4   | 5   | Call mergeSort(arr, 4, 5)                   |
| 14   | [1, 4, 3, 2, 7, 5] | 4     | -   | -   | return (base case)                          |
| 15   | [1, 4, 3, 2, 7, 5] | 3     | 4   | 5   | Call merge(arr, 3, 4, 5)                    |
| 16   | [1, 4, 3, 2, 5, 7] | 3     | 4   | 5   | Merge left=[2,7], right=[5] to temp=[2,5,7] |
| 17   | [1, 4, 3, 2, 5, 7] | 3     | -   | -   | Copy temp=[2,5,7] back to arr=[1,4,3,2,5,7] |
| 18   | [1, 2, 3, 4, 5, 7] | 0     | 2   | 5   | Call merge(arr, 0, 2, 5)                    |
| 19   | [1, 2, 3, 4, 5, 7] | 0     | -   | -   | Done, arr is sorted                         |

The algorithm is now finished, and the array is sorted.


### Time & Space Complexity
The time complexity of Merge Sort is O(n log n) in the worst, average, and best case, where n is the number of elements in the array. 

The space complexity of Merge Sort is O(n) because it uses temporary arrays to merge the subarrays.

### Stability
Merge Sort is a stable sorting algorithm because it preserves the relative order of equal elements.

### Uses
Merge Sort is useful for sorting large arrays or linked lists because it has a consistent O(n log n) time complexity and can easily be parallelized. It is also used as a subroutine in other sorting algorithms, such as Timsort.