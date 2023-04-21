import java.util.Stack;

public class Insert {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("Original stack: " + stack);
        pushAtIndex(stack, 1, 4);
        System.out.println("New stack: " + stack);
    }

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
}
