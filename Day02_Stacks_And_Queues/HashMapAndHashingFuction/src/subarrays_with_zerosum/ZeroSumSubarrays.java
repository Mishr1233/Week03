package subarrays_with_zerosum;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ZeroSumSubarrays {

    // Function to find all subarrays with zero-sum
    public static List<List<Integer>> findZeroSumSubarrays(int[] arr) {
        // List to store the result subarrays
        List<List<Integer>> result = new ArrayList<>();

        // HashMap to store the cumulative sum and its corresponding indices
        HashMap<Integer, List<Integer>> sumMap = new HashMap<>();

        // Initialize currentSum
        int currentSum = 0;

        // Traverse the array
        for (int i = 0; i < arr.length; i++) {
            // Update current cumulative sum
            currentSum += arr[i];

            // If currentSum is zero, a subarray from index 0 to i has a sum of zero
            if (currentSum == 0) {
                List<Integer> subarray = new ArrayList<>();
                for (int j = 0; j <= i; j++) {
                    subarray.add(arr[j]);
                }
                result.add(subarray);
            }

            // If currentSum has been seen before, find all subarrays with zero sum
            if (sumMap.containsKey(currentSum)) {
                // Get all indices where the same cumulative sum has occurred
                List<Integer> indices = sumMap.get(currentSum);
                for (int index : indices) {
                    List<Integer> subarray = new ArrayList<>();
                    for (int j = index + 1; j <= i; j++) {
                        subarray.add(arr[j]);
                    }
                    result.add(subarray);
                }
            }

            // Add the current index to the list of indices for currentSum in the map
            sumMap.putIfAbsent(currentSum, new ArrayList<>());
            sumMap.get(currentSum).add(i);
        }

        return result;
    }

    // Helper function to display the subarrays
    public static void display(List<List<Integer>> result) {
        for (List<Integer> subarray : result) {
            System.out.println(subarray);
        }
    }

    public static void main(String[] args) {
        int[] arr = {6, -1, 3, -3, 4, -2, 2, 4, -4};

        // Find and display all subarrays with zero-sum
        List<List<Integer>> result = findZeroSumSubarrays(arr);
        display(result);
    }
}

