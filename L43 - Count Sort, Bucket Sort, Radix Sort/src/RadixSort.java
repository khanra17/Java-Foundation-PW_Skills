import java.util.Arrays;

public class RadixSort {

    static int findMax(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int value : arr) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }


    static void countSort(int[] arr, int place) {
        // Find the maximum element in the array
        int max = findMax(arr);

        // Frequency array
        int[] count = new int[10];
        for (int i : arr) {
            count[(i / place) % 10]++; // increment the count of the digit at the given place
        }

        // Prefix sum
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1]; // calculate the cumulative count of the digits
        }

        int[] out = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            int idx = count[(arr[i] / place) % 10] - 1; // calculate the index of the element in the output array
            out[idx] = arr[i]; // place the element in the output array
            count[(arr[i] / place) % 10]--; // decrement the count of the digit at the given place
        }

        // copy the sorted array from the output array to the input array
        System.arraycopy(out, 0, arr, 0, arr.length);
    }

    static void radixSort(int[] arr) {
        int max = findMax(arr); // find the maximum element in the array
        for (int place = 1; max / place > 0; place *= 10) { // loop through each digit place
            countSort(arr, place); // sort the array by the digit at the current place
        }
    }


    public static void main(String[] args) {
        int[] arr = {7, 4, 5, 1, 2};
        radixSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
