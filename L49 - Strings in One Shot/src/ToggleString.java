public class ToggleString {
    public static void main(String[] args) {
        String str = "PhisICS";
        String toggledString = toggleString(str);
        System.out.println(toggledString);
    }

    public static String toggleString(String str) {
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (Character.isUpperCase(charArray[i])) {
                charArray[i] = Character.toLowerCase(charArray[i]);
            } else if (Character.isLowerCase(charArray[i])) {
                charArray[i] = Character.toUpperCase(charArray[i]);
            }
        }
        return new String(charArray);
    }
}