public class LinkedListLength {
    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            next = null;
        }
    }

    public static int getLengthIterative(Node head) {
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    public static int getLengthRecursive(Node head) {
        if (head == null) {
            return 0;
        }
        return 1 + getLengthRecursive(head.next);
    }

    public static void main(String[] args) {
        // Create a sample linked list: 1 -> 2 -> 3 -> 4 -> 5
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        // Test the iterative approach
        int lengthIterative = getLengthIterative(head);
        System.out.println("Length (iterative): " + lengthIterative); // Output: 5

        // Test the recursive approach
        int lengthRecursive = getLengthRecursive(head);
        System.out.println("Length (recursive): " + lengthRecursive); // Output: 5
    }
}
