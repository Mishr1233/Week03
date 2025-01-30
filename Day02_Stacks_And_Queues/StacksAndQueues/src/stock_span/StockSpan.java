package stock_span;

import java.util.Stack;

public class StockSpan{

    // Function to calculate the stock span
    public static int[] calculateSpan(int[] prices) {
        int n = prices.length;
        int[] span = new int[n];  // Array to store the span of each day
        Stack<Integer> stack = new Stack<>();  // Stack to store indices of prices

        // Loop through each price
        for (int i = 0; i < n; i++) {
            // Pop elements from the stack while the stack is not empty
            while (!stack.isEmpty() && prices[stack.peek()] <= prices[i]) {
                stack.pop();
            }

            // If the stack is empty, it means the current price is greater than all previous prices
            // so the span will be the full length from day 0 to the current day
            if (stack.isEmpty()) {
                span[i] = i + 1;  // Span is i + 1 because array index starts from 0
            } else {
                // Otherwise, the span is the difference between the current index and the index of the last greater price
                span[i] = i - stack.peek();
            }

            // Push the current index to the stack for future comparison
            stack.push(i);
        }

        return span;
    }

    // Helper function to display the spans
    public static void display(int[] span) {
        for (int s : span) {
            System.out.print(s + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] prices = {100, 80, 60, 70, 60, 75, 85};

        // Calculate the span of stock prices
        int[] span = calculateSpan(prices);

        // Display the span for each day
        display(span);
    }
}

