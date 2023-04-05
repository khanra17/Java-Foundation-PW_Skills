import java.util.Arrays;

public class MoveZeroes {
    static void customBubbleSort(int[] arr) {
        int length = arr.length;

        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                if (arr[j] == 0) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {0, 5, 0, 3, 4, 2};
        customBubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
