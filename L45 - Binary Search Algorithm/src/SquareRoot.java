public class SquareRoot {

    static int sqrt(int x) {
        int ans = -1;
        int start = 0, end = x;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (mid <= x / mid) {
                start = mid + 1;
                ans = mid;
            }
            else end = mid - 1;
        }
        return ans;
    }


    public static void main(String[] args) {
        System.out.println(sqrt(24));
    }
}
