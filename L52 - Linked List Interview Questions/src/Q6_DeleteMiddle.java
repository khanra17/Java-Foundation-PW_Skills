public class Q6_DeleteMiddle {

    public static Node deleteMiddle(Node head) {
        if (head == null || head.next == null) {
            return null; // cannot delete the middle node
        }

        Node slow = head;
        Node fast = head;
        Node prev = null;

        // move slow one node at a time and fast two nodes at a time until fast reaches the end of the list
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // delete the middle node
        prev.next = slow.next;

        return head;
    }

    public static void main(String[] args) {
        // create a linked list with some nodes
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        // print the original list
        System.out.println("Original list:");
        head.display();

        // delete the middle node
        Node newHead = deleteMiddle(head);

        // print the updated list
        System.out.println("Updated list:");
        newHead.display();
    }

}
