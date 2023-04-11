Binary Search
=======================================
Binary search is a searching algorithm that works on sorted arrays. It repeatedly divides the search interval in half until the target value is found or the interval cannot be further divided.

Binary search is called "binary" because it divides the search interval in half at each step of the search. This means that the algorithm can quickly eliminate half of the remaining search space at each step, which makes it very efficient for searching large arrays. The name "binary" also distinguishes this algorithm from other searching algorithms that do not divide the search space in half, such as linear search.

### How it Works
In each iteration of the outer loop, the algorithm compares each pair of adjacent elements in the array.
If the pair is in the wrong order, the elements are swapped.
This process is repeated until the entire array is sorted.
The size of the sorted part of the array is increased by 1 in each iteration, because the largest element is guaranteed to be at the end of the array after each iteration.

Here is the code for binary search in Java:

```java
static int binarySearchRecursive(int[] arr, int target, int start, int end) {
    if (start > end) {
        return -1;
    }
    int mid = (start + end) / 2;
    if (arr[mid] == target) {
        return mid;
    }
    if (arr[mid] > target) {
        return binarySearchRecursive(arr, target, start, mid - 1);
    }
    return binarySearchRecursive(arr, target, mid + 1, end);
}

static int binarySearchIterative(int[] arr, int target) {
    int start = 0;
    int end = arr.length - 1;
    while (start <= end) {
        int mid = (start + end) / 2;
        if (arr[mid] == target) {
            return mid;
        }
        if (arr[mid] > target) {
            end = mid - 1;
        } else {
            start = mid + 1;
        }
    }
    return -1;
}
```

### Example
Let's take an example sorted array `[1, 2, 4, 5, 7]` and search for the element 5 using binary search (`binarySearchIterative`):

| Iteration | `start` | `end` | `mid` | Action taken                                                         |
|-----------|---------|-------|-------|----------------------------------------------------------------------|
| 1         | 0       | 7     | 3     | Compare `arr[3]` with `target`, `arr[3]` < `target`, set `start` = 4 |
| 2         | 4       | 7     | 5     | Compare `arr[5]` with `target`, `arr[5]` > `target`, set `end` = 4   |
| 3         | 4       | 4     | 4     | Compare `arr[4]` with `target`, `arr[4]` == `target`, return `4`     |

The algorithm is finished, and the element 5 is not found in the array. The algorithm can be modified to return the index of the element if found.

### Time & Space Complexity
The time complexity of binary search is O(log n) because the algorithm divides the search interval in half in each iteration, resulting in a significant reduction of the search space.

The space complexity is O(1) because the algorithm does not use any extra memory.

### Uses
Binary search can be used to quickly find a specific value in a sorted array. It is also useful in many other applications, such as finding the location of a specific element in a data structure like a tree or a graph. Additionally, binary search can be used to perform range queries, which involve finding all elements within a certain range in a sorted array.

### Limitations
Binary search requires that the input array is sorted in ascending or descending order. If the array is not sorted, binary search cannot be used.


Problems on Binary Search
=======================================

### Find the first occurrence of a given element x, given that the given array is sorted. If no occurrence is found, return -1.

**Input: arr = [1, 5, 5, 5, 6, 2, 4], x = 5 <br>
Output: 1**

### Explanation
We need to use a modified version of `binarySearchIterative` to find the index of the first occurrence of a target element in a sorted array. This modified version is called `firstOccurrence` and differs from the original implementation by storing the index of the first occurrence in a separate variable and discarding any other potential occurrences on the right side of the current index. This ensures that `firstOccurrence` returns the index of the first occurrence of the target element in the array, rather than any arbitrary occurrence. If the target element is not found in the array, `firstOccurrence` returns -1.

To modify the `binarySearchIterative` method to return the index of the first occurrence of a target element, we need to make two changes to the original implementation:

1. Instead of returning the current `mid` index when the target element is found, we need to store the index in a separate variable called `firstOccurrence`.
2. After storing the `mid` index in `firstOccurrence`, we need to discard any other potential occurrences of the target element on the right side of the current `mid` index. To do this, we set the `end` index to `mid - 1`.

These changes are implemented in the `firstOccurrence` method, which uses the modified binary search algorithm to return the index of the first occurrence of the target element in a sorted array.

### Solution Code
```java
static int firstOccurrence(int[] arr, int target) {
    int firstOccurrence = -1;
    int start = 0, end = arr.length - 1;
    while (start <= end) {
        int mid = (start + end) / 2;
        if (arr[mid] == target) {
            firstOccurrence = mid;
            end = mid - 1;
        }
        else if (arr[mid] > target) {
            end = mid - 1;
        } else {
            start = mid + 1;
        }
    }
    return firstOccurrence;
}
```

### Find the square root of the given non-negative value x. Round it off to the nearest floor integer value.

**Input: x = 4 <br>
Output: 2**

**Input: x = 11 <br>
Output: 3**

### Explanation
This code is implementing the binary search algorithm to find the square root of a non-negative integer x. The algorithm starts with a range of possible square roots from 0 to x and then iteratively narrows down the range by checking the middle point of the range. If the middle point is less than or equal to x divided by the middle point, then the algorithm updates the lower bound of the range to mid + 1 and records the current mid as the potential answer. Otherwise, the upper bound of the range is updated to mid - 1. This process continues until the lower bound is greater than the upper bound, at which point the potential answer is returned as the square root rounded down to the nearest integer.

### Solution Code
```java
static int sqrt(int x) {
    int ans = -1;
    int start = 0, end = x;
    while (start <= end) {
        int mid = start + (end - start) / 2;
        if (mid <= x / mid) {
            start = mid + 1;
            ans = mid;
        }
        else end = mid - 1;
    }
    return ans;
}
```






