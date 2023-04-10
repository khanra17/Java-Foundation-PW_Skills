import java.util.Arrays;

public class FixSwappedElements {
    static void sortSwappedArray(int[] arr) {
        int length = arr.length;
        int first = -1;
        int second = -1;

        // Identify the two out-of-order elements
        for (int i = 1; i < length; i++) {
            if (arr[i - 1] > arr[i]) {
                if (first == -1) {
                    first = i - 1;
                } else {
                    second = i;
                    break; // Found both elements, exit the loop
                }
            }
        }

        // Swap the elements if found
        if (first != -1 && second != -1) {
            int temp = arr[first];
            arr[first] = arr[second];
            arr[second] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 8, 6, 7, 5, 9, 10};
        sortSwappedArray(arr);
        System.out.println(Arrays.toString(arr));
    }
}