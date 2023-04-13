Search in 2d matrix
=======================================
Search the 'target' value in a 2d integer matrix of dimensions n x m and return true if found, else return false.</br>
This syntax has the following properties:

1. Integers in each row are sorted from left to right.
2. The first integer if each row is greater than the last integer of the previous row.

**Input: `Matrix = [[1,35,7],[10,11,16,20],[23,30,34,60]]`, `target = 3` <br>
Output: `true`**

## Solution

The implementation first searches for the row that could potentially contain the target by comparing the target with the
first and last elements of each row using binary search. If the target is within the range of a row, it then searches
for the column within that row by comparing the target with the middle element of each column using binary search.

If the target is found, the method returns the index of the target as a one-dimensional index where the row index is
multiplied by the number of columns and added to the column index. If the target is not found, the method returns -1.

### Solution Code

```java
public static boolean binarySearchMatrix(int[][] mtr, int target) {
    int rows = mtr.length;
    int columns = mtr[0].length;
    int left = 0;
    int right = rows - 1;

    // Search for the row
    while (left <= right) {
        int mid = left + (right - left) / 2;
        if (mtr[mid][0] <= target && target <= mtr[mid][columns - 1]) {
            // Found the row that could potentially contain the target
            int colLeft = 0;
            int colRight = columns - 1;

            // Search for the column within the row
            while (colLeft <= colRight) {
                int colMid = colLeft + (colRight - colLeft) / 2;
                if (mtr[mid][colMid] == target) {
                    return true;
                } else if (mtr[mid][colMid] < target) {
                    colLeft = colMid + 1;
                } else {
                    colRight = colMid - 1;
                }
            }
            // Target not found in the row
            return false;
        } else if (mtr[mid][0] > target) {
            right = mid - 1;
        } else {
            left = mid + 1;
        }
    }
    // Target not found in the matrix
    return false;
}
```

### Alternate Solution

The implementation first checks if the input matrix is null or empty. Then it initializes the start and end indices of
the binary search range as 0 and the total number of elements in the matrix minus 1, respectively. Inside the binary
search loop, it calculates the mid index and converts it to the corresponding row and column indices in the matrix using
integer division and modulo operations.

If the target is found at the mid index, the method returns true. If the target is less than the value at the mid index,
the method updates the end index to mid - 1 to search in the lower half of the range. Otherwise, the method updates the
start index to mid + 1 to search in the upper half of the range. If the target is not found in the loop, the method
returns false.

Overall, this implementation has a time complexity of O(log(mn)) where m and n are the number of rows and columns in the
matrix, respectively, since it performs a binary search on a one-dimensional array of size mn.

### Alternate Solution Code

```java
public static boolean binarySearchMatrixAs1D(int[][] mtr, int target) {
    int rows = mtr.length;
    int columns = mtr[0].length;
    int left = 0;
    int right = (rows * columns) - 1;

    // Binary search for the target
    while (left <= right) {
        int mid = left + (right - left) / 2;
        int row = mid / columns;
        int col = mid % columns;
        int midVal = mtr[row][col];
        if (midVal == target) {
            return true;
        } else if (midVal < target) {
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }
    // Target not found in the matrix
    return false;
}
```

### Which One to Use?

The first function, `binarySearchMatrix`, first performs a binary search on the rows to locate the row that may contain the target value. Then, it performs a binary search on that row to find the target. It has a time complexity of `O(log(rows) + log(columns))`.

The second function, `binarySearchMatrixAs1D`, uses binary search on a flattened 2D matrix represented as a 1D array. It has a time complexity of `O(log(rows*columns))`.

In general, if the number of columns in the matrix is much larger than the number of rows, the second function may be faster. However, if the number of rows is much larger than the number of columns, the first function may be faster.

It's worth noting that the first function is more memory-efficient, as it does not require a flattened representation of the matrix. However, this may not be a significant factor depending on the size of the matrix.


