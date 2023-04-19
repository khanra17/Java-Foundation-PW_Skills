Linked List Interview Questions
=======================================

### Q1: Delete node with node as given parameter
```java
public void deleteNode(Node node) {
    if (node == null || node.next == null) {
        // cannot delete node or last node
        return;
    }
    
    Node nextNode = node.next;
    node.data = nextNode.data;
    node.next = nextNode.next;
    nextNode.next = null; // free memory
}
```

### Q2: Find nth node from end of linked list
```java
public Node nthNodeFromEnd(Node head, int n) {
    if (head == null || n < 1) {
        return null;
    }
    
    Node slow = head;
    Node fast = head;
    // Move fast n nodes ahead of slow
    for (int i = 0; i < n; i++) {
        if (fast == null) {
            return null; // n is greater than the size of the linked list
        }
        fast = fast.next;
    }
    // Move slow and fast together until fast reaches the end of the list
    while (fast != null) {
        slow = slow.next;
        fast = fast.next;
    }
    // slow is the nth node from the end of the list
    return slow;
}
```

### Q3: Remove nth node from end
This method is similar to the previous method for finding the nth node from the end of the list, with the addition of removing that node.

The method first checks if the list is empty. If so, it returns null because there is nothing to remove.

Next, it creates a dummy node to handle the edge case where the first node needs to be removed. The dummy node's next points to the head of the list.

Then, it initializes two pointers - slow and fast - with slow pointing to the dummy node and fast pointing to the head of the list. The fast pointer is moved n nodes ahead of the slow pointer using a for loop. If the fast pointer reaches the end of the list before moving n nodes ahead, it means n is greater than the size of the list, and the method returns the original head because there is nothing to remove.

Once the fast pointer has moved n nodes ahead of the slow pointer, both pointers are moved together until the fast pointer reaches the end of the list. At this point, the slow pointer points to the node immediately before the node to be removed.

To remove the nth node from the end of the list, the slow pointer's next is set to the node after the one to be removed.

Finally, the method returns the dummy node's next, which is the head of the modified list.

Overall, this method also has a time complexity of O(n) since it traverses the list only once.
```java
public Node removeNthFromEnd(Node head, int n) {
    if (head == null) {
        return null; // the list is empty
    }
    
    Node dummy = new Node(0); // create a dummy node to handle edge cases
    dummy.next = head;
    
    Node slow = dummy;
    Node fast = head;
    
    // Move fast n nodes ahead of slow
    for (int i = 0; i < n; i++) {
        if (fast == null) {
            return head; // n is greater than the size of the list, so nothing to remove
        }
        fast = fast.next;
    }
    
    // Move slow and fast together until fast reaches the end of the list
    while (fast != null) {
        slow = slow.next;
        fast = fast.next;
    }
    
    // Remove the nth node from the end of the list
    slow.next = slow.next.next;
    
    return dummy.next;
}
```

### Q4: Find Intersection of Two Linked Lists
The findIntersection method takes two singly linked list heads as inputs and returns the node where the lists intersect, or null if they do not intersect. The approach is to first find the lengths of both lists and advance the head of the longer list so that both lists are equal in length. Then, we traverse both lists together until we find the intersection node (i.e., the node where both lists have the same reference).

```java
 public Node findIntersection(Node headA, Node headB) {
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
```

### Q5: Find middle(right) of a linked list
The findMiddle method takes a singly linked list head as input and returns the middle node of the list. The approach is to use two pointers, slow and fast, where slow moves one node at a time and fast moves two nodes at a time. When fast reaches the end of the list, slow will be at the middle node (or the second middle node if the list has an even number of nodes).

```java
public static Node findMiddle(Node head) {
    if (head == null) {
        return null; // the list is empty
    }

    Node slow = head;
    Node fast = head;

    // move slow one node at a time and fast two nodes at a time
    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
    }

    // when fast reaches the end of the list, slow will be at the middle node
    return slow;
}
```

### Q6: Delete middle(right) of a linked list
The approach is similar to the previous implementation, but this time we also keep track of the previous node of the middle node so that we can update its next pointer after deleting the middle node. We use two pointers, slow and fast, to traverse the list. The slow pointer moves one node at a time and the fast pointer moves two nodes at a time. When fast reaches the end of the list, slow will be pointing to the middle node. We use a third pointer, prev, to keep track of the previous node of slow. Once we find the middle node, we update prev.next to skip over the middle node, effectively deleting it. Finally, we return the head of the updated list. If the input list is empty or has only one node, we return null indicating that the middle node cannot be deleted.

