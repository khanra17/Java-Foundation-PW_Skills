class Node {
    int data;
    Node next;
    Node prev;

    Node child; // For flatten

    public Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
        this.child = null;
    }

    public void display() {
        Node current = this;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public void displayWithChild() {
        Node current = this;
        while (current != null) {
            System.out.print(current.data + " ");
            if (current.child != null) {
                System.out.print("(");
                current.child.displayWithChild();
                System.out.print(")");
            }
            current = current.next;
        }
    }

}