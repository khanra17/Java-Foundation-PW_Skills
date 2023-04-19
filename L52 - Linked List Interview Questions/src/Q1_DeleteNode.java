public class Q1_DeleteNode {
    public static void deleteNode(Node node) {
        if (node == null || node.next == null) {
            // cannot delete node or last node
            return;
        }

        Node nextNode = node.next;
        node.data = nextNode.data;
        node.next = nextNode.next;
        nextNode.next = null; // free memory
    }

    public static void main(String[] args) {
        // Create a linked list with some nodes
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        // Test deleteNode method
        System.out.println("Original linked list:");
        head.display();
        System.out.println("Deleting node with value 3...");
        Node nodeToDelete = head.next.next;
        deleteNode(nodeToDelete);
        System.out.println("Updated linked list:");
        head.display();
    }
}
