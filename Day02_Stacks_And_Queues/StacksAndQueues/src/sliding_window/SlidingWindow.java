package sliding_window;


import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindow{

    // Function to find the maximum element in each sliding window
    public static int[] slidingWindowMaximum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        int n = nums.length;
        int[] result = new int[n - k + 1];  // To store the result
        Deque<Integer> deque = new LinkedList<>();  // Deque to store indices of useful elements

        for (int i = 0; i < n; i++) {
            // Remove indices that are out of the current window
            if (!deque.isEmpty() && deque.peek() < i - k + 1) {
                deque.poll();
            }

            // Remove elements from the deque which are smaller than the current element
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }

            // Add the current element's index to the deque
            deque.offer(i);

            // The first k elements form a complete window, so start adding to the result
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peek()];  // The maximum is at the front of the deque
            }
        }

        return result;
    }

    // Helper function to display the result
    public static void display(int[] result) {
        for (int num : result) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;

        // Find the maximum of each sliding window
        int[] result = slidingWindowMaximum(nums, k);

        // Display the result
        display(result);
    }
}
