import java.util.Stack;

public class Remove {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("Before removal: " + stack);
        removeAtIndex(stack, 1);
        System.out.println("After removal: " + stack);
    }

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
}
