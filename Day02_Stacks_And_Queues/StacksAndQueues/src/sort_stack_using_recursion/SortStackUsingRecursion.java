package sort_stack_using_recursion;

import java.util.Stack;

public class SortStackUsingRecursion {

    public static void sort(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }

        // Pop the top element
        int temp = stack.pop();

        // Sort the remaining stack
        sort(stack);

        // Insert the popped element back into the sorted stack
        insertSorted(stack, temp);
    }

    private static void insertSorted(Stack<Integer> stack, int temp) {
        // Base case: If the stack is empty or the temp is greater than the top element, push it
        if (stack.isEmpty() || temp >= stack.peek()) {
            stack.push(temp);
        } else {
            // If temp is smaller than the top, pop and recurse
            int top = stack.pop();
            insertSorted(stack, temp);

            // Push the previously popped element back
            stack.push(top);
        }
    }

    public static void display(Stack<Integer> stack){
        // Use a temporary stack to display the elements without altering the original stack
        Stack<Integer> tempStack = new Stack<>();
        while (!stack.isEmpty()) {
            tempStack.push(stack.pop());
        }

        // Print the elements
        while (!tempStack.isEmpty()) {
            int val = tempStack.pop();
            System.out.print(val + " ");
            stack.push(val); // Push it back to the original stack
        }
        System.out.println(); // For a new line after displaying the stack
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(5);
        stack.push(3);
        stack.push(30);

        sort(stack);

        // Display the sorted stack
        display(stack);
    }
}
