package Longest_consecutive_sequence;


import java.util.HashMap;

public class CosecutiveSequence {

    // Function to find the length of the longest consecutive sequence
    public static int longestConsecutive(int[] nums) {
        // If the array is empty, return 0
        if (nums.length == 0) {
            return 0;
        }

        // HashMap to store the length of consecutive sequences
        HashMap<Integer, Integer> map = new HashMap<>();
        int longestStreak = 0;

        // Iterate through each number in the array
        for (int num : nums) {
            // If num is already in the map, skip it
            if (map.containsKey(num)) {
                continue;
            }

            // Check the left and right sequence lengths
            int left = map.getOrDefault(num - 1, 0);
            int right = map.getOrDefault(num + 1, 0);

            // Calculate the length of the new sequence
            int currentStreak = left + right + 1;

            // Update the longest streak found
            longestStreak = Math.max(longestStreak, currentStreak);

            // Update the map for the new sequence
            map.put(num, currentStreak);
            map.put(num - left, currentStreak); // Update the left boundary of the sequence
            map.put(num + right, currentStreak); // Update the right boundary of the sequence
        }

        return longestStreak;
    }

    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};

        // Find the length of the longest consecutive sequence
        int result = longestConsecutive(nums);

        System.out.println("The length of the longest consecutive sequence is: " + result);
    }
}


/*

//optional approach


import java.util.HashSet;

public class LongestConsecutiveSequence {

    // Function to find the length of the longest consecutive sequence
    public static int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        // Hash set to store the elements
        HashSet<Integer> numSet = new HashSet<>();

        // Insert all elements into the set
        for (int num : nums) {
            numSet.add(num);
        }

        int longestStreak = 0;

        // Iterate over each number in the set
        for (int num : numSet) {
            // Check if num is the start of a sequence
            if (!numSet.contains(num - 1)) {
                // Find the length of the sequence starting from num
                int currentNum = num;
                int currentStreak = 1;

                while (numSet.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }

                // Update the longest streak
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }

    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};

        // Find the length of the longest consecutive sequence
        int result = longestConsecutive(nums);

        System.out.println("The length of the longest consecutive sequence is: " + result);
    }
}
*/