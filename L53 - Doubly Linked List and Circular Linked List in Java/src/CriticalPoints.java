import java.util.Arrays;

public class CriticalPoints {
    public static int[] nodesBetweenCriticalPoints(Node h) {
        int first = Integer.MAX_VALUE, last = 0, prev_val = h.data, min_d = Integer.MAX_VALUE;
        for (int i = 0; h.next != null; ++i) {
            if ((prev_val < h.data && h.data > h.next.data) || (prev_val > h.data && h.data < h.next.data)) {
                if (last != 0) min_d = Math.min(min_d, i - last);
                first = Math.min(first, i);
                last = i;
            }
            prev_val = h.data;
            h = h.next;
        }
        if (min_d == Integer.MAX_VALUE) return new int[]{-1, -1};
        return new int[]{min_d, last - first};
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        Node node2 = new Node(3);
        Node node3 = new Node(2);
        Node node4 = new Node(2);
        Node node5 = new Node(3);
        Node node6 = new Node(2);
        Node node7 = new Node(2);
        Node node8 = new Node(2);
        Node node9 = new Node(7);

        head.next = node2;
        node2.prev = head;
        node2.next = node3;
        node3.prev = node2;
        node3.next = node4;
        node4.prev = node3;
        node4.next = node5;
        node5.prev = node4;
        node5.next = node6;
        node6.prev = node5;
        node6.next = node7;
        node7.prev = node6;
        node7.next = node8;
        node8.prev = node7;
        node8.next = node9;
        node9.prev = node8;

        int[] result = nodesBetweenCriticalPoints(head);
        System.out.println(Arrays.toString(result));
    }

}

