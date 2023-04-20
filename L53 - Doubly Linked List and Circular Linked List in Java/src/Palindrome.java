public class Palindrome {
    public static boolean isPalindrome(Node head) {
        if (head == null) {
            System.out.println("List is empty.");
            return false;
        }
        Node tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        Node currentHead = head;
        Node currentTail = tail;
        while (currentHead != currentTail && currentHead.prev != currentTail) {
            if (currentHead.data != currentTail.data) {
                return false;
            }
            currentHead = currentHead.next;
            currentTail = currentTail.prev;
        }
        return true;
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

    public static void main(String[] args) {
        Node list = new Node(0);
        insertAtTail(list,1);
        insertAtTail(list,2);
        insertAtTail(list,3);
        insertAtTail(list,2);
        insertAtTail(list,1);
        if (isPalindrome(list)) {
            System.out.println("The list is a palindrome.");
        } else {
            System.out.println("The list is not a palindrome.");
        }
    }

}
