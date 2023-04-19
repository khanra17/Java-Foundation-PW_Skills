public class Q18_OddEven {
    public static Node oddEvenList(Node head) {
        if (head == null) {
            return null;
        }

        Node odd = head;
        Node even = head.next;
        Node evenHead = even;

        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }

        odd.next = evenHead;
        return head;
    }

    public static void main(String[] args) {
        // create a sample linked list: 1 -> 2 -> 3 -> 4 -> 5 -> null
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        // print the original list
        System.out.println("Original list:");
        head.display();

        // reorder the list
        head = oddEvenList(head);

        // print the reordered list
        System.out.println("Reordered list:");
        head.display();
    }

}