Search in 2d matrix (Diagonal Search)
=======================================
Search the 'target' value in a 2d integer matrix of dimensions n x m and return true if found, else return false.</br>
This syntax has the following properties:

1. Integers in each row are sorted from left to right.
2. Integers in each column are sorted from top to bottom.
3. The first integer if each row may be sorter than the last integer of the previous row.

**Input: `Matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]]`, `target = 5` <br>
Output: `true`**

## Solution
To solve this problem, we can start from the top right corner of the matrix and traverse it diagonally towards the
bottom left corner while comparing the elements with the target value. We can use the sorted nature of the rows and
columns to eliminate certain portions of the matrix during our search.

Initialize row pointer i to 0 and column pointer j to the last column of the matrix.
While i is less than the number of rows and j is greater than or equal to 0:
a. If the target value is equal to the current element in the matrix at position (i, j), return true.
b. If the target value is less than the current element, decrement j.
c. If the target value is greater than the current element, increment i.
If the target value is not found after traversing the entire diagonal, return false.

The time complexity of this solution is O(m+n), where m is the number of rows and n is the number of columns in the matrix. This is because in the worst case, we may traverse all the rows and columns of the matrix.

### Solution Code
```java
public boolean searchIn2DMatrixDiagonal(int[][] matrix, int target) {
    if (matrix == null || matrix.length == 0) {
        return false;
    }
    
    int rows = matrix.length;
    int cols = matrix[0].length;
    
    int i = 0;  // starting from top right corner
    int j = cols - 1;
    
    while (i < rows && j >= 0) {
        if (matrix[i][j] == target) {
            return true;
        } else if (matrix[i][j] < target) {
            i++;  // target can only be in the lower rows
        } else {
            j--;  // target can only be in the left columns
        }
    }
    
    return false;  // target not found in matrix
}
```

Find peak index of mountain array
=======================================
Given a mountain array `a` of length greater than 3, return the index `i` such that `arr[0] < arr[1] < ... < arr[i-1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1]`. This index is known as the peak index.

**Input: `a = [0, 4, 1, 0]` <br>
Output: `1`**

## Solution
This solution implements binary search to find the peak index in a mountain array. The algorithm divides the search range in half and checks if the middle element is greater than its neighbor to the right. If it is, then the peak must be on the left half of the search range. If it's not, then the peak must be on the right half of the search range. The search continues until the peak index is found. The initial value of `ans` is set to 1 because the problem statement guarantees that the array has a peak, so the peak index cannot be the first or last element.

### Solution Code
```java
public static int peakIndexInMountainArray(int[] arr) {
    int start = 0, end = arr.length - 1;
    int ans = 1;
    while (start <= end) {
        int mid = start + (end - start) / 2;
        if (arr[mid] > arr[mid + 1]) {
            ans = mid;
            end = mid - 1;
        } else {
            start = mid + 1;
        }
    }
    return ans;
}
```


Find peak element
=======================================
Given an array nums of integers, find a peak element in it. A peak element is an element that is greater than its neighbors.

**Input: `[1,2,3,1]` <br>
Output: `2`**

**Input: `[1,2,1,3,5,6,4]` <br>
Output: `1` or `5`**

## Solution
This solution also implements binary search to find a peak element in an array. The algorithm is similar to the previous one, but with slight modifications. At each step, the middle element is compared with its neighbors to determine whether it is a peak. If it is, then the index of the peak is returned. If it's not, then the search continues in the direction of the higher neighbor. The initial values of start and end are set to 0 and nums.length - 1 respectively because the peak can be at any position in the array.

### Solution Code
```java
public static int findPeakElement(int[] nums) {
    int start = 0, end = nums.length - 1;
    while (start < end) {
        int mid = start + (end - start) / 2;
        if (nums[mid] > nums[mid + 1]) {
            end = mid;
        } else {
            start = mid + 1;
        }
    }
    return start;
}
```