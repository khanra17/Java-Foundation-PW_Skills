public class TwoSum {
    public static void findPairsWithSum(Node head, int target) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        Node left = head;
        Node right = head;
        while (right.next != null) {
            right = right.next;
        }
        boolean foundPair = false;
        while (left != null && right != null && left != right && right.next != left) {
            int sum = left.data + right.data;
            if (sum == target) {
                System.out.println("Pair found: " + left.data + ", " + right.data);
                foundPair = true;
                left = left.next;
                right = right.prev;
            } else if (sum < target) {
                left = left.next;
            } else {
                right = right.prev;
            }
        }
        if (!foundPair) {
            System.out.println("No pair found.");
        }
    }

    public static void main(String[] args) {
        // create a sorted doubly linked list with some values
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

        // find pairs in the list that add up to a given target value
        int target = 5;
        findPairsWithSum(head, target);
    }

}
