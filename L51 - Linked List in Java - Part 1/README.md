Linked List in Java - Part 1
=======================================
### Introduction
A linked list is a data structure used in computer science to store a sequence of elements, where each element (also known as a node) points to the next one in the sequence. Each node in a linked list consists of two parts: a data element and a reference (also called a pointer or link) to the next node in the list.

### Pro & Cons of Array, ArrayList
Arrays and ArrayLists are other commonly used data structures for storing collections of elements. Some pros and cons of using these data structures are:

#### Pros of Arrays:
* Elements in an array are stored in contiguous memory locations, which makes accessing elements by index very fast.
* Arrays have a fixed size, which can be an advantage in situations where you need a fixed amount of memory.

#### Cons of Arrays:
* Arrays have a fixed size, which can be a disadvantage if you need to add or remove elements dynamically.
* Inserting or deleting elements in an array requires shifting all elements after the insertion/deletion point, which can be a slow operation.

#### Pros of ArrayList:
* ArrayLists can grow and shrink dynamically as elements are added or removed, which can be very useful in situations where you need to change the size of the collection.
* ArrayLists have built-in methods for common operations such as adding, removing, and accessing elements, which can make programming with them easier.

#### Cons of ArrayList:
* Elements in an ArrayList are stored in a non-contiguous manner, which can make accessing elements by index slower than with arrays.
* ArrayLists are implemented using an underlying array, which can be inefficient if the array needs to be resized frequently.

### Linked List Pros & Cons
#### Pros of Linked Lists:
* Linked lists can grow and shrink dynamically as elements are added or removed, which can be very useful in situations where you need to change the size of the collection.
* Inserting or deleting elements in a linked list requires only changing the links between nodes, which can be a fast operation.

#### Cons of Linked Lists:
* Elements in a linked list are not stored in contiguous memory locations, which can make accessing elements by index slower than with arrays or ArrayLists.
* Linked lists require extra memory to store the reference to the next node, which can be a disadvantage if memory usage is a concern.

### Linked List Types
There are three main types of linked lists:

#### Singly Linked List
In a singly linked list, each node has a reference to the next node in the list, but not to the previous node. This means that you can only traverse the list in one direction, from the first node to the last node.

#### Doubly Linked List
In a doubly linked list, each node has a reference to both the next node and the previous node in the list. This means that you can traverse the list in both directions, from the first node to the last node and from the last node to the first node.

#### Circular Linked List
In a circular linked list, the last node in the list has a reference to the first node in the list, forming a circle. This means that you can traverse the list indefinitely, starting from any node in the list.

### Displaying a Linked List
To display a linked list, you can traverse the list from the first node to the last node, printing the value of each node as you go. Here's an example Java code snippet that demonstrates how to display the values in a singly linked list:

```java
public class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public static void displayLinkedList(Node head) {
    Node currentNode = head;
    while (currentNode != null) {
        System.out.print(currentNode.data + " ");
        currentNode = currentNode.next;
    }
}
```

### Linked List Implementation
Here's an implementation of a singly linked list in Java that supports insertion at the end, beginning, and a specific index, as well as getting and deleting elements at a specific index:

```java
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
```

### Linked List Length
Here's an implementation of finding the length of a linked list using both iterative and recursive approaches in Java:

#### Iterative Approach:
In this approach, we start at the head of the linked list, and we increment a counter variable called count for each node we encounter while traversing the linked list. Once we have traversed the entire list, we return the count as the length of the linked list.

```java
public int getLengthIterative(Node head) {
    int count = 0;
    Node current = head;
    while (current != null) {
        count++;
        current = current.next;
    }
    return count;
}
```

#### Recursive Approach:
In this approach, we make use of the fact that the length of a linked list is one more than the length of its tail. Therefore, we recursively calculate the length of the tail of the linked list until we reach the end of the list, which is when we return 0. We then add 1 to the result of the recursive call to get the length of the entire linked list.

```java
public int getLengthRecursive(Node head) {
    if (head == null) {
        return 0;
    }
    return 1 + getLengthRecursive(head.next);
}
```
Note that the recursive approach has the disadvantage of using more memory due to the recursive function calls. However, it can be more concise and easier to read than the iterative approach.