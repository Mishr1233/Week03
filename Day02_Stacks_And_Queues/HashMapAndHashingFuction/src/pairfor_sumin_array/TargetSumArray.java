package pairfor_sumin_array;

import java.util.HashSet;

public class TargetSumArray {

    // Function to check if there exists a pair with the given sum
    public static boolean hasPairWithSum(int[] arr, int target) {
        HashSet<Integer> visited = new HashSet<>();

        // Traverse through the array
        for (int num : arr) {
            // Check if (target - num) is in the set
            if (visited.contains(target - num)) {
                return true; // Found a pair with the given sum
            }
            // Add the current number to the set
            visited.add(num);
        }

        // No pair found with the given sum
        return false;
    }

    public static void main(String[] args) {
        // Sample array and target sum
        int[] arr = {10, 15, 3, 7};
        int target = 17;

        // Check if there exists a pair with the given sum
        boolean result = hasPairWithSum(arr, target);

        if (result) {
            System.out.println("There exists a pair with the given sum.");
        } else {
            System.out.println("No pair found with the given sum.");
        }
    }
}
