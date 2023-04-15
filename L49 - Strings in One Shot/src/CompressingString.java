public class CompressingString {
    public static String compressString(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }

        StringBuilder sb = new StringBuilder();
        char currentChar = str.charAt(0);
        int count = 1;

        for (int i = 1; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == currentChar) {
                count++;
            } else {
                sb.append(currentChar).append(count);
                currentChar = c;
                count = 1;
            }
        }

        sb.append(currentChar).append(count);
        return sb.toString();
    }

    public static void main(String[] args) {
        String input = "aaabbbbccddde";
        String output = compressString(input);
        System.out.println(output);
    }
}
