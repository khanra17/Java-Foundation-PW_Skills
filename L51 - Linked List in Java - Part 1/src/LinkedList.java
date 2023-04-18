public class LinkedList {

    private ListNode head;
    private int size;

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    // Insert a new node at the end of the list
    public void insertAtEnd(int val) {
        ListNode newNode = new ListNode(val);
        if (head == null) {
            head = newNode;
        } else {
            ListNode curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = newNode;
        }
        size++;
    }

    // Insert a new node at the beginning of the list
    public void insertAtBeginning(int val) {
        ListNode newNode = new ListNode(val);
        newNode.next = head;
        head = newNode;
        size++;
    }

    // Insert a new node at a specific index in the list
    public void insertAtIndex(int val, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        if (index == 0) {
            insertAtBeginning(val);
            return;
        }
        if (index == size) {
            insertAtEnd(val);
            return;
        }
        ListNode newNode = new ListNode(val);
        ListNode curr = head;
        for (int i = 0; i < index - 1; i++) {
            curr = curr.next;
        }
        newNode.next = curr.next;
        curr.next = newNode;
        size++;
    }

    // Get the value of the node at a specific index in the list
    public int getElement(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        ListNode curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        return curr.val;
    }

    // Delete the node at a specific index in the list
    public void delete(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        if (index == 0) {
            head = head.next;
            size--;
            return;
        }
        ListNode curr = head;
        for (int i = 0; i < index - 1; i++) {
            curr = curr.next;
        }
        curr.next = curr.next.next;
        size--;
    }

    // Get the size of the list
    public int size() {
        return size;
    }
}
