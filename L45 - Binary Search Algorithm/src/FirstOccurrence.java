public class FirstOccurrence {

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


    public static void main(String[] args) {
        int[] arr = {1, 5, 5, 5, 6, 2, 4};
        System.out.println(firstOccurrence(arr, 9));
    }
}
