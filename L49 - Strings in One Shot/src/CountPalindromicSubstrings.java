public class CountPalindromicSubstrings {
    public static void main(String[] args) {
        System.out.println(countPalindromicSubstrings("abc")); // "a", "b", "c".
        System.out.println(countPalindromicSubstrings("aba")); // "a", "b", "a", and "aba".
    }

    public static int countPalindromicSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (isPalindromic(s.substring(i, j + 1))) {
                    // System.out.println(s.substring(i, j + 1)); // Print the  palindrome
                    count++;
                }
            }
        }
        return count;
    }

    public static boolean isPalindromic(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
