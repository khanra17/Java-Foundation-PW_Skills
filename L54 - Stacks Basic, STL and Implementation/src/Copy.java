import java.util.Stack;

public class Copy {

    public static void main(String[] args) {
        Stack<Integer> originalStack = new Stack<>();
        originalStack.push(1);
        originalStack.push(2);
        originalStack.push(3);
        Stack<Integer> copiedStack = copyStack(originalStack);
        System.out.println("Original stack: " + originalStack);
        System.out.println("Copied stack: " + copiedStack);
    }

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
}
