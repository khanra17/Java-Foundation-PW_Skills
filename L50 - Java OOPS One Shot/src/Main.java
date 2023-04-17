public class Main {
    public static void main(String[] args) {
        runFraction(args);
        runMyArrayList(args);
    }

    public static void runFraction(String[] args) {
        MyArrayList<String> list = new MyArrayList<>();
        list.add("Hello");
        list.add("World");
        list.add("Java");

        System.out.println("List size: " + list.size());
        System.out.println("Element at index 1: " + list.get(1));

        list.remove(0);

        System.out.println("List size after removal: " + list.size());
        System.out.println("Element at index 0 after removal: " + list.get(0));

        list.clear();

        System.out.println("List size after clear: " + list.size());
    }

    public static void runMyArrayList(String[] args) {
        Fraction fraction1 = new Fraction(3, 4);
        Fraction fraction2 = new Fraction(1, 2);

        Fraction sum = fraction1.add(fraction2);

        System.out.println("The sum of " + fraction1.getNumerator() + "/" + fraction1.getDenominator() + " and " + fraction2.getNumerator() + "/" + fraction2.getDenominator() + " is " + sum.getNumerator() + "/" + sum.getDenominator());
    }
}
