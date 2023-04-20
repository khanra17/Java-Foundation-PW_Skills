public class Flatten {
    public static Node flatten(Node head) {
        if (head == null) {
            return null;
        }
        Node tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        Node current = head;
        while (current != null) {
            if (current.child != null) {
                Node flattenedChild = flatten(current.child);
                flattenedChild.prev = tail;
                tail.next = flattenedChild;
                while (tail.next != null) {
                    tail = tail.next;
                }
                current.child = null;
            }
            current = current.next;
        }
        return head;
    }

    public static void main(String[] args) {
        // create a multilevel doubly linked list
        Node head = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);
        Node node9 = new Node(9);
        Node node10 = new Node(10);
        Node node11 = new Node(11);
        Node node12 = new Node(12);
        head.next = node2;
        node2.prev = head;
        node2.next = node3;
        node3.prev = node2;
        node3.next = node4;
        node4.prev = node3;
        node4.next = node5;
        node5.prev = node4;
        node3.child = node6;
        node6.next = node7;
        node7.prev = node6;
        node7.next = node8;
        node8.prev = node7;
        node8.next = node9;
        node9.prev = node8;
        node4.child = node10;
        node10.next = node11;
        node11.prev = node10;
        node11.next = node12;
        node12.prev = node11;

        // print the list
        head.displayWithChild();
        System.out.println();

        // flatten the list
        flatten(head);

        // print the flattened list
        head.displayWithChild();
    }

}
