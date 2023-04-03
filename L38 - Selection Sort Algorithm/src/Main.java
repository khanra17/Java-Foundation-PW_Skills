import java.util.Arrays;

public class Main {

    static void selectionSort(int[] arr) {
        int length = arr.length;

        for (int i = 0; i < length - 1; i++) {
            int min_index = i;
            for (int j = i + 1; j < length; j++) {
                if (arr[j] < arr[min_index]) {
                    min_index = j;
                }
            }

            if (min_index != i) {
                arr[i] = arr[i] + arr[min_index];
                arr[min_index] = arr[i] - arr[min_index];
                arr[i] = arr[i] - arr[min_index];
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {7, 4, 5, 1, 2};
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}