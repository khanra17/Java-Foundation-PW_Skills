Doubly Linked List and Circular Linked List in Java
=======================================

### Limitation of Singly Linked List
A singly linked list is a linear data structure that consists of nodes linked together with pointers, where each node contains a data element and a pointer to the next node in the list. While singly linked lists have some advantages over other data structures, such as constant-time insertion and deletion at the beginning of the list, they also have some limitations that should be considered when deciding whether to use them in a particular situation.

Here are some of the limitations of singly linked lists:

1. Singly linked lists do not provide direct access to individual nodes, which means that to access a particular node in the list, you have to traverse the list from the beginning until you find the node you're looking for. This results in a time complexity of O(n) for the get operation, where n is the length of the list.
2. If only head is given: If you only have a reference to the head of a singly linked list, you can only traverse the list in one direction - forward from the head. This means that if you need to perform any operations that involve traversing the list in reverse, you will need to implement additional data structures or algorithms to support those operations.
3. More space is used: Singly linked lists use more memory than arrays for storing the same amount of data because they need to store a pointer to the next node for each node in the list.
4. Cannot move backwards: Singly linked lists can only be traversed in one direction - forward from the head. This means that if you need to move backwards in the list, you will need to implement additional data structures or algorithms to support that operation.

Overall, while singly linked lists have some advantages over other data structures, they also have some limitations that should be considered when deciding whether to use them in a particular situation.

### Doubly Linked List
A Doubly Linked List (DLL) is a data structure that consists of a sequence of nodes, where each node contains two pointers, one to the previous node and one to the next node. This makes it possible to traverse the list in both forward and backward directions.

In a DLL, each node contains data and two pointers, one pointing to the previous node and one to the next node. The first node in the list has a null pointer for the previous node, and the last node has a null pointer for the next node. This allows for efficient insertion and deletion of nodes from both ends of the list.

One of the advantages of a DLL over a singly linked list is that it allows for efficient removal of nodes from the end of the list. In a singly linked list, removing the last node requires iterating through the entire list to find the second-to-last node, but in a DLL, the last node can be removed in constant time by following the previous pointer of the last node.

However, DLLs require more memory than singly linked lists because each node requires an additional pointer. Additionally, DLLs are more complex to implement and require more code to maintain the integrity of the pointers.

Overall, DLLs are useful in situations where there is a need to traverse a list in both forward and backward directions, or where efficient removal of nodes from both ends of the list is required.

### Creating a DLL
To create a DLL using this Node class, you would first create a Node object for the first node of the list, and set its "next" and "prev" pointers to null since it is the only node in the list. For example:
```java
public static void main(String[] args) {
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
    }
```

### Displaying a DLL
Note that we start from the head node and call the display method on it. The method traverses the entire list using the next pointers and prints the data of each node.

```java
public void display() {
    Node current = this;
    while (current != null) {
        System.out.print(current.data + " ");
        current = current.next;
    }
    System.out.println();
}
```
#### In reverse order using prev
This method starts from the last node in the list (i.e., the node whose next pointer is null) and then traverses the list backwards using the prev pointers.

```java
public void displayReverse() {
    Node current = this;
    while (current.next != null) {
        current = current.next;
    }
    while (current != null) {
        System.out.print(current.data + " ");
        current = current.prev;
    }
    System.out.println();
}
```
#### Display a node if random node is given
If a random node of a doubly linked list is given, we can display the entire list by traversing the list in both directions from that node. Here's an example implementation:

```java
public static void displayFromNode(Node node) {
    Node current = node;
    while (current.prev != null) {
        current = current.prev;
    }
    while (current != null) {
        System.out.print(current.data + " ");
        current = current.next;
    }
    System.out.println();
}
```

### Insertion at head of a DLL
This method takes the current head of the DLL and the data for the new node as arguments, and returns the new head of the DLL after insertion. It creates a new node with the given data, sets its next pointer to the current head, and sets the prev pointer of the current head to the new node. Finally, it returns the new node as the new head of the DLL.

```java
public static Node insertAtHead(Node head, int data) {
    Node newNode = new Node(data);
    newNode.next = head;
    head.prev = newNode;
    return newNode;
}
```

### Insertion at tail of a DLL
This method takes the current head of the DLL and the data for the new node as arguments, and does not return anything. It creates a new node with the given data, then traverses the list using the next pointers until it reaches the last node. It then sets the next pointer of the last node to the new node, and sets the prev pointer of the new node to the last node.

```java
public static void insertAtTail(Node head, int data) {
    Node newNode = new Node(data);
    Node current = head;
    while (current.next != null) {
        current = current.next;
    }
    current.next = newNode;
    newNode.prev = current;
}
```

