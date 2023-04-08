import java.util.Arrays;

public class CountSort {

    static int findMax(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int value : arr) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }

    static void countSortBasic(int[] arr) {
        // Frequency array
        int[] count = new int[findMax(arr) + 1];
        for (int value : arr) {
            count[value]++;
        }

        int k = 0;
        for (int i = 0; i < count.length; i++) {
            for (int j = 0; j < count[i]; j++) {
                arr[k++] = i;
            }
        }
    }


    static void countSortStable(int[] arr) {
        // Find the maximum element in the array
        int max = findMax(arr);

        // Frequency array
        int[] count = new int[max + 1];
        for (int value : arr) {
            count[value]++;
        }

        // Prefix sum
        for (int i = 1; i <= max; i++) {
            count[i] += count[i - 1];
        }

        int[] out = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            int idx = count[arr[i]] - 1;
            out[idx] = arr[i];
            count[arr[i]]--;
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = out[i];
        }
    }


    public static void main(String[] args) {
        int[] arrBasic = {7, 4, 5, 1, 2};
        countSortBasic(arrBasic);
        System.out.println(Arrays.toString(arrBasic));

        int[] arrStable = {7, 4, 5, 1, 2};
        countSortStable(arrStable);
        System.out.println(Arrays.toString(arrStable));
    }
}

