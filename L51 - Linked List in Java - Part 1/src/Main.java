public class Main {
    public static void main(String[] args) {
        // Implement Linked List
        LinkedList list = new LinkedList();
        list.insertAtEnd(1);
        list.insertAtEnd(2);
        list.insertAtBeginning(0);
        list.insertAtIndex(3, 3);
        System.out.println(list.getElement(2)); // Output: 1
        list.delete(1);
        System.out.println(list.getElement(1)); // Output: 1
        System.out.println(list.size()); // Output: 3

    }
}
