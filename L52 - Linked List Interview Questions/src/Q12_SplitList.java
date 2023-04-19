class Q12_SplitList {

    public static Node[] splitList(Node head) {
        Node oddHead = null, oddTail = null;
        Node evenHead = null, evenTail = null;

        while (head != null) {
            if (head.data % 2 == 0) { // even value
                if (evenHead == null) {
                    evenHead = evenTail = head;
                } else {
                    evenTail.next = head;
                    evenTail = evenTail.next;
                }
            } else { // odd value
                if (oddHead == null) {
                    oddHead = oddTail = head;
                } else {
                    oddTail.next = head;
                    oddTail = oddTail.next;
                }
            }
            head = head.next;
        }

        // terminate the two lists
        if (evenTail != null) {
            evenTail.next = null;
        }
        if (oddTail != null) {
            oddTail.next = null;
        }

        return new Node[]{oddHead, evenHead};
    }

    public static void main(String[] args) {
        // create a linked list
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        // split the linked list into two lists
        Node[] splitLists = splitList(head);
        Node oddList = splitLists[0];
        Node evenList = splitLists[1];

        // print the odd list
        System.out.print("Odd list: ");
        while (oddList != null) {
            System.out.print(oddList.data + " ");
            oddList = oddList.next;
        }
        System.out.println();

        // print the even list
        System.out.print("Even list: ");
        while (evenList != null) {
            System.out.print(evenList.data + " ");
            evenList = evenList.next;
        }
        System.out.println();
    }
}
