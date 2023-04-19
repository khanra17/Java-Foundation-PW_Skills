class Q15_ReverseLinkedListIterative {

    public static Node reverseList(Node head) {
        Node prev = null;
        Node curr = head;

        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    public static void main(String[] args) {
        // create a linked list
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        // reverse the linked list iteratively
        Node newHead = reverseList(head);

        // print the reversed linked list
        while (newHead != null) {
            System.out.print(newHead.data + " ");
            newHead = newHead.next;
        }
        System.out.println();
    }
}
