class Node {
    int data;
    Node next;
    Node random; // For 19th Question

    public Node(int data) {
        this.data = data;
        this.next = null;
        this.random = null;
    }

    public void display() {
        Node current = this;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    // For 19th Question
    public void displayWithRandom() {
        Node curr = this;
        while (curr != null) {
            System.out.print(curr.data + "(" + (curr.random != null ? curr.random.data : "null") + ") -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }
}