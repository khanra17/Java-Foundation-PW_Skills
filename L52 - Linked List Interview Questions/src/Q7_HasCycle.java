public class Q7_HasCycle {
    public static boolean hasCycle(Node head) {
        if (head == null) {
            return false; // the list is empty
        }

        Node slow = head;
        Node fast = head.next;

        while (fast != null && fast.next != null) {
            if (slow == fast) {
                return true; // cycle detected
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        return false; // no cycle detected
    }

    public static void main(String[] args) {
        // create a linked list with a cycle
        Node head = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node2;

        // detect the cycle
        boolean hasCycle = hasCycle(head);

        // print the result
        if (hasCycle) {
            System.out.println("The linked list contains a cycle.");
        } else {
            System.out.println("The linked list does not contain a cycle.");
        }
    }

}
