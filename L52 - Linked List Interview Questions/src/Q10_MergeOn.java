class Q10_MergeOn {

    public static Node mergeLists(Node l1, Node l2) {
        // handle edge cases
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        // create a dummy node to simplify code
        Node dummy = new Node(0);
        Node tail = dummy;

        // merge the lists
        while (l1 != null && l2 != null) {
            if (l1.data <= l2.data) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }

        // attach the remaining nodes to the merged list
        if (l1 != null) {
            tail.next = l1;
        } else {
            tail.next = l2;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        // create two sorted linked lists
        Node l1 = new Node(1);
        l1.next = new Node(3);
        l1.next.next = new Node(5);

        Node l2 = new Node(2);
        l2.next = new Node(4);
        l2.next.next = new Node(6);

        // merge the linked lists
        Node merged = mergeLists(l1, l2);

        // print the merged linked list
        while (merged != null) {
            System.out.print(merged.data + " ");
            merged = merged.next;
        }
    }
}
