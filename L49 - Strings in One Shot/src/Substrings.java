public class Substrings {
    public static void main(String[] args) {
        String s = "abcd";
        int n = s.length();

        // loop to generate all possible substrings
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                System.out.println(s.substring(i, j));
            }
        }
    }
}