### Insert at any index
This method takes the current head of the DLL, the index at which to insert the new node, and the data for the new node as arguments, and does not return anything. It creates a new node with the given data, then traverses the list using the next pointers until it reaches the node at the given index. If the index is out of bounds (i.e., greater than the length of the list), it prints an error message and returns without inserting the new node. Otherwise, it sets the next pointer of the new node to the current node at the given index, sets the prev pointer of the new node to the node before the current node, sets the next pointer of the node before the current node to the new node, and sets the prev pointer of the current node to the new node.

```java
public static void insertAtIndex(Node head, int index, int data) {
    Node newNode = new Node(data);
    Node current = head;
    int i = 0;
    while (i < index && current != null) {
        current = current.next;
        i++;
    }
    if (current == null) {
        System.out.println("Invalid index, node not inserted.");
        return;
    }
    newNode.next = current;
    newNode.prev = current.prev;
    current.prev.next = newNode;
    current.prev = newNode;
}
```

### Deletion
The deleteAtHead method takes the current head of the DLL as an argument and returns the new head of the list after deleting the node at the head. It checks if the list is empty and returns null if it is, and checks if the list has only one node and returns null if it does (since there are no more nodes to link to). Otherwise, it sets the prev pointer of the new head (i.e., the second node in the list) to null and returns the new head.

The deleteAtTail method takes the current head of the DLL as an argument and returns the head of the list after deleting the node at the tail. It checks if the list is empty and returns null if it is, and checks if the list has only one node and returns null if it does (since there are no more nodes to link to). Otherwise, it traverses the list using the next pointers until it reaches the last node, sets the next pointer of the second-to-last node to null, and returns the head of the list.

The deleteAtIndex method takes the current head of the DLL and the index at which to delete a node as arguments, and does not return anything. It checks if the list is empty and prints an error message if it is, and traverses the list using the next pointers until it reaches the node at the given index. If the index is out of bounds (i.e., greater than or equal to the length of the list), it prints an error message and returns without deleting any nodes. Otherwise, it updates the next and prev pointers of the neighboring nodes to skip the node at the given index.

```java
public static Node deleteAtHead(Node head) {
    if (head == null) {
        System.out.println("List is empty, deletion not possible.");
        return null;
    }
    if (head.next == null) {
        return null;
    }
    head.next.prev = null;
    return head.next;
}

public static Node deleteAtTail(Node head) {
    if (head == null) {
        System.out.println("List is empty, deletion not possible.");
        return null;
    }
    if (head.next == null) {
        return null;
    }
    Node current = head;
    while (current.next != null) {
        current = current.next;
    }
    current.prev.next = null;
    return head;
}

public static void deleteAtIndex(Node head, int index) {
    if (head == null) {
        System.out.println("List is empty, deletion not possible.");
        return;
    }
    Node current = head;
    int i = 0;
    while (i < index && current != null) {
        current = current.next;
        i++;
    }
    if (current == null) {
        System.out.println("Invalid index, node not deleted.");
        return;
    }
    if (current == head) {
        head = current.next;
    }
    if (current.next != null) {
        current.next.prev = current.prev;
    }
    current.prev.next = current.next;
}
```

## Circular Linked List
A circular linked list is a type of linked list in which the last node points back to the first node, forming a circle. This can be useful in certain situations, such as when you want to iterate over the list multiple times without having to reset to the beginning.

```java
Node head = new Node(1);
Node node2 = new Node(2);
Node node3 = new Node(3);

head.next = node2;
node2.prev = head;
node2.next = node3;
node3.prev = node2;

// make the list circular by linking the last node to the first node
node3.next = head;
head.prev = node3;
```
```text
1 <-> 2 <-> 3 <-> 1
```

### Delete head of a CLL
To delete the head node in a circular linked list, we need to update the head pointer to point to the next node in the list, and update the next pointer of the last node in the list to point to the new head. Then, we can return the new head node.

```java
public Node deleteHead() {
    if (head == null) {
        System.out.println("List is empty.");
        return null;
    }
    Node newHead = head.next;
    if (newHead == head) { // if only one node in the list
        head = null;
    } else {
        Node current = head;
        while (current.next != head) {
            current = current.next;
        }
        current.next = newHead;
        head = newHead;
    }
    return newHead;
}
```

### Find the Minimum and Maximum Number of Nodes Between Critical Points
A critical point in a linked list is defined as either a local maxima or a local minima.

A node is a local maxima if the current node has a value strictly greater than the previous node and the next node.

A node is a local minima if the current node has a value strictly smaller than the previous node and the next node.

Note that a node can only be a local maxima/minima if there exists both a previous node and a next node.

Given a linked list head, return an array of length 2 containing [minDistance, maxDistance] where minDistance is the minimum distance between any two distinct critical points and maxDistance is the maximum distance between any two distinct critical points. If there are fewer than two critical points, return [-1, -1].

