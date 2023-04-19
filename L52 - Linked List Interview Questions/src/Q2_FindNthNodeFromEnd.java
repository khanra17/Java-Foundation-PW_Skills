public class Q2_FindNthNodeFromEnd {
    public static Node nthNodeFromEnd(Node head, int n) {
        if (head == null || n < 1) {
            return null;
        }

        Node slow = head;
        Node fast = head;
        // Move fast n nodes ahead of slow
        for (int i = 0; i < n; i++) {
            if (fast == null) {
                return null; // n is greater than the size of the linked list
            }
            fast = fast.next;
        }
        // Move slow and fast together until fast reaches the end of the list
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        // slow is the nth node from the end of the list
        return slow;
    }


    public static void main(String[] args) {
        // Create a linked list with some nodes
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        // Test nthNodeFromEnd method
        System.out.println("Finding 2nd node from end...");
        Node nthNode = nthNodeFromEnd(head, 2);
        if (nthNode != null) {
            System.out.println("Node with value " + nthNode.data + " found.");
        } else {
            System.out.println("Node not found.");
        }
    }
}