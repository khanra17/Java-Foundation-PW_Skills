import java.util.Arrays;

public class SortFruits {

    static void customSelectionSort(String[] arr) {
        int length = arr.length;
        for (int i = 0; i < length - 1; i++) {
            int min_index = i;
            for (int j = i + 1; j < length; j++) {
                if (arr[j].compareTo(arr[min_index]) < 0) {
                    min_index = j;
                }
            }

            if (min_index != i) {
                String temp = arr[i];
                arr[i] = arr[min_index];
                arr[min_index] = temp;
            }
        }
    }

    public static void main(String[] args) {
        String[] arr = {"papaya", "lime", "watermelon", "apple", "mango", "kiwi"};
        customSelectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
