public class LinkedListStack {

    private Node top;

    private static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void push(int element) {
        Node node = new Node(element);
        node.next = top;
        top = node;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow");
            return -1;
        }
        int element = top.data;
        top = top.next;
        return element;
    }

    public int peak() {
        if (isEmpty()) {
            System.out.println("Stack Underflow");
            return -1;
        }
        return top.data;
    }
}