```java
public static Node deleteMiddle(Node head) {
    if (head == null || head.next == null) {
        return null; // cannot delete the middle node
    }

    Node slow = head;
    Node fast = head;
    Node prev = null;

    // move slow one node at a time and fast two nodes at a time until fast reaches the end of the list
    while (fast != null && fast.next != null) {
        prev = slow;
        slow = slow.next;
        fast = fast.next.next;
    }

    // delete the middle node
    prev.next = slow.next;

    return head;
}
```

### Q7: Has Cycle
This implementation uses two pointers, slow and fast, to traverse the linked list. The slow pointer moves one node at a time and the fast pointer moves two nodes at a time. If the list contains a cycle, the fast pointer will eventually catch up to the slow pointer and they will be pointing to the same node. If there is no cycle in the list, the fast pointer will eventually reach the end of the list and the loop will terminate without detecting a cycle.

```java
public static boolean hasCycle(Node head) {
    if (head == null) {
        return false; // the list is empty
    }

    Node slow = head;
    Node fast = head.next;

    while (fast != null && fast.next != null) {
        if (slow == fast) {
            return true; // cycle detected
        }
        slow = slow.next;
        fast = fast.next.next;
    }

    return false; // no cycle detected
}
```

### Q8: Find Cycle Start
This implementation is similar to the original hasCycle method, except that it uses a second loop to find the node where the cycle begins. When the slow and fast pointers meet at a node in the cycle, we move the slow pointer back to the head of the list, and then move both pointers one node at a time until they meet at the node where the cycle begins.

```java
public static Node findCycleStart(Node head) {
    if (head == null) {
        return null; // the list is empty
    }

    Node slow = head;
    Node fast = head;

    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;

        // If there's a cycle, move slow back to the head and move both slow and fast one node at a time
        // until they meet at the node where the cycle begins
        if (slow == fast) {
            slow = head;
            while (slow != fast) {
                slow = slow.next;
                fast = fast.next;
            }
            return slow; // this is the node where the cycle begins
        }
    }

    return null; // there is no cycle
}
```

### Q10: Merge 2 Sorted Linked Lists (O(n) space)
The `mergeLists` method takes two sorted linked lists, l1 and l2, and returns a new sorted linked list that contains all the elements of l1 and l2.

To merge the two lists, we create a dummy node to simplify the code, and then we iterate through both lists, adding the smallest element to the merged list at each step. When one list is exhausted, we attach the remaining nodes of the other list to the merged list.

```java
public static Node mergeLists(Node l1, Node l2) {
    // handle edge cases
    if (l1 == null) {
        return l2;
    }
    if (l2 == null) {
        return l1;
    }

    // create a dummy node to simplify code
    Node dummy = new Node(0);
    Node tail = dummy;

    // merge the lists
    while (l1 != null && l2 != null) {
        if (l1.data <= l2.data) {
            tail.next = l1;
            l1 = l1.next;
        } else {
            tail.next = l2;
            l2 = l2.next;
        }
        tail = tail.next;
    }

    // attach the remaining nodes to the merged list
    if (l1 != null) {
        tail.next = l1;
    } else {
        tail.next = l2;
    }

    return dummy.next;
}
```

### Q11: Merge 2 Sorted Linked Lists (O(1) space)
In this implementation, instead of creating a dummy node and using a tail pointer to build the merged list, we use the head and tail pointers to keep track of the merged list and its last node. We initialize the head and tail pointers to null initially and determine the head node of the merged list based on the first nodes of the input lists. Then we set the tail pointer to the head node and update it in each iteration of the while loop while merging the input lists. This way, we do not need to use any additional memory to store a dummy node and a tail pointer.

```java
public static Node mergeLists(Node l1, Node l2) {
    // handle edge cases
    if (l1 == null) {
        return l2;
    }
    if (l2 == null) {
        return l1;
    }

    // set the head and tail pointers
    Node head = null;
    Node tail = null;

    // determine the head node of the merged list
    if (l1.data <= l2.data) {
        head = l1;
        l1 = l1.next;
    } else {
        head = l2;
        l2 = l2.next;
    }

    // set the tail pointer to the head node
    tail = head;

    // merge the lists
    while (l1 != null && l2 != null) {
        if (l1.data <= l2.data) {
            tail.next = l1;
            l1 = l1.next;
        } else {
            tail.next = l2;
            l2 = l2.next;
        }
        tail = tail.next;
    }

    // attach the remaining nodes to the merged list
    if (l1 != null) {
        tail.next = l1;
    } else {
        tail.next = l2;
    }

    return head;
}
```

