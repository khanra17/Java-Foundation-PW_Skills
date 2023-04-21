Stacks Basic, STL and Implementation
=======================================
### Introduction
A stack is a linear data structure that follows the Last-In-First-Out (LIFO) principle, where the last element inserted is the first element to be removed. Stacks support three main operations - push (insertion), pop (removal), and peak (return the top element without removing it). The time complexity for push, pop, and peak operations depends on the implementation of the stack. Stacks can be implemented using arrays or linked lists.

### Push at any Index
To push an element at any index of a stack, you can follow these steps:

1. Create a temporary stack.
2. Pop elements from the original stack and push them onto the temporary stack until you reach the desired index.
3. Push the new element onto the original stack.
4. Pop elements from the temporary stack and push them back onto the original stack.

```java
public static void pushAtIndex(Stack<Integer> stack, int index, int value) {
    if (index < 0 || index > stack.size()) {
        throw new IndexOutOfBoundsException("Index out of range: " + index);
    }
    Stack<Integer> tempStack = new Stack<>();
    for (int i = 0; i < index; i++) {
        tempStack.push(stack.pop());
    }
    stack.push(value);
    while (!tempStack.isEmpty()) {
        stack.push(tempStack.pop());
    }
}
```

### Display Stack
We can display the elements of a stack iteratively or recursively. The iterative implementation is as follows:
```java
public static void displayStackIterative(Stack<Integer> stack) {
    Stack<Integer> tempStack = new Stack<>();
    while(!stack.isEmpty()){
        tempStack.push(stack.pop());
    }
    while (!tempStack.isEmpty()) {
        int cur = tempStack.pop();
        System.out.print(cur);
        stack.push(cur);
    }
}
```

In this implementation, the displayStackRecursive method takes a stack as input and recursively displays its contents using a helper method. The displayStackRecursiveHelper method recursively pops elements from the stack and displays them, then pushes them back onto the stack. This results in the elements being displayed in the correct order.
```java
public static void displayStackRecursive(Stack<Integer> stack) {
    if (stack.isEmpty()) {
        return;
    }
    int element = stack.pop();
    displayStackRecursive(stack);
    System.out.println(element);
    stack.push(element);
}
```

### Remove from any index
In this implementation, the removeAtIndex method takes a Stack and an index as input, and removes the element at the specified index from the Stack. The method first checks if the index is valid, and throws an IndexOutOfBoundsException if it's not. Then, the method creates a temporary Stack and pops elements from the original Stack until it reaches the element at the specified index. The element at the specified index is then popped and discarded. Finally, the method pops the remaining elements from the temporary Stack and pushes them back onto the original Stack.

```java
public static void removeAtIndex(Stack<Integer> stack, int index) {
    if (index < 0 || index >= stack.size()) {
        throw new IndexOutOfBoundsException("Invalid index");
    }
    int stackSize = stack.size();
    Stack<Integer> tempStack = new Stack<>();
    for (int i = 0; i < stackSize - index - 1; i++) {
        tempStack.push(stack.pop());
    }
    stack.pop();
    while (!tempStack.isEmpty()) {
        stack.push(tempStack.pop());
    }
}
```

### Copy Stack
In this approach, you pop elements from the original Stack, push them onto the temporary Stack, and then push them back onto the original Stack while also pushing them onto the new copied Stack. This way, you don't modify the original Stack or create a new Stack object directly.

```java
public static Stack<Integer> copyStack(Stack<Integer> originalStack) {
    Stack<Integer> tempStack = new Stack<>();
    Stack<Integer> copiedStack = new Stack<>();
    while (!originalStack.isEmpty()) {
        tempStack.push(originalStack.pop());
    }
    while (!tempStack.isEmpty()) {
        int element = tempStack.pop();
        originalStack.push(element);
        copiedStack.push(element);
    }
    return copiedStack;
}
```

### Reverse Stack
To reverse a stack, we can either use an iterative or a recursive approach. The iterative implementation is as follows:

```java
public static void reverseIterative(Stack<Integer> stack) {
    Stack<Integer> tempStack = new Stack<>();
    while (!stack.isEmpty()) {
        tempStack.push(stack.pop());
    }
    while (!tempStack.isEmpty()) {
        stack.push(tempStack.pop());
    }
}
```

The recursive implementation is as follows:
```java
public static void reverseStackRecursive(Stack<Integer> stack) {
    if (stack.isEmpty()) {
        return;
    }
    int temp = stack.pop();
    reverseStackRecursive(stack);
    insertAtBottom(stack, temp);
}

public static void insertAtBottom(Stack<Integer> stack, int value) {
    if (stack.isEmpty()) {
        stack.push(value);
        return;
    }
    int temp = stack.pop();
    insertAtBottom(stack, value);
    stack.push(temp);
}
```

### Underflow
An underflow error occurs when you attempt to remove an element from an empty Stack. In other words, the Stack does not have any elements to pop, but you still attempt to pop an element. This results in an error, usually a runtime exception, such as EmptyStackException in Java.

### Overflow
An overflow error occurs when you attempt to insert an element into a Stack that is already full. In other words, the Stack has reached its maximum capacity, but you still try to push an element onto it. This results in an error, usually a runtime exception, such as StackOverflowError in Java.

### Array Implementation of Stack
An array-based implementation of a stack involves using an array to store the elements of the stack. The top element of the stack is represented by an index in the array. The implementation for an array-based stack is as follows:

```java
public class Stack {
    private static final int MAX_SIZE = 100;
    private int[] stack;
    private int top;

    public Stack() {
        stack = new int[MAX_SIZE];
        top = -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == MAX_SIZE - 1;
    }

    public void push(int element) {
        if (isFull()) {
            System.out.println("Stack Overflow");
            return;
        }
        stack[++top] = element;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow");
            return -1;
        }
        return stack[top--];
    }

    public int peak() {
        if (isEmpty()) {
            System.out.println("Stack Underflow");
            return -1;
        }
        return stack[top];
    }
}
```

### Linked List Implementation of Stack
A linked list-based implementation of a stack involves using a linked list to store the elements of the stack. Each element of the linked list represents a node in the stack. The top element of the stack is represented by the head of the linked list. The implementation for a linked list-based stack is as follows:

```java
public class Stack {
    private Node top;

    private static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void push(int element) {
        Node node = new Node(element);
        node.next = top;
        top = node;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow");
            return -1;
        }
        int element = top.data;
        top = top.next;
        return element;
    }

    public int peak() {
        if (isEmpty()) {
            System.out.println("Stack Underflow");
            return -1;
        }
        return top.data;
    }
}
```

### Advantages & Disadvantages of Array Implementation of Stack
#### Advantages:
* Simple implementation using an array
* Random access to elements
* Cache locality for better performance
* No additional memory allocation overhead

#### Disadvantages:
* Fixed size, cannot grow dynamically
* Can cause stack overflow if the array is full

### Advantages & Disadvantages of Linked List Implementation of Stack
#### Advantages:
* Can grow dynamically, no size limit
* Efficient memory utilization

#### Disadvantages:
* Additional memory allocation overhead for each element
* No random access to elements