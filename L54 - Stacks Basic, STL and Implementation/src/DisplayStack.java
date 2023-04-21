import java.util.Stack;

public class DisplayStack {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        displayStackIterative(stack);
        displayStackRecursive(stack);
    }

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
        System.out.println();
    }

    public static void displayStackRecursive(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int element = stack.pop();
        displayStackRecursive(stack);
        System.out.print(element);
        stack.push(element);
    }
}