### Q12: Given a linked list, split it into two lists such that one contains odd values, and the other contains even values.
In this implementation, we use two pairs of pointers, oddHead and oddTail for the odd list, and evenHead and evenTail for the even list. We iterate through the input list, and for each node, we check if its value is odd or even, and append it to the corresponding list using the tail pointer. After we finish iterating the input list, we terminate the two lists by setting the next pointer of their last nodes to null, and return them as an array of two nodes. Finally, we print the two lists to verify the correctness of the implementation.

```java
public static Node[] splitList(Node head) {
    Node oddHead = null, oddTail = null;
    Node evenHead = null, evenTail = null;

    while (head != null) {
        if (head.data % 2 == 0) { // even value
            if (evenHead == null) {
                evenHead = evenTail = head;
            } else {
                evenTail.next = head;
                evenTail = evenTail.next;
            }
        } else { // odd value
            if (oddHead == null) {
                oddHead = oddTail = head;
            } else {
                oddTail.next = head;
                oddTail = oddTail.next;
            }
        }
        head = head.next;
    }

    // terminate the two lists
    if (evenTail != null) {
        evenTail.next = null;
    }
    if (oddTail != null) {
        oddTail.next = null;
    }

    return new Node[] {oddHead, evenHead};
}
```

#### Using constant (O(1)) space
In this implementation, we use the same basic idea as before to split the list into odd and even lists, but we modify the original list in place to avoid using extra space. Specifically, for each node in the input list, we first save a reference to its next node in the next variable, then we set the node's next pointer to null. This effectively removes the node from the input list and prepares it to be appended to one of the two output lists. We then append the node to the corresponding output list using the same tail pointer mechanism as before. Finally, we return the two output lists as an array of two nodes. Note that since we modify the input list in place, we do not need to terminate the output lists, as the last node of each list will already have a next pointer of null.

```java
public static Node[] splitList(Node head) {
    Node oddHead = null, oddTail = null;
    Node evenHead = null, evenTail = null;

    while (head != null) {
        Node next = head.next;
        head.next = null;
        if (head.data % 2 == 0) { // even value
            if (evenHead == null) {
                evenHead = evenTail = head;
            } else {
                evenTail.next = head;
                evenTail = evenTail.next;
            }
        } else { // odd value
            if (oddHead == null) {
                oddHead = oddTail = head;
            } else {
                oddTail.next = head;
                oddTail = oddTail.next;
            }
        }
        head = next;
    }

    return new Node[] {oddHead, evenHead};
}
```

### Q13: Remove duplicates from sorted linked list
In this implementation, we use a current pointer to traverse the list. At each step, we compare the data of the current node with the data of its next node. If the two nodes have the same value, we skip over the next node by updating the next pointer of the current node to point to the node after the next node. Otherwise, we move the current pointer to the next node.

Note that this algorithm works for a sorted linked list only. If the input list is not sorted, we can first sort it using a sorting algorithm such as merge sort before removing duplicates.

```java
public static void removeDuplicates(Node head) {
    Node current = head;
    while (current != null && current.next != null) {
        if (current.data == current.next.data) {
            current.next = current.next.next;
        } else {
            current = current.next;
        }
    }
}
```

### Q14: Reverse a Linked List (Recursive)
To reverse a linked list recursively, we can use a recursive function that takes the head of the linked list as an argument and returns the new head of the reversed list.

The basic idea is to reverse the rest of the linked list after the current node, and then append the current node to the end of the reversed rest. We can achieve this by calling the recursive function on the next node and then updating its next pointer to point to the current node.

```java
public static Node reverseList(Node head) {
    // base case: empty list or single node list
    if (head == null || head.next == null) {
        return head;
    }

    // reverse the rest of the list
    Node rest = reverseList(head.next);

    // append the current node to the end of the reversed rest
    head.next.next = head;
    head.next = null;

    // return the new head of the reversed list
    return rest;
}
```

### Q15: Reverse a Linked List (Iterative)
To reverse a linked list iteratively, we can use a simple iterative algorithm that iterates through the linked list and reverses the next pointers of each node.

The basic idea is to maintain three pointers: one for the current node, one for the previous node, and one for the next node. We start by setting the current node to the head of the linked list and the previous node to null. Then, we iterate through the linked list and for each node, we set the next node to be the current node's next pointer, then set the current node's next pointer to be the previous node. Finally, we update the previous node to be the current node and the current node to be the next node. We continue this process until we reach the end of the linked list, at which point the previous node will be the new head of the reversed list.

```java
public static Node reverseList(Node head) {
    Node prev = null;
    Node curr = head;

    while (curr != null) {
        Node next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;
    }

    return prev;
}
```

### Q16: Palindrome Linked List
To determine whether a linked list is a palindrome, we can use a simple algorithm that involves iterating through the linked list twice. The basic idea is to use a fast and slow pointer to find the middle of the linked list, then reverse the second half of the linked list and compare it to the first half.

