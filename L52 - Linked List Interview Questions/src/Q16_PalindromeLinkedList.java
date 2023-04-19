class Q16_PalindromeLinkedList {

    public static boolean isPalindrome(Node head) {
        // handle edge cases
        if (head == null || head.next == null) {
            return true;
        }

        // find the middle of the linked list using a fast and slow pointer
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // reverse the second half of the linked list
        Node prev = null;
        Node curr = slow;
        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // compare the first half of the linked list to the reversed second half
        Node p1 = head;
        Node p2 = prev;
        while (p2 != null) {
            if (p1.data != p2.data) {
                return false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        return true;
    }

    public static void main(String[] args) {
        // create a linked list
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(1);

        // check if the linked list is a palindrome
        boolean isPal = isPalindrome(head);

        // print the result
        System.out.println("Is the linked list a palindrome? " + isPal);
    }
}
