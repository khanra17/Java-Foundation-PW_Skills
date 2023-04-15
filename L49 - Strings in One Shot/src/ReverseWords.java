public class ReverseWords {
    public static void main(String[] args) {
        String input = "I am an educator";
        String[] words = input.split(" ");
        StringBuilder reversed = new StringBuilder();

        for (String word : words) {
            StringBuilder temp = new StringBuilder(word);
            reversed.append(temp.reverse() + " ");
        }
        System.out.println("Original string: " + input);
        System.out.println("Reversed string: " + reversed.toString().trim());
    }
}