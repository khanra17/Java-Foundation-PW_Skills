public class MaximaMinima {
    public static void findMaxAndMin(Node head) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        int max = head.data;
        int min = head.data;
        Node current = head;
        while (current != null) {
            if (current.data > max) {
                max = current.data;
            }
            if (current.data < min) {
                min = current.data;
            }
            current = current.next;
        }
        System.out.println("Max value: " + max);
        System.out.println("Min value: " + min);
    }

    public static void main(String[] args) {
        // create a doubly linked list with some values
        Node head = new Node(10);
        Node node2 = new Node(2);
        Node node3 = new Node(30);
        Node node4 = new Node(4);
        Node node5 = new Node(50);
        head.next = node2;
        node2.prev = head;
        node2.next = node3;
        node3.prev = node2;
        node3.next = node4;
        node4.prev = node3;
        node4.next = node5;
        node5.prev = node4;

        // find max and min values in the list
        findMaxAndMin(head);
    }

}