#### Solution
This solution tracks the minimum distance min_d between any two distinct critical points seen so far, and also tracks the first and last critical points found, to calculate the maximum distance last - first. It also keeps track of the index i of the current node in the iteration, and the previous value prev_val to check if the current node is a critical point.

```java
public int[] nodesBetweenCriticalPoints(ListNode h) {
    int first = Integer.MAX_VALUE, last = 0, prev_val = h.val, min_d = Integer.MAX_VALUE;
    for (int i = 0; h.next != null; ++i) {
        if ((prev_val < h.val && h.val > h.next.val) || 
            (prev_val > h.val && h.val < h.next.val)) {
            if (last != 0)
                min_d = Math.min(min_d, i - last);
            first = Math.min(first, i);
            last = i;
        }
        prev_val = h.val;
        h = h.next;
    }        
    if (min_d == Integer.MAX_VALUE)
        return new int[] {-1, -1};
    return new int[] {min_d, last - first};
}
```

### Is DLL Palindrome
Here, we first check if the list is empty. Then, we initialize the tail pointer to point to the last node in the list by traversing the list using the next pointers. We also initialize two pointers currentHead and currentTail to point to the first and last nodes in the list, respectively.

We then compare the values at each node pointed to by currentHead and currentTail. If they match, we move currentHead to the next node and currentTail to the previous node. We continue doing this until currentHead and currentTail meet each other or currentTail moves past currentHead. If at any point the values at the nodes pointed to by currentHead and currentTail do not match, we know that the list is not a palindrome and return false. If we reach the end of the loop without returning false, we know that the list is a palindrome and return true.

```java
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
```

### Two sum in a sorted DLL
In this implementation, the method takes a Node object head as an argument, which represents the head of the doubly linked list, and an integer target as the value we want to find pairs for. We first check if the list is empty by checking if head is null. Then, we initialize two pointers left and right to point to the first and last nodes in the list, respectively.

We then use a while loop to traverse the list with the two pointers. The loop continues until left and right meet each other, left becomes greater than right, or right moves past left. Inside the loop, we compute the sum of the values at the nodes pointed to by left and right. If the sum is equal to target, we print the pair of values and move left to the next node and right to the previous node. If the sum is less than target, we move left to the next node. If the sum is greater than target, we move right to the previous node.

If we reach the end of the loop without finding a pair whose sum is equal to target, we print a message indicating that no pair was found.

```java
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
```

### Maxima & Minima
To find the maximum and minimum values in a doubly linked list, we can use a simple linear scan of the list with two variables, one for the maximum value and one for the minimum value.

In this implementation, the method takes a Node object head as an argument, which represents the head of the doubly linked list. We first check if the list is empty by checking if head is null. Then, we initialize two variables max and min to the value of the first node in the list, and initialize a pointer current to head.

We then use a while loop to traverse the list with the current pointer. Inside the loop, we check if the value of the current node pointed to by current is greater than max. If it is, we update max to be the value of the current node. We then check if the value of the current node is less than min. If it is, we update min to be the value of the current node. Finally, we move current to the next node in the list.

After the loop ends, we print the maximum and minimum values of the list to the console.

```java
public static void findMaxAndMin(Node head) {
    if (head == null) {
        System.out.println("List is empty.");
        return;
    }
    int max = head.data;
    int min = head.data;
    Node current = head;
    while (current != null) {
        if (current.data > max) {
            max = current.data;
        }
        if (current.data < min) {
            min = current.data;
        }
        current = current.next;
    }
    System.out.println("Max value: " + max);
    System.out.println("Min value: " + min);
}
```

### Flatten a Multilevel DLL
Flattening a multilevel doubly linked list involves rearranging the list such that all the nodes at deeper levels are moved to the same level, while preserving the order of the nodes. This can be accomplished using a recursive approach where we traverse the list and flatten each child list recursively.

In this implementation, the method takes a Node object head as an argument, which represents the head of the multilevel doubly linked list. We first check if the list is empty by checking if head is null. If it is, we simply return null.

We then initialize a tail variable to head, and use a while loop to traverse the list and find the last node in the list, which will become the tail of the flattened list.

Next, we use another while loop to traverse the list again, this time checking if each node has a child list. If it does, we recursively flatten the child list using the flatten method, and then attach the flattened child list to the end of the current node's list. We also update the tail pointer to point to the new end of the list. Finally, we remove the child reference from the current node since it has been flattened.

After the loop ends, we return the head of the flattened list.

```java
public static Node flatten(Node head) {
    if (head == null) {
        return null;
    }
    Node tail = head;
    while (tail.next != null) {
        tail = tail.next;
    }
    Node current = head;
    while (current != null) {
        if (current.child != null) {
            Node flattenedChild = flatten(current.child);
            flattenedChild.prev = tail;
            tail.next = flattenedChild;
            while (tail.next != null) {
                tail = tail.next;
            }
            current.child = null;
        }
        current = current.next;
    }
    return head;
}
```