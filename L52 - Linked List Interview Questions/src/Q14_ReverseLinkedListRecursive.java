class Q14_ReverseLinkedListRecursive {

    public static Node reverseList(Node head) {
        // base case: empty list or single node list
        if (head == null || head.next == null) {
            return head;
        }

        // reverse the rest of the list
        Node rest = reverseList(head.next);

        // append the current node to the end of the reversed rest
        head.next.next = head;
        head.next = null;

        // return the new head of the reversed list
        return rest;
    }

    public static void main(String[] args) {
        // create a linked list
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        // reverse the linked list recursively
        Node newHead = reverseList(head);

        // print the reversed linked list
        while (newHead != null) {
            System.out.print(newHead.data + " ");
            newHead = newHead.next;
        }
        System.out.println();
    }
}
