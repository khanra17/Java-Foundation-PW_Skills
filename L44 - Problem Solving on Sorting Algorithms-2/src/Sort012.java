import java.util.Arrays;

public class Sort012 {

    static void sort012(int[] arr) {
        int low = 0, high = arr.length - 1, mid = 0;
        while (mid <= high) {
            switch (arr[mid]) {
                case 0 -> {
                    int temp = arr[low];
                    arr[low] = arr[mid];
                    arr[mid] = temp;
                    low++;
                    mid++;
                }
                case 1 -> {
                    mid++;
                }
                case 2 -> {
                    int temp = arr[mid];
                    arr[mid] = arr[high];
                    arr[high] = temp;
                    high--;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {0, 2, 1, 2, 0, 0};
        sort012(arr);
        System.out.println(Arrays.toString(arr));
    }
}
