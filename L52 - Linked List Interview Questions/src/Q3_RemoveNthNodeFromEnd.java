public class Q3_RemoveNthNodeFromEnd {

    public static Node removeNthFromEnd(Node head, int n) {
        if (head == null) {
            return null; // the list is empty
        }

        Node dummy = new Node(0); // create a dummy node to handle edge cases
        dummy.next = head;

        Node slow = dummy;
        Node fast = head;

        // Move fast n nodes ahead of slow
        for (int i = 0; i < n; i++) {
            if (fast == null) {
                return head; // n is greater than the size of the list, so nothing to remove
            }
            fast = fast.next;
        }

        // Move slow and fast together until fast reaches the end of the list
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        // Remove the nth node from the end of the list
        slow.next = slow.next.next;

        return dummy.next;
    }

    public static void main(String[] args) {
        // Create a linked list with some nodes
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        // Test removeNthFromEnd method
        int n = 2;
        System.out.println("Removing " + n + "th node from end...");
        Node newHead = removeNthFromEnd(head, n);
        if (newHead != null) {
            Node current = newHead;
            while (current != null) {
                System.out.print(current.data + " ");
                current = current.next;
            }
        } else {
            System.out.println("List is empty.");
        }
    }

}