```java
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
```

### Q17: Maximum Twin Sum of a Linked List
In a linked list of size n, where n is even, the ith node (0-indexed) of the linked list is known as the twin of the (n-1-i)th node, if 0 <= i <= (n / 2) - 1.

For example, if n = 4, then node 0 is the twin of node 3, and node 1 is the twin of node 2. These are the only nodes with twins for n = 4.
The twin sum is defined as the sum of a node and its twin.

Given the head of a linked list with even length, return the maximum twin sum of the linked list.

#### Solution: 
To solve this problem, we can traverse the linked list and calculate the twin sum for each pair of twin nodes. We can then keep track of the maximum twin sum seen so far and return it at the end.

Here's the step-by-step algorithm to solve the problem:

1. Initialize a variable maxTwinSum to 0.
2. Traverse the linked list with a pointer p, and for each node:
   * Calculate the twin index twinIndex as n - 1 - currentIndex, where n is the length of the linked list and currentIndex is the index of the current node.
   * If currentIndex is less than or equal to n / 2 - 1, calculate the twin sum as the sum of the current node's value and its twin node's value, and update maxTwinSum if the twin sum is greater than maxTwinSum.
3. Return maxTwinSum.

```java
public int maxTwinSum(Node head) {
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
            int twinSum = p.val + twin.val;
            if (twinSum > maxTwinSum) {
                maxTwinSum = twinSum;
            }
        }
        p = p.next;
    }
    
    return maxTwinSum;
}
```

### Q18: Odd Even Linked List
Given the head of a singly linked list, group all the nodes with odd indices together followed by the nodes with even indices, and return the reordered list.

The first node is considered odd, the second node even, and so on. Note that the relative order inside both the even and odd groups should remain as it was in the input.

Input: 1->2->3->4->5
Output: 1->3->5->2->4

#### Solution:
This function takes the head of a singly linked list as input, and returns the reordered list where all the nodes with odd indices are grouped together followed by the nodes with even indices.

The function works as follows:

* If the input list is empty, return null.
* Initialize odd to the head of the list, even to the second node, and evenHead to even.
* Iterate over the list with a loop that runs while even is not null and even.next is not null.
* In each iteration, link the odd node to even.next, move odd to odd.next, link even node to odd.next, and move even to even.next.
* Once the loop is done, link the last node in the odd group to the first node in the even group (odd.next = evenHead), and return the head of the list (return head).

```java
public static Node oddEvenList(Node head) {
    if (head == null) {
        return null;
    }
    
    Node odd = head;
    Node even = head.next;
    Node evenHead = even;

    while (even != null && even.next != null) {
        odd.next = even.next;
        odd = odd.next;
        even.next = odd.next;
        even = even.next;
    }

    odd.next = evenHead;
    return head;
}
```

### Q19: Copy List with Random Pointer
Construct a deep copy of a lined list where each node contains an additional random pointer, which could point to any node in the list, or null.

#### Solution:
We use a three-step approach to create a deep copy of the linked list with random pointers:

1. Create a new copy of each node and insert it after the original node 
   * Traverse the original list and create a new copy of each node with the same value 
   * Insert the copy node after the original node by setting the original node's next pointer to the copy node

2. Assign random pointers for each copy
   * Traverse the list and for each node, assign the random pointer of its copy to the next node of its random pointer
   * For example, if the random pointer of node A points to node B, then the random pointer of the copy of node A should point to the copy of node B

3. Separate the original list and the copy list
   * Traverse the list and separate the original list and the copy list by setting the next pointers of each original node to its next next node (i.e., the copy node)
   * Similarly, set the next pointers of each copy node to its next next node

This three-step approach uses constant extra space and runs in O(n) time, where n is the length of the linked list.

```java
public Node copyRandomList(Node head) {
    if (head == null) {
        return null;
    }

    // Step 1: Create a new copy of each node and insert it after the original node
    Node curr = head;
    while (curr != null) {
        Node copy = new Node(curr.val);
        copy.next = curr.next;
        curr.next = copy;
        curr = copy.next;
    }

    // Step 2: Assign random pointers for each copy
    curr = head;
    while (curr != null) {
        if (curr.random != null) {
            curr.next.random = curr.random.next;
        }
        curr = curr.next.next;
    }

    // Step 3: Separate the original list and the copy list
    curr = head;
    Node copyHead = head.next;
    Node copyCurr = copyHead;
    while (curr != null) {
        curr.next = curr.next.next;
        if (copyCurr.next != null) {
            copyCurr.next = copyCurr.next.next;
        }
        curr = curr.next;
        copyCurr = copyCurr.next;
    }

    return copyHead;
}
```
