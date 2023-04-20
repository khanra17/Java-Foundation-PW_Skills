public class Insertion {
    public static Node insertAtHead(Node head, int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head.prev = newNode;
        return newNode;
    }

    public static void insertAtTail(Node head, int data) {
        Node newNode = new Node(data);
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
        newNode.prev = current;
    }

    public static void insertAtIndex(Node head, int index, int data) {
        Node newNode = new Node(data);
        Node current = head;
        int i = 0;
        while (i < index && current != null) {
            current = current.next;
            i++;
        }
        if (current == null) {
            System.out.println("Invalid index, node not inserted.");
            return;
        }
        newNode.next = current;
        newNode.prev = current.prev;
        current.prev.next = newNode;
        current.prev = newNode;
    }

    public static void main(String[] args) {
        // create a DLL with one node
        Node head = new Node(1);

        // insert a new node at the head
        head = insertAtHead(head, 0);

        // insert a new node at the tail
        insertAtTail(head, 3);

        // insert a new node at the index
        insertAtIndex(head, 2, 2);

        // display the list
        head.display();
    }
}
