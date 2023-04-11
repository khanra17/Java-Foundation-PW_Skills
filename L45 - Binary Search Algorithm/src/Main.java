public class Main {

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

    public static void main(String[] args) {
        int[] arr = {2, 5, 5, 5, 6, 6, 8, 9, 9, 9};
        System.out.println(binarySearchRecursive(arr, 9, 0, arr.length - 1));
        System.out.println(binarySearchIterative(arr, 9));
    }
}