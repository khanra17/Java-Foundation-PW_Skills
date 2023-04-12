public class Main {

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


    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 8, 9, 10, 11, 0, 1, 2, 3};
        System.out.println(binarySearchMinimum(arr));
        System.out.println(binarySearchTarget(arr, 2));
        System.out.println(binarySearchTargetDuplicate(arr, 20));
    }
}
