public class Q8_FindCycleStart {

    public static Node findCycleStart(Node head) {
        if (head == null) {
            return null; // the list is empty
        }

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            // If there's a cycle, move slow back to the head and move both slow and fast one node at a time
            // until they meet at the node where the cycle begins
            if (slow == fast) {
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow; // this is the node where the cycle begins
            }
        }

        return null; // there is no cycle
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

        // find the start of the cycle
        Node cycleStart = findCycleStart(head);

        // print the result
        if (cycleStart != null) {
            System.out.println("The cycle starts at node " + cycleStart.data);
        } else {
            System.out.println("The linked list does not contain a cycle.");
        }
    }

}
