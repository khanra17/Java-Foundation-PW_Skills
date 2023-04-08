import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BucketSort {

    public static void bucketSort(int[] arr) {
        // Buckets
        ArrayList<Integer>[] buckets = new ArrayList[10];

        // Initialize empty buckets
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<Integer>();
        }

        // Add elements to buckets
        for (int elem : arr) {
            int digit = (elem / 10) % 10;
            buckets[digit].add(elem);
        }

        // Sort buckets
        for (ArrayList<Integer> bucket : buckets) {
            Collections.sort(bucket);
        }

        // Copy buckets to original array
        int index = 0;
        for (ArrayList<Integer> bucket : buckets) {
            for (int elem : bucket) {
                arr[index++] = elem;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {25, 10, 35, 5, 30, 15, 20, 40, 5, 10, 56, 30, 25};
        bucketSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
