public class Deletion {
    public static Node deleteAtHead(Node head) {
        if (head == null) {
            System.out.println("List is empty, deletion not possible.");
            return null;
        }
        if (head.next == null) {
            return null;
        }
        head.next.prev = null;
        return head.next;
    }

    public static Node deleteAtTail(Node head) {
        if (head == null) {
            System.out.println("List is empty, deletion not possible.");
            return null;
        }
        if (head.next == null) {
            return null;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.prev.next = null;
        return head;
    }

    public static void deleteAtIndex(Node head, int index) {
        if (head == null) {
            System.out.println("List is empty, deletion not possible.");
            return;
        }
        Node current = head;
        int i = 0;
        while (i < index && current != null) {
            current = current.next;
            i++;
        }
        if (current == null) {
            System.out.println("Invalid index, node not deleted.");
            return;
        }
        if (current == head) {
            head = current.next;
        }
        if (current.next != null) {
            current.next.prev = current.prev;
        }
        current.prev.next = current.next;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);

        head.next = node2;
        node2.prev = head;
        node2.next = node3;
        node3.prev = node2;
        node3.next = node4;
        node4.prev = node3;
        node4.next = node5;
        node5.prev = node4;

        System.out.print("Before deletion: ");
        head.display();

        System.out.print("After deletion head: ");
        deleteAtHead(head);
        head.display();

        System.out.print("After deletion tail: ");
        deleteAtTail(head);
        head.display();

        System.out.print("After deletion at index 2: ");
        deleteAtIndex(head, 2);
        head.display();
    }
}
