public class Q5_FindMiddle {

    public static Node findMiddle(Node head) {
        if (head == null) {
            return null; // the list is empty
        }

        Node slow = head;
        Node fast = head;

        // move slow one node at a time and fast two nodes at a time
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // when fast reaches the end of the list, slow will be at the middle node
        return slow;
    }

    public static void main(String[] args) {
        // create a linked list with some nodes
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        // test findMiddle method
        Node middle = findMiddle(head);
        if (middle != null) {
            System.out.println("Middle node has value: " + middle.data);
        } else {
            System.out.println("List is empty.");
        }
    }

}
