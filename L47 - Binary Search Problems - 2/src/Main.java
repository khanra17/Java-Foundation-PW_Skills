public class Main {

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

    public static boolean searchIn2DMatrixDiagonal(int[][] matrix, int target) {
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

    public static void main(String[] args) {
        int[][] matrix = {{1, 35, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        int[][] matrix_diagonal = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        System.out.println(binarySearchMatrix(matrix, 34));
        System.out.println(binarySearchMatrixAs1D(matrix, 34));
        System.out.println(searchIn2DMatrixDiagonal(matrix, 34)); // We can apply diagonal approach here as well
        System.out.println(searchIn2DMatrixDiagonal(matrix_diagonal, 5));

        int[] arr_mountain = {0, 4, 1, 0};
        System.out.println(peakIndexInMountainArray(arr_mountain));

        int[] arr_peak = {1, 2, 1, 3, 5, 6, 4};
        System.out.println(findPeakElement(arr_peak));
    }
}
