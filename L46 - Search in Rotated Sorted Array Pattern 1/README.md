Find index of minimum element in rotated sorted array
=======================================
Given an rotated sorted array, find the index of the minimum element in the array. (Elements in the array are unique.)

**Input: `4, 5, 6, 7, 8, 9, 10, 11, 0, 1, 2, 3` <br>
Output: `8`**

## Solution
The given problem asks to find the index of the minimum element in a rotated sorted array. To solve this problem, we use the binary search algorithm. We initialize two pointers, left and right, to the start and end of the array, respectively. We find the middle index of the array, and we compare the middle element with the rightmost element of the array. If the middle element is less than the rightmost element, we discard the right half of the array and continue searching in the left half. Otherwise, we discard the left half of the array and continue searching in the right half. We repeat this process until we find the minimum element, which is the element for which the left and right pointers meet. We return the index of this minimum element.

### Solution Code
```java
public static int binarySearchMinimum(int[] arr) {
    int left = 0;
    int right = arr.length - 1;
    while (left < right) {
        int mid = left + (right - left) / 2;
        if (arr[mid] < arr[right]) {
            right = mid;
        } else {
            left = mid + 1;
        }
    }
    return left;
}
```

### Dry Run
Let's dry run the given code with an input array `[4, 5, 6, 7, 8, 9, 10, 11, 0, 1, 2, 3]`.

| Iteration | Left | Right | Mid | New Array                            | Explanation                                                                                                                       |
|-----------|------|-------|-----|--------------------------------------|-----------------------------------------------------------------------------------------------------------------------------------|
| 0         | -    | -     | -   | 4, 5, 6, 7, 8, 9, 10, 11, 0, 1, 2, 3 | The initial array is given.                                                                                                       |
| 1         | 4    | 9     | 8   | 9, 10, 11, 0, 1, 2, 3                | The middle index is 8. Since arr[8] < arr[9], the minimum value must be in the left half of the array.                            |
| 2         | 9    | 3     | 11  | 0, 1, 2, 3                           | The middle index is 11. Since arr[11] > arr[3], the minimum value must be in the right half of the array.                         |
| 3         | 0    | 1     | 1   | 0, 1                                 | The middle index is 1. Since arr[1] < arr[0], the minimum value must be in the left half of the array.                            |
| 4         | 0    | 0     | 0   | Ans = 0                              | The left and right endpoints of the array have converged to the same index, which is the index of the minimum value in the array. |



Find index of target element in rotated sorted array
=======================================
Given an rotated sorted array, find the index of the target element in the array. (Elements in the array are unique.)

**Input: `arr = [4, 5, 6, 7, 8, 9, 10, 11, 0, 1, 2, 3]`, `target = 2` <br>
Output: `10`**

## Solution
We cannot use the previous algorithm of searching the index of the minimum element in this case because the problem requires us to find the index of a given target element, not the minimum element. The algorithm for finding the minimum element assumes that the array is rotated at some unknown pivot point, and it works by comparing the middle element with the last element of the array to determine which half of the array to discard in each iteration. However, this algorithm does not tell us anything about the position of the target element in the array, so we cannot use it directly to solve this problem.

For example, consider the rotated sorted array arr = [7, 8, 9, 1, 2, 3, 4, 5, 6] and the target element target = 2. The previous algorithm would return the index 3, which is the index of the minimum element 1. However, this does not help us find the index of the target element 2, which is actually located at index 4.

Therefore, we need to use a different algorithm that takes into account both the rotation and the position of the target element in the array. The provided solution uses a modified binary search algorithm that can handle rotated arrays and find the index of the target element in O(log n) time.

We first identify if the left or right half of the array is sorted. Then, we check if the target element lies within the sorted half. If it does, we continue the binary search in that half. If not, we discard that half and continue the search in the other half.

### Solution Code
```java
public static int binarySearchTarget(int[] arr, int target) {
    int left = 0;
    int right = arr.length - 1;

    while (left <= right) {
        int mid = left + (right - left) / 2;

        if (arr[mid] == target) {
            return mid;
        }

        if (arr[left] <= arr[mid]) {
            // Left half is sorted
            if (arr[left] <= target && target < arr[mid]) {
                right = mid - 1; // Search left half
            } else {
                left = mid + 1; // Search right half
            }
        } else {
            // Right half is sorted
            if (arr[mid] < target && target <= arr[right]) {
                left = mid + 1; // Search right half
            } else {
                right = mid - 1; // Search left half
            }
        }
    }

    return -1; // Target not found
}
```

### Dry Run
Let's dry run the given code with an input array `[4, 5, 6, 7, 8, 9, 10, 11, 0, 1, 2, 3]`.
[//]: # (TODO: Add Dry Run)

Find index of target element in rotated sorted array with duplicates
=======================================
Given an rotated sorted array with duplicates, find if the target element is in the array.

**Input: `arr = [0, 0, 0, 1, 1, 1, 2, 0, 0, 0]`, `target = 2` <br>
Output: `true`**

## Solution
The code you provided earlier is for binary search in a non-duplicate rotated sorted array. In this solution, we again use binary search to search for the target element, but we only consider the scenario where the array is rotated, and there are no duplicates.

The solution follows the same approach as the solution for the rotated sorted array with duplicates. We start by defining two pointers, one pointing to the start of the array and the other pointing to the end of the array. We then use a while loop to search for the target element. In each iteration, we calculate the middle index of the array using the formula (left + right) / 2.

If the middle element is equal to the target element, we return the index of the middle element because we have found the element.

Next, we need to decide which part of the array to discard, either the left or the right, based on whether the left or right half is sorted. To do this, we check if the left element is less than or equal to the middle element. If this is true, the left half is sorted, and we can check if the target element is within the range of the left half. If the target element is within the range of the left half, we update the right pointer to mid - 1 and continue the loop. If not, we update the left pointer to mid + 1 and continue the loop.

On the other hand, if the left element is greater than the middle element, the right half is sorted, and we can check if the target element is within the range of the right half. If the target element is within the range of the right half, we update the left pointer to mid + 1 and continue the loop. If not, we update the right pointer to mid - 1 and continue the loop.

If the target element is not found in the array, we exit the loop and return -1.

In summary, the main difference between the two solutions is that the solution for the non-duplicate rotated sorted array does not consider the scenario where the array has duplicates. Otherwise, the solutions follow the same approach, where we use binary search to search for the target element and decide which part of the array to discard based on whether the left or right half is sorted.

### Solution Code
```java
public static boolean binarySearchTargetDuplicate(int[] arr, int target) {
    int left = 0;
    int right = arr.length - 1;

    while (left <= right) {
        int mid = left + (right - left) / 2;

        if (arr[mid] == target) {
            return true;
        } else if (arr[left] == arr[mid] && arr[mid] == arr[right]) {
            left++;
            right--;
        }

        if (arr[left] <= arr[mid]) {
            // Left half is sorted
            if (arr[left] <= target && target < arr[mid]) {
                right = mid - 1; // Search left half
            } else {
                left = mid + 1; // Search right half
            }
        } else {
            // Right half is sorted
            if (arr[mid] < target && target <= arr[right]) {
                left = mid + 1; // Search right half
            } else {
                right = mid - 1; // Search left half
            }
        }
    }

    return false; // Target not found
}
```

### Dry Run
[//]: # (TODO: Add Dry Run)