public class Q4_FindIntersection {

    public static Node findIntersection(Node headA, Node headB) {
        if (headA == null || headB == null) {
            return null; // either list is empty
        }

        // find the lengths of both lists
        int lenA = getLength(headA);
        int lenB = getLength(headB);

        // advance the head of the longer list to make both lists equal in length
        while (lenA > lenB) {
            headA = headA.next;
            lenA--;
        }
        while (lenB > lenA) {
            headB = headB.next;
            lenB--;
        }

        // traverse both lists together until we find the intersection
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }

        // either headA or headB will be the intersection node
        return headA;
    }

    private static int getLength(Node head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }

    public static void main(String[] args) {
        // create two linked lists with an intersection node
        Node headA = new Node(1);
        headA.next = new Node(2);
        Node intersection = new Node(3);
        headA.next.next = intersection;
        headA.next.next.next = new Node(4);

        Node headB = new Node(5);
        headB.next = intersection;
        headB.next.next = new Node(6);

        // Print the two linked lists
        headA.display();
        headB.display();

        // test findIntersection method
        Node intersectionNode = findIntersection(headA, headB);
        if (intersectionNode != null) {
            System.out.println("Intersection found at node with value: " + intersectionNode.data);
        } else {
            System.out.println("No intersection found.");
        }
    }

}
