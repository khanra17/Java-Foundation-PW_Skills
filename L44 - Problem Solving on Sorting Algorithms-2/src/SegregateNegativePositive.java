import java.util.Arrays;

public class SegregateNegativePositive {

    static void segregateArray(int[] arr) {
        int l = 0, r = arr.length - 1;
        while (l < r) {
            while (arr[l] < 0) l++;
            while (arr[r] >= 0) r--;
            if (l < r) {
                int temp = arr[l];
                arr[l] = arr[r];
                arr[r] = temp;
                l++;
                r--;
            }
        }

    }

    public static void main(String[] args) {
        int[] arr = {19, -20, 7, 4, -13, 11, -5, 3};
        segregateArray(arr);
        System.out.println(Arrays.toString(arr));
    }
}
