import java.util.Arrays;

public class Main {

    static void bubbleSort(int[] arr) {
        int length = arr.length;
        boolean swaped = false;

        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swaped = true;
                }
            }
            if (!swaped) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}