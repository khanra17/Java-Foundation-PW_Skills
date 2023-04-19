public class Q17_MaximumTwinSum {
    public static int maxTwinSum(Node head) {
        int n = 0;
        Node p = head;
        while (p != null) {
            n++;
            p = p.next;
        }

        int maxTwinSum = 0;
        p = head;
        for (int i = 0; i < n; i++) {
            int twinIndex = n - 1 - i;
            if (i <= n / 2 - 1) {
                Node twin = head;
                for (int j = 0; j < twinIndex; j++) {
                    twin = twin.next;
                }
                int twinSum = p.data + twin.data;
                if (twinSum > maxTwinSum) {
                    maxTwinSum = twinSum;
                }
            }
            p = p.next;
        }

        return maxTwinSum;
    }

    public static void main(String[] args) {
        // create a linked list with even length
        Node head = new Node(1);
        head.next = new Node(3);
        head.next.next = new Node(5);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(4);
        head.next.next.next.next.next = new Node(6);

        // calculate the maximum twin sum and print the result
        int maxTwinSum = maxTwinSum(head);
        System.out.println("Maximum twin sum: " + maxTwinSum);
    }

}